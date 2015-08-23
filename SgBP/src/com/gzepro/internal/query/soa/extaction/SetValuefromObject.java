package com.gzepro.internal.query.soa.extaction;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.NumberUtils;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestListDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceDetaiDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessDetaiDTO;

public class SetValuefromObject {
	/**
	 * @param outVo 公共服务平台实体
	 * @param inVo 实名系统实体
	 * @return 公共服务平台实体
	 * @throws Exception
	 */
	public com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo personSetValueFormIn(com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo outVo,
			com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo inVo) throws Exception{
		com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo();
		parameters =  (com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo) cloneObject(inVo, parameters, null);
		parameters.setPersonId(outVo.getPersonId());
		if(outVo.getAdduser() != null && !outVo.getAdduser().equals("")){
			parameters.setAdduser(outVo.getAdduser());
		}else{
			parameters.setAdduser("admin");			
		}
		parameters.setIsvalid("1");
		return parameters;
	}
	public com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo affixSetValueFormIn(			
			com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO dto) throws Exception{
		com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo();
		parameters =  (com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo) cloneObject(dto, parameters, null);
		if(parameters.getUploadDate().length()>10){
			parameters.setUploadDate(dealDate(parameters.getUploadDate().substring(0, 10))+"");
		}
		
		return parameters;
	}
	
	public com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo educationSetValueFormIn(
			com.gzepro.internal.query.soa.service.user.dto.rcsm.jyjl.EducationexperienceListDTO dto) throws Exception{
		com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo();
		parameters = (com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo)cloneObject(dto, parameters, null);
		parameters.setAdddate(Integer.parseInt(dto.getAdddate()==null?"0":dto.getAdddate()));
		String value = dto.getModifydate();
		if(dto.getModifydate() == null || dto.getModifydate().equals("0")){
			value = "0";
		}
		parameters.setModifydate(Integer.parseInt(value));
		
		value = dto.getFromDate();
		if(dto.getFromDate() == null || dto.getFromDate().equals("0")){
			value = "";
		}
		parameters.setFromDate(dealDate(value));
		value = dto.getToDate();
		if(dto.getToDate() == null || dto.getToDate().equals("0")){
			value = "";
		}
		parameters.setToDate(dealDate(value));
		
		return parameters;
	}
	
	public com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo projectSetValueFormIn(
			com.gzepro.internal.query.soa.service.user.dto.rcsm.xmjy.ProjectExperienceListDTO dto) throws Exception{
		com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo();
		parameters = (com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo)cloneObject(dto, parameters, null);
		parameters.setAdddate(Integer.parseInt(dto.getAdddate()==null?"0":dto.getAdddate()));	
		String value = "";
		parameters.setPersonnum(Long.parseLong(dto.getPersonnum()==null?"0":dto.getPersonnum()));
		value = dto.getModifydate();
		if(dto.getModifydate() == null || dto.getModifydate().equals("0")){
			value = "0";
		}
		parameters.setModifydate(Integer.parseInt(value));
		
		parameters.setProjmoney(Double.parseDouble(dto.getProjmoney()==null?"0":dto.getProjmoney()));
		
		value = dto.getToDate();
		if(dto.getToDate() == null || dto.getToDate().equals("0")){
			value = "";
		}
		parameters.setToDate(dealDate(value));
		value = dto.getFromDate();
		if(dto.getFromDate() == null || dto.getFromDate().equals("0")){
			value = "";
		}
		parameters.setFromDate(dealDate(value));
		return parameters;
	}
	
	public com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo technicallymessSetValueFormIn(
			com.gzepro.internal.query.soa.service.user.dto.rcsm.zcxx.TechnicallymessListDTO dto) throws Exception{
		com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo();
		parameters = (com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo)cloneObject(dto, parameters, null);
		parameters.setAdddate(Integer.parseInt(dto.getAdddate()==null?"0":dto.getAdddate()));	
		parameters.setModifydate(Integer.parseInt(dto.getModifydate()==null?"0":dto.getModifydate()));
		String value = dto.getAssessDate();
		if(dto.getAssessDate() == null || dto.getAssessDate().equals("0")){
			value = "";
		}
		parameters.setAssessDate(dealDate(value));
		return parameters;
	}
	
