package com.cesystem.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ScoreApplication entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ScoreApplication", schema = "dbo", catalog = "ce_system")
public class ScoreApplication implements java.io.Serializable {

	// Fields

	private Integer saId;
	private ScoreItems scoreItems;
	private Student studentByObjectId;
	private Student studentByApplicantId;
	private String type;
	private String status;
	private String applicationDetail;
	private String time;

	// Constructors

	/** default constructor */
	public ScoreApplication() {
	}

	/** minimal constructor */
	public ScoreApplication(Integer saId) {
		this.saId = saId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sa_id", unique = true, nullable = false)
	public Integer getSaId() {
		return this.saId;
	}

	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "si_id")
	public ScoreItems getScoreItems() {
		return this.scoreItems;
	}

	public void setScoreItems(ScoreItems scoreItems) {
		this.scoreItems = scoreItems;
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
	@JoinColumn(name = "applicant_id")
	public Student getStudentByApplicantId() {
		return this.studentByApplicantId;
	}

	public void setStudentByApplicantId(Student studentByApplicantId) {
		this.studentByApplicantId = studentByApplicantId;
	}

	@Column(name = "type", length = 40)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "status", length = 40)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "application_detail")
	public String getApplicationDetail() {
		return this.applicationDetail;
	}

	public void setApplicationDetail(String applicationDetail) {
		this.applicationDetail = applicationDetail;
	}

	@Column(name = "time")
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}