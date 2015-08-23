package com.gzepro.internal.query.common.struts.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
public class ExceptionInterceptor extends AbstractInterceptor{
	private static final Log logger = LogFactory.getLog(ExceptionInterceptor.class);
	public static final String EXCEPTION = "exception";
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
        try {
            return invocation.invoke();
        } catch (Exception e) {
            String message = "Caught exception while invoking action: " + invocation.getAction();
            logger.error(message, e);
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            invocation.getInvocationContext().put("_exception_string_", sw.toString());
            return EXCEPTION;
        }
    }
}
