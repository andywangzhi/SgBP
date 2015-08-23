package com.gzepro.internal.query.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * RsRczytjnr entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RS_RCZYTJNR")
public class RsRczytjnr implements java.io.Serializable {

	// Fields

	private String pk;
	private String adddate;
	private String adduser;
	private String pcounty;
	private String year;
	private String rlzyzhslzs;
	private String rlzbgxl;
	private String rcgxl;
	private String rczyzl;
	private String rlzyzl;
	private String rczybl;
	private String bkysxlbl;
	private String gjnrcbl;
	private String ncsyrcjynx;
	private String gnpjsjynx;
	private String xzldsjynx;
	private String zyldnlrksjy;
	private String mwldlzyfry;
	private String mbwrkkxjrs;
	private String nmcyrys;
	private String cyryszbl;
	private String rlzbtzzbl;
	private String rczxzjzbl;
	private String czrlzbtzzbl;
	private String qsfmzlsql;
	private String qsgjzlsql;
	private String gjkjlwsll;
	private String gjkjlwyyl;
	private String hdgjjjlsl;
	private String dzrczl;
	private String dzrcfkjzl;
	private String dzbkysrsbl;
	private String xlygwyszbl;
	private String qyrczl;
	private String qybkysszbl;
	private String qyyjwgzszbl;
	private String schfsxprcs;
	private String fgyjjqyrcsl;
	private String qyzcyrcbl;
	private String zyjszl;
	private String zyfjjrczl;
	private String zybkjysbl;
	private String zyzcyrcbl;
	private String qyzyjsrsbl;
	private String gjnzl;
	private String gjnfgjjsl;
	private String ncrczl;
	private String nczldlbl;
	private String shgzzl;
	private String shgsysl;
	private String shgszbl;
	private String jyfgrcsl;
	private String jybsrcsl;
	private String zzbshrcsl;
	private String yjgccrcsl;
	private String xzgxqymd;
	private String xzgjjyjzx;
	private String xzgjjqyzx;
	private String xzgjjsys;
	private String xzgcsys;
	private String xzkygzz;

	// Constructors

	/** default constructor */
	public RsRczytjnr() {
	}

