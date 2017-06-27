package com.cesystem.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Rank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rank", schema = "dbo", catalog = "ce_system")
public class Rank implements java.io.Serializable {

	// Fields

	private RankId id;

	// Constructors

	/** default constructor */
	public Rank() {
	}

	/** full constructor */
	public Rank(RankId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "studentId", column = @Column(name = "student_id", nullable = false)),
			@AttributeOverride(name = "studentName", column = @Column(name = "student_name", length = 20)),
			@AttributeOverride(name = "studentNumber", column = @Column(name = "student_number", length = 20)),
			@AttributeOverride(name = "classNumber", column = @Column(name = "class_number", nullable = false, length = 20)),
			@AttributeOverride(name = "gpa", column = @Column(name = "gpa", precision = 18)),
			@AttributeOverride(name = "gpaSort", column = @Column(name = "gpa_sort")),
			@AttributeOverride(name = "comprehensivePerformance", column = @Column(name = "comprehensive_performance", precision = 53, scale = 0)),
			@AttributeOverride(name = "comprehensivePerformanceRanking", column = @Column(name = "comprehensive_performance_ranking", precision = 18)),
			@AttributeOverride(name = "courseName", column = @Column(name = "course_name")),
			@AttributeOverride(name = "point", column = @Column(name = "point", precision = 18)),
			@AttributeOverride(name = "score", column = @Column(name = "score", precision = 18)) })
	public RankId getId() {
		return this.id;
	}

	public void setId(RankId id) {
		this.id = id;
	}

}