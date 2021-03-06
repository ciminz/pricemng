package com.nngdjt.pricemng.action;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.base.Page;
import com.nngdjt.pricemng.entity.Role;
import com.nngdjt.pricemng.entity.User;
import com.nngdjt.pricemng.entity.UserExample;
import com.nngdjt.pricemng.entity.UserExample.Criteria;
import com.nngdjt.pricemng.entity.UserRoleExample;
import com.nngdjt.pricemng.entity.UserRoleKey;
import com.nngdjt.pricemng.mapper.RoleMapper;
import com.nngdjt.pricemng.mapper.UserMapper;
import com.nngdjt.pricemng.mapper.UserRoleMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;
import com.vane.utils.BaseUtil;

public class UserManageAction extends ActionSupport{
	
	private static Logger logger = LoggerFactory.getLogger(UserManageAction.class);
	
	private User user;
	
	private String roleIds;
	
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	private String nowpage;
	
	private String pagesize;
	
	public String getPagesize() {
		if(this.pagesize == null) {
			return "5";
		}
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getNowpage() {
		if(this.nowpage == null) {
			return "1";
		}
		return nowpage;
	}

	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private UserMapper userMapper;
	
	private UserRoleMapper userRoleMapper;
	
	private RoleMapper roleMapper;
	
	/**
	 * 初始化组件
	 */
	private void beanInit() {
		userMapper = (UserMapper)LocalBeanFactory.get(UserMapper.class);
		userRoleMapper = (UserRoleMapper)LocalBeanFactory.get(UserRoleMapper.class);
		this.roleMapper = (RoleMapper)LocalBeanFactory.get(RoleMapper.class);
	}
	
	
	public String viewToAdd() {
		this.beanInit();
		List<Role> roleInfoList = this.roleMapper.selectByExample(null);
		ServletActionContext.getRequest().setAttribute("roleInfoList", roleInfoList);
		return "success";
	}
	/**
	 * 用户查询
	 * @return
	 */
	public String query() {
		this.beanInit();
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		if(this.getUser() != null && this.getUser().getUsername() != null && !"".equals(this.getUser().getUsername())) {
			criteria.andUsernameLike("%" + this.getUser().getUsername() + "%");
		}
		if(this.getUser() != null && this.getUser().getRealusername() != null && !"".equals(this.getUser().getRealusername())) {
			criteria.andRealusernameLike("%" + this.getUser().getRealusername() + "%");
		}
		List<User> userList = this.userMapper.selectByExampleWithRowbounds(userExample,
				new RowBounds(Page.getOffSet(this.getNowpage(), this.getPagesize()), Integer.valueOf(this.getPagesize())));
		int totalPageSize = Page.getTotolSize(Integer.valueOf(this.getPagesize()) ,this.userMapper.countByExample(userExample)); 
		ServletActionContext.getRequest().setAttribute("queryResult", userList);
		ServletActionContext.getRequest().setAttribute("totalPageSize", totalPageSize + "");
		return "success";
	}
	
	/**
	 * 用户删除
	 * @return
	 */
	public String delete() {
		this.beanInit();
		if(this.getUser() == null || this.getUser().getId() == null || "".equals(this.getUser().getId())) {
			logger.info("get user id faild");
			return ExceptionProcess.exceptionProcess("无法接受用户信息");
		}
		this.userMapper.deleteByPrimaryKey(this.getUser().getId());
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(this.getUser().getId());
		this.userRoleMapper.deleteByExample(userRoleExample);
		ServletActionContext.getRequest().setAttribute("returnPage", "userManage/userQueryByCondition");
		return "success";
	}
	
	/**
	 * 用户新增
	 */
	public String add() {
		this.beanInit();
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		if(this.getUser() != null && this.getUser().getUsername() != null && !"".equals(this.getUser().getUsername())) {
			criteria.andUsernameEqualTo(this.getUser().getUsername());
		}
		
		List<User> userList = this.userMapper.selectByExample(userExample);
		if(userList != null && userList.size() != 0) {
			logger.info("exist the same name user");
			return ExceptionProcess.exceptionProcess("已存在相同用户名的用户","userManage/userImportView");
		}
		//新增用户
		User userIntoDb = new User();
		userIntoDb.setId(BaseUtil.getSeqLong());
		userIntoDb.setUsername(this.getUser().getUsername());
		userIntoDb.setRealusername(this.getUser().getRealusername());
		userIntoDb.setTel(this.getUser().getTel());
		userIntoDb.setPassword("123456");
		
		if(this.getRoleIds() == null) {
			logger.info("no role");
			return ExceptionProcess.exceptionProcess("请分配角色!","userManage/userImportView");
		}
		
		String[] chkValues = this.getRoleIds().split(","); 
		if(chkValues == null || chkValues.length == 0) {
			//分配角色
//			UserRoleKey userRole = new UserRoleKey();
//			userRole.setUserId(userIntoDb.getId());
//			userRole.setRoleId(Long.valueOf(Constants.NORMAL_USER_ROLE_ID));
//			this.userRoleMapper.insert(userRole);
			logger.info("no role");
			return ExceptionProcess.exceptionProcess("请分配角色!","userManage/userImportView");
		}else {
			for(String roleId : chkValues) {
				//分配角色
				UserRoleKey userRole = new UserRoleKey();
				userRole.setUserId(userIntoDb.getId());
				userRole.setRoleId(Long.valueOf(roleId));
				this.userRoleMapper.insert(userRole);
			}
			this.userMapper.insert(userIntoDb);
		}
		
		
		ServletActionContext.getRequest().setAttribute("returnPage", "userManage/userQueryByCondition");
		return "success";
	}
	
	
	public String userUpdView() {
		this.beanInit();
		if(this.getUser() == null) {
			this.setUser((User)ServletActionContext.getRequest().getSession().getAttribute("nowuser"));
		}
		User user = this.userMapper.selectByPrimaryKey(this.getUser().getId());
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(user.getId());
		List<UserRoleKey> userRoleList = this.userRoleMapper.selectByExample(userRoleExample);
		List<Role> roleList = this.roleMapper.selectByExample(null);
		ServletActionContext.getRequest().setAttribute("upduser", user);
		ServletActionContext.getRequest().setAttribute("userRoleList", userRoleList);
		ServletActionContext.getRequest().setAttribute("roleInfoList", roleList);
		return "success";
	}
	
	public String updAdmin() {
		this.beanInit();
		String[] chkValues = this.getRoleIds().split(","); 
		if(chkValues == null || chkValues.length == 0) {
			logger.info("no role");
			return ExceptionProcess.exceptionProcess("请分配角色!","userManage/userQueryByCondition");
		}else {
			for(String roleId : chkValues) {
				//分配角色
				UserRoleKey userRole = new UserRoleKey();
				userRole.setUserId(this.getUser().getId());
				userRole.setRoleId(Long.valueOf(roleId.trim()));
				this.userRoleMapper.insert(userRole);
				this.userMapper.updateByPrimaryKey(this.getUser());
			}
		}
		
		ServletActionContext.getRequest().setAttribute("returnPage", "userManage/userQueryByCondition");
		return "success";
	} 
	
	public String updUser() {
		this.beanInit();
		if(this.getRoleIds() == null) {
			logger.info("no role");
			return ExceptionProcess.exceptionProcess("请分配角色!","userManage/userQueryByCondition");
		}
		String[] chkValues = this.getRoleIds().split(","); 
		if(chkValues == null || chkValues.length == 0) {
			logger.info("no role");
			return ExceptionProcess.exceptionProcess("请分配角色!","userManage/userQueryByCondition");
		}else {
			UserRoleExample userRoleExample = new UserRoleExample();
			userRoleExample.createCriteria().andUserIdEqualTo(this.getUser().getId());
			this.userRoleMapper.deleteByExample(userRoleExample);
			User userIndb = this.userMapper.selectByPrimaryKey(this.getUser().getId());
			this.getUser().setPassword(userIndb.getPassword());
			
			for(String roleId : chkValues) {
				//分配角色
				UserRoleKey userRole = new UserRoleKey();
				userRole.setUserId(this.getUser().getId());
				userRole.setRoleId(Long.valueOf(roleId.trim()));
				this.userRoleMapper.insert(userRole);
			}
			this.userMapper.updateByPrimaryKey(this.getUser());
		}
		
		ServletActionContext.getRequest().setAttribute("returnPage", "userManage/userQueryByCondition");
		return "success";
	} 
	
	
	public String userPwdUpd() {
		this.beanInit();
		User userInDb = this.userMapper.selectByPrimaryKey(this.getUser().getId());
		userInDb.setPassword(this.getUser().getPassword());
		this.userMapper.updateByPrimaryKey(userInDb);
		ServletActionContext.getRequest().setAttribute("returnPage", "view/right.vm");
		return "success";
	}
}
