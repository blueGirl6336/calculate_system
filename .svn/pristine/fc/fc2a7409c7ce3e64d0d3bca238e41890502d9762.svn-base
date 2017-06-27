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
 * AuditPrize entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AuditPrize", schema = "dbo", catalog = "ce_system")
public class AuditPrize implements java.io.Serializable {

	// Fields

	private Integer apId;
	private PrizeApplication prizeApplication;
	private Student student;
	private Boolean isAgree;
	private String remark;

	// Constructors

	/** default constructor */
	public AuditPrize() {
	}

	/** minimal constructor */
	public AuditPrize(Integer apId) {
		this.apId = apId;
	}

	/** full constructor */
	public AuditPrize(Integer apId, PrizeApplication prizeApplication,
			Student student, Boolean isAgree, String remark) {
		this.apId = apId;
		this.prizeApplication = prizeApplication;
		this.student = student;
		this.isAgree = isAgree;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ap_id", unique = true, nullable = false)
	public Integer getApId() {
		return this.apId;
	}

	public void setApId(Integer apId) {
		this.apId = apId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prize_application_id")
	public PrizeApplication getPrizeApplication() {
		return this.prizeApplication;
	}

	public void setPrizeApplication(PrizeApplication prizeApplication) {
		this.prizeApplication = prizeApplication;
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