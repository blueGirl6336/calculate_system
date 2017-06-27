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
 * ScoreItems entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ScoreItems", schema = "dbo", catalog = "ce_system", uniqueConstraints = @UniqueConstraint(columnNames = "item_name"))
public class ScoreItems implements java.io.Serializable {

	// Fields

	private Integer siId;
	private Apartment apartment;
	private String itemName;
	private Double score;
	private String scoreType;

	// Constructors

	/** default constructor */
	public ScoreItems() {
	}

	/** minimal constructor */
	public ScoreItems(Integer siId) {
		this.siId = siId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "si_id", unique = true, nullable = false)
	public Integer getSiId() {
		return this.siId;
	}

	public void setSiId(Integer siId) {
		this.siId = siId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "apartment_id")
	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Column(name = "item_name", unique = true, length = 40)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "score", precision = 53, scale = 0)
	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Column(name = "score_type")
	public String getScoreType() {
		return this.scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

}