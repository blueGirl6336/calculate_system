package com.cesystem.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Dictionary", schema = "dbo", catalog = "ce_system", uniqueConstraints = {
		@UniqueConstraint(columnNames = "dict_code"),
		@UniqueConstraint(columnNames = "dict_name") })
public class Dictionary implements java.io.Serializable {

	// Fields

	private Integer dictionaryId;
	private String dictParentCode;
	private String dictCode;
	private String dictName;
	private String remark;

	// Constructors

	/** default constructor */
	public Dictionary() {
	}

	/** minimal constructor */
	public Dictionary(Integer dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	/** full constructor */
	public Dictionary(Integer dictionaryId, String dictParentCode,
			String dictCode, String dictName, String remark) {
		this.dictionaryId = dictionaryId;
		this.dictParentCode = dictParentCode;
		this.dictCode = dictCode;
		this.dictName = dictName;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "dictionary_id", unique = true, nullable = false)
	public Integer getDictionaryId() {
		return this.dictionaryId;
	}

	public void setDictionaryId(Integer dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	@Column(name = "dict_parent_code")
	public String getDictParentCode() {
		return this.dictParentCode;
	}

	public void setDictParentCode(String dictParentCode) {
		this.dictParentCode = dictParentCode;
	}

	@Column(name = "dict_code", unique = true)
	public String getDictCode() {
		return this.dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	@Column(name = "dict_name", unique = true)
	public String getDictName() {
		return this.dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}