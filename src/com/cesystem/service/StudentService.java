package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.Major;
import com.cesystem.pojo.Rank;
import com.cesystem.pojo.Student;
import com.cesystem.temp.MajorRankTemp;
import com.cesystem.temp.StudentScoreTemp;
import com.cesystem.temp.StudentSimpleInf;

public interface StudentService {

	public List<Rank> getClassRank(String classId);

	public StudentScoreTemp getStudentScoreTempById(int studentId);

	public List<String> getAllCourse(String classId);

	public Student getStudentById(int studentId);

	public List<Student> getAllStudent();

	public boolean changeApartment(int studentId, int apartmentId);

	public Student searchByUserName(String UserName);


	public StudentSimpleInf searchByUserName2(String UserName);

	public List<StudentSimpleInf> searchByName(String name);

	/**
	 * 学生注册
	 * 
	 * @param studentSimpleInfs
	 * @return
	 */
	public String studentRegister(List<StudentSimpleInf> studentSimpleInfs);

	public List<MajorRankTemp> getMajorRank(Major major);

	public List<Student> getAllClassStudent(int studentId);
	
	public List<Student> getMajorStudent(int studentId);
}