	/** full constructor */
	public RsRczytjnr(String adddate, String adduser, String pcounty,
			String year, String rlzyzhslzs, String rlzbgxl, String rcgxl,
			String rczyzl, String rlzyzl, String rczybl, String bkysxlbl,
			String gjnrcbl, String ncsyrcjynx, String gnpjsjynx,
			String xzldsjynx, String zyldnlrksjy, String mwldlzyfry,
			String mbwrkkxjrs, String nmcyrys, String cyryszbl,
			String rlzbtzzbl, String rczxzjzbl, String czrlzbtzzbl,
			String qsfmzlsql, String qsgjzlsql, String gjkjlwsll,
			String gjkjlwyyl, String hdgjjjlsl, String dzrczl,
			String dzrcfkjzl, String xlygwyszbl, String qyrczl,
			String qybkysszbl, String qyyjwgzszbl, String schfsxprcs,
			String fgyjjqyrcsl, String qyzcyrcbl, String zyjszl,
			String zyfjjrczl, String zybkjysbl, String zyzcyrcbl,
			String qyzyjsrsbl, String gjnzl, String gjnfgjjsl, String ncrczl,
			String nczldlbl, String shgzzl, String shgsysl, String shgszbl,
			String jyfgrcsl, String jybsrcsl, String zzbshrcsl,
			String yjgccrcsl, String xzgxqymd, String xzgjjyjzx,
			String xzgjjqyzx, String xzgjjsys, String xzgcsys, String xzkygzz) {
		this.adddate = adddate;
		this.adduser = adduser;
		this.pcounty = pcounty;
		this.year = year;
		this.rlzyzhslzs = rlzyzhslzs;
		this.rlzbgxl = rlzbgxl;
		this.rcgxl = rcgxl;
		this.rczyzl = rczyzl;
		this.rlzyzl = rlzyzl;
		this.rczybl = rczybl;
		this.bkysxlbl = bkysxlbl;
		this.gjnrcbl = gjnrcbl;
		this.ncsyrcjynx = ncsyrcjynx;
		this.gnpjsjynx = gnpjsjynx;
		this.xzldsjynx = xzldsjynx;
		this.zyldnlrksjy = zyldnlrksjy;
		this.mwldlzyfry = mwldlzyfry;
		this.mbwrkkxjrs = mbwrkkxjrs;
		this.nmcyrys = nmcyrys;
		this.cyryszbl = cyryszbl;
		this.rlzbtzzbl = rlzbtzzbl;
		this.rczxzjzbl = rczxzjzbl;
		this.czrlzbtzzbl = czrlzbtzzbl;
		this.qsfmzlsql = qsfmzlsql;
		this.qsgjzlsql = qsgjzlsql;
		this.gjkjlwsll = gjkjlwsll;
		this.gjkjlwyyl = gjkjlwyyl;
		this.hdgjjjlsl = hdgjjjlsl;
		this.dzrczl = dzrczl;
		this.dzrcfkjzl = dzrcfkjzl;
		this.xlygwyszbl = xlygwyszbl;
		this.qyrczl = qyrczl;
		this.qybkysszbl = qybkysszbl;
		this.qyyjwgzszbl = qyyjwgzszbl;
		this.schfsxprcs = schfsxprcs;
		this.fgyjjqyrcsl = fgyjjqyrcsl;
		this.qyzcyrcbl = qyzcyrcbl;
		this.zyjszl = zyjszl;
		this.zyfjjrczl = zyfjjrczl;
		this.zybkjysbl = zybkjysbl;
		this.zyzcyrcbl = zyzcyrcbl;
		this.qyzyjsrsbl = qyzyjsrsbl;
		this.gjnzl = gjnzl;
		this.gjnfgjjsl = gjnfgjjsl;
		this.ncrczl = ncrczl;
		this.nczldlbl = nczldlbl;
		this.shgzzl = shgzzl;
		this.shgsysl = shgsysl;
		this.shgszbl = shgszbl;
		this.jyfgrcsl = jyfgrcsl;
		this.jybsrcsl = jybsrcsl;
		this.zzbshrcsl = zzbshrcsl;
		this.yjgccrcsl = yjgccrcsl;
		this.xzgxqymd = xzgxqymd;
		this.xzgjjyjzx = xzgjjyjzx;
		this.xzgjjqyzx = xzgjjqyzx;
		this.xzgjjsys = xzgjjsys;
		this.xzgcsys = xzgcsys;
		this.xzkygzz = xzkygzz;
	}

