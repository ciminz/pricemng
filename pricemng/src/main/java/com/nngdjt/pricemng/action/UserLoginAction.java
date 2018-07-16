package com.nngdjt.pricemng.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.MD5Encoder;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.base.DataBuilder;
import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.base.Station;
import com.nngdjt.pricemng.entity.Menuitem;
import com.nngdjt.pricemng.entity.MenuitemExample;
import com.nngdjt.pricemng.entity.MenuitemRoleExample;
import com.nngdjt.pricemng.entity.MenuitemRoleKey;
import com.nngdjt.pricemng.entity.PriceInfo;
import com.nngdjt.pricemng.entity.PriceInfoExample;
import com.nngdjt.pricemng.entity.User;
import com.nngdjt.pricemng.entity.UserExample;
import com.nngdjt.pricemng.entity.UserRoleExample;
import com.nngdjt.pricemng.entity.UserRoleKey;
import com.nngdjt.pricemng.mapper.MenuitemMapper;
import com.nngdjt.pricemng.mapper.MenuitemRoleMapper;
import com.nngdjt.pricemng.mapper.PriceInfoMapper;
import com.nngdjt.pricemng.mapper.UserMapper;
import com.nngdjt.pricemng.mapper.UserRoleMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;

public class UserLoginAction extends ActionSupport{
	
	private static Logger logger = LoggerFactory.getLogger(UserLoginAction.class);
	
	private String name;
	
	private String password;
	
	private String validateCode;
	
	private UserMapper userMapper;
	
	private UserRoleMapper userRoleMapper;
	
	private MenuitemMapper menuitemMapper;
	
	private MenuitemRoleMapper menuItemRoleMapper;
	
	private PriceInfoMapper priceInfoMapper;
	
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
	
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}


	
	private void beanInit() {
		userMapper = (UserMapper)LocalBeanFactory.get(UserMapper.class);
		userRoleMapper = (UserRoleMapper)LocalBeanFactory.get(UserRoleMapper.class);
		menuitemMapper = (MenuitemMapper)LocalBeanFactory.get(MenuitemMapper.class);
		menuItemRoleMapper = (MenuitemRoleMapper)LocalBeanFactory.get(MenuitemRoleMapper.class);
		priceInfoMapper = (PriceInfoMapper)LocalBeanFactory.get(PriceInfoMapper.class);
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
		logger.info(this.encoderByMd5(user.getPassword()).toUpperCase());
		logger.info(this.password.toUpperCase());
		if(!this.password.toUpperCase().equals(this.encoderByMd5(user.getPassword()).toUpperCase())) {
			logger.info("user password is not correct");
			return ExceptionProcess.exceptionProcess("用户密码错误");
		}
		
		logger.info(">>>>>>val1:" + this.getValidateCode() + ", val2:" 
		+ (String)ServletActionContext.getRequest().getSession().getAttribute("validateCode"));
		
		if(!this.getValidateCode().equals(ServletActionContext.getRequest().getSession().getAttribute("validateCode"))) {
			logger.info("user validatecode is not correct");
			return ExceptionProcess.exceptionProcess("验证码错误");
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
		
		List<Long> menuitemIdList = new ArrayList<Long>();
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
				if(menuitemIdList.contains(childItem.getId())) {
					continue;
				}
				menuItemListOfUser.add(childItem);
				menuitemIdList.add(childItem.getId());
			}
		}
		
		ServletActionContext.getRequest().getSession().setAttribute("menuItemListOfUser", menuItemListOfUser);
		initPriceTable();
		return "success";
	}
	
	public String logout() {
		logger.info(">>>>>user logout...");
		ServletActionContext.getRequest().getSession().removeAttribute("nowuser");
		return "success";
	}
	
	
	public void initPriceTable() {
		this.beanInit();
	    List<List<String>> priceList = new ArrayList<List<String>>();
		DataBuilder dataBuilder = new DataBuilder();
		ServletActionContext.getRequest().getSession().setAttribute("dataBuilder", dataBuilder);
		for(int i = 0; i < dataBuilder.lines.size(); i++) {
			Station desStation = dataBuilder.lines.get(i);
			List<PriceInfo> priceInfoList = new ArrayList<PriceInfo>();
			for(int j = 0; j <= i; j++) {
				Station oriStation =  dataBuilder.lines.get(j);
				PriceInfoExample priceInfoExcample = new PriceInfoExample();
				priceInfoExcample.createCriteria()
				.andOriStationNoEqualTo(oriStation.getStationNo())
				.andDesStationNoEqualTo(desStation.getStationNo())
				.andAuditFlgEqualTo("Y");;
				List<PriceInfo> priceInfoTmpList = priceInfoMapper.selectByExample(priceInfoExcample);
				if(priceInfoTmpList != null && priceInfoTmpList.size() != 0) {
					System.out.println(priceInfoTmpList.get(0).getPrice());
					priceInfoList.add(priceInfoTmpList.get(0));
				}else {
					PriceInfo priceInfoTmp = new PriceInfo();
					priceInfoTmp.setPrice("未审核");
					priceInfoList.add(priceInfoTmp);
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
		ServletActionContext.getRequest().getSession().setAttribute("priceList", priceList);
		
	}
	
	
	public String encoderByMd5(String s) {
		try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] bytes = md.digest(s.getBytes("utf-8"));
	        return toHex(bytes);
	    }
	    catch (Exception e) {
	        throw new RuntimeException(e);
	    }
    }
	
	private static String toHex(byte[] bytes) {

	    final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
	    StringBuilder ret = new StringBuilder(bytes.length * 2);
	    for (int i=0; i<bytes.length; i++) {
	        ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
	        ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
	    }
	    return ret.toString();
	}
}
