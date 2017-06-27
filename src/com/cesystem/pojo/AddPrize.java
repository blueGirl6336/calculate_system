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
 * AddPrize entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AddPrize", schema = "dbo", catalog = "ce_system")
public class AddPrize implements java.io.Serializable {

	// Fields

	private Integer adpId;
	private Apartment apartment;
	private String prizeName;
	private String prizeNeed;
	private String prizeDetail;
	private String addDetail;
	private String status;

	// Constructors

	/** default constructor */
	public AddPrize() {
	}


	/** full constructor */
	public AddPrize(Apartment apartment, String prizeName,
			String prizeNeed, String prizeDetail, String addDetail) {
		this.apartment = apartment;
		this.prizeName = prizeName;
		this.prizeNeed = prizeNeed;
		this.prizeDetail = prizeDetail;
		this.addDetail = addDetail;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "adp_id", unique = true, nullable = false)
	public Integer getAdpId() {
		return this.adpId;
	}

	public void setAdpId(Integer adpId) {
		this.adpId = adpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "apartment_id")
	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Column(name = "prize_name")
	public String getPrizeName() {
		return this.prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	@Column(name = "prize_need")
	public String getPrizeNeed() {
		return this.prizeNeed;
	}

	public void setPrizeNeed(String prizeNeed) {
		this.prizeNeed = prizeNeed;
	}

	@Column(name = "prize_detail")
	public String getPrizeDetail() {
		return this.prizeDetail;
	}

	public void setPrizeDetail(String prizeDetail) {
		this.prizeDetail = prizeDetail;
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