package com.cesystem.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * College entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "College", schema = "dbo", catalog = "ce_system", uniqueConstraints = @UniqueConstraint(columnNames = "college_name"))
public class College implements java.io.Serializable {

	// Fields

	private Integer collegeId;
	private String collegeName;

	// Constructors

	/** default constructor */
	public College() {
	}

	/** minimal constructor */
	public College(Integer collegeId) {
		this.collegeId = collegeId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "college_id", unique = true, nullable = false)
	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	@Column(name = "college_name", unique = true, length = 50)
	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}