	// Property accessors
	@Id  
    @Column(name="PK",unique = true, nullable = false, length = 35)
	@GeneratedValue(generator = "T_PERSON_GENERATOR")
	@GenericGenerator(name = "T_PERSON_GENERATOR", strategy = "com.gzepro.internal.query.base.id.SgBPIdentifierGenerator")    
	public String getPk() {
		return this.pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	@Column(name = "ADDDATE", length = 35)
	public String getAdddate() {
		return this.adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	@Column(name = "ADDUSER", length = 35)
	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	@Column(name = "PCOUNTY", length = 5)
	public String getPcounty() {
		return this.pcounty;
	}

	public void setPcounty(String pcounty) {
		this.pcounty = pcounty;
	}

	@Column(name = "YEAR", length = 35)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "RLZYZHSLZS", length = 35)
	public String getRlzyzhslzs() {
		return this.rlzyzhslzs;
	}

	public void setRlzyzhslzs(String rlzyzhslzs) {
		this.rlzyzhslzs = rlzyzhslzs;
	}

	@Column(name = "RLZBGXL", length = 35)
	public String getRlzbgxl() {
		return this.rlzbgxl;
	}

	public void setRlzbgxl(String rlzbgxl) {
		this.rlzbgxl = rlzbgxl;
	}

	@Column(name = "RCGXL", length = 35)
	public String getRcgxl() {
		return this.rcgxl;
	}

	public void setRcgxl(String rcgxl) {
		this.rcgxl = rcgxl;
	}

	@Column(name = "RCZYZL", length = 35)
	public String getRczyzl() {
		return this.rczyzl;
	}

	public void setRczyzl(String rczyzl) {
		this.rczyzl = rczyzl;
	}

	@Column(name = "RLZYZL", length = 35)
	public String getRlzyzl() {
		return this.rlzyzl;
	}

	public void setRlzyzl(String rlzyzl) {
		this.rlzyzl = rlzyzl;
	}

	@Column(name = "RCZYBL", length = 35)
	public String getRczybl() {
		return this.rczybl;
	}

	public void setRczybl(String rczybl) {
		this.rczybl = rczybl;
	}

	@Column(name = "BKYSXLBL", length = 35)
	public String getBkysxlbl() {
		return this.bkysxlbl;
	}

	public void setBkysxlbl(String bkysxlbl) {
		this.bkysxlbl = bkysxlbl;
	}

	@Column(name = "GJNRCBL", length = 35)
	public String getGjnrcbl() {
		return this.gjnrcbl;
	}

	public void setGjnrcbl(String gjnrcbl) {
		this.gjnrcbl = gjnrcbl;
	}

	@Column(name = "NCSYRCJYNX", length = 35)
	public String getNcsyrcjynx() {
		return this.ncsyrcjynx;
	}

	public void setNcsyrcjynx(String ncsyrcjynx) {
		this.ncsyrcjynx = ncsyrcjynx;
	}

	@Column(name = "GNPJSJYNX", length = 35)
	public String getGnpjsjynx() {
		return this.gnpjsjynx;
	}

	public void setGnpjsjynx(String gnpjsjynx) {
		this.gnpjsjynx = gnpjsjynx;
	}

	@Column(name = "XZLDSJYNX", length = 35)
	public String getXzldsjynx() {
		return this.xzldsjynx;
	}

	public void setXzldsjynx(String xzldsjynx) {
		this.xzldsjynx = xzldsjynx;
	}

	@Column(name = "ZYLDNLRKSJY", length = 35)
	public String getZyldnlrksjy() {
		return this.zyldnlrksjy;
	}

	public void setZyldnlrksjy(String zyldnlrksjy) {
		this.zyldnlrksjy = zyldnlrksjy;
	}

	@Column(name = "MWLDLZYFRY", length = 35)
	public String getMwldlzyfry() {
		return this.mwldlzyfry;
	}

	public void setMwldlzyfry(String mwldlzyfry) {
		this.mwldlzyfry = mwldlzyfry;
	}

	@Column(name = "MBWRKKXJRS", length = 35)
	public String getMbwrkkxjrs() {
		return this.mbwrkkxjrs;
	}

	public void setMbwrkkxjrs(String mbwrkkxjrs) {
		this.mbwrkkxjrs = mbwrkkxjrs;
	}

	@Column(name = "NMCYRYS", length = 35)
	public String getNmcyrys() {
		return this.nmcyrys;
	}

	public void setNmcyrys(String nmcyrys) {
		this.nmcyrys = nmcyrys;
	}

	@Column(name = "CYRYSZBL", length = 35)
	public String getCyryszbl() {
		return this.cyryszbl;
	}

	public void setCyryszbl(String cyryszbl) {
		this.cyryszbl = cyryszbl;
	}

	@Column(name = "RLZBTZZBL", length = 35)
	public String getRlzbtzzbl() {
		return this.rlzbtzzbl;
	}

	public void setRlzbtzzbl(String rlzbtzzbl) {
		this.rlzbtzzbl = rlzbtzzbl;
	}

	@Column(name = "RCZXZJZBL", length = 35)
	public String getRczxzjzbl() {
		return this.rczxzjzbl;
	}

	public void setRczxzjzbl(String rczxzjzbl) {
		this.rczxzjzbl = rczxzjzbl;
	}

	@Column(name = "CZRLZBTZZBL", length = 35)
	public String getCzrlzbtzzbl() {
		return this.czrlzbtzzbl;
	}

	public void setCzrlzbtzzbl(String czrlzbtzzbl) {
		this.czrlzbtzzbl = czrlzbtzzbl;
	}

	@Column(name = "QSFMZLSQL", length = 35)
	public String getQsfmzlsql() {
		return this.qsfmzlsql;
	}

	public void setQsfmzlsql(String qsfmzlsql) {
		this.qsfmzlsql = qsfmzlsql;
	}

	@Column(name = "QSGJZLSQL", length = 35)
	public String getQsgjzlsql() {
		return this.qsgjzlsql;
	}

	public void setQsgjzlsql(String qsgjzlsql) {
		this.qsgjzlsql = qsgjzlsql;
	}

	@Column(name = "GJKJLWSLL", length = 35)
	public String getGjkjlwsll() {
		return this.gjkjlwsll;
	}

	public void setGjkjlwsll(String gjkjlwsll) {
		this.gjkjlwsll = gjkjlwsll;
	}

	@Column(name = "GJKJLWYYL", length = 35)
	public String getGjkjlwyyl() {
		return this.gjkjlwyyl;
	}

	public void setGjkjlwyyl(String gjkjlwyyl) {
		this.gjkjlwyyl = gjkjlwyyl;
	}

	@Column(name = "HDGJJJLSL", length = 35)
	public String getHdgjjjlsl() {
		return this.hdgjjjlsl;
	}

	public void setHdgjjjlsl(String hdgjjjlsl) {
		this.hdgjjjlsl = hdgjjjlsl;
	}

	@Column(name = "DZRCZL", length = 35)
	public String getDzrczl() {
		return this.dzrczl;
	}

	public void setDzrczl(String dzrczl) {
		this.dzrczl = dzrczl;
	}

	@Column(name = "DZRCFKJZL", length = 35)
	public String getDzrcfkjzl() {
		return this.dzrcfkjzl;
	}

	public void setDzrcfkjzl(String dzrcfkjzl) {
		this.dzrcfkjzl = dzrcfkjzl;
	}

	@Column(name = "XLYGWYSZBL", length = 35)
	public String getXlygwyszbl() {
		return this.xlygwyszbl;
	}

	public void setXlygwyszbl(String xlygwyszbl) {
		this.xlygwyszbl = xlygwyszbl;
	}

	@Column(name = "QYRCZL", length = 35)
	public String getQyrczl() {
		return this.qyrczl;
	}

	public void setQyrczl(String qyrczl) {
		this.qyrczl = qyrczl;
	}

	@Column(name = "QYBKYSSZBL", length = 35)
	public String getQybkysszbl() {
		return this.qybkysszbl;
	}

	public void setQybkysszbl(String qybkysszbl) {
		this.qybkysszbl = qybkysszbl;
	}

	@Column(name = "QYYJWGZSZBL", length = 35)
	public String getQyyjwgzszbl() {
		return this.qyyjwgzszbl;
	}

	public void setQyyjwgzszbl(String qyyjwgzszbl) {
		this.qyyjwgzszbl = qyyjwgzszbl;
	}

	@Column(name = "SCHFSXPRCS", length = 35)
	public String getSchfsxprcs() {
		return this.schfsxprcs;
	}

	public void setSchfsxprcs(String schfsxprcs) {
		this.schfsxprcs = schfsxprcs;
	}

	@Column(name = "FGYJJQYRCSL", length = 35)
	public String getFgyjjqyrcsl() {
		return this.fgyjjqyrcsl;
	}

	public void setFgyjjqyrcsl(String fgyjjqyrcsl) {
		this.fgyjjqyrcsl = fgyjjqyrcsl;
	}

	@Column(name = "QYZCYRCBL", length = 35)
	public String getQyzcyrcbl() {
		return this.qyzcyrcbl;
	}

	public void setQyzcyrcbl(String qyzcyrcbl) {
		this.qyzcyrcbl = qyzcyrcbl;
	}

	@Column(name = "ZYJSZL", length = 35)
	public String getZyjszl() {
		return this.zyjszl;
	}

	public void setZyjszl(String zyjszl) {
		this.zyjszl = zyjszl;
	}

	@Column(name = "ZYFJJRCZL", length = 35)
	public String getZyfjjrczl() {
		return this.zyfjjrczl;
	}

	public void setZyfjjrczl(String zyfjjrczl) {
		this.zyfjjrczl = zyfjjrczl;
	}

	@Column(name = "ZYBKJYSBL", length = 35)
	public String getZybkjysbl() {
		return this.zybkjysbl;
	}

	public void setZybkjysbl(String zybkjysbl) {
		this.zybkjysbl = zybkjysbl;
	}

	@Column(name = "ZYZCYRCBL", length = 35)
	public String getZyzcyrcbl() {
		return this.zyzcyrcbl;
	}

	public void setZyzcyrcbl(String zyzcyrcbl) {
		this.zyzcyrcbl = zyzcyrcbl;
	}

	@Column(name = "QYZYJSRSBL", length = 35)
	public String getQyzyjsrsbl() {
		return this.qyzyjsrsbl;
	}

	public void setQyzyjsrsbl(String qyzyjsrsbl) {
		this.qyzyjsrsbl = qyzyjsrsbl;
	}

	@Column(name = "GJNZL", length = 35)
	public String getGjnzl() {
		return this.gjnzl;
	}

	public void setGjnzl(String gjnzl) {
		this.gjnzl = gjnzl;
	}

	@Column(name = "GJNFGJJSL", length = 35)
	public String getGjnfgjjsl() {
		return this.gjnfgjjsl;
	}

	public void setGjnfgjjsl(String gjnfgjjsl) {
		this.gjnfgjjsl = gjnfgjjsl;
	}

	@Column(name = "NCRCZL", length = 35)
	public String getNcrczl() {
		return this.ncrczl;
	}

	public void setNcrczl(String ncrczl) {
		this.ncrczl = ncrczl;
	}

	@Column(name = "NCZLDLBL", length = 35)
	public String getNczldlbl() {
		return this.nczldlbl;
	}

	public void setNczldlbl(String nczldlbl) {
		this.nczldlbl = nczldlbl;
	}

	@Column(name = "SHGZZL", length = 35)
	public String getShgzzl() {
		return this.shgzzl;
	}

	public void setShgzzl(String shgzzl) {
		this.shgzzl = shgzzl;
	}

	@Column(name = "SHGSYSL", length = 35)
	public String getShgsysl() {
		return this.shgsysl;
	}

	public void setShgsysl(String shgsysl) {
		this.shgsysl = shgsysl;
	}

	@Column(name = "SHGSZBL", length = 35)
	public String getShgszbl() {
		return this.shgszbl;
	}

	public void setShgszbl(String shgszbl) {
		this.shgszbl = shgszbl;
	}

	@Column(name = "JYFGRCSL", length = 35)
	public String getJyfgrcsl() {
		return this.jyfgrcsl;
	}

	public void setJyfgrcsl(String jyfgrcsl) {
		this.jyfgrcsl = jyfgrcsl;
	}

	@Column(name = "JYBSRCSL", length = 35)
	public String getJybsrcsl() {
		return this.jybsrcsl;
	}

	public void setJybsrcsl(String jybsrcsl) {
		this.jybsrcsl = jybsrcsl;
	}

	@Column(name = "ZZBSHRCSL", length = 35)
	public String getZzbshrcsl() {
		return this.zzbshrcsl;
	}

	public void setZzbshrcsl(String zzbshrcsl) {
		this.zzbshrcsl = zzbshrcsl;
	}

	@Column(name = "YJGCCRCSL", length = 35)
	public String getYjgccrcsl() {
		return this.yjgccrcsl;
	}

	public void setYjgccrcsl(String yjgccrcsl) {
		this.yjgccrcsl = yjgccrcsl;
	}

	@Column(name = "XZGXQYMD", length = 35)
	public String getXzgxqymd() {
		return this.xzgxqymd;
	}

	public void setXzgxqymd(String xzgxqymd) {
		this.xzgxqymd = xzgxqymd;
	}

	@Column(name = "XZGJJYJZX", length = 35)
	public String getXzgjjyjzx() {
		return this.xzgjjyjzx;
	}

	public void setXzgjjyjzx(String xzgjjyjzx) {
		this.xzgjjyjzx = xzgjjyjzx;
	}

	@Column(name = "XZGJJQYZX", length = 35)
	public String getXzgjjqyzx() {
		return this.xzgjjqyzx;
	}

	public void setXzgjjqyzx(String xzgjjqyzx) {
		this.xzgjjqyzx = xzgjjqyzx;
	}

	@Column(name = "XZGJJSYS", length = 35)
	public String getXzgjjsys() {
		return this.xzgjjsys;
	}

	public void setXzgjjsys(String xzgjjsys) {
		this.xzgjjsys = xzgjjsys;
	}

	@Column(name = "XZGCSYS", length = 35)
	public String getXzgcsys() {
		return this.xzgcsys;
	}

	public void setXzgcsys(String xzgcsys) {
		this.xzgcsys = xzgcsys;
	}

	@Column(name = "XZKYGZZ", length = 35)
	public String getXzkygzz() {
		return this.xzkygzz;
	}

	public void setXzkygzz(String xzkygzz) {
		this.xzkygzz = xzkygzz;
	}

	@Column(name = "DZBKYSRSBL", length = 35)
	public String getDzbkysrsbl() {
		return dzbkysrsbl;
	}

	public void setDzbkysrsbl(String dzbkysrsbl) {
		this.dzbkysrsbl = dzbkysrsbl;
	}

}