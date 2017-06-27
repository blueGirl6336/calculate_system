package com.cesystem.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PrizeBackupId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PrizeBackupId implements java.io.Serializable {

	// Fields

	private Integer prizeId;
	private String prizeDetail;
	private String prizeNeed;
	private Integer apartmentId;
	private String prizeName;

	// Constructors

	/** default constructor */
	public PrizeBackupId() {
	}

	/** minimal constructor */
	public PrizeBackupId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	/** full constructor */
	public PrizeBackupId(Integer prizeId, String prizeDetail, String prizeNeed,
			Integer apartmentId, String prizeName) {
		this.prizeId = prizeId;
		this.prizeDetail = prizeDetail;
		this.prizeNeed = prizeNeed;
		this.apartmentId = apartmentId;
		this.prizeName = prizeName;
	}

	// Property accessors

	@Column(name = "prize_id", nullable = false)
	public Integer getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
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

	@Column(name = "apartment_id")
	public Integer getApartmentId() {
		return this.apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	@Column(name = "prize_name")
	public String getPrizeName() {
		return this.prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrizeBackupId))
			return false;
		PrizeBackupId castOther = (PrizeBackupId) other;

		return ((this.getPrizeId() == castOther.getPrizeId()) || (this
				.getPrizeId() != null && castOther.getPrizeId() != null && this
				.getPrizeId().equals(castOther.getPrizeId())))
				&& ((this.getPrizeDetail() == castOther.getPrizeDetail()) || (this
						.getPrizeDetail() != null
						&& castOther.getPrizeDetail() != null && this
						.getPrizeDetail().equals(castOther.getPrizeDetail())))
				&& ((this.getPrizeNeed() == castOther.getPrizeNeed()) || (this
						.getPrizeNeed() != null
						&& castOther.getPrizeNeed() != null && this
						.getPrizeNeed().equals(castOther.getPrizeNeed())))
				&& ((this.getApartmentId() == castOther.getApartmentId()) || (this
						.getApartmentId() != null
						&& castOther.getApartmentId() != null && this
						.getApartmentId().equals(castOther.getApartmentId())))
				&& ((this.getPrizeName() == castOther.getPrizeName()) || (this
						.getPrizeName() != null
						&& castOther.getPrizeName() != null && this
						.getPrizeName().equals(castOther.getPrizeName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPrizeId() == null ? 0 : this.getPrizeId().hashCode());
		result = 37
				* result
				+ (getPrizeDetail() == null ? 0 : this.getPrizeDetail()
						.hashCode());
		result = 37 * result
				+ (getPrizeNeed() == null ? 0 : this.getPrizeNeed().hashCode());
		result = 37
				* result
				+ (getApartmentId() == null ? 0 : this.getApartmentId()
						.hashCode());
		result = 37 * result
				+ (getPrizeName() == null ? 0 : this.getPrizeName().hashCode());
		return result;
	}

}