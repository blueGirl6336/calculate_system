package com.cesystem.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AuditScore entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AuditScore", schema = "dbo", catalog = "ce_system")
public class AuditScore implements java.io.Serializable {

	// Fields

	private Integer asId;
	private ScoreApplication scoreApplication;
	private Student student;
	private Boolean isAgree;
	private String remark;

	// Constructors

	/** default constructor */
	public AuditScore() {
	}

	/** minimal constructor */
	public AuditScore(Integer asId) {
		this.asId = asId;
	}

	/** full constructor */
	public AuditScore(Integer asId, ScoreApplication scoreApplication,
			Student student, Boolean isAgree, String remark) {
		this.asId = asId;
		this.scoreApplication = scoreApplication;
		this.student = student;
		this.isAgree = isAgree;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "as_id", unique = true, nullable = false)
	public Integer getAsId() {
		return this.asId;
	}

	public void setAsId(Integer asId) {
		this.asId = asId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "score_application_id")
	public ScoreApplication getScoreApplication() {
		return this.scoreApplication;
	}

	public void setScoreApplication(ScoreApplication scoreApplication) {
		this.scoreApplication = scoreApplication;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "is_agree")
	public Boolean getIsAgree() {
		return this.isAgree;
	}

	public void setIsAgree(Boolean isAgree) {
		this.isAgree = isAgree;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}