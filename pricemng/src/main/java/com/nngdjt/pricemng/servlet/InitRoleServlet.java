package com.nngdjt.pricemng.servlet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.nngdjt.pricemng.base.DataBuilder;
import com.nngdjt.pricemng.base.Station;
import com.nngdjt.pricemng.entity.Menuitem;
import com.nngdjt.pricemng.entity.MenuitemRoleExample;
import com.nngdjt.pricemng.entity.MenuitemRoleKey;
import com.nngdjt.pricemng.entity.PriceInfo;
import com.nngdjt.pricemng.entity.PriceInfoExample;
import com.nngdjt.pricemng.entity.Role;
import com.nngdjt.pricemng.entity.User;
import com.nngdjt.pricemng.entity.UserExample;
import com.nngdjt.pricemng.entity.UserRoleExample;
import com.nngdjt.pricemng.entity.UserRoleKey;
import com.nngdjt.pricemng.mapper.MenuitemMapper;
import com.nngdjt.pricemng.mapper.MenuitemRoleMapper;
import com.nngdjt.pricemng.mapper.PriceInfoMapper;
import com.nngdjt.pricemng.mapper.RoleMapper;
import com.nngdjt.pricemng.mapper.UserMapper;
import com.nngdjt.pricemng.mapper.UserRoleMapper;
import com.vane.base.LocalBeanFactory;

/**
 * Servlet implementation class ImportMenuItemServlet
 */
public class InitRoleServlet extends HttpServlet {
	private static final String USER_MNG_MENU_ID = "1";
	
	private static final String ROLE_MNG_MENU_ID = "2";
	
	private static final String SYSADMIN_USER_ID = "1";
	
	private WebApplicationContext wac;
	
	private MenuitemMapper menuitemMapper;
	
	private UserMapper userMapper;
	
	private RoleMapper roleMapper;
	
	private UserRoleMapper userRoleMapper;
	
	private MenuitemRoleMapper menuitemRoleMapper;
	
	private PriceInfoMapper priceInfoMapper;
	
	private void beanInit() {
		this.menuitemMapper = (MenuitemMapper)LocalBeanFactory.get(MenuitemMapper.class);
		this.userMapper = (UserMapper)LocalBeanFactory.get(UserMapper.class);
		this.roleMapper = (RoleMapper)LocalBeanFactory.get(RoleMapper.class);
		this.userRoleMapper = (UserRoleMapper)LocalBeanFactory.get(UserRoleMapper.class);
		this.menuitemRoleMapper = (MenuitemRoleMapper)LocalBeanFactory.get(MenuitemRoleMapper.class);
		this.priceInfoMapper = (PriceInfoMapper)LocalBeanFactory.get(PriceInfoMapper.class);
	}

