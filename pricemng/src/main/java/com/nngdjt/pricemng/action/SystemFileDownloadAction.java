package com.nngdjt.pricemng.action;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SystemFileDownloadAction extends ActionSupport{
	
	private String fileName;
	
	private String subPath;
		
	public String getSubPath() {
		if(this.subPath == null) {
			return "/";
		}
		return subPath;
	}

	public void setSubPath(String subPath) {
		this.subPath = subPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String execute() {
		String aFilePath = null; // 要下载的文件路径
		String aFileName = null; // 要下载的文件名
		FileInputStream in = null; // 输入流
		ServletOutputStream out = null; // 输出流
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ResourceBundle rb = ResourceBundle.getBundle("system_file_store");
		try {

			aFilePath = rb.getString("down_path");
			aFileName = this.getFileName();

			response.setHeader("Content-disposition", "attachment; filename=" + new String(aFileName.getBytes("gb2312"),"iso8859-1"));

			in = new FileInputStream(new File(aFilePath + "/" + this.getSubPath(), aFileName)); // 读入文件
			out = response.getOutputStream();
			out.flush();
			byte[] bytes = new byte[2048];
			int aRead = 0;
			while ((aRead = in.read(bytes)) != -1 & in != null) {
				out.write(bytes,0,aRead);
				out.flush();
			}
			out.flush();
			
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			}catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
