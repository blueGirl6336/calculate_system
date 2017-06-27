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
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Course", schema = "dbo", catalog = "ce_system", uniqueConstraints = {
		@UniqueConstraint(columnNames = "course_name"),
		@UniqueConstraint(columnNames = "course_number") })
public class Course implements java.io.Serializable {

	// Fields

	private Integer courseId;
	private String courseNumber;
	private String courseName;
	private Double point;
	private String type;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer courseId) {
		this.courseId = courseId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "course_number", unique = true)
	public String getCourseNumber() {
		return this.courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	@Column(name = "course_name", unique = true)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "point", precision = 18)
	public Double getPoint() {
		return this.point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}