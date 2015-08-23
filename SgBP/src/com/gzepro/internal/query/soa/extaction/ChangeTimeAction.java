package com.gzepro.internal.query.soa.extaction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;

@SuppressWarnings("serial")
@Scope("prototype")
@Component("system.changeTime")
public class ChangeTimeAction extends SoaBaseJsonAction {
	private DataChangeTask dataChangeTask;
	private String hours = "20";
	private String minute = "10";
	private String errorMessage = "";
	
	
	public String topage(){
		try {
			dataChangeTask.setDataChangeTime();
			hours = dataChangeTask.getHours().trim();
			minute = dataChangeTask.getMinute().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "changetimepage";
	}
	public String saveOrUpdate(){
		try {
			if(hours == null && hours.equals("")){
				errorMessage = "小时的范围不对";
				hours = "20";
				return "changetimepage";
			}
			if(minute == null && minute.equals("")){
				errorMessage = "分钟的范围不对";
				minute = "10";
				return "changetimepage";
			}
			if(0 > Integer.parseInt(hours) && Integer.parseInt(hours) >24){	
				errorMessage = "小时的范围不对";
				return "changetimepage";
			}
			if(1 > Integer.parseInt(minute) && Integer.parseInt(minute) >59){
				errorMessage = "分钟的范围不对";
				return "changetimepage";
			}
			dataChangeTask.setHours(hours);
			dataChangeTask.setMinute(minute);
			dataChangeTask.writeConfig();
			dataChangeTask.setChangeTime();		
			errorMessage = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "changetimepage";
	}

	public DataChangeTask getDataChangeTask() {
		return dataChangeTask;
	}

	public void setDataChangeTask(DataChangeTask dataChangeTask) {
		this.dataChangeTask = dataChangeTask;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
