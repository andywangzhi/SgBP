package com.gzepro.internal.query.common.util;

import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class LDAPUtil {
	
	private static PropertyUtil p = new PropertyUtil();
	
	public static InitialLdapContext getConnectionFromFool()
			throws NamingException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		String privideUrl = p.getPropertieValue("config/spring/jdbc.properties", "ldap_provider_url");
		env.put(Context.PROVIDER_URL,privideUrl);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put("com.sun.jndi.ldap.connect.pool", "false");
		env.put("java.naming.referral", "follow");
		return new InitialLdapContext(env, null);
	}

	public static boolean authenticate(String userDn, String password)
			throws NamingException {
		LdapContext ctx = null;
		try {
			Control[] connCtls = new Control[] {};
			ctx = getConnectionFromFool();
			ctx.getRequestControls();
			ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, "CN=" + userDn+ ",ou=users,o=alticor");
			ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);
			ctx.reconnect(connCtls);
			return true;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
				ctx = null;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (LDAPUtil.authenticate("CN087482", "amway123")) {
				System.out.println("successfully ");
			} else {
				System.out.println("failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
