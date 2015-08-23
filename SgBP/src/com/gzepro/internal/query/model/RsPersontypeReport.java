package com.gzepro.internal.query.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * RsPersontype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rs_persontype_report")
public class RsPersontypeReport implements java.io.Serializable {

	private static final long serialVersionUID = 7594176322006355210L;
	// Fields

	private String persontypeid;
	private String personId;
	private String type;

	// Constructors

	/** default constructor */
	public RsPersontypeReport() {
	}

	// Property accessors
	@Id
	@Column(name = "PERSONTYPEID", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")
	public String getPersontypeid() {
		return this.persontypeid;
	}

	public void setPersontypeid(String persontypeid) {
		this.persontypeid = persontypeid;
	}

	@Column(name = "PERSONID", nullable = false)
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "TYPE", nullable = false, length = 2)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}