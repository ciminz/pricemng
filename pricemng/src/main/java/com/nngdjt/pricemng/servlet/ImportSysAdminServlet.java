package com.nngdjt.pricemng.servlet;

import java.io.File;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.omg.CORBA.UserException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HttpServletBean;

import com.nngdjt.pricemng.entity.User;
import com.nngdjt.pricemng.entity.UserExample;
import com.nngdjt.pricemng.mapper.UserMapper;
import com.vane.base.LocalBeanFactory;
import com.vane.utils.BaseUtil;

/**
 * Servlet implementation class ImportSysAdminServlet
 */
public class ImportSysAdminServlet extends HttpServlet {
	private WebApplicationContext wac;
	
	private UserMapper userMapper;
	
	private void beanInit() {
		this.userMapper = (UserMapper)LocalBeanFactory.get(UserMapper.class);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.beanInit();
		wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		String contextPath = this.getServletContext().getRealPath("/WEB-INF") + "/";
		String sysAdminPropertieAddr = contextPath + "sysadmin-config.xml";
		try {
			Document document = new SAXReader().read(new File(sysAdminPropertieAddr));
			Element rootElement = document.getRootElement();
			List<Element> list = rootElement.elements();
			User sysAdmin = new User();
			for(Element e : list) {
				if(("username").equals(e.getName())) {
					sysAdmin.setUsername(e.getText());
				}
				
				if(("password").equals(e.getName())) {
					sysAdmin.setPassword(e.getText());
				}
				
				if("realUsername".equals(e.getName())) {
					sysAdmin.setRealusername(e.getText());
				}
			}
			if(sysAdmin.getUsername() != null && sysAdmin.getPassword() != null) {
				UserExample userExample = new UserExample();
				userExample.createCriteria().andUsernameEqualTo(sysAdmin.getUsername());
				List<User> userList = this.userMapper.selectByExample(userExample);
				if(userList != null && userList.size() == 0) {
					sysAdmin.setId(1L);
					this.userMapper.insert(sysAdmin);
				}
			}
			this.getServletContext().setAttribute("sysAdmin", sysAdmin.getUsername());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
