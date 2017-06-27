package com.cesystem.temp;

import java.util.List;

import com.cesystem.pojo.WinScore;

public class StudentScoreTemp {

	private String studentNumber;
	private String studentName;
	private double peerEvaluation;
	private double gpa;
	private double personalityDevelopment;
	private double daily;
	private double comprehensiveScore;				//综合成绩
	private int	gpaSort;
	private int comprehensiveScoreSort;				//综合成绩排名
	private List<WinScoreTemp> winScoreTempList;	//加分情况列表
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public double getPeerEvaluation() {
		return peerEvaluation;
	}
	public void setPeerEvaluation(double peerEvaluation) {
		this.peerEvaluation = peerEvaluation;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public double getPersonalityDevelopment() {
		return personalityDevelopment;
	}
	public void setPersonalityDevelopment(double personalityDevelopment) {
		this.personalityDevelopment = personalityDevelopment;
	}
	public double getDaily() {
		return daily;
	}
	public void setDaily(double daily) {
		this.daily = daily;
	}
	public double getComprehensiveScore() {
		return comprehensiveScore;
	}
	public void setComprehensiveScore(double comprehensiveScore) {
		this.comprehensiveScore = comprehensiveScore;
	}
	public int getGpaSort() {
		return gpaSort;
	}
	public void setGpaSort(int gpaSort) {
		this.gpaSort = gpaSort;
	}
	public int getComprehensiveScoreSort() {
		return comprehensiveScoreSort;
	}
	public void setComprehensiveScoreSort(int comprehensiveScoreSort) {
		this.comprehensiveScoreSort = comprehensiveScoreSort;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<WinScoreTemp> getWinScoreTempList() {
		return winScoreTempList;
	}
	public void setWinScoreTempList(List<WinScoreTemp> winScoreTempList) {
		this.winScoreTempList = winScoreTempList;
	}
}
