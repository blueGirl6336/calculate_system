package com.cesystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.PeerEvaluationDao;
import com.cesystem.dao.PrizeDao;
import com.cesystem.dao.ScoreItemsDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.dao.WinPrizeDao;
import com.cesystem.dao.WinScoreDao;
import com.cesystem.pojo.PeerEvaluation;
import com.cesystem.pojo.Prize;
import com.cesystem.pojo.ScoreItems;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.WinPrize;
import com.cesystem.pojo.WinScore;
import com.cesystem.service.StatisticalReportsService;
import com.cesystem.temp.PeerEvaluationTemp;
import com.cesystem.util.ExcelUtil;
@Service
public class StatisticalRepotrsServiceImpl implements StatisticalReportsService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ScoreItemsDao scoreItemsDao;
	@Autowired
	private PrizeDao prizeDao;
	@Autowired
	private WinScoreDao winScoreDao;
	@Autowired
	private WinPrizeDao winPrizeDao;
	@Autowired
	private PeerEvaluationDao peerEvaluationDao;
	
	@Override
	public String getScoreStatisticalReports(String path) {
		List<Student> studentList = studentDao.getAllStudent();
		ExcelUtil excelUtil = new ExcelUtil();
		return excelUtil.createScoreExcel(studentList,path);
	}

	@Override
	public String getStudentScoreItemsStatisticalReports(String path) {
		List<Student> studentList = studentDao.getAllStudent();
        List<ScoreItems> scoreItemsList = scoreItemsDao.getAllScoreItems();
        List<WinScore> winScoreList = winScoreDao.searchAllWinScore();
		ExcelUtil excelUtil = new ExcelUtil();
		return excelUtil.createStudentScoreItemsExcel(studentList, scoreItemsList, winScoreList,path);
	}

	@Override
	public String getStudentPrizeStatisticalReports(String path) {
		List<Student> studentList = studentDao.getAllStudent();
        List<Prize> prizeList = prizeDao.getAll();
        List<WinPrize> winPrizeList = winPrizeDao.searchAllWinPrize();
		ExcelUtil excelUtil = new ExcelUtil();
		return excelUtil.createStudentPrizeExcel(studentList, prizeList, winPrizeList,path);
	}

	@Override
	public String getPeerEvaluationStatisticalReports(String classNumber, String path) {
		
		int excellentNumber;
		int goodNumber;
		int moderNumber;
		int commonNumber;
		
		PeerEvaluationTemp peerEvaluationTemp;
		
		List<Student> studentList = studentDao.getStudentByClassNumber(classNumber);
        List<PeerEvaluation> peerEvaluationList;
		List<PeerEvaluationTemp> peerEvaluationListTemp = new ArrayList<PeerEvaluationTemp>();
		
		if(null != studentList)
		{
			for(Student studentItem : studentList)
			{
				excellentNumber = 0;
				goodNumber = 0;
				moderNumber = 0;
				commonNumber = 0;
				peerEvaluationList = peerEvaluationDao.getPeerEvaluationByObjectId(studentItem.getStudentId());
				
				if(null != peerEvaluationList)
				{
					for(PeerEvaluation peerEvaluationItem : peerEvaluationList)
					{
						if(peerEvaluationItem.getLevel().equals("500001"))
						{
							excellentNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500002"))
						{
							goodNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500003"))
						{
							moderNumber ++;
						}
						else if(peerEvaluationItem.getLevel().equals("500004"))
						{
							commonNumber ++;
						}
					}
					peerEvaluationTemp = new PeerEvaluationTemp();
					
					peerEvaluationTemp.setStudentId(studentItem.getStudentId());
					peerEvaluationTemp.setStudentName(studentItem.getStudentName());
					peerEvaluationTemp.setStudentNumber(studentItem.getUsers().getUserName());
					peerEvaluationTemp.setExcellent(excellentNumber);
					peerEvaluationTemp.setGood(goodNumber);
					peerEvaluationTemp.setModer(moderNumber);
					peerEvaluationTemp.setCommon(commonNumber);
					peerEvaluationTemp.setResultScore((excellentNumber * 40 + goodNumber * 35 + moderNumber * 30 + commonNumber * 25) / studentList.size());
					
					peerEvaluationListTemp.add(peerEvaluationTemp);
				}
			}
		}
		

		ExcelUtil excelUtil = new ExcelUtil();
		return excelUtil.createPeerEvaluationByClassNumberExcel(peerEvaluationListTemp, path);
	}

	@Override
	public String getPerPeerEvaluationStatisticalReports(String classNumber,
			String path) {
		List<Student> studentList = studentDao.getStudentByClassNumber(classNumber);
        List<PeerEvaluation> peerEvaluationList = new ArrayList<PeerEvaluation>();
        
        for (Student s : studentList) {
        	peerEvaluationList.addAll(this.peerEvaluationDao.getPeerEvaluationByStudentId(s.getStudentId()));
        }
        
        
		return new ExcelUtil().getPerPeerEvaluationStatisticalReports(peerEvaluationList, path);
	}
}
