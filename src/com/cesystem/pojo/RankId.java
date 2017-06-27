package com.cesystem.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RankId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class RankId implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private String studentName;
	private String studentNumber;
	private String classNumber;
	private Double gpa;
	private Integer gpaSort;
	private Double comprehensivePerformance;
	private Double comprehensivePerformanceRanking;
	private String courseName;
	private Double point;
	private Double score;

	// Constructors

	/** default constructor */
	public RankId() {
	}

	/** minimal constructor */
	public RankId(Integer studentId, String classNumber) {
		this.studentId = studentId;
		this.classNumber = classNumber;
	}

	/** full constructor */
	public RankId(Integer studentId, String studentName, String studentNumber,
			String classNumber, Double gpa, Integer gpaSort,
			Double comprehensivePerformance,
			Double comprehensivePerformanceRanking, String courseName,
			Double point, Double score) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.classNumber = classNumber;
		this.gpa = gpa;
		this.gpaSort = gpaSort;
		this.comprehensivePerformance = comprehensivePerformance;
		this.comprehensivePerformanceRanking = comprehensivePerformanceRanking;
		this.courseName = courseName;
		this.point = point;
		this.score = score;
	}

	// Property accessors

	@Column(name = "student_id", nullable = false)
	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Column(name = "student_name", length = 20)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "student_number", length = 20)
	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	@Column(name = "class_number", nullable = false, length = 20)
	public String getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
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

	@Column(name = "comprehensive_performance", precision = 53, scale = 0)
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

	@Column(name = "course_name")
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

	@Column(name = "score", precision = 18)
	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RankId))
			return false;
		RankId castOther = (RankId) other;

		return ((this.getStudentId() == castOther.getStudentId()) || (this
				.getStudentId() != null && castOther.getStudentId() != null && this
				.getStudentId().equals(castOther.getStudentId())))
				&& ((this.getStudentName() == castOther.getStudentName()) || (this
						.getStudentName() != null
						&& castOther.getStudentName() != null && this
						.getStudentName().equals(castOther.getStudentName())))
				&& ((this.getStudentNumber() == castOther.getStudentNumber()) || (this
						.getStudentNumber() != null
						&& castOther.getStudentNumber() != null && this
						.getStudentNumber()
						.equals(castOther.getStudentNumber())))
				&& ((this.getClassNumber() == castOther.getClassNumber()) || (this
						.getClassNumber() != null
						&& castOther.getClassNumber() != null && this
						.getClassNumber().equals(castOther.getClassNumber())))
				&& ((this.getGpa() == castOther.getGpa()) || (this.getGpa() != null
						&& castOther.getGpa() != null && this.getGpa().equals(
						castOther.getGpa())))
				&& ((this.getGpaSort() == castOther.getGpaSort()) || (this
						.getGpaSort() != null && castOther.getGpaSort() != null && this
						.getGpaSort().equals(castOther.getGpaSort())))
				&& ((this.getComprehensivePerformance() == castOther
						.getComprehensivePerformance()) || (this
						.getComprehensivePerformance() != null
						&& castOther.getComprehensivePerformance() != null && this
						.getComprehensivePerformance().equals(
								castOther.getComprehensivePerformance())))
				&& ((this.getComprehensivePerformanceRanking() == castOther
						.getComprehensivePerformanceRanking()) || (this
						.getComprehensivePerformanceRanking() != null
						&& castOther.getComprehensivePerformanceRanking() != null && this
						.getComprehensivePerformanceRanking().equals(
								castOther.getComprehensivePerformanceRanking())))
				&& ((this.getCourseName() == castOther.getCourseName()) || (this
						.getCourseName() != null
						&& castOther.getCourseName() != null && this
						.getCourseName().equals(castOther.getCourseName())))
				&& ((this.getPoint() == castOther.getPoint()) || (this
						.getPoint() != null && castOther.getPoint() != null && this
						.getPoint().equals(castOther.getPoint())))
				&& ((this.getScore() == castOther.getScore()) || (this
						.getScore() != null && castOther.getScore() != null && this
						.getScore().equals(castOther.getScore())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		result = 37
				* result
				+ (getStudentName() == null ? 0 : this.getStudentName()
						.hashCode());
		result = 37
				* result
				+ (getStudentNumber() == null ? 0 : this.getStudentNumber()
						.hashCode());
		result = 37
				* result
				+ (getClassNumber() == null ? 0 : this.getClassNumber()
						.hashCode());
		result = 37 * result
				+ (getGpa() == null ? 0 : this.getGpa().hashCode());
		result = 37 * result
				+ (getGpaSort() == null ? 0 : this.getGpaSort().hashCode());
		result = 37
				* result
				+ (getComprehensivePerformance() == null ? 0 : this
						.getComprehensivePerformance().hashCode());
		result = 37
				* result
				+ (getComprehensivePerformanceRanking() == null ? 0 : this
						.getComprehensivePerformanceRanking().hashCode());
		result = 37
				* result
				+ (getCourseName() == null ? 0 : this.getCourseName()
						.hashCode());
		result = 37 * result
				+ (getPoint() == null ? 0 : this.getPoint().hashCode());
		result = 37 * result
				+ (getScore() == null ? 0 : this.getScore().hashCode());
		return result;
	}

}