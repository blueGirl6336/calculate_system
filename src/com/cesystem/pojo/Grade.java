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
 * Grade entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Grade", schema = "dbo", catalog = "ce_system", uniqueConstraints = @UniqueConstraint(columnNames = "grade_number"))
public class Grade implements java.io.Serializable {

	// Fields

	private Integer gradeId;
	private Integer gradeNumber;

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** minimal constructor */
	public Grade(Integer gradeId) {
		this.gradeId = gradeId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "grade_id", unique = true, nullable = false)
	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	@Column(name = "grade_number", unique = true)
	public Integer getGradeNumber() {
		return this.gradeNumber;
	}

	public void setGradeNumber(Integer gradeNumber) {
		this.gradeNumber = gradeNumber;
	}

}