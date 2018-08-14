package com.nngdjt.pricemng.interceptor;

import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class XssInterceptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
        ActionContext actionContext = invocation.getInvocationContext();
        Map<String, Object> map = actionContext.getParameters();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
        	
            String value = "";
            if(entry.getValue() instanceof String) {
            	value = (String)entry.getValue();
            }else {
            	value = ((String[])(entry.getValue()))[0];
            }
        	
            entry.setValue(StringEscapeUtils.escapeHtml4(value));//将提交上来的字符串进行转码
            //System.out.println((entry.getValue()));
        }
        return invocation.invoke();
    }
}
