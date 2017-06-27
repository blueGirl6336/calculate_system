package com.cesystem.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.ChooseClassDao;
import com.cesystem.dao.CourseDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.pojo.ChooseClass;
import com.cesystem.pojo.Course;
import com.cesystem.pojo.Student;
import com.cesystem.service.ChooseClassService;

@Service
public class ChooseClassServiceImpl implements ChooseClassService {

	@Autowired
	private ChooseClassDao chooseClassDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	CourseDao courseDao;

	//录入学分绩信息
	@Override
	public void addChooseClass(ChooseClass chooseClass) {
		chooseClassDao.add(chooseClass);
	}

	//修改学分绩信息
	@Override
	public void modifyChooseClass(ChooseClass chooseClass) {
		chooseClassDao.update(chooseClass);
	}

	//删除学分绩信息
	@Override
	public void deleteChooseClass(ChooseClass chooseClass) {
		chooseClassDao.delete(chooseClass);
	}

	//根据学号查找学分绩信息
	@Override
	public List<ChooseClass> searchChooseClassByUserName(String userName) {
		List<ChooseClass> winScoreList = chooseClassDao.searchChooseClassByUserName(userName);
		return winScoreList;
	}

	//查找所有学分绩信息
	@Override
	public List<ChooseClass> searchAllChooseClass() {
		List<ChooseClass>chooseClassList = chooseClassDao.searchAllChooseClass();
		return chooseClassList;
	}

	@Override
	public ChooseClass searchChooseClassById(int ccId) {
		ChooseClass chooseClass = chooseClassDao.searchChooseClassById(ccId);
		return chooseClass;
	}

	@Override
	public void addChooseClassByExcel(String path) {
		try {
			Workbook book = Workbook.getWorkbook(new File(path));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			
			ChooseClass chooseClass;
			Course course;
			
			String courseNumber;
			String courseName;
			Double point;
			String type;
			
			boolean isExist;
			
			for (int i = 2; i < sheet.getColumns(); i++) {
				courseNumber = sheet.getCell(i, 1).getContents();
				courseName = sheet.getCell(i, 2).getContents();
				point = Double.parseDouble(sheet.getCell(i, 3).getContents());
				type = sheet.getCell(i, 4).getContents();
				
				isExist = courseDao.findSameCourse(courseNumber, courseName, point, type);
				
				if ( !isExist ) {
					course = new Course();
					course.setCourseName(courseName);
					course.setCourseNumber(courseNumber);
					course.setPoint(point);
					course.setType(type);
					courseDao.add(course);
				}
			}
			
			for (int i = 6; i < sheet.getRows(); i++) {
				for (int j =2 ; j < sheet.getColumns(); j++) {
				
				    chooseClass = new ChooseClass();
				
				    Cell cell = sheet.getCell(0, i);
				    chooseClass.setStudent(studentDao.searchByUserName(cell
				    		.getContents()));
				
				    cell = sheet.getCell(j, 1);     
				    chooseClass.setCourse(courseDao.searchByCourseNumber(cell
				     		.getContents()));
				
				    chooseClass.setIsCurrent(true);
				
				    cell = sheet.getCell(j, i);
				    chooseClass.setScore(Double.parseDouble(cell.getContents()));
				
				    chooseClassDao.add(chooseClass);
				}
			}
			book.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<ChooseClass> searchByMajorNameAndGradeNumber(String majorName,
			int gradeNumber) {
		List<Student> studentList = studentDao.searchByMajorNameAndGradeNumber(majorName, gradeNumber);
		
		List<ChooseClass> chooseClassList = new ArrayList<ChooseClass>();
		
		for(Student s : studentList) {
			chooseClassList.addAll(chooseClassDao.searchChooseClassByStudentId(s.getStudentId()));
		}
        
		return chooseClassList;
	}

	@Override
	public List<ChooseClass> searchMainByMajorNameAndGradeNumber(
			String majorName, int gradeNumber) {
		List<Student> studentList = studentDao.searchByMajorNameAndGradeNumber(majorName, gradeNumber);
		
		List<ChooseClass> chooseClassList = new ArrayList<ChooseClass>();
		
		for(Student s : studentList) {
			chooseClassList.addAll(chooseClassDao.searchMainChooseClassByStudentId(s.getStudentId()));
		}
        
		return chooseClassList;
	}

	@Override
	public ChooseClass searchChooseClassByUserNameAndCourseId(
			String userName, Integer courseId) {
        Student student = studentDao.searchByUserName(userName);
        
        ChooseClass chooseClass = chooseClassDao.searchByStudentIdAndCourseId(student.getStudentId(), courseId);
        
		return chooseClass;
	}
	
}