	@Override
	@Transactional
	@Rollback(true)
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.beanInit();
		this.initRole();
		this.initRoleMenu();
		this.initUserRole();
		this.initPriceTable();
//		//查看是否存在ID为1的角色
//		Role role = this.roleMapper.selectByPrimaryKey(1L);
//		if(role == null) {
//			role = new Role();
//			role.setId(1L);
//			role.setRolename("超级管理员");
//			this.roleMapper.insert(role);
//		}
//		
//		//超级管理员是否存在用户管理权限
//		MenuitemRoleExample menuitemRoleExample = new MenuitemRoleExample();
//		menuitemRoleExample.createCriteria().andRoleIdEqualTo(role.getId()).andMenuItemIdEqualTo(Long.valueOf(USER_MNG_MENU_ID));
//		List<MenuitemRoleKey> menuitemRoleList = this.menuitemRoleMapper.selectByExample(menuitemRoleExample);
//		if(menuitemRoleList == null || menuitemRoleList.size() == 0) {
//			MenuitemRoleKey menuitemRole = new MenuitemRoleKey();
//			menuitemRole.setMenuItemId(Long.valueOf(USER_MNG_MENU_ID));
//			menuitemRole.setRoleId(role.getId());
//			this.menuitemRoleMapper.insert(menuitemRole);
//		}
//		
//		//超级管理员是否存在角色管理权限
//		menuitemRoleExample = new MenuitemRoleExample();
//		menuitemRoleExample.createCriteria().andRoleIdEqualTo(role.getId()).andMenuItemIdEqualTo(Long.valueOf(ROLE_MNG_MENU_ID));
//		 menuitemRoleList = this.menuitemRoleMapper.selectByExample(menuitemRoleExample);
//		if(menuitemRoleList == null || menuitemRoleList.size() == 0) {
//			MenuitemRoleKey menuitemRole = new MenuitemRoleKey();
//			menuitemRole.setMenuItemId(Long.valueOf(ROLE_MNG_MENU_ID));
//			menuitemRole.setRoleId(role.getId());
//			this.menuitemRoleMapper.insert(menuitemRole);
//		}
//		
//		//sysadmin用户是否具有超级管理员权限
//		User sysadmin = this.userMapper.selectByPrimaryKey(Long.valueOf(SYSADMIN_USER_ID));
//		UserRoleExample userRoleExample = new UserRoleExample();
//		userRoleExample.createCriteria().andRoleIdEqualTo(role.getId()).andUserIdEqualTo(sysadmin.getId());
//		List<UserRoleKey> userRoleList = this.userRoleMapper.selectByExample(userRoleExample);
//		if(userRoleList == null || userRoleList.size() == 0) {
//			UserRoleKey userRole = new UserRoleKey();
//			userRole.setRoleId(role.getId());
//			userRole.setUserId(sysadmin.getId());
//			this.userRoleMapper.insert(userRole);
//		}
	}
	
	private void initRole() {
		String contextPath = this.getServletContext().getRealPath("/WEB-INF") + "/";
		String menuItemPropertieAddr = contextPath + "role-config.xml";
		Set<String> nameArray = new HashSet<String>();
		try {
			List<Role> roles = this.roleMapper.selectByExample(null);
			if(roles != null) {
				for (Role role : roles) {
					nameArray.add(role.getId() + "");
				}
			}
			
			Document document = new SAXReader().read(new File(menuItemPropertieAddr));
			Element rootElement = document.getRootElement();
			List<Element> items = rootElement.elements();
			List<Role> itemIntoDb = new ArrayList<Role> ();
			out:for(Element e : items) {
				List<Element> itemArgs = e.elements();
				Role role = new Role();
				for(Element e2 : itemArgs) {
					if(("Id").equals(e2.getName())) {
						if(nameArray.contains(e2.getText())) {
							continue out;
						}
						role.setId(Long.valueOf(e2.getText()));
						nameArray.add(e2.getText());
					}
					
					if(("RoleName").equals(e2.getName())) { 
						role.setRolename(e2.getText());
					}
				}
				itemIntoDb.add(role);
			}
			
			for(Role role : itemIntoDb) {
				this.roleMapper.insert(role);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initRoleMenu() {
		String contextPath = this.getServletContext().getRealPath("/WEB-INF") + "/";
		String menuItemPropertieAddr = contextPath + "role_menu-config.xml";
		Set<String> nameArray = new HashSet<String>();
		try {
			List<MenuitemRoleKey> menuitemRoles = this.menuitemRoleMapper.selectByExample(null);
			if(menuitemRoles != null) {
				for (MenuitemRoleKey menuitemRole : menuitemRoles) {
					nameArray.add(menuitemRole.getRoleId() + "" + menuitemRole.getMenuItemId());
				}
			}
			
			Document document = new SAXReader().read(new File(menuItemPropertieAddr));
			Element rootElement = document.getRootElement();
			List<Element> items = rootElement.elements();
			List<MenuitemRoleKey> itemIntoDb = new ArrayList<MenuitemRoleKey> ();
			out:for(Element e : items) {
				List<Element> itemArgs = e.elements();
				MenuitemRoleKey menuitemRole = new MenuitemRoleKey();
				String roleId = "";
				String menuId = "";
				for(Element e2 : itemArgs) {
					if(("RoleId").equals(e2.getName())) {
						roleId = e2.getText();
					}
					
					if(("MenuId").equals(e2.getName())) { 
						menuId = e2.getText();
					}
				}
				if(nameArray.contains(roleId + menuId)) {
					continue out;
				}
				menuitemRole.setRoleId(Long.valueOf(roleId));
				menuitemRole.setMenuItemId(Long.valueOf(menuId));
				itemIntoDb.add(menuitemRole);
			}
			
			for(MenuitemRoleKey menuitemRole : itemIntoDb) {
				this.menuitemRoleMapper.insert(menuitemRole);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initUserRole() {
		String contextPath = this.getServletContext().getRealPath("/WEB-INF") + "/";
		String menuItemPropertieAddr = contextPath + "user_role-config.xml";
		Set<String> nameArray = new HashSet<String>();
		try {
			List<UserRoleKey> UserRoles = this.userRoleMapper.selectByExample(null);
			if(UserRoles != null) {
				for (UserRoleKey userRole : UserRoles) {
					nameArray.add(userRole.getRoleId() + "" + userRole.getUserId());
				}
			}
			
			Document document = new SAXReader().read(new File(menuItemPropertieAddr));
			Element rootElement = document.getRootElement();
			List<Element> items = rootElement.elements();
			List<UserRoleKey> itemIntoDb = new ArrayList<UserRoleKey> ();
			out:for(Element e : items) {
				List<Element> itemArgs = e.elements();
				UserRoleKey userRole = new UserRoleKey();
				String roleId = "";
				String userId = "";
				for(Element e2 : itemArgs) {
					if(("RoleId").equals(e2.getName())) {
						roleId = e2.getText();
					}
					
					if(("UserId").equals(e2.getName())) { 
						userId = e2.getText();
						User user = this.userMapper.selectByPrimaryKey(Long.valueOf(userId));
						if(user == null) {
							continue out;
						}
					}
				}
				if(nameArray.contains(roleId + userId)) {
					continue out;
				}
				userRole.setRoleId(Long.valueOf(roleId));
				userRole.setUserId(Long.valueOf(userId));
				itemIntoDb.add(userRole);
			}
			
			for(UserRoleKey userRole : itemIntoDb) {
				this.userRoleMapper.insert(userRole);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initPriceTable() {
		this.beanInit();
	    List<List<String>> priceList = new ArrayList<List<String>>();
		DataBuilder dataBuilder = new DataBuilder();
		this.getServletContext().setAttribute("dataBuilder", dataBuilder);
		for(int i = 0; i < dataBuilder.lines.size(); i++) {
			Station desStation = dataBuilder.lines.get(i);
			List<PriceInfo> priceInfoList = new ArrayList<PriceInfo>();
			for(int j = 0; j <= i; j++) {
				Station oriStation =  dataBuilder.lines.get(j);
				PriceInfoExample priceInfoExcample = new PriceInfoExample();
				priceInfoExcample.createCriteria()
				.andOriStationNoEqualTo(oriStation.getStationNo())
				.andDesStationNoEqualTo(desStation.getStationNo());
				List<PriceInfo> priceInfoTmpList = priceInfoMapper.selectByExample(priceInfoExcample);
				if(priceInfoTmpList != null && priceInfoTmpList.size() != 0) {
					System.out.println(priceInfoTmpList.get(0).getPrice());
					priceInfoList.add(priceInfoTmpList.get(0));
				}
			}
			
			int size = dataBuilder.lines.size();
			List<String> priceRow = new ArrayList<String>();
			priceRow.add(desStation.getName());
			for(PriceInfo priceInfo : priceInfoList) {
                priceRow.add(priceInfo.getPrice());  
            }
			
			for(int k = priceRow.size(); k <= size; k++) {
				priceRow.add("");
			}
			priceList.add(priceRow);
		}
		
		//设置尾行
		List<String> priceRow = new ArrayList<String>();
		priceRow.add("");
		for(Station station : dataBuilder.lines) {
		   priceRow.add(station.getName());  
		}
		priceList.add(priceRow);
		this.getServletContext().setAttribute("priceList", priceList);
		
	}
}
