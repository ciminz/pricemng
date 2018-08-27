package com.nngdjt.pricemng.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.entity.LineInfo;
import com.nngdjt.pricemng.entity.LineInfoExample;
import com.nngdjt.pricemng.entity.StationInfo;
import com.nngdjt.pricemng.mapper.LineInfoMapper;
import com.nngdjt.pricemng.mapper.StationInfoMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;

public class AjaxAction extends ActionSupport{
	private static final Logger logger = LoggerFactory.getLogger(AjaxAction.class);
	
	private LineInfo lineInfo;
	
	private LineInfoMapper lineInfoMapper;
	
	private StationInfo stationInfo;
	
	private StationInfoMapper stationInfoMapper;
	
	private String validateCode;
	
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public StationInfo getStationInfo() {
		return stationInfo;
	}

	public void setStationInfo(StationInfo stationInfo) {
		this.stationInfo = stationInfo;
	}

	public LineInfo getLineInfo() {
		return lineInfo;
	}

	public void setLineInfo(LineInfo lineInfo) {
		this.lineInfo = lineInfo;
	}
	
	private void beanInit() {
		this.lineInfoMapper = (LineInfoMapper)LocalBeanFactory.get(LineInfoMapper.class);
		this.stationInfoMapper = (StationInfoMapper)LocalBeanFactory.get(StationInfoMapper.class);
	}

	public String findLine() {
		logger.info(">>>>>>>>>>>>>>>>get find line ajax request");
		this.beanInit();
		StringBuilder returnMessage = null;
		try {
			LineInfoExample lineInfoExample = new LineInfoExample();
			lineInfoExample.setOrderByClause("line_no asc");
			List<LineInfo> lineInfoList = this.lineInfoMapper.selectByExample(lineInfoExample);
			returnMessage = new StringBuilder("<response><messageHead>0</messageHead>");
			returnMessage.append("<count>").append(lineInfoList.size()).append("</count>");
			for(LineInfo l: lineInfoList) {
				returnMessage.append("<lineInfo>")
				.append("<lineNo>").append(l.getLineNo()).append("</lineNo>")
				.append("<lineNme>").append(l.getLineNme()).append("</lineNme>")
				.append("</lineInfo>");
			}
			returnMessage.append("</response>");
		
		} catch (Exception e) {
			returnMessage = new StringBuilder("<response><messageHead>-1</messageHead></response>");
		}
		
		logger.info(">>>>>>>>>>>>>>>>" + returnMessage.toString());
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(returnMessage.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String findStation() {
		logger.info(">>>>>>>>>>>>>>>>get find station ajax request");
		this.beanInit();
		StringBuilder returnMessage = null;
		try {
			List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(null);
			returnMessage = new StringBuilder("<response><messageHead>0</messageHead>");
			returnMessage.append("<count>").append(stationInfoList.size()).append("</count>");
			for(StationInfo s: stationInfoList) {
				returnMessage.append("<stationInfo>")
				.append("<stationNo>").append(s.getStationNo()).append("</stationNo>")
				.append("<stationNme>").append(s.getStationNme()).append("</stationNme>")
				.append("<lineNo>").append(s.getLineNo()).append("</lineNo>")
				.append("</stationInfo>");
			}
			returnMessage.append("</response>");
		
		} catch (Exception e) {
			returnMessage = new StringBuilder("<response><messageHead>-1</messageHead></response>");
		}
		
		logger.info(">>>>>>>>>>>>>>>>" + returnMessage.toString());
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(returnMessage.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String setValidateCode() {
		logger.info(">>>>>>>>>>>>>>" + this.getValidateCode());
		ServletActionContext.getRequest().getSession().setAttribute("validateCode", this.getValidateCode());
		StringBuilder returnMessage = null;
		returnMessage = new StringBuilder("<response><messageHead>0</messageHead></response>");
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(returnMessage.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