	public com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo technologicalHarvestSetValueFormIn(
			com.gzepro.internal.query.soa.service.user.dto.rcsm.kjcg.TechnologicalHarvestListDTO dto) throws Exception{
		com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo();
		parameters = (com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo)cloneObject(dto, parameters, null);
		String value = dto.getAdddate();
		if(dto.getAdddate() == null || dto.getAdddate().equals("0")){
			value = "";
		}
		parameters.setAdddate(dealDate(value));
		parameters.setModifydate(Integer.parseInt(dto.getModifydate()==null?"0":dto.getModifydate()));
		value = dto.getAssessDate();
		if(dto.getAssessDate() == null || dto.getAssessDate().equals("0")){
			value = "";
		}
		parameters.setAssessDate(dealDate(value));
		return parameters;
	}
	public com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo workSetValueFormIn(
			com.gzepro.internal.query.soa.service.user.dto.rcsm.gzjl.WorkexperienceDetailDTO dto) throws Exception{
		com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo parameters = new com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo();
		parameters = (com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo)cloneObject(dto, parameters, null);
		parameters.setAdddate(Integer.parseInt(dto.getAdddate()==null?"0":dto.getAdddate()));
		String value = dto.getModifydate();
		if(dto.getModifydate() == null || dto.getModifydate().equals("0")){
			value = "0";
		}
		parameters.setModifydate(Integer.parseInt(value));
		value = dto.getToDate();
		if(dto.getToDate() == null || dto.getToDate().equals("0")){
			value = "";
		}
		parameters.setToDate(dealDate(value));
		value = dto.getFromDate();
		if(dto.getFromDate() == null || dto.getFromDate().equals("0")){
			value = "";
		}
		parameters.setFromDate(dealDate(value));
		return parameters;
	}
	
	private String changIntToDate(int value){
		if(value == 0){
			return null;
		}
		return DateUtil.dateToDateString(DateUtil.getYYYYMMddDateFromInt(value), "yyyy-MM-dd");
	}
	
	private String changIntToString(int value){
		if(value == 0){
			return "0";
		}
		return ""+value;
	}
	
	/**
	 * @param outVo 实名系统实体
	 * @param inVo 实名系统实体
	 * @return 公共服务平台实体
	 * @throws Exception
	 */
	public RsPersonDetailDTO personSetValueFormOut(RsPersonDetailDTO inVo,
			com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutVo outVo) throws Exception{
		RsPersonDetailDTO parameters = new RsPersonDetailDTO();
		parameters =  (RsPersonDetailDTO) cloneObject(outVo, parameters, null);
		parameters.setPersonId(inVo.getPersonId());
		parameters.setAdddate(changIntToString(outVo.getAdddate()));		
		parameters.setCheckdate(changIntToString(outVo.getCheckdate()));
		parameters.setDeledate(changIntToString(outVo.getDeledate()));
		parameters.setModifydate(changIntToString(outVo.getModifydate()));
		parameters.setOperationalDate(changIntToDate(outVo.getOperationalDate()));
		parameters.setPbirthday(changIntToDate(outVo.getPbirthday()));
		parameters.setValidatedate(changIntToString(outVo.getValidatedate()));
		parameters.setAuditdate(changIntToString(outVo.getAuditdate()));
		if(parameters.getAdduser() == null || parameters.getAdduser().equals("")){
			parameters.setAdduser("admin");
		}		
		if(inVo.getSourcetype() == null || inVo.getSourcetype().equals("")){
			parameters.setSourcetype("3");
		}
		return parameters;
	}
	
	public RsAffixDTO affixSetValueFormOut(			
			com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo qo) throws Exception{
		RsAffixDTO parameters = new RsAffixDTO();
		parameters =  (RsAffixDTO) cloneObject(qo, parameters, null);
		if(parameters.getUploadDate().length()>10){
			parameters.setUploadDate(parameters.getUploadDate().substring(0, 10));
		}
		return parameters;
	}
	
