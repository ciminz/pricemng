package com.nngdjt.pricemng.action;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.base.Constants;
import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.base.Page;
import com.nngdjt.pricemng.entity.StationInfo;
import com.nngdjt.pricemng.entity.StationInfoExample;
import com.nngdjt.pricemng.entity.StationInfoExample.Criteria;
import com.nngdjt.pricemng.entity.UserRoleExample;
import com.nngdjt.pricemng.entity.UserRoleKey;
import com.nngdjt.pricemng.mapper.StationInfoMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;
import com.vane.utils.BaseUtil;

public class StationManageAction extends ActionSupport{
	
	private static Logger logger = LoggerFactory.getLogger(StationManageAction.class);
	
	private StationInfo stationInfo;

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
	
	public StationInfo getStationInfo() {
		return stationInfo;
	}

	public void setStationInfo(StationInfo stationInfo) {
		this.stationInfo = stationInfo;
	}


	private StationInfoMapper stationInfoMapper;
	
	
	/**
	 * 初始化组件
	 */
	private void beanInit() {
		this.stationInfoMapper = (StationInfoMapper)LocalBeanFactory.get(StationInfoMapper.class);
	}
	
	/**
	 * 站点查询
	 * @return
	 */
	public String query() {
		this.beanInit();
		StationInfoExample stationInfoExample = new StationInfoExample();
		Criteria criteria = stationInfoExample.createCriteria();
		if(this.getStationInfo() != null && this.getStationInfo().getStationNo() != null && !"".equals(this.getStationInfo().getStationNo())) {
			criteria.andStationNoLike("%" + this.getStationInfo().getStationNo() + "%");
		}
		if(this.getStationInfo() != null && this.getStationInfo().getStationNme() != null && !"".equals(this.getStationInfo().getStationNme())) {
			criteria.andStationNmeLike("%" + this.getStationInfo().getStationNme() + "%");
		}
		if(this.getStationInfo() != null && this.getStationInfo().getExchangeFlg() != null && !"-1".equals(this.getStationInfo().getExchangeFlg())) {
			criteria.andExchangeFlgEqualTo(this.getStationInfo().getExchangeFlg());
		}
		List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExampleWithRowbounds(stationInfoExample,
				new RowBounds(Page.getOffSet(this.getNowpage(), this.getPagesize()), Integer.valueOf(this.getPagesize())));
		int totalPageSize = Page.getTotolSize(Integer.valueOf(this.getPagesize()) ,this.stationInfoMapper.countByExample(stationInfoExample)); 
		ServletActionContext.getRequest().setAttribute("queryResult", stationInfoList);
		ServletActionContext.getRequest().setAttribute("totalPageSize", totalPageSize + "");
		return "success";
	}
	
	/**
	 * 站点删除
	 * @return
	 */
	public String delete() {
		this.beanInit();
		if(this.getStationInfo() == null || this.getStationInfo().getId() == null || "".equals(this.getStationInfo().getId())) {
			logger.info("get station id faild");
			return ExceptionProcess.exceptionProcess("无法接受站点信息");
		}
		this.stationInfoMapper.deleteByPrimaryKey(this.getStationInfo().getId());
		
		//删除运距
		
		ServletActionContext.getRequest().setAttribute("returnPage", "stationManage/stationQueryByCondition");
		return "success";
	}
	
	/**
	 * 站点新增
	 */
	public String add() {
		this.beanInit();
		StationInfoExample stationInfoExample = new StationInfoExample();
		Criteria criteria = stationInfoExample.createCriteria();
		if(this.getStationInfo() != null && this.getStationInfo().getStationNo() != null && !"".equals(this.getStationInfo().getStationNo())) {
			criteria.andStationNoEqualTo(this.getStationInfo().getStationNo());
		}
		
		List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
		if(stationInfoList != null && stationInfoList.size() != 0) {
			logger.info("exist the same station no station");
			return ExceptionProcess.exceptionProcess("已存在相同站点编号的站点信息","stationManage/stationImportView");
		}
		//新增用户
		StationInfo stationInfoIntoDb = new StationInfo();
		stationInfoIntoDb.setId(BaseUtil.getSeqLong());
		stationInfoIntoDb.setStationNo(this.getStationInfo().getStationNo());
		stationInfoIntoDb.setStationNme(this.getStationInfo().getStationNme());
		stationInfoIntoDb.setStationEnNme(this.getStationInfo().getStationEnNme());
		stationInfoIntoDb.setLineNo(this.getStationInfo().getLineNo());
		stationInfoIntoDb.setLocationX(this.getStationInfo().getLocationX());
		stationInfoIntoDb.setLocationY(this.getStationInfo().getLocationY());
		stationInfoIntoDb.setExchangeFlg(this.getStationInfo().getExchangeFlg());
		stationInfoIntoDb.setExchangeStNo(this.getStationInfo().getExchangeStNo());
		stationInfoIntoDb.setExchangeStLiNo(this.getStationInfo().getExchangeStLiNo());
		stationInfoIntoDb.setStationDes(this.getStationInfo().getStationDes());
		this.stationInfoMapper.insert(stationInfoIntoDb);
		
		//分配角色
		ServletActionContext.getRequest().setAttribute("returnPage", "stationManage/stationQueryByCondition");
		return "success";
	}
	
	/**
	 * 跳转更新页面
	 * @return
	 */
	public String stationUpdView() {
		this.beanInit();
		this.stationInfo = this.stationInfoMapper.selectByPrimaryKey(this.stationInfo.getId());
		return "success";
	}
	
	/**
	 * 跳转更新页面
	 * @return
	 */
	public String upd() {
		this.beanInit();
		int i = this.stationInfoMapper.updateByPrimaryKey(this.stationInfo);
		if(i == 1) {
			ServletActionContext.getRequest().setAttribute("returnPage", "stationManage/stationQueryByCondition");
			return "success";
		}else {
			return ExceptionProcess.exceptionProcess("系统更新失败","stationManage/stationQueryByCondition");
		}
		
	}
}
