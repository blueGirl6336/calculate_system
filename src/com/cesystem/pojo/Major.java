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
import javax.persistence.UniqueConstraint;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Major", schema = "dbo", catalog = "ce_system", uniqueConstraints = @UniqueConstraint(columnNames = "major_name"))
public class Major implements java.io.Serializable {

	// Fields

	private Integer majorId;
	private College college;
	private String majorName;

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(Integer majorId) {
		this.majorId = majorId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "major_id", unique = true, nullable = false)
	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "college_id")
	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Column(name = "major_name", unique = true)
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

}