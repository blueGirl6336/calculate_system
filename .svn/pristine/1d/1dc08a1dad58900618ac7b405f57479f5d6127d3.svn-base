package com.cesystem.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AddScore entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AddScore", schema = "dbo", catalog = "ce_system")
public class AddScore implements java.io.Serializable {

	// Fields

	private Integer adsId;
	private Apartment apartment;
	private String score;
	private String scoreType;
	private String scoreName;
	private String addDetail;
	private String status;

	// Constructors

	/** default constructor */
	public AddScore() {
	}



	/** full constructor */
	public AddScore(Apartment apartment, String score,
			String scoreType, String scoreName, String addDetail) {
		this.apartment = apartment;
		this.score = score;
		this.scoreType = scoreType;
		this.scoreName = scoreName;
		this.addDetail = addDetail;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ads_id", unique = true, nullable = false)
	public Integer getAdsId() {
		return this.adsId;
	}

	public void setAdsId(Integer adsId) {
		this.adsId = adsId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "apartment_id")
	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Column(name = "score")
	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Column(name = "score_type")
	public String getScoreType() {
		return this.scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	@Column(name = "score_name")
	public String getScoreName() {
		return this.scoreName;
	}

	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}

	@Column(name = "add_detail")
	public String getAddDetail() {
		return this.addDetail;
	}

	public void setAddDetail(String addDetail) {
		this.addDetail = addDetail;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}