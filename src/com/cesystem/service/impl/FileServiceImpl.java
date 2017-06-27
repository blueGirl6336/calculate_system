package com.cesystem.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.cesystem.dao.ClassesDao;
import com.cesystem.pojo.Classes;
import com.cesystem.service.FileService;
import com.cesystem.temp.StudentSimpleInf;
import com.cesystem.util.ExcelUtil;
import com.cesystem.util.FileUtil;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private ClassesDao classesDao;

	@Override
	public List<StudentSimpleInf> manageFile(File fileData) {

		List<StudentSimpleInf> studentSimpleInfs = new ArrayList<StudentSimpleInf>();
		Random r = new Random();
		Integer inte = r.nextInt() % 10007;
		Date date = new Date();
		String dirName = new SimpleDateFormat("yyyyMMdd").format(date);
		String newFileName = new SimpleDateFormat("yyyyMMddHHmmss_SSS")
				.format(date) + inte.toString() + ".xls";

		String filePath = FileUtil.savePath + "/" + dirName;

		FileUtil.uploadFile(filePath, fileData, newFileName);

		Workbook rwb = null;

		filePath = filePath + "/" + newFileName;
		rwb = ExcelUtil.openRead(filePath, rwb);

		Sheet oSheet = rwb.getSheet(0);
		int row = oSheet.getRows();
		Cell cell = null;
		String userName = "";
		String name = "";
		Classes classes = null;
		StudentSimpleInf studentSimpleInf = null;
		String dormitoryNumber = "";
		for (int i = 0; i < row; i++) {
			cell = oSheet.getCell(0, i);
			userName = cell.getContents();
			cell = oSheet.getCell(1, i);
			name = cell.getContents();
			cell = oSheet.getCell(2, i);
			classes = classesDao.getClassesByNumber(cell.getContents());
			cell = oSheet.getCell(3, i);
			dormitoryNumber = cell.getContents();

			studentSimpleInf = new StudentSimpleInf();
			studentSimpleInf.setUserName(userName);
			studentSimpleInf.setPassword(userName);
			studentSimpleInf.setClassNumber(classes.getClassNumber());
			studentSimpleInf.setStudentName(name);
			studentSimpleInf.setDormitoryNumber(dormitoryNumber);
			studentSimpleInfs.add(studentSimpleInf);
			
		}

		return studentSimpleInfs;
	}

}
