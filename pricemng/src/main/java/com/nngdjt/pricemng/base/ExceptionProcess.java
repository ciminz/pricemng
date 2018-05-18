package com.nngdjt.pricemng.base;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.action.UserLoginAction;

public class ExceptionProcess {
	private static Logger logger = LoggerFactory.getLogger(ExceptionProcess.class); 
	public static String exceptionProcess(String message) {
		logger.info("============exception message=======>" + message);
		ServletActionContext.getRequest().setAttribute("exceptionFlg", "1");
		ServletActionContext.getRequest().setAttribute("exceptionMessage", message);
		return "input";
	}
	
	
	public static String exceptionProcess(String message, String returnPage) {
		logger.info("============exception message=======>" + message);
		ServletActionContext.getRequest().setAttribute("exceptionFlg", "1");
		ServletActionContext.getRequest().setAttribute("exceptionMessage", message);
		ServletActionContext.getRequest().setAttribute("returnPage", returnPage);
		return "input";
	}
}
