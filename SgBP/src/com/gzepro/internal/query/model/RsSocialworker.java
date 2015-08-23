package com.gzepro.internal.query.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * RsSocialworker entity. @author MyEclipse Persistence Tools
 * author:张建薇
 * addDate:2013-03-22
 * description:持证社工人
 */
@Entity
@Table(name = "RS_SOCIALWORKER")
public class RsSocialworker implements java.io.Serializable {
	private static final long serialVersionUID = -7928119002589450402L;
	
	private Long swid;
	private String swdate;
	private Long t1;
	private Long t2;
	private Long t3;
	private Long t4;
	private Long qx;
	

	// Constructors

	/** default constructor */
	public RsSocialworker() {
	}

	/** full constructor */
	public RsSocialworker(String swdate, Long t1, Long t2,Long t3,Long t4,Long qx) {
		this.swdate = swdate;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.qx = qx;
	}

	// Property accessors

	@Id  
    @Column(name="swid")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_socialWorker")      
    @SequenceGenerator(name="seq_socialWorker",allocationSize=1,initialValue=1, sequenceName="SEQ_RS_SOCIALWORKER ") 
	public Long getSwid() {
		return this.swid;
	}

	public void setSwid(Long swid) {
		this.swid = swid;
	}

	@Column(name = "swdate", length = 32)
	public String getSwdate() {
		return this.swdate;
	}

	public void setSwdate(String swdate) {
		this.swdate = swdate;
	}

	@Column(name = "t1", length = 2)
	public Long getT1() {
		return t1;
	}

	public void setT1(Long t1) {
		this.t1 = t1;
	}

	@Column(name = "t2", length = 2)
	public Long getT2() {
		return t2;
	}

	public void setT2(Long t2) {
		this.t2 = t2;
	}

	@Column(name = "t3", length = 2)
	public Long getT3() {
		return t3;
	}

	public void setT3(Long t3) {
		this.t3 = t3;
	}

	@Column(name = "t4", length = 2)
	public Long getT4() {
		return t4;
	}

	public void setT4(Long t4) {
		this.t4 = t4;
	}

	@Column(name = "qx", length = 2)
	public Long getQx() {
		return qx;
	}

	public void setQx(Long qx) {
		this.qx = qx;
	}

	
}