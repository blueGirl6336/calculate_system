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

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * Apartment entity. @author MyEclipse Persistence Tools
 */
@JsonAutoDetect
@Entity
@Table(name = "Apartment", schema = "dbo", catalog = "ce_system", uniqueConstraints = @UniqueConstraint(columnNames = "apartment_name"))
public class Apartment implements java.io.Serializable {

	// Fields

	private Integer apartmentId;
	private String apartmentName;
	private String remark;

	// Constructors

	/** default constructor */
	public Apartment() {
	}

	/** minimal constructor */
	public Apartment(Integer apartmentId, String apartmentName) {
		this.apartmentId = apartmentId;
		this.apartmentName = apartmentName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "apartment_id", unique = true, nullable = false)
	public Integer getApartmentId() {
		return this.apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	@Column(name = "apartment_name", unique = true, nullable = false, length = 40)
	public String getApartmentName() {
		return this.apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}