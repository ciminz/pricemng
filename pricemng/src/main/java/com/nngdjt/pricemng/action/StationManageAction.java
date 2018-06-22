package com.nngdjt.pricemng.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.base.Constants;
import com.nngdjt.pricemng.base.Excel;
import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.base.Page;
import com.nngdjt.pricemng.entity.DistanceInfo;
import com.nngdjt.pricemng.entity.DistanceInfoExample;
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
	
    private File file;
	
	private String fileFileName;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
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
		if(this.getStationInfo() != null && this.getStationInfo().getLineNo() != null && !"-1".equals(this.getStationInfo().getLineNo())) {
			criteria.andLineNoLike("%" + this.getStationInfo().getLineNo() + "%");
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
		logger.info(">>>>>>>>>" + stationInfoList.size());
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
		stationInfoIntoDb.setSortId(this.getStationInfo().getStationNo().substring(1));
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
	
	
	/**
	 * 批量新增更新
	 * @return
	 */
	public String addBatch() {
		logger.info(">>>>>>>add batch");
		this.beanInit();
		logger.info(">>>>>>>file>>>>>>>" + this.getFileFileName());
		ResourceBundle rb = ResourceBundle.getBundle("system_file_store");
		String path = rb.getString("up_path");
		
		//写文件
		File saveFile = new File(path,this.getFileFileName());
		InputStream is;
		try {
			is = new FileInputStream(this.getFile());
			OutputStream os = new FileOutputStream(saveFile);
			byte[] b = new byte[2048000];
			int len = -1;
			while((len = is.read(b)) != -1) {
				System.out.println("uploading....");
				os.write(b,0,len);
				os.flush();
			}
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ExceptionProcess.exceptionProcess("文件上传失败","distanceManage/distanceImportView");
		} catch (IOException e) {
			e.printStackTrace();
			return ExceptionProcess.exceptionProcess("文件上传失败","distanceManage/distanceImportView");
		}
		
		List<Map<String,String>> excelData = Excel.getExcelData(path + "/" + this.getFileFileName(), 
				new String[]{
						"stationNo",
						"stationNme",
						"stationEnNme",
						"lineNo",
						"sortId",
						"locationX",
						"locationY",
						"exchangeFlg",
						"exchangeStNo",
						"exchangeStLiNo",
						"stationDes"
						});
		
		//数据校验
		List<StationInfo> stationInfoListIntoDb = new ArrayList<StationInfo>();
		int rowindex = 0;
		for(Map<String,String> map : excelData) {
			rowindex++;
			String stationNo = map.get("stationNo");
			String stationNme = map.get("stationNme");
			String stationEnNme = map.get("stationEnNme");
			String lineNo = map.get("lineNo");
			String sortId = map.get("sortId");
			String locationX = map.get("locationX");
			String locationY = map.get("locationY");
			String exchangeFlg = map.get("exchangeFlg");
			String exchangeStNo = map.get("exchangeStNo");
			String exchangeStLiNo = map.get("exchangeStLiNo");
			String stationDes = map.get("stationDes");
			//校验数据是否为空
			if(stationNo == null || "".equals(stationNo.trim())) {
				logger.info("stationNo is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点编号获取失败","stationManage/stationImportView");
			}
			
			if(stationNme == null || "".equals(stationNme.trim())) {
				logger.info("stationNme is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点名称获取失败","stationManage/stationImportView");
			}
			
			if(stationEnNme == null || "".equals(stationEnNme.trim())) {
				logger.info("stationEnNme is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点英文名称获取失败","stationManage/stationImportView");
			}
			
			if(lineNo == null || "".equals(lineNo.trim())) {
				logger.info("lineNo is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点所属线路编号获取失败","stationManage/stationImportView");
			}
			
			if(sortId == null || "".equals(sortId.trim())) {
				logger.info("sortId is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点顺序号获取失败","stationManage/stationImportView");
			}
			
			if(locationX == null || "".equals(locationX.trim())) {
				logger.info("locationX is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点坐标X获取失败","stationManage/stationImportView");
			}
			
			if(locationY == null || "".equals(locationY.trim())) {
				logger.info("locationY is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点坐标X获取失败","stationManage/stationImportView");
			}
			
			if(exchangeFlg == null || "".equals(exchangeFlg.trim())) {
				logger.info("exchangeFlg is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点是否是换成站获取失败","stationManage/stationImportView");
			}
			
			if("Y".equals(exchangeFlg) && (exchangeStNo == null || "".equals(exchangeStNo.trim()))) {
				logger.info("exchangeStNo is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点换乘运营站编号获取失败","stationManage/stationImportView");
			}else {
				exchangeStNo = exchangeStNo.trim();
			}
			
			if("Y".equals(exchangeFlg) && (exchangeStLiNo == null || "".equals(exchangeStLiNo.trim()))) {
				logger.info("exchangeStLiNo is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" + rowindex + "行,站点换乘站所属线路编号获取失败","stationManage/stationImportView");
			}else {
				exchangeStLiNo = exchangeStLiNo.trim();
			}
			
			stationNo = stationNo.trim();
			stationNme = stationNme.trim();
			stationEnNme = stationEnNme.trim();
			lineNo = lineNo.trim();
			sortId  = sortId.trim();
			locationX = locationX.trim();
			locationY = locationY.trim();
			exchangeFlg = exchangeFlg.trim();
			
			
			//查询是否存在站点信息
//			StationInfoExample stationInfoExample = new StationInfoExample();
//			stationInfoExample.createCriteria().andStationNoEqualTo(stationNo);
//			if(this.stationInfoMapper.countByExample(stationInfoExample) != 0) {
//				return ExceptionProcess.exceptionProcess("编号为:" + stationNo + " 站点系统中已存在","statioManage/stationImportView");
//			}
			
			StationInfo stationInfo = new StationInfo();
			stationInfo.setId(BaseUtil.getSeqLong());
			stationInfo.setStationNo(stationNo);
			stationInfo.setStationNme(stationNme);
			stationInfo.setStationEnNme(stationEnNme);
			stationInfo.setLineNo(lineNo);
			stationInfo.setSortId(stationInfo.getStationNo().substring(1));
			stationInfo.setLocationX(locationX);
			stationInfo.setLocationY(locationY);
			stationInfo.setExchangeFlg(exchangeFlg);
			stationInfoListIntoDb.add(stationInfo);
		}
		
		for(StationInfo stationInfo : stationInfoListIntoDb) {
			StationInfoExample stationInfoExample = new StationInfoExample();
			stationInfoExample.createCriteria()
			.andStationNoEqualTo(stationInfo.getStationNo());
			List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
			if(stationInfoList != null && stationInfoList.size() != 0) {
				stationInfo.setId(stationInfoList.get(0).getId());
				this.stationInfoMapper.updateByPrimaryKey(stationInfo);
			}else {
				this.stationInfoMapper.insert(stationInfo);
			}
		}
		
		ServletActionContext.getRequest().setAttribute("returnPage", "stationManage/stationQueryByCondition");
		return "success";
	}
}
