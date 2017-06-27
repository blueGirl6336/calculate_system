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
 * Prize entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Prize", schema = "dbo", catalog = "ce_system", uniqueConstraints = @UniqueConstraint(columnNames = "prize_name"))
public class Prize implements java.io.Serializable {

	// Fields

	private Integer prizeId;
	private Apartment apartment;
	private String prizeDetail;
	private String prizeNeed;
	private String prizeName;

	// Constructors

	/** default constructor */
	public Prize() {
	}

	/** minimal constructor */
	public Prize(Integer prizeId) {
		this.prizeId = prizeId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "prize_id", unique = true, nullable = false)
	public Integer getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "apartment_id")
	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Column(name = "prize_detail")
	public String getPrizeDetail() {
		return this.prizeDetail;
	}

	public void setPrizeDetail(String prizeDetail) {
		this.prizeDetail = prizeDetail;
	}

	@Column(name = "prize_need")
	public String getPrizeNeed() {
		return this.prizeNeed;
	}

	public void setPrizeNeed(String prizeNeed) {
		this.prizeNeed = prizeNeed;
	}

	@Column(name = "prize_name", unique = true)
	public String getPrizeName() {
		return this.prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

}