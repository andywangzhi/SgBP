package com.gzepro.internal.query.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * RsTalantteam entity. @author MyEclipse Persistence Tools
 * author:张建薇
 * addDate:2013-03-22
 * description:人才队伍建设情况
 */

@Entity
@Table(name = "RS_TALANTTEAM")
public class RsTalantteam implements java.io.Serializable {
	private static final long serialVersionUID = 1475810187158409909L;
	
	private Long tid;
	private String td;
	private Long tp;
	private Long t1;
	private Long t2;
	private Long t3;
	private Long t4;
	private Long t5;
	private Long t6;
	private Long t7;
	private Long t8;
	private Long t9;
	private Long t10;

	// Constructors

	/** default constructor */
	public RsTalantteam() {
	}

	/** full constructor */
	public RsTalantteam(String td, Long tp, Long t1, Long t2,
			Long t3, Long t4, Long t5, Long t6,
			Long t7, Long t8, Long t9, Long t10) {
		this.td = td;
		this.tp = tp;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
		this.t7 = t7;
		this.t8 = t8;
		this.t9 = t9;
		this.t10 = t10;
	}

	// Property accessors

	@Id  
    @Column(name="tid")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_talantTeam")      
    @SequenceGenerator(name="seq_talantTeam",allocationSize=1,initialValue=1, sequenceName="SEQ_RS_TALANTTEAM ") 
	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	@Column(name = "td", length = 32)
	public String getTd() {
		return this.td;
	}

	public void setTd(String td) {
		this.td = td;
	}

	@Column(name = "tp")
	public Long getTp() {
		return this.tp;
	}

	public void setTp(Long tp) {
		this.tp = tp;
	}

	@Column(name = "t1")
	public Long getT1() {
		return this.t1;
	}

	public void setT1(Long t1) {
		this.t1 = t1;
	}

	@Column(name = "t2")
	public Long getT2() {
		return this.t2;
	}

	public void setT2(Long t2) {
		this.t2 = t2;
	}

	@Column(name = "t3")
	public Long getT3() {
		return this.t3;
	}

	public void setT3(Long t3) {
		this.t3 = t3;
	}

	@Column(name = "t4")
	public Long getT4() {
		return this.t4;
	}

	public void setT4(Long t4) {
		this.t4 = t4;
	}

	@Column(name = "t5")
	public Long getT5() {
		return this.t5;
	}

	public void setT5(Long t5) {
		this.t5 = t5;
	}

	@Column(name = "t6")
	public Long getT6() {
		return this.t6;
	}

	public void setT6(Long t6) {
		this.t6 = t6;
	}

	@Column(name = "t7")
	public Long getT7() {
		return this.t7;
	}

	public void setT7(Long t7) {
		this.t7 = t7;
	}

	@Column(name = "t8")
	public Long getT8() {
		return this.t8;
	}

	public void setT8(Long t8) {
		this.t8 = t8;
	}

	@Column(name = "t9")
	public Long getT9() {
		return this.t9;
	}

	public void setT9(Long t9) {
		this.t9 = t9;
	}

	@Column(name = "t10")
	public Long getT10() {
		return this.t10;
	}

	public void setT10(Long t10) {
		this.t10 = t10;
	}

}