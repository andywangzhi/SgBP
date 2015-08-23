/**
 * 
 */
package com.gzepro.internal.query.soa.service.user.dto.rcsm.rckh;

import com.gzepro.internal.query.system.model.RsRcgzkhpfb;
import com.gzepro.internal.query.system.model.RsRczytjnr;

/**
 * @author SgBP 广州易宝信息技术有限公司
 * @since  2013-3-21
 * @version 1.0
 */
public class RckhForm {
	private RsRcgzkhpfb rsRcgzkhpfb;
	private RsRczytjnr rsRczytjnr;
	private String pcounty;
	private String year;

	public RsRcgzkhpfb getRsRcgzkhpfb() {
		return rsRcgzkhpfb;
	}

	public void setRsRcgzkhpfb(RsRcgzkhpfb rsRcgzkhpfb) {
		this.rsRcgzkhpfb = rsRcgzkhpfb;
	}

	public String getPcounty() {
		return pcounty;
	}

	public void setPcounty(String pcounty) {
		this.pcounty = pcounty;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public RsRczytjnr getRsRczytjnr() {
		return rsRczytjnr;
	}

	public void setRsRczytjnr(RsRczytjnr rsRczytjnr) {
		this.rsRczytjnr = rsRczytjnr;
	}
}
