package com.gzepro.internal.query.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class PropertyUtil {
    /**
     * 读取配置文件
     * @param filePath
     * @return
     */
	public Properties getProperties(String filePath) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally{
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return p;
	}
	
    /**
     * 读取配置文件
     * @param filePath
     * @param proName
     * @return
     */
	public String getPropertieValue(String filePath,String proName) {
		Properties p = getProperties(filePath);
		String result = "";
		if(p != null){
			String tempStr = p.getProperty(proName);
			if(tempStr != null){
				result = tempStr;
			}
		}
		return result;
	}
}
