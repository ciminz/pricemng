package com.nngdjt.pricemng.action;

import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.base.Page;
import com.nngdjt.pricemng.entity.LineInfo;
import com.nngdjt.pricemng.entity.LineInfoExample;
import com.nngdjt.pricemng.entity.LineInfoExample.Criteria;
import com.nngdjt.pricemng.mapper.LineInfoMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;
import com.vane.utils.BaseUtil;

public class LineManageAction extends ActionSupport{
	
	private static Logger logger = LoggerFactory.getLogger(LineManageAction.class);
	
	private LineInfo lineInfo;
	
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
	
	public LineInfo getLineInfo() {
		return lineInfo;
	}

	public void setLineInfo(LineInfo lineInfo) {
		this.lineInfo = lineInfo;
	}

	private LineInfoMapper lineInfoMapper;
	
	/**
	 * 初始化组件
	 */
	private void beanInit() {
		lineInfoMapper = (LineInfoMapper)LocalBeanFactory.get(LineInfoMapper.class);
	}
	
	/**
	 * 用户查询
	 * @return
	 */
	public String query() {
		this.beanInit();
		LineInfoExample lineInfoExample = new LineInfoExample();
		lineInfoExample.setOrderByClause("LINE_NO");
		List<LineInfo> lineInfoList = this.lineInfoMapper.selectByExampleWithRowbounds(lineInfoExample,
				new RowBounds(Page.getOffSet(this.getNowpage(), this.getPagesize()), Integer.valueOf(this.getPagesize())));
		int totalPageSize = Page.getTotolSize(Integer.valueOf(this.getPagesize()) ,this.lineInfoMapper.countByExample(null)); 
		ServletActionContext.getRequest().setAttribute("queryResult", lineInfoList);
		ServletActionContext.getRequest().setAttribute("totalPageSize", totalPageSize + "");
		return "success";
	}
	
	/**
	 * 线路删除
	 * @return
	 */
	public String delete() {
		this.beanInit();
		if(this.getLineInfo() == null || this.getLineInfo().getId() == null || "".equals(this.getLineInfo().getId())) {
			logger.info("get line id faild");
			return ExceptionProcess.exceptionProcess("无法接受线路信息");
		}
		this.lineInfoMapper.deleteByPrimaryKey(this.getLineInfo().getId());
		ServletActionContext.getRequest().setAttribute("returnPage", "lineManage/lineQueryByCondition");
		return "success";
	}
	
	/**
	 * 用户新增
	 */
	public String add() {
		this.beanInit();
		LineInfoExample lineInfoExample = new LineInfoExample();
		Criteria criteria = lineInfoExample.createCriteria();
		if(this.getLineInfo() != null && this.getLineInfo().getLineNo() != null && !"".equals(this.getLineInfo().getLineNo())) {
			criteria.andLineNoEqualTo(this.getLineInfo().getLineNo());
		}
		
		List<LineInfo> lineInfoList = this.lineInfoMapper.selectByExample(lineInfoExample);
		if(lineInfoList != null && lineInfoList.size() != 0) {
			logger.info("exist the same lineno line");
			return ExceptionProcess.exceptionProcess("已存在相同线路编号的线路","lineManage/lineImportView");
		}
		//新增线路
		LineInfo lineInfoIntoDb = new LineInfo();
		lineInfoIntoDb.setId(BaseUtil.getSeqLong());
		lineInfoIntoDb.setLineNo(this.getLineInfo().getLineNo());
		lineInfoIntoDb.setLineNme(this.getLineInfo().getLineNme());
		lineInfoIntoDb.setLineEnNme(this.getLineInfo().getLineEnNme());
		lineInfoIntoDb.setLineColor(this.getLineInfo().getLineColor());
		lineInfoIntoDb.setLineDes(this.getLineInfo().getLineDes());
		this.lineInfoMapper.insert(lineInfoIntoDb);
		ServletActionContext.getRequest().setAttribute("returnPage", "lineManage/lineQueryByCondition");
		return "success";
	}
}