	public EducationexperienceDetaiDTO educationSetValueFormOut(
			com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceVo outVo) throws Exception{
		EducationexperienceDetaiDTO parameters = new EducationexperienceDetaiDTO();
		parameters = (EducationexperienceDetaiDTO)cloneObject(outVo, parameters, null);
		parameters.setAdddate(changIntToDate(outVo.getAdddate()));
		parameters.setFromDate(changIntToDate(outVo.getFromDate()));
		parameters.setModifydate(changIntToDate(outVo.getModifydate()));
		parameters.setToDate(changIntToDate(outVo.getToDate()));

		return parameters;
	}
	
	public ProjectExperienceDetaiDTO projectSetValueFormOut(
			com.gmcc.support.trade.service.provider.outrcsm.xmjy.ProjectExperienceVo outVo) throws Exception{
		ProjectExperienceDetaiDTO parameters = new ProjectExperienceDetaiDTO();
		parameters = (ProjectExperienceDetaiDTO)cloneObject(outVo, parameters, null);
		parameters.setAdddate(changIntToString(outVo.getAdddate()));
		parameters.setFromDate(changIntToDate(outVo.getFromDate()));
		parameters.setModifydate(changIntToString(outVo.getModifydate()));
		parameters.setToDate(changIntToDate(outVo.getToDate()));
		
		return parameters;
	}
	public TechnicallymessDetaiDTO technicallymessSetValueFormOut(
			com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessVo dto) throws Exception{
		TechnicallymessDetaiDTO parameters = new TechnicallymessDetaiDTO();
		parameters = (TechnicallymessDetaiDTO)cloneObject(dto, parameters, null);
		parameters.setAdddate(changIntToString(dto.getAdddate()));
		parameters.setAssessDate(changIntToDate(dto.getAssessDate()));
		parameters.setModifydate(changIntToString(dto.getModifydate()));
		return parameters;
	}
	
	public TechnologicalHarvestListDTO technologicalHarvestSetValueFormOut(
			com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestVo outVo) throws Exception{
		TechnologicalHarvestListDTO parameters = new TechnologicalHarvestListDTO();
		parameters = (TechnologicalHarvestListDTO)cloneObject(outVo, parameters, null);
		parameters.setAdddate(changIntToDate(outVo.getAdddate()));
		parameters.setAssessDate(changIntToDate(outVo.getAssessDate()));
		parameters.setModifydate(changIntToDate(outVo.getModifydate()));
		return parameters;
	}
	
