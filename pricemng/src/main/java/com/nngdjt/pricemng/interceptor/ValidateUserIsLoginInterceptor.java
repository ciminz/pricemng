package com.nngdjt.pricemng.interceptor;

import org.apache.struts2.ServletActionContext;

import com.nngdjt.pricemng.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidateUserIsLoginInterceptor implements Interceptor{

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
		// TODO Auto-generated method stub
		User u = (User)ServletActionContext.getRequest().getSession().getAttribute("nowuser");
		if(u == null) {
			ServletActionContext.getRequest().setAttribute("notLogin", "0");
			return "notlogin";
		}
		
		return arg0.invoke();
	}

}
