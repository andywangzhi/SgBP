package com.gzepro.internal.query.common.util;

import org.apache.axis.message.SOAPHeaderElement;

 /**
  * 
  * 服务调用代理类,用于添加服务的Soap信息Heads
  * 
  * @author lw
  * @version 1.0
  * Created on: 2012-7-1
  */
 public class WSProxy {
		 private String username = "root";
		 private String password = "sonus";
		
		 private String nameSpace = "";
         private SOAPHeaderElement usernameEle;
         private SOAPHeaderElement passwordEle;
         
         public WSProxy() {
        	 String username = "root";
        	 String password = "sonus";
        	 String md5Password = MD5Util.getMD5String(password).toUpperCase();
        	 usernameEle = new SOAPHeaderElement(nameSpace,"Username",username);
        	 passwordEle = new SOAPHeaderElement(nameSpace,"Password", md5Password);
         }
         
         public WSProxy(String username,String password) {
        	 String md5Password = MD5Util.getMD5String(password).toUpperCase();
        	 usernameEle = new SOAPHeaderElement(nameSpace,"Username",username);
        	 passwordEle = new SOAPHeaderElement(nameSpace,"Password", md5Password);
         }

		public SOAPHeaderElement getUsernameEle() {
			return usernameEle;
		}

		public void setUsernameEle(SOAPHeaderElement usernameEle) {
			this.usernameEle = usernameEle;
		}

		public SOAPHeaderElement getPasswordEle() {
			return passwordEle;
		}

		public void setPasswordEle(SOAPHeaderElement passwordEle) {
			this.passwordEle = passwordEle;
		}
		
 }
