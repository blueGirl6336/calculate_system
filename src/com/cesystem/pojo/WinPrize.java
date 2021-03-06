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
 * WinPrize entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "WinPrize", schema = "dbo", catalog = "ce_system")
public class WinPrize implements java.io.Serializable {

	// Fields

	private Integer wpId;
	private Student student;
	private PrizeApplication prizeApplication;
	private Prize prize;
	private Boolean isCurrent;
	private String time;

	// Constructors

	/** default constructor */
	public WinPrize() {
	}

	/** minimal constructor */
	public WinPrize(Integer wpId) {
		this.wpId = wpId;
	}

	/** full constructor */
	public WinPrize(Integer wpId, Student student,
			PrizeApplication prizeApplication, Prize prize, Boolean isCurrent,
			String time) {
		this.wpId = wpId;
		this.student = student;
		this.prizeApplication = prizeApplication;
		this.prize = prize;
		this.isCurrent = isCurrent;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "wp_id", unique = true, nullable = false)
	public Integer getWpId() {
		return this.wpId;
	}

	public void setWpId(Integer wpId) {
		this.wpId = wpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pa_id")
	public PrizeApplication getPrizeApplication() {
		return this.prizeApplication;
	}

	public void setPrizeApplication(PrizeApplication prizeApplication) {
		this.prizeApplication = prizeApplication;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prize_id")
	public Prize getPrize() {
		return this.prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	@Column(name = "is_current")
	public Boolean getIsCurrent() {
		return this.isCurrent;
	}

	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

	@Column(name = "time")
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}