	public WorkexperienceListDTO workSetValueFormOut(
			com.gmcc.support.trade.service.provider.outrcsm.gzjl.WorkexperienceVo outVo) throws Exception{
		WorkexperienceListDTO parameters = new WorkexperienceListDTO();
		parameters = (WorkexperienceListDTO)cloneObject(outVo, parameters, null);
		parameters.setAdddate(changIntToString(outVo.getAdddate()));
		parameters.setFromDate(changIntToDate(outVo.getFromDate()));
		parameters.setModifydate(changIntToString(outVo.getModifydate()));
		parameters.setToDate(changIntToDate(outVo.getToDate()));
		return parameters;
	}
	
	
	/**
	 * 转换dto对象
	 * @param o1  soa服务查询到的对象
	 * @param o2  转换后的dto对象
	 * @param map 敏感字段
	 * @return o2
	 * @throws Exception
	 */
	public Object cloneObject(Object o1, Object o2, Map map) throws Exception {
		
		if (o1 == null){
			return null;
		}

		Method[] methods = o2.getClass().getDeclaredMethods();
		
		for (Method setter : methods) {
			// 只处理setter方法
			if ( setter.getName().startsWith("set") ) {
				String getterName = setter.getName().replaceFirst("set", "get");
				try {					
					boolean isContain = false; 
					Method[] o1Method = o1.getClass().getDeclaredMethods();
					for( int i = 0 ; i < o1Method.length; i++ ){
						if( o1Method[i].toString().indexOf(getterName) != -1){
							isContain = true;                          //包含此方法
							break;
						}
					}
					
					if( isContain ){
						// 获取相应的getter方法
						Method getter = o1.getClass().getDeclaredMethod(getterName,null);
						Type[] setterParamTypes = setter.getGenericParameterTypes();

						for (int i = 0; i < setterParamTypes.length; i++) {

							Object value = null;
							String validName = getterName.toString().replace("get", "");
							char firstChar = validName.charAt(0); // 第一个大写字符转成小写
							String low = String.valueOf(firstChar).toLowerCase();
							validName = low + validName.substring(1, validName.length());

							if (map != null && map.containsKey(validName)) { //如果是敏感字段
								value = map.get(validName).toString();
							} else {
								value = changeToDto(getter.invoke(o1,null), setterParamTypes[i]);
							}
							
							if (value == null) { // null值不赋值
								continue;
							}
							
							setter.invoke(o2, new Object[] { value }); // 从entity取值赋予vo
						}
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		}

		return o2;
	}
	
	/**
     * Clone值，如果类型不一样，则做基本类型的转换
     * @param v1 待Clone的值
     * @param toType Clone后的dto类型
     * @return
     */
	public Object changeToDto(Object v1, Type toType){
		
		String class2 = toType.toString();

		if (v1 == null) {
			//处理基本类型
			if (class2.equals("long")) {
				return 0;
			} else if (class2.equals("int")) {
				return 0;
			} else if (class2.equals("double")) {
				return 0.0;
			} else if (class2.equals("float")) {
				return 0;
			} else {
				return null;
			}
		}

		String class1 = v1.getClass().toString();

		//如果相同类型，则直接返回原值   
		if (class1.equals(class2)) {
			return v1;
		}
		
		//返回String类型
		else if ( class2.indexOf("java.lang.String") != -1  ||  class2.equals("String") ) {
			
			if (class1.indexOf("java.lang.Integer") != -1) {
				return ((Integer) v1).toString();
			} else if (class1.indexOf("java.lang.Double") != -1) {
				return NumberUtils.format((Double) v1,",##0.00");
			} else if (class1.indexOf("java.lang.Float") != -1) {
				return NumberUtils.format((Float) v1,",##0.00");
			} else if (class1.indexOf("java.lang.Long") != -1) {
				return ((Long) v1).toString();
			} else if (class1.indexOf("java.math.BigDecimal") != -1) {
				return ((BigDecimal) v1).toString();
			} else if (class1.indexOf("java.util.Calendar") != -1) {
				return DateUtil.calendarToString( (Calendar)v1, "yyyy-MM-dd");
			}else if (class1.indexOf("java.util.GregorianCalendar") != -1) {
				return DateUtil.calendarToString( (Calendar)v1, "yyyy-MM-dd");
			}
			
			return v1.toString();
		}else if(class1.indexOf("java.lang.Integer") != -1  &&  class2.equals("int") ){
			return v1;
		}else if(class1.indexOf("java.lang.Byte") != -1  ||  class2.equals("byte") ){
			return v1;
		}
		
		return null;
	}
	
	/**
	 * 处理日期 格式为yyyy-MM-dd
	 * @return 返回日期的整形
	 */
	public int dealDate(String inputQuery){
		int dateInt = 0;
		if(inputQuery!=null && !inputQuery.trim().equals("")){
			Date beginDate=DateUtil.getDate(inputQuery,"yyyy-MM-dd");  //yyyy-MM-dd
    		int bYYYY = DateUtil.getYear(beginDate);
    		int bMM = DateUtil.getMonth(beginDate);
    		int bDD = DateUtil.getDay(beginDate);
    		if( bMM <=9 ){
    			dateInt= Integer.parseInt(bYYYY +"0"+ bMM);
    		}else{
    			dateInt= Integer.parseInt(bYYYY +""+ bMM);
    		}
    		if( bDD <=9 ){
    			dateInt= Integer.parseInt(dateInt +"0"+ bDD);
    		}else{
    			dateInt= Integer.parseInt(dateInt +""+ bDD);
    		}
    	}
		return dateInt;
	}
	
}
