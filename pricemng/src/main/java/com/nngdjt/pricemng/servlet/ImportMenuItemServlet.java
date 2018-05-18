package com.nngdjt.pricemng.servlet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nngdjt.pricemng.entity.Menuitem;
import com.nngdjt.pricemng.mapper.MenuitemMapper;
import com.vane.base.LocalBeanFactory;
import com.vane.utils.BaseUtil;

/**
 * Servlet implementation class ImportMenuItemServlet
 */
public class ImportMenuItemServlet extends HttpServlet {
	private WebApplicationContext wac;
	
	private MenuitemMapper menuitemMapper;
	
	private void beanInit() {
		this.menuitemMapper = (MenuitemMapper)LocalBeanFactory.get(MenuitemMapper.class);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.beanInit();
		wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		String contextPath = this.getServletContext().getRealPath("/WEB-INF") + "/";
		String menuItemPropertieAddr = contextPath + "menu-config.xml";
		Set<String> menuNameArray = new HashSet<String>();
		try {
			List<Menuitem> menuItems = this.menuitemMapper.selectByExample(null);
			if(menuItems != null) {
				for (Menuitem menuitem : menuItems) {
					menuNameArray.add(menuitem.getMenuitemname());
				}
			}
			
			Document document = new SAXReader().read(new File(menuItemPropertieAddr));
			Element rootElement = document.getRootElement();
			List<Element> items = rootElement.elements();
			List<Menuitem> menuItemIntoDb = new ArrayList<Menuitem> ();
			out:for(Element e : items) {
				List<Element> itemArgs = e.elements();
				Menuitem menuItem = new Menuitem();
				for(Element e2 : itemArgs) {
					if(("ItemName").equals(e2.getName())) {
						if(menuNameArray.contains(e2.getText())) {
							continue out;
						}
						menuItem.setMenuitemname(e2.getText());
						menuNameArray.add(e2.getText());
					}
					
					if(("Url").equals(e2.getName())) { 
						menuItem.setUrl(e2.getText());
					}
					
					if(("IsParent").equals(e2.getName())) {
						menuItem.setIsparent(Integer.parseInt(e2.getText()));
					}
					
					if("Id".equals(e2.getName())) {
						menuItem.setId(Long.valueOf(e2.getText()));
					}
					
					if("Parent".equals(e2.getName()) && e2.getText() != null && !"".equals(e2.getText())) {
						menuItem.setParent(Long.valueOf(e2.getText()));
					}
				}
				menuItemIntoDb.add(menuItem);
			}
			
			for(Menuitem menuItem : menuItemIntoDb) {
				this.menuitemMapper.insert(menuItem);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
