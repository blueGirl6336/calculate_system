package com.cesystem.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.ScoreItemsDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.dao.WinScoreDao;
import com.cesystem.pojo.WinScore;
import com.cesystem.service.WinScoreService;

@Service
public class WinScoreServiceImpl implements WinScoreService {

	@Autowired
	private WinScoreDao winScoreDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	ScoreItemsDao scoreItemsDao;

	// 录入扣分信息和加分信息
	@Override
	public void addWinScore(WinScore winScore) {
		winScoreDao.add(winScore);
	}


	@Override
	public void addWinScoreByExcel(String path) {
		try {
			Workbook book = Workbook.getWorkbook(new File(path));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			WinScore winScore;
			for (int i = 0; i < sheet.getRows()-1; i++) {
				winScore = new WinScore();
				// 得到第一列第一行的单元格
				Cell cell = sheet.getCell(0, i+1);
				winScore.setStudent(studentDao.searchByUserName(cell
						.getContents()));
				cell = sheet.getCell(1, i+1);
				winScore.setScoreItems(scoreItemsDao.getById(Integer.parseInt(cell
						.getContents())));
				winScore.setIsCurrent(true);
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				java.util.Date date=new java.util.Date();  
				String time=sdf.format(date); 
				
				winScore.setTime(time);
				
				winScoreDao.add(winScore);
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
	
	// 修改扣分和加分信息
	@Override
	public void modifyWinScore(WinScore winScore) {
		winScoreDao.update(winScore);
	}

	// 删除加分和扣分信息
	@Override
	public void deleteWinScore(WinScore winScore) {
		winScoreDao.delete(winScore);
	}

	// 根据主键查找
	@Override
	public WinScore searchWinScoreById(int wsId) {
		WinScore winScore = winScoreDao.searchWinScoreById(wsId);
		return winScore;
	}

	// 根据学号查找加扣分信息
	@Override
	public List<WinScore> searchWinScoreByUserName(String userName) {
		List<WinScore> winScoreList = winScoreDao
				.searchWinScoreByUserName(userName);
		return winScoreList;
	}

	// 根据学生会成员的部门查找
	@Override
	public List<WinScore> searchWinScoreByApartmentId(int apartmentId) {
		List<WinScore> winScoreList = winScoreDao
				.searchWinScoreByApartmentId(apartmentId);
		return winScoreList;
	}

	// 查找所有加扣分信息
	@Override
	public List<WinScore> searchAllWinScore() {
		List<WinScore> winScoreList = winScoreDao.searchAllWinScore();
		return winScoreList;
	}


}
