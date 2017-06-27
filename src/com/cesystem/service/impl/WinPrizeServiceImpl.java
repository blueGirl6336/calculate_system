package com.cesystem.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.PrizeDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.dao.WinPrizeDao;
import com.cesystem.pojo.WinPrize;
import com.cesystem.service.WinPrizeService;
import com.cesystem.temp.WinPrizeTemp;

@Service
public class WinPrizeServiceImpl implements WinPrizeService {

	private List<WinPrize> winPrizeList;
	private WinPrizeTemp winPrizeTemp;
	private List<WinPrizeTemp> winPrizeTempList;
	@Autowired
	private WinPrizeDao winPrizeDao;

	@Autowired
	StudentDao studentDao;
	@Autowired
	PrizeDao prizeDao;
	
	@Override
	public List<WinPrizeTemp> getWinPrize(int studentId) {
		// TODO Auto-generated method stub
		//��Stringת����ΪDate��ʽ
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		winPrizeList = winPrizeDao.getWinPrize(studentId);
		winPrizeTemp = new WinPrizeTemp();
		winPrizeTempList = new ArrayList<WinPrizeTemp>();
		if(null != winPrizeList)
		{
			for(WinPrize item : winPrizeList)
			{
				winPrizeTemp.setPrizeId(item.getPrize().getPrizeId());
				winPrizeTemp.setPrizeName(item.getPrize().getPrizeName());
				try {
					winPrizeTemp.setDate(formatter.parse(item.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				winPrizeTempList.add(winPrizeTemp);
			}
			
		};
		if(null != winPrizeTempList)
			System.out.println(winPrizeTempList.size());
		return winPrizeTempList;
	}

    //录入扣分信息和加分信息
	@Override
	public void addWinPrize(WinPrize winPrize) {
		winPrizeDao.add(winPrize);
	}

	@Override
	public void addWinPrizeByExcel(String path) {
		try {
			Workbook book = Workbook.getWorkbook(new File(path));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			WinPrize winPrize;
			for (int i = 0; i < sheet.getRows()-1; i++) {
				winPrize = new WinPrize();
				// 得到第一列第一行的单元格
				Cell cell = sheet.getCell(0, i+1);
				winPrize.setStudent(studentDao.searchByUserName(cell
						.getContents()));
				cell = sheet.getCell(1, i+1);
				winPrize.setPrize(prizeDao.getPrizeById(Integer.parseInt(cell
						.getContents())));
				winPrize.setIsCurrent(true);
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				java.util.Date date=new java.util.Date();  
				String time=sdf.format(date); 
				
				winPrize.setTime(time);
				
				winPrizeDao.add(winPrize);
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
	
	//修改扣分和加分信息
	@Override
	public void modifyWinPrize(WinPrize winPrize) {
		winPrizeDao.update(winPrize);
	}

	//删除加分和扣分信息
	@Override
	public void deleteWinPrize(WinPrize winPrize) {
		winPrizeDao.delete(winPrize);
	}

	//根据主键查找
	@Override
	public WinPrize searchWinPrizeById(int wpId) {
		WinPrize winPrize = winPrizeDao.searchWinPrizeById(wpId);
		return winPrize;
	}
	
	//根据学号查找加扣分信息
	@Override
	public List<WinPrize> searchWinPrizeByUserName(String userName) {
		List<WinPrize> winPrizeList = winPrizeDao.searchWinPrizeByUserName(userName);
		return winPrizeList;
	}

	//根据学生会成员的部门查找
	@Override
	public List<WinPrize> searchWinPrizeByApartmentId(
			int apartmentId) {
		List<WinPrize> winPrizeList = winPrizeDao.searchWinPrizeByApartmentId(apartmentId);
		return winPrizeList;
	}
	
	//查找所有加扣分信息
	@Override
	public List<WinPrize> searchAllWinPrize() {
		List<WinPrize> winPrizeList = winPrizeDao.searchAllWinPrize();
				return winPrizeList;
	}


}
