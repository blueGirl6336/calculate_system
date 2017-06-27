package com.cesystem.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PrizeBackup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "prizeBackup", schema = "dbo", catalog = "ce_system")
public class PrizeBackup implements java.io.Serializable {

	// Fields

	private PrizeBackupId id;

	// Constructors

	/** default constructor */
	public PrizeBackup() {
	}

	/** full constructor */
	public PrizeBackup(PrizeBackupId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "prizeId", column = @Column(name = "prize_id", nullable = false)),
			@AttributeOverride(name = "prizeDetail", column = @Column(name = "prize_detail")),
			@AttributeOverride(name = "prizeNeed", column = @Column(name = "prize_need")),
			@AttributeOverride(name = "apartmentId", column = @Column(name = "apartment_id")),
			@AttributeOverride(name = "prizeName", column = @Column(name = "prize_name")) })
	public PrizeBackupId getId() {
		return this.id;
	}

	public void setId(PrizeBackupId id) {
		this.id = id;
	}

}