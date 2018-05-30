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

import com.nngdjt.pricemng.base.Excel;
import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.base.Page;
import com.nngdjt.pricemng.entity.DistanceInfo;
import com.nngdjt.pricemng.entity.DistanceInfoExample;
import com.nngdjt.pricemng.entity.StationInfoExample;
import com.nngdjt.pricemng.entity.ViewStationDistanceInfo;
import com.nngdjt.pricemng.entity.ViewStationDistanceInfoExample;
import com.nngdjt.pricemng.entity.ViewStationDistanceInfoExample.Criteria;
import com.nngdjt.pricemng.mapper.DistanceInfoMapper;
import com.nngdjt.pricemng.mapper.StationInfoMapper;
import com.nngdjt.pricemng.mapper.ViewStationDistanceInfoMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;
import com.vane.utils.BaseUtil;

public class DistanceManageAction extends ActionSupport{
	
	private static Logger logger = LoggerFactory.getLogger(DistanceManageAction.class);
	
	private DistanceInfo distanceInfo;
	
	private ViewStationDistanceInfo viewStationDistanceInfo;
	
	private String oriLineNo;
	
	private String desLineNo;
	
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

	public String getDesLineNo() {
		return desLineNo;
	}

	public void setDesLineNo(String desLineNo) {
		this.desLineNo = desLineNo;
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


	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}
	
	public String getNowpage() {
		if(this.nowpage == null) {
			return "1";
		}
		return nowpage;
	}
	
	public DistanceInfo getDistanceInfo() {
		return distanceInfo;
	}

	public void setDistanceInfo(DistanceInfo distanceInfo) {
		this.distanceInfo = distanceInfo;
	}

	public ViewStationDistanceInfo getViewStationDistanceInfo() {
		return viewStationDistanceInfo;
	}

	public void setViewStationDistanceInfo(
			ViewStationDistanceInfo viewStationDistanceInfo) {
		this.viewStationDistanceInfo = viewStationDistanceInfo;
	}
	
	public String getOriLineNo() {
		return oriLineNo;
	}

	public void setOriLineNo(String oriLineNo) {
		this.oriLineNo = oriLineNo;
	}

	
	private DistanceInfoMapper distanceInfoMapper;
	
	private ViewStationDistanceInfoMapper viewStationDistanceInfoMapper;
	
	private StationInfoMapper stationInfoMapper;
	
	/**
	 * 初始化组件
	 */
	private void beanInit() {
		this.viewStationDistanceInfoMapper = (ViewStationDistanceInfoMapper)LocalBeanFactory.get(ViewStationDistanceInfoMapper.class);
		this.distanceInfoMapper = (DistanceInfoMapper)LocalBeanFactory.get(DistanceInfoMapper.class);
		this.stationInfoMapper = (StationInfoMapper)LocalBeanFactory.get(StationInfoMapper.class);
	}
	
	/**
	 * 运距查询
	 * @return
	 */
	public String query() {
		this.beanInit();
		ViewStationDistanceInfoExample viewStationDistanceInfoExample = new ViewStationDistanceInfoExample();
		Criteria criteria = viewStationDistanceInfoExample.createCriteria();
		
		logger.info("" + (this.getViewStationDistanceInfo() == null));
		//logger.info("" + (this.getViewStationDistanceInfo().getoStationNo() == null));
		if(this.getViewStationDistanceInfo() != null && this.getViewStationDistanceInfo().getOriStationNo() != null && !"-1".equals(this.getViewStationDistanceInfo().getOriStationNo())) {
			criteria.andOriStationNoLike("%" + this.getViewStationDistanceInfo().getOriStationNo() + "%");
		}
		
		if(this.getViewStationDistanceInfo() != null && this.getViewStationDistanceInfo().getDesStationNo() != null && !"-1".equals(this.getViewStationDistanceInfo().getDesStationNo())) {
			criteria.andDesStationNoLike("%" + this.getViewStationDistanceInfo().getDesStationNo() + "%");
		}
		List<ViewStationDistanceInfo> vStationDistanceInfoList = this.viewStationDistanceInfoMapper.selectByExampleWithRowbounds(viewStationDistanceInfoExample,
				new RowBounds(Page.getOffSet(this.getNowpage(), this.getPagesize()), Integer.valueOf(this.getPagesize())));
		int totalPageSize = Page.getTotolSize(Integer.valueOf(this.getPagesize()) ,this.viewStationDistanceInfoMapper.countByExample(viewStationDistanceInfoExample)); 
		ServletActionContext.getRequest().setAttribute("queryResult", vStationDistanceInfoList);
		ServletActionContext.getRequest().setAttribute("totalPageSize", totalPageSize + "");
		return "success";
	}
	
