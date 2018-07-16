package com.nngdjt.pricemng.interceptor;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.action.AjaxAction;
import com.nngdjt.pricemng.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidateUserIsLoginInterceptor implements Interceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxAction.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		logger.info(ServletActionContext.getRequest().getRequestURL().toString());
		if(ServletActionContext.getRequest().getRequestURL().toString().indexOf("ajaxSetValidateCode") != -1) {
			return arg0.invoke();
		}
		// TODO Auto-generated method stub
		User u = (User)ServletActionContext.getRequest().getSession().getAttribute("nowuser");
		if(u == null) {
			ServletActionContext.getRequest().setAttribute("notLogin", "0");
			return "notlogin";
		}
		
		return arg0.invoke();
	}

}
