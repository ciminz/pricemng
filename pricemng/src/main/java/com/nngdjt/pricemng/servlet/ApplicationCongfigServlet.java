package com.nngdjt.pricemng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class ApplicationCongfigServlet
 */
public class ApplicationCongfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String rootAddr = this.getServletContext().getContextPath();
		this.getServletContext().setAttribute("rootAddr", rootAddr + "/");
	}
}
