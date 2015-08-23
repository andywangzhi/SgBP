package com.gzepro.internal.query.soa.extaction.sundoctor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("simpleService")
public class SimpleService implements Serializable{
	
	private static final long serialVersionUID = 122323233244334343L;
	
	public void testMethod(String triggerName){
		//这里执行定时调度业务
		//logger.info(triggerName);
		
		try {
			System.out.println(triggerName + " 定时器  " + SimpleService.getSystemDateTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Date getSystemDateTime() throws Exception {
		Date dateSystem = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.parse(sdf.format(dateSystem));
		
	}

}
