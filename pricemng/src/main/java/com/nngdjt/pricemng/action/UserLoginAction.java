package com.nngdjt.pricemng.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.entity.Menuitem;
import com.nngdjt.pricemng.entity.MenuitemExample;
import com.nngdjt.pricemng.entity.MenuitemRoleExample;
import com.nngdjt.pricemng.entity.MenuitemRoleKey;
import com.nngdjt.pricemng.entity.User;
import com.nngdjt.pricemng.entity.UserExample;
import com.nngdjt.pricemng.entity.UserRoleExample;
import com.nngdjt.pricemng.entity.UserRoleKey;
import com.nngdjt.pricemng.mapper.MenuitemMapper;
import com.nngdjt.pricemng.mapper.MenuitemRoleMapper;
import com.nngdjt.pricemng.mapper.UserMapper;
import com.nngdjt.pricemng.mapper.UserRoleMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;

public class UserLoginAction extends ActionSupport{
	
	private static Logger logger = LoggerFactory.getLogger(UserLoginAction.class);
	
	private String name;
	
	private String password;
	
	private UserMapper userMapper;
	
	private UserRoleMapper userRoleMapper;
	
	private MenuitemMapper menuitemMapper;
	
	private MenuitemRoleMapper menuItemRoleMapper;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private void beanInit() {
		userMapper = (UserMapper)LocalBeanFactory.get(UserMapper.class);
		userRoleMapper = (UserRoleMapper)LocalBeanFactory.get(UserRoleMapper.class);
		menuitemMapper = (MenuitemMapper)LocalBeanFactory.get(MenuitemMapper.class);
		menuItemRoleMapper = (MenuitemRoleMapper)LocalBeanFactory.get(MenuitemRoleMapper.class);
	}
	
	public String execute() {
		this.beanInit();
		if(ServletActionContext.getRequest().getSession().getAttribute("nowuser") != null) {
			return "success";
		}
		
		if(this.name == null || this.password == null) {
			return ExceptionProcess.exceptionProcess("无法接受用户信息");
		}
		//根据用户名查找用户信息
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(this.name);
		List<User> userList = this.userMapper.selectByExample(userExample);
		if(userList == null || userList.size() == 0) {
			logger.info("user is not found");
			return ExceptionProcess.exceptionProcess("用户信息不存在");
		}
		if(userList.size() != 1) {//用户不唯一
			logger.info("user is not unique");
			return ExceptionProcess.exceptionProcess("用户信息不唯一");
		}
		
		User user = userList.get(0);
		if(!this.password.equals(user.getPassword())) {
			logger.info("user password is not correct");
			return ExceptionProcess.exceptionProcess("用户密码错误");
		}
		
		//将用户信息放入session中保存
		ServletActionContext.getRequest().getSession().setAttribute("nowuser", user);
		
		//查找用户角色及角色包含的菜单信息
		List<Menuitem> menuItemListOfUser = new ArrayList<Menuitem>();
		List<Long> parentMenuitemOfUserList = new ArrayList<Long>();
		UserRoleExample userRoleExcample = new UserRoleExample();
		userRoleExcample.createCriteria().andUserIdEqualTo(user.getId());
		List<UserRoleKey> userRoleList = this.userRoleMapper.selectByExample(userRoleExcample);
		for(UserRoleKey userRole : userRoleList) {
			Long roleId = userRole.getRoleId();
			MenuitemRoleExample menuitemRoleExample = new MenuitemRoleExample();
			menuitemRoleExample.createCriteria().andRoleIdEqualTo(roleId);
			List<MenuitemRoleKey> menuitemRoleList = this.menuItemRoleMapper.selectByExample(menuitemRoleExample);
			for(MenuitemRoleKey menuitemRole : menuitemRoleList) {
				parentMenuitemOfUserList.add(menuitemRole.getMenuItemId());
			}
		}
		
		for(Long menuitemId : parentMenuitemOfUserList) {
			Menuitem parentMenuitem = this.menuitemMapper.selectByPrimaryKey(menuitemId);
			if(parentMenuitem == null) {
				continue;
			}
			menuItemListOfUser.add(parentMenuitem);
			//查找子节点
			MenuitemExample menuitemExample = new MenuitemExample();
			menuitemExample.createCriteria().andParentEqualTo(parentMenuitem.getId());
			List<Menuitem> menuItmeChildList = this.menuitemMapper.selectByExample(menuitemExample);
			for(Menuitem childItem : menuItmeChildList) {
				menuItemListOfUser.add(childItem);
			}
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("menuItemListOfUser", menuItemListOfUser);
		
		return "success";
	}
	
	public String logout() {
		logger.info(">>>>>user logout...");
		ServletActionContext.getRequest().getSession().removeAttribute("nowuser");
		return "success";
	}
}
