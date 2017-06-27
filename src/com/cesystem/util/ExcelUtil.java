package com.cesystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.cesystem.pojo.PeerEvaluation;
import com.cesystem.pojo.Prize;
import com.cesystem.pojo.ScoreItems;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.WinPrize;
import com.cesystem.pojo.WinScore;
import com.cesystem.temp.PeerEvaluationTemp;

public class ExcelUtil {

	public String createScoreExcel(List<Student> studentList, String path) {
		// File file = new File(ConstUtil.XLS_PATH + "Score");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String str = sdf.format(date);
		String realPath = path + "/" + str + ".xls";
		File file = new File(realPath);
		if (!file.exists()) {

		}
		FileOutputStream os;
		try {
			Label iteLabel = null;
			Number iteNumber = null;
			int ite = 0;
			os = new FileOutputStream(file);
			// 创建工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			// 创建新的一页
			WritableSheet sheet = workbook.createSheet("学生成绩表", 0);
			// 创建要显示的具体内容
			Label tUserName = new Label(0, 0, "学号");
			sheet.addCell(tUserName);
			Label tStudentName = new Label(1, 0, "学生姓名");
			sheet.addCell(tStudentName);
			Label tGpa = new Label(2, 0, "GPA");
			sheet.addCell(tGpa);
			Label tGpaSort = new Label(3, 0, "GPA排名");
			sheet.addCell(tGpaSort);
			Label tComprehensivePerformance = new Label(4, 0, "综合成绩");
			sheet.addCell(tComprehensivePerformance);
			Label tComprehensivePerformanceRanking = new Label(5, 0, "综合成绩排名");
			sheet.addCell(tComprehensivePerformanceRanking);
			Label tClass = new Label(6, 0, "班级");
			sheet.addCell(tClass);
			for (Student s : studentList) {
				ite++;
				iteLabel = new Label(0, ite, s.getUsers().getUserName());
				sheet.addCell(iteLabel);

				iteLabel = new Label(1, ite, s.getStudentName());
				sheet.addCell(iteLabel);

				iteNumber = new Number(2, ite, s.getGpa());
				sheet.addCell(iteNumber);

				iteNumber = new Number(3, ite, s.getGpaSort());
				sheet.addCell(iteNumber);

				iteNumber = new Number(4, ite, s.getComprehensivePerformance());
				sheet.addCell(iteNumber);

				iteNumber = new Number(5, ite,
						s.getComprehensivePerformanceRanking());
				sheet.addCell(iteNumber);

				iteLabel = new Label(6, ite, s.getClasses().getClassNumber());
				sheet.addCell(iteLabel);
			}
			// 把创建的内容写入到输出流中，并关闭输出流
			workbook.write();
			workbook.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return ConstUtil.SERVER_PATH + "Score";
		return ConstUtil.SERVER_PATH + realPath;
	}

	public String createStudentScoreItemsExcel(List<Student> studentList,
			List<ScoreItems> scoreItemsList, List<WinScore> winScoreList,
			String path) {
		// File file = new File(ConstUtil.XLS_PATH + "StudentScoreItems");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String str = sdf.format(date);
		String realPath = path + "/" + str + ".xls";
		File file = new File(realPath);
		if (!file.exists()) {

		}
		FileOutputStream os;
		try {
			Label iteLabel = null;
			// Number iteNumber = null;
			// int ite = 0;
			os = new FileOutputStream(file);
			// 创建工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			// 创建新的一页
			WritableSheet sheet = workbook.createSheet("学生加分项表", 0);
			// 创建要显示的具体内容
			for (int i = 0; i < scoreItemsList.size(); i++) {
				iteLabel = new Label(i + 1, 0, scoreItemsList.get(i)
						.getItemName());
				sheet.addCell(iteLabel);
			}
			for (int i = 0; i < studentList.size(); i++) {
				iteLabel = new Label(0, i + 1, studentList.get(i)
						.getStudentName());
				sheet.addCell(iteLabel);
				for (WinScore w : winScoreList) {
					for (int j = 0; j < scoreItemsList.size(); j++) {
						if (scoreItemsList.get(j).getSiId() == w
								.getScoreItems().getSiId()) {
							iteLabel = new Label(j + 1, i + 1, "1");
							sheet.addCell(iteLabel);
						}
					}
				}
			}
			// 把创建的内容写入到输出流中，并关闭输出流
			workbook.write();
			workbook.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return ConstUtil.SERVER_PATH + "StudentScoreItems";
		return ConstUtil.SERVER_PATH + realPath;
	}

	public String createStudentPrizeExcel(List<Student> studentList,
			List<Prize> prizeList, List<WinPrize> winPrizeList, String path) {
		// File file = new File(ConstUtil.XLS_PATH + "StudentPrize");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String str = sdf.format(date);
		String realPath = path + "/" + str + ".xls";
		File file = new File(realPath);
		if (!file.exists()) {

		}
		FileOutputStream os;
		try {
			Label iteLabel = null;
			// Number iteNumber = null;
			// int ite = 0;
			os = new FileOutputStream(file);
			// 创建工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			// 创建新的一页
			WritableSheet sheet = workbook.createSheet("学生奖项表", 0);
			// 创建要显示的具体内容
			for (int i = 0; i < prizeList.size(); i++) {
				iteLabel = new Label(i + 1, 0, prizeList.get(i).getPrizeName());
				sheet.addCell(iteLabel);
			}
			for (int i = 0; i < studentList.size(); i++) {
				iteLabel = new Label(0, i + 1, studentList.get(i)
						.getStudentName());
				sheet.addCell(iteLabel);
				for (WinPrize w : winPrizeList) {
					for (int j = 0; j < prizeList.size(); j++) {
						if (prizeList.get(j).getPrizeId() == w.getPrize()
								.getPrizeId()) {
							iteLabel = new Label(j + 1, i + 1, "1");
							sheet.addCell(iteLabel);
						}
					}
				}
			}
			// 把创建的内容写入到输出流中，并关闭输出流
			workbook.write();
			workbook.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return ConstUtil.SERVER_PATH + "StudentPrize";
		return ConstUtil.SERVER_PATH + realPath;
	}

	public String createPeerEvaluationByClassNumberExcel(
			List<PeerEvaluationTemp> peerEvaluationListTemp, String path) {
		// File file = new File(ConstUtil.XLS_PATH +
		// "PeerEvaluationByClassNumber");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String str = sdf.format(date);
		String realPath = path + "/" + str + ".xls";
		File file = new File(realPath);
		if (!file.exists()) {

		}
		FileOutputStream os;
		try {
			Label iteLabel = null;
			Number iteNumber = null;
			int ite = 0;
			os = new FileOutputStream(file);
			// 创建工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			// 创建新的一页
			WritableSheet sheet = workbook.createSheet("学生互评得分表", 0);
			// 创建要显示的具体内容
			Label tStudentNumber = new Label(0, 0, "学号");
			sheet.addCell(tStudentNumber);
			Label tStudentName = new Label(1, 0, "姓名");
			sheet.addCell(tStudentName);
			Label tExcellent = new Label(2, 0, "优");
			sheet.addCell(tExcellent);
			Label tGood = new Label(3, 0, "良");
			sheet.addCell(tGood);
			Label tModer = new Label(4, 0, "中");
			sheet.addCell(tModer);
			Label tCommon = new Label(5, 0, "一般");
			sheet.addCell(tCommon);
			Label tResultScore = new Label(6, 0, "得分");
			sheet.addCell(tResultScore);
			for (PeerEvaluationTemp p : peerEvaluationListTemp) {
				ite++;
				iteLabel = new Label(0, ite, p.getStudentNumber());
				sheet.addCell(iteLabel);

				iteLabel = new Label(1, ite, p.getStudentName());
				sheet.addCell(iteLabel);

				iteNumber = new Number(2, ite, p.getExcellent());
				sheet.addCell(iteNumber);

				iteNumber = new Number(3, ite, p.getGood());
				sheet.addCell(iteNumber);

				iteNumber = new Number(4, ite, p.getModer());
				sheet.addCell(iteNumber);

				iteNumber = new Number(5, ite, p.getCommon());
				sheet.addCell(iteNumber);

				iteNumber = new Number(6, ite, p.getResultScore());
				sheet.addCell(iteNumber);
			}
			// 把创建的内容写入到输出流中，并关闭输出流
			workbook.write();
			workbook.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return ConstUtil.SERVER_PATH + "PeerEvaluationByClassNumber";
		return ConstUtil.SERVER_PATH + realPath;
	}

	public String getPerPeerEvaluationStatisticalReports(
			List<PeerEvaluation> peerEvaluationList, String path) {
		// File file = new File(ConstUtil.XLS_PATH +
		// "PeerEvaluationByClassNumber");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String str = sdf.format(date);
		String realPath = path + "/" + str + ".xls";
		File file = new File(realPath);
		if (!file.exists()) {

		}
		FileOutputStream os;
		try {
			Label iteLabel = null;
			Number iteNumber = null;
			int ite = 0;
			os = new FileOutputStream(file);
			// 创建工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			// 创建新的一页
			WritableSheet sheet = workbook.createSheet("学生个人互评得分表", 0);
			// 创建要显示的具体内容
			Label tStudentNumber = new Label(0, 0, "评者学号");
			sheet.addCell(tStudentNumber);
			Label tStudentName = new Label(1, 0, "被评者学号");
			sheet.addCell(tStudentName);
			Label tExcellent = new Label(2, 0, "互评值");
			for (PeerEvaluation p : peerEvaluationList) {
				ite++;
				iteLabel = new Label(0, ite, p.getStudentByStudentId().getUsers().getUserName());
				sheet.addCell(iteLabel);

				iteLabel = new Label(1, ite, p.getStudentByObjectId().getUsers().getUserName());
				sheet.addCell(iteLabel);

				String level = null;
				if ("500001".equals(p.getLevel())) {
					level = "优";
				}else if ("500002".equals(p.getLevel())) {
					level = "良";
				}else if ("500003".equals(p.getLevel())) {
					level = "中";
				}else if ("500004".equals(p.getLevel())) {
					level = "一般";
				}
				iteLabel = new Label(2, ite, level);
				sheet.addCell(iteLabel);
			}
			// 把创建的内容写入到输出流中，并关闭输出流
			workbook.write();
			workbook.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return ConstUtil.SERVER_PATH + "PeerEvaluationByClassNumber";
		return ConstUtil.SERVER_PATH + realPath;
	}

	/**
	 * 打开读文件
	 * 
	 * @param filePath
	 * @param rwb
	 * @return
	 */
	public static Workbook openRead(String filePath, Workbook rwb) {
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rwb = Workbook.getWorkbook(is);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rwb;
	}
	/*
	 * public void addChooseClassByExcel(String path) { StudentService
	 * studentService = new StudentServiceImpl(); CourseService courseService =
	 * new CourseServiceImpl(); ChooseClassService chooseClassService = new
	 * ChooseClassServiceImpl(); try { Workbook book = Workbook.getWorkbook(new
	 * File(path)); // 获得第一个工作表对象 Sheet sheet = book.getSheet(0); ChooseClass
	 * chooseClass; for (int i = 0; i < sheet.getRows(); i++) { chooseClass =
	 * new ChooseClass(); // 得到第一列第一行的单元格 Cell cell = sheet.getCell(0, i+1);
	 * chooseClass.setStudent(studentService.searchByUserName(cell
	 * .getContents())); cell = sheet.getCell(1, i+1);
	 * chooseClass.setCourse(courseService.searchByCourseName(cell
	 * .getContents())); chooseClass.setIsCurrent(true); cell = sheet.getCell(2,
	 * i+1); chooseClass.setScore(Double.parseDouble(cell.getContents()));
	 * chooseClassService.addChooseClass(chooseClass); } book.close(); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e)
	 * { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/*
	 * public void addWinPrizeByExcel(String path) { StudentService
	 * studentService = new StudentServiceImpl(); PrizeService prizeService =
	 * new PrizeServiceImpl(); WinPrizeService winPrizeService = new
	 * WinPrizeServiceImpl(); try { Workbook book = Workbook.getWorkbook(new
	 * File(path)); // 获得第一个工作表对象 Sheet sheet = book.getSheet(0); WinPrize
	 * winPrize; for (int i = 0; i < sheet.getRows(); i++) { winPrize = new
	 * WinPrize(); // 得到第一列第一行的单元格 Cell cell = sheet.getCell(0, i+1);
	 * winPrize.setStudent(studentService.searchByUserName(cell
	 * .getContents())); cell = sheet.getCell(1, i+1);
	 * winPrize.setPrize(prizeService.getById(Integer.parseInt(cell
	 * .getContents()))); winPrize.setIsCurrent(true);
	 * 
	 * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); java.util.Date
	 * date=new java.util.Date(); String time=sdf.format(date);
	 * 
	 * winPrize.setTime(time);
	 * 
	 * winPrizeService.addWinPrize(winPrize); } book.close(); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e)
	 * { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); } }
	 */
}
