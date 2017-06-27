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
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Student", schema = "dbo", catalog = "ce_system", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class Student implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private Apartment apartment;
	private Users users;
	private Classes classes;
	private String studentName;
	private Double gpa;
	private Integer gpaSort;
	private Double comprehensivePerformance;
	private Double comprehensivePerformanceRanking;
	private String dormitoryNumber;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Apartment apartment, Users users, Classes classes,
			String studentName, Double gpa, Integer gpaSort,
			Double comprehensivePerformance,
			Double comprehensivePerformanceRanking, String dormitoryNumber) {
		this.apartment = apartment;
		this.users = users;
		this.classes = classes;
		this.studentName = studentName;
		this.gpa = gpa;
		this.gpaSort = gpaSort;
		this.comprehensivePerformance = comprehensivePerformance;
		this.comprehensivePerformanceRanking = comprehensivePerformanceRanking;
		this.dormitoryNumber = dormitoryNumber;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "student_id", unique = true, nullable = false)
	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "apartment_id")
	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", unique = true)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "class_number")
	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Column(name = "student_name", length = 20)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "gpa", precision = 18)
	public Double getGpa() {
		return this.gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	@Column(name = "gpa_sort")
	public Integer getGpaSort() {
		return this.gpaSort;
	}

	public void setGpaSort(Integer gpaSort) {
		this.gpaSort = gpaSort;
	}

	@Column(name = "comprehensive_performance", precision = 18)
	public Double getComprehensivePerformance() {
		return this.comprehensivePerformance;
	}

	public void setComprehensivePerformance(Double comprehensivePerformance) {
		this.comprehensivePerformance = comprehensivePerformance;
	}

	@Column(name = "comprehensive_performance_ranking", precision = 18)
	public Double getComprehensivePerformanceRanking() {
		return this.comprehensivePerformanceRanking;
	}

	public void setComprehensivePerformanceRanking(
			Double comprehensivePerformanceRanking) {
		this.comprehensivePerformanceRanking = comprehensivePerformanceRanking;
	}

	@Column(name = "dormitory_number")
	public String getDormitoryNumber() {
		return this.dormitoryNumber;
	}

	public void setDormitoryNumber(String dormitoryNumber) {
		this.dormitoryNumber = dormitoryNumber;
	}


}