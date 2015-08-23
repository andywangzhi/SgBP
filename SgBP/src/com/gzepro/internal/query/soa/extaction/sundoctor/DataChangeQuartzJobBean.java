package com.gzepro.internal.query.soa.extaction.sundoctor;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.gzepro.internal.query.soa.extaction.DataChangeTask;

public class DataChangeQuartzJobBean extends QuartzJobBean {

	@Resource
	private DataChangeTask dataChangeTask;
	
	

	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
		Trigger trigger = jobexecutioncontext.getTrigger();
		String triggerName = trigger.getName();		
		dataChangeTask.doChangeJob();
	}



	public DataChangeTask getDataChangeTask() {
		return dataChangeTask;
	}



	public void setDataChangeTask(DataChangeTask dataChangeTask) {
		this.dataChangeTask = dataChangeTask;
	}

}