	/**
	 * 运距删除
	 * @return
	 */
	public String delete() {
		this.beanInit();
		
		if(this.getDistanceInfo() == null || this.getDistanceInfo().getOriStationNo() == null || "".equals(this.getDistanceInfo().getOriStationNo())) {
			logger.info("get distance OriStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受运距起始站信息");
		}
		
		if(this.getDistanceInfo() == null || this.getDistanceInfo().getDesStationNo() == null || "".equals(this.getDistanceInfo().getDesStationNo())) {
			logger.info("get distance DesStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受运距目的站信息");
		}
		
		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
		distanceInfoExample.createCriteria()
		.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo())
		.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
		
		this.distanceInfoMapper.deleteByExample(distanceInfoExample);
		
		//删除运距
		ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
		return "success";
	}
	
	/**
	 * 运距新增
	 */
	public String add() {
		this.beanInit();
		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
		com.nngdjt.pricemng.entity.DistanceInfoExample.Criteria criteria = distanceInfoExample.createCriteria();
		if(this.getDistanceInfo() != null && this.getDistanceInfo().getOriStationNo() != null && !"".equals(this.getDistanceInfo().getOriStationNo())) {
			criteria.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo());
		}
		
		if(this.getDistanceInfo() != null && this.getDistanceInfo().getDesStationNo() != null && !"".equals(this.getDistanceInfo().getDesStationNo())) {
			criteria.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
		}
		
		List<DistanceInfo> distanceInfoList = this.distanceInfoMapper.selectByExample(distanceInfoExample);
		if(distanceInfoList != null && distanceInfoList.size() != 0) {
			logger.info("exist the same distance info");
			return ExceptionProcess.exceptionProcess("已存在相同起始和终点的间距信息","distanceManage/distanceImportView");
		}
		//新增用户
		DistanceInfo distanceInfoIntoDb = new DistanceInfo();
		distanceInfoIntoDb.setId(BaseUtil.getSeqLong());
		distanceInfoIntoDb.setOriStationNo(this.getDistanceInfo().getOriStationNo());
		distanceInfoIntoDb.setDesStationNo(this.getDistanceInfo().getDesStationNo());
		distanceInfoIntoDb.setDistance(this.getDistanceInfo().getDistance());
		this.distanceInfoMapper.insert(distanceInfoIntoDb);
		
		ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
		return "success";
	}
	
	/**
	 * 跳转更新页面
	 * @return
	 */
	public String distanceUpdView() {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		this.beanInit();
		
		if(this.getDistanceInfo() == null || this.getDistanceInfo().getOriStationNo() == null || "".equals(this.getDistanceInfo().getOriStationNo())) {
			logger.info("get distance OriStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受运距起始站信息");
		}
		
		if(this.getDistanceInfo() == null || this.getDistanceInfo().getDesStationNo() == null || "".equals(this.getDistanceInfo().getDesStationNo())) {
			logger.info("get distance DesStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受运距目的站信息");
		}
		
		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
		distanceInfoExample.createCriteria()
		.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo())
		.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
		this.distanceInfo = this.distanceInfoMapper.selectByExample(distanceInfoExample).get(0);
		
		StationInfoExample StationInfoExample = new StationInfoExample();
		StationInfoExample.createCriteria().andStationNoEqualTo(this.distanceInfo.getOriStationNo());
		this.oriLineNo = this.stationInfoMapper.selectByExample(StationInfoExample).get(0).getLineNo();
		
		StationInfoExample = new StationInfoExample();
		StationInfoExample.createCriteria().andStationNoEqualTo(this.distanceInfo.getDesStationNo());
		this.desLineNo = this.stationInfoMapper.selectByExample(StationInfoExample).get(0).getLineNo();
		
		return "success";
	}
	
	/**
	 * 跳转更新页面
	 * @return
	 */
	public String upd() {
		this.beanInit();
		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
		com.nngdjt.pricemng.entity.DistanceInfoExample.Criteria criteria = distanceInfoExample.createCriteria();
		if(this.getDistanceInfo() != null && this.getDistanceInfo().getOriStationNo() != null && !"".equals(this.getDistanceInfo().getOriStationNo())) {
			criteria.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo());
		}
		
		if(this.getDistanceInfo() != null && this.getDistanceInfo().getDesStationNo() != null && !"".equals(this.getDistanceInfo().getDesStationNo())) {
			criteria.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
		}
		
		List<DistanceInfo> distanceInfoList = this.distanceInfoMapper.selectByExample(distanceInfoExample);
		if(distanceInfoList == null && distanceInfoList.size() == 0) {
			logger.info("the distance info no found");
			return ExceptionProcess.exceptionProcess("无法获取运距信息","distanceManage/distanceQueryByCondition");
		}
		
		DistanceInfo distanceInfoUpd = distanceInfoList.get(0);
		distanceInfoUpd.setDistance(this.getDistanceInfo().getDistance());
		int i = this.distanceInfoMapper.updateByPrimaryKey(distanceInfoUpd);
		if(i == 1) {
			ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
			return "success";
		}else {
			return ExceptionProcess.exceptionProcess("系统更新失败","distanceManage/distanceQueryByCondition");
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
		
		List<Map<String,String>> excelData = Excel.getExcelData(path + "/" + this.getFileFileName(), new String[]{"oriStationNo","desStationNo","distance"});
		
		//数据校验
		List<DistanceInfo> distanceInfoListIntoDb = new ArrayList<DistanceInfo>();
		int rowindex = 0;
		for(Map<String,String> map : excelData) {
			rowindex++;
			String oriStationNo = map.get("oriStationNo");
			String desStationNo = map.get("desStationNo");
			String distance = map.get("distance");
			//校验数据是否为空
			if(oriStationNo == null || "".equals(oriStationNo.trim())) {
				logger.info("oriStation is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" +rowindex + "行,起始站点获取失败","distanceManage/distanceImportView");
			}
			
			if(desStationNo == null || "".equals(desStationNo.trim())) {
				logger.info("desStation is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" +rowindex + "行,目的站点获取失败","distanceManage/distanceImportView");
			}
			
			if(distance == null || "".equals(distance.trim())) {
				logger.info("desStation is null");
				return ExceptionProcess.exceptionProcess("数据文件中第" +rowindex + "行,间距获取失败","distanceManage/distanceImportView");
			}
			
			oriStationNo = oriStationNo.trim();
			desStationNo = desStationNo.trim();
			distance = distance.trim();
			
			//查询是否存在站点信息
			StationInfoExample stationInfoExample = new StationInfoExample();
			stationInfoExample.createCriteria().andStationNoEqualTo(oriStationNo);
			if(this.stationInfoMapper.countByExample(stationInfoExample) == 0) {
				logger.info("station info: " + oriStationNo + " is null");
				return ExceptionProcess.exceptionProcess("编号为:" + oriStationNo + " 站点系统中不存在","distanceManage/distanceImportView");
			}
			
			stationInfoExample = new StationInfoExample();
			stationInfoExample.createCriteria().andStationNoEqualTo(desStationNo);
			if(this.stationInfoMapper.countByExample(stationInfoExample) == 0) {
				logger.info("station info: " + oriStationNo + " is null");
				return ExceptionProcess.exceptionProcess("编号为:" + desStationNo + " 站点系统中不存在","distanceManage/distanceImportView");
			}
			
			DistanceInfo distanceInfo = new DistanceInfo();
			distanceInfo.setId(BaseUtil.getSeqLong());
			distanceInfo.setOriStationNo(oriStationNo);
			distanceInfo.setDesStationNo(desStationNo);
			distanceInfo.setDistance(distance);
			distanceInfoListIntoDb.add(distanceInfo);
		}
		
		for(DistanceInfo distanceInfo : distanceInfoListIntoDb) {
			DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
			distanceInfoExample.createCriteria()
			.andOriStationNoEqualTo(distanceInfo.getOriStationNo())
			.andDesStationNoEqualTo(distanceInfo.getDesStationNo());
			List<DistanceInfo> distanceInfoList = this.distanceInfoMapper.selectByExample(distanceInfoExample);
			if(distanceInfoList != null && distanceInfoList.size() != 0) {
				distanceInfo.setId(distanceInfoList.get(0).getId());
				this.distanceInfoMapper.updateByPrimaryKey(distanceInfo);
			}else {
				this.distanceInfoMapper.insert(distanceInfo);
			}
		}
		
		ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
		return "success";
	}
}
