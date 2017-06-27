package com.cesystem.temp;

import com.cesystem.pojo.Prize;
import com.cesystem.pojo.Student;

public class PrizeApplicationTemp {

	private Integer paId;
	private Student studentByObjectId;
	private Prize prize;
	private Student studentByApplicantId;
	private String type;
	private String status;
	private String applicationDetail;
	private String times;
	public Integer getPaId() {
		return paId;
	}
	public void setPaId(Integer paId) {
		this.paId = paId;
	}
	public Student getStudentByObjectId() {
		return studentByObjectId;
	}
	public void setStudentByObjectId(Student studentByObjectId) {
		this.studentByObjectId = studentByObjectId;
	}
	public Prize getPrize() {
		return prize;
	}
	public void setPrize(Prize prize) {
		this.prize = prize;
	}
	public Student getStudentByApplicantId() {
		return studentByApplicantId;
	}
	public void setStudentByApplicantId(Student studentByApplicantId) {
		this.studentByApplicantId = studentByApplicantId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApplicationDetail() {
		return applicationDetail;
	}
	public void setApplicationDetail(String applicationDetail) {
		this.applicationDetail = applicationDetail;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
}
