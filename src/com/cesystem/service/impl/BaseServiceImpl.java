package com.cesystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.BaseDao;
import com.cesystem.dao.ChooseClassDao;
import com.cesystem.dao.ClassesDao;
import com.cesystem.dao.PeerEvaluationDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.dao.WinScoreDao;
import com.cesystem.pojo.ChooseClass;
import com.cesystem.pojo.Grade;
import com.cesystem.pojo.Major;
import com.cesystem.pojo.PeerEvaluation;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.WinScore;
import com.cesystem.service.BaseService;
import com.cesystem.temp.StudentAchievement;

@Service
public class BaseServiceImpl implements BaseService {
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private WinScoreDao winScoreDao;
	@Autowired
	private PeerEvaluationDao peerEvaluationDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ChooseClassDao chooseClassDao;
	@Autowired
	private ClassesDao classesDao;

	@Override
	public void changeTerm() {
		baseDao.changeTerm();
	}

	@Override
	public void calculateAllResults() {

		/*
		 * 抽取学生的各类信息
		 */
		List<Student> students = studentDao.getAllStudent();
		List<StudentAchievement> studentAchievements = new ArrayList<StudentAchievement>();
		StudentAchievement studentAchievement = null;
		List<WinScore> winScores = null;
		List<ChooseClass> chooseClasses = null;
		List<PeerEvaluation> peerEvaluations = null;

		for (Student s : students) {
			studentAchievement = new StudentAchievement();
			winScores = winScoreDao.getWinScoreByStudentId(s.getStudentId());
			chooseClasses = chooseClassDao.searchChooseClassByStudentId(s
					.getStudentId());
			peerEvaluations = peerEvaluationDao.getPeerEvaluationByObjectId(s
					.getStudentId());
			studentAchievement.setChooseClasses(chooseClasses);
			studentAchievement.setPeerEvaluations(peerEvaluations);
			studentAchievement.setStudent(s);
			studentAchievement.setWinScores(winScores);
			studentAchievements.add(studentAchievement);
		}

		/*
		 * 计算学分绩
		 */
		Double gpa = 0.00;
		Double weight = 0.00;
		for (StudentAchievement s : studentAchievements) {

			chooseClasses = s.getChooseClasses();
			for (ChooseClass c : chooseClasses) {
				gpa += c.getScore() * c.getCourse().getPoint();
				weight += c.getCourse().getPoint();
			}
			gpa = gpa / weight;
			s.getStudent().setGpa(gpa);
		}	

		/*
		 * 计算综合成绩
		 */
		Double peGrade = 0.00;
		Double dailyGrade = 35.00;
		Double bodyGrade = 5.00;
		Double speciallGrade = 0.00;
		Double cp = 0.00;

		for (StudentAchievement s : studentAchievements) {

			// 计算日常行为分和个性发展分
			winScores = s.getWinScores();
			for (WinScore w : winScores) {
				if (w.getScoreItems().getScoreType().equals("300001")) {
					dailyGrade += w.getScoreItems().getScore();
				} else {
					speciallGrade += w.getScoreItems().getScore();
				}
			}
			// 计算同学互评分
			peerEvaluations = s.getPeerEvaluations();
			String level = "";
			int number = 0;
			for (PeerEvaluation p : peerEvaluations) {
				level = p.getLevel();
				number++;
				if (level.equals("500001")) {
					peGrade += 40;
				} else if (level.equals("500002")) {
					peGrade += 35;
				} else if (level.equals("500003")) {
					peGrade += 30;
				} else if (level.equals("500004")) {
					peGrade += 25;
				}
			}
			if(number != 0)
				peGrade /= number;

			// 计算总成绩并保存
			cp = (peGrade + dailyGrade + bodyGrade) * 0.3
					+ s.getStudent().getGpa() * 0.7 + speciallGrade;
			
			s.getStudent().setComprehensivePerformance(cp);
			studentDao.update(s.getStudent());

		}

		/*
		 * 计算排名
		 */
		List<Grade> grades = baseDao.getAll(new Grade(), "gradeId");
		List<Major> majors = baseDao.getAll(new Major(), "majorId");
		for (Grade g : grades) {
			for (Major m : majors) {
				
				// 计算综合成绩排名
				students = studentDao.getStudentByGradeAndMajorSortByCP(g.getGradeId(), m.getMajorId());
				Double sort = 0.0;
				for (Student s : students) {
					sort++;
					s.setComprehensivePerformanceRanking(sort);

				}
				
				// 计算总成绩排名
				students = studentDao.getStudentByGradeAndMajorSortByGPA(g.getGradeId(), m.getMajorId());
				int sort2 = 0;
				for (Student s : students) {
					sort2++;
					s.setGpaSort(sort2);
				}

				// 更新排名
				for (Student s : students) {
					studentDao.update(s);
				}
			}
		}


	}
}
