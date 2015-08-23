
package com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg;

/**
  * @ClassName: TechnologicalHarvestSO
  * @Description: TODO(科技成果详细信息封装查询数据对象 )
  * @author 张建薇
  * @date Jul 24, 2012 7:11:36 PM
 */
public class RetrieveTechnologicalHarvestSO {
	private String personId;//个人信息ID
	private String harvestId;//成果ID
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getHarvestId() {
		return harvestId;
	}
	public void setHarvestId(String harvestId) {
		this.harvestId = harvestId;
	}
	
}
