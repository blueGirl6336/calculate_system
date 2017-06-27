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
 * PeerEvaluation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PeerEvaluation", schema = "dbo", catalog = "ce_system")
public class PeerEvaluation implements java.io.Serializable {

	// Fields

	private Integer peId;
	private Student studentByObjectId;
	private Student studentByStudentId;
	private String level;
	private Boolean isCurrent;
	private String time;

	// Constructors

	/** default constructor */
	public PeerEvaluation() {
	}

	/** minimal constructor */
	public PeerEvaluation(Integer peId) {
		this.peId = peId;
	}

	/** full constructor */
	public PeerEvaluation(Integer peId, Student studentByObjectId,
			Student studentByStudentId, String level, Boolean isCurrent,
			String time) {
		this.peId = peId;
		this.studentByObjectId = studentByObjectId;
		this.studentByStudentId = studentByStudentId;
		this.level = level;
		this.isCurrent = isCurrent;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pe_id", unique = true, nullable = false)
	public Integer getPeId() {
		return this.peId;
	}

	public void setPeId(Integer peId) {
		this.peId = peId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "object_id")
	public Student getStudentByObjectId() {
		return this.studentByObjectId;
	}

	public void setStudentByObjectId(Student studentByObjectId) {
		this.studentByObjectId = studentByObjectId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	public Student getStudentByStudentId() {
		return this.studentByStudentId;
	}

	public void setStudentByStudentId(Student studentByStudentId) {
		this.studentByStudentId = studentByStudentId;
	}

	@Column(name = "level", length = 50)
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
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