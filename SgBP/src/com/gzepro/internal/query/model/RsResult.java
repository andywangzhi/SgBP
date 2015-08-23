package com.gzepro.internal.query.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RsResult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_RESULT")
public class RsResult implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1042811549714685299L;
	private Long id;
	private Date ctime;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String f;
	private String g;
	private String h;
	private String i;
	private String j;
	private String k;
	private String l;
	private String m;
	private String n;
	private String o;
	private String p;
	private String q;
	private String r;
	private String s;
	private String t;
	private String u;
	private String v;
	private String w;
	private String x;
	private String y;
	private String z;

	// Constructors

	/** default constructor */
	public RsResult() {
	}

	/** minimal constructor */
	public RsResult(Long id, Date ctime) {
		this.id = id;
		this.ctime = ctime;
	}

	/** full constructor */
	public RsResult(Long id, Date ctime, String a, String b, String c,
			String d, String e, String f, String g, String h, String i,
			String j, String k, String l, String m, String n, String o,
			String p, String q, String r, String s, String t, String u,
			String v, String w, String x, String y, String z) {
		this.id = id;
		this.ctime = ctime;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;
		this.j = j;
		this.k = k;
		this.l = l;
		this.m = m;
		this.n = n;
		this.o = o;
		this.p = p;
		this.q = q;
		this.r = r;
		this.s = s;
		this.t = t;
		this.u = u;
		this.v = v;
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CTIME", nullable = false, length = 7)
	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@Column(name = "A", length = 12)
	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	@Column(name = "B", length = 12)
	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Column(name = "C", length = 12)
	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	@Column(name = "D", length = 12)
	public String getD() {
		return this.d;
	}

	public void setD(String d) {
		this.d = d;
	}

	@Column(name = "E", length = 12)
	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
	}

	@Column(name = "F", length = 12)
	public String getF() {
		return this.f;
	}

	public void setF(String f) {
		this.f = f;
	}

	@Column(name = "G", length = 12)
	public String getG() {
		return this.g;
	}

	public void setG(String g) {
		this.g = g;
	}

	@Column(name = "H", length = 12)
	public String getH() {
		return this.h;
	}

	public void setH(String h) {
		this.h = h;
	}

	@Column(name = "I", length = 12)
	public String getI() {
		return this.i;
	}

	public void setI(String i) {
		this.i = i;
	}

	@Column(name = "J", length = 12)
	public String getJ() {
		return this.j;
	}

	public void setJ(String j) {
		this.j = j;
	}

	@Column(name = "K", length = 12)
	public String getK() {
		return this.k;
	}

	public void setK(String k) {
		this.k = k;
	}

	@Column(name = "L", length = 12)
	public String getL() {
		return this.l;
	}

	public void setL(String l) {
		this.l = l;
	}

	@Column(name = "M", length = 12)
	public String getM() {
		return this.m;
	}

	public void setM(String m) {
		this.m = m;
	}

	@Column(name = "N", length = 12)
	public String getN() {
		return this.n;
	}

	public void setN(String n) {
		this.n = n;
	}

	@Column(name = "O", length = 12)
	public String getO() {
		return this.o;
	}

	public void setO(String o) {
		this.o = o;
	}

	@Column(name = "P", length = 12)
	public String getP() {
		return this.p;
	}

	public void setP(String p) {
		this.p = p;
	}

	@Column(name = "Q", length = 12)
	public String getQ() {
		return this.q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@Column(name = "R", length = 12)
	public String getR() {
		return this.r;
	}

	public void setR(String r) {
		this.r = r;
	}

	@Column(name = "S", length = 12)
	public String getS() {
		return this.s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Column(name = "T", length = 12)
	public String getT() {
		return this.t;
	}

	public void setT(String t) {
		this.t = t;
	}

	@Column(name = "U", length = 12)
	public String getU() {
		return this.u;
	}

	public void setU(String u) {
		this.u = u;
	}

	@Column(name = "V", length = 12)
	public String getV() {
		return this.v;
	}

	public void setV(String v) {
		this.v = v;
	}

	@Column(name = "W", length = 12)
	public String getW() {
		return this.w;
	}

	public void setW(String w) {
		this.w = w;
	}

	@Column(name = "X", length = 12)
	public String getX() {
		return this.x;
	}

	public void setX(String x) {
		this.x = x;
	}

	@Column(name = "Y", length = 12)
	public String getY() {
		return this.y;
	}

	public void setY(String y) {
		this.y = y;
	}

	@Column(name = "Z", length = 12)
	public String getZ() {
		return this.z;
	}

	public void setZ(String z) {
		this.z = z;
	}

}