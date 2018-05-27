package com.nngdjt.pricemng.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nngdjt.pricemng.base.DataBuilder;
import com.nngdjt.pricemng.base.Page;
import com.nngdjt.pricemng.base.PriceUtil;
import com.nngdjt.pricemng.base.Station;
import com.nngdjt.pricemng.base.Subway;
import com.nngdjt.pricemng.entity.DistanceInfo;
import com.nngdjt.pricemng.entity.DistanceInfoExample;
import com.nngdjt.pricemng.entity.LineInfo;
import com.nngdjt.pricemng.entity.PriceInfo;
import com.nngdjt.pricemng.entity.PriceInfoExample;
import com.nngdjt.pricemng.entity.StationInfo;
import com.nngdjt.pricemng.entity.StationInfoExample;
import com.nngdjt.pricemng.entity.ViewPriceInfo;
import com.nngdjt.pricemng.entity.ViewPriceInfoExample;
import com.nngdjt.pricemng.entity.ViewPriceInfoExample.Criteria;
import com.nngdjt.pricemng.mapper.DistanceInfoMapper;
import com.nngdjt.pricemng.mapper.LineInfoMapper;
import com.nngdjt.pricemng.mapper.PriceInfoMapper;
import com.nngdjt.pricemng.mapper.StationInfoMapper;
import com.nngdjt.pricemng.mapper.ViewPriceInfoMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.vane.base.LocalBeanFactory;

public class PriceManageAction extends ActionSupport{
	
	private static Logger logger = LoggerFactory.getLogger(PriceManageAction.class);
	
	private PriceInfo priceInfo;
	
	private ViewPriceInfo viewPriceInfo;
	
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

	public String getNowpage() {
		if(this.nowpage == null) {
			return "1";
		}
		return nowpage;
	}
	
	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}

	
	public PriceInfo getPriceInfo() {
		return priceInfo;
	}

	public void setPriceInfo(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	public ViewPriceInfo getViewPriceInfo() {
		return viewPriceInfo;
	}

	public void setViewPriceInfo(ViewPriceInfo viewPriceInfo) {
		this.viewPriceInfo = viewPriceInfo;
	}
	
	public String getOriLineNo() {
		return oriLineNo;
	}

	public void setOriLineNo(String oriLineNo) {
		this.oriLineNo = oriLineNo;
	}

	
	private DistanceInfoMapper distanceInfoMapper;
	
	private ViewPriceInfoMapper viewPriceInfoMapper;
	
	private StationInfoMapper stationInfoMapper;
	
	private LineInfoMapper lineInfoMapper;
	
	private PriceInfoMapper priceInfoMapper;
	/**
	 * 初始化组件
	 */
	private void beanInit() {
		this.viewPriceInfoMapper = (ViewPriceInfoMapper)LocalBeanFactory.get(ViewPriceInfoMapper.class);
		this.distanceInfoMapper = (DistanceInfoMapper)LocalBeanFactory.get(DistanceInfoMapper.class);
		this.stationInfoMapper = (StationInfoMapper)LocalBeanFactory.get(StationInfoMapper.class);
		this.lineInfoMapper = (LineInfoMapper)LocalBeanFactory.get(LineInfoMapper.class);
		this.priceInfoMapper = (PriceInfoMapper)LocalBeanFactory.get(PriceInfoMapper.class);
	}
	
	/**
	 * 票价查询
	 * @return
	 */
	public String query() {
		this.beanInit();
		ViewPriceInfoExample viewPriceInfoExample = new ViewPriceInfoExample();
		Criteria criteria= viewPriceInfoExample.createCriteria();
		
		if(this.getViewPriceInfo() != null && this.getViewPriceInfo().getOriStationNo() != null && !"-1".equals(this.getViewPriceInfo().getOriStationNo())) {
			criteria.andOriStationNoLike("%" + this.getViewPriceInfo().getOriStationNo() + "%");
		}
		
		if(this.getViewPriceInfo() != null && this.getViewPriceInfo().getDesStationNo() != null && !"-1".equals(this.getViewPriceInfo().getDesStationNo())) {
			criteria.andDesStationNoLike("%" + this.getViewPriceInfo().getDesStationNo() + "%");
		}
		
		if(this.getViewPriceInfo() != null && this.getViewPriceInfo().getAuditFlg() != null && !"-1".equals(this.getViewPriceInfo().getAuditFlg())) {
			criteria.andAuditFlgEqualTo(this.getViewPriceInfo().getAuditFlg());
		}
		
		List<ViewPriceInfo> vPriceInfoList = this.viewPriceInfoMapper.selectByExampleWithRowbounds(viewPriceInfoExample,
				new RowBounds(Page.getOffSet(this.getNowpage(), this.getPagesize()), Integer.valueOf(this.getPagesize())));
		int totalPageSize = Page.getTotolSize(Integer.valueOf(this.getPagesize()) ,this.viewPriceInfoMapper.countByExample(viewPriceInfoExample)); 
		ServletActionContext.getRequest().setAttribute("queryResult", vPriceInfoList);
		ServletActionContext.getRequest().setAttribute("totalPageSize", totalPageSize + "");
		return "success";
	}
	
	/**
	 * 更新线网票价
	 * @return
	 */
	//@Transactional(propagation=Propagation.NEVER)
	public String priceManageUpdateAllPrice() {
		this.beanInit();
		logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<,,,");
		//检查每条线，相邻站点是否都有间距信息
		boolean flag = true;
		List<LineInfo> lineInfoList = this.lineInfoMapper.selectByExample(null);
		StringBuilder returnMessage = null;
		out:for(LineInfo lineInfo : lineInfoList) {
			StationInfoExample stationInfoExample = new StationInfoExample();
			stationInfoExample.createCriteria().andLineNoEqualTo(lineInfo.getLineNo());
			List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
			
			for(StationInfo stationInfo : stationInfoList) {
				StationInfo nextStation = null;
				if(stationInfoList.indexOf(stationInfo) + 1 < stationInfoList.size()) {
					nextStation = stationInfoList.get(stationInfoList.indexOf(stationInfo) + 1);
				}
				else {
					break;
				}
				
				String oriStationNo = "";
				String desStationNo = "";
				if("Y".equals(stationInfo.getExchangeFlg())) {
					oriStationNo = stationInfo.getExchangeStNo();
				}else {
					oriStationNo = stationInfo.getStationNo();
				}
				
				if("Y".equals(nextStation.getExchangeFlg())) {
					desStationNo = nextStation.getExchangeStNo();
				}else {
					desStationNo = nextStation.getStationNo();
				}
				
				DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
				distanceInfoExample.createCriteria().
				andOriStationNoEqualTo(oriStationNo)
				.andDesStationNoEqualTo(desStationNo);
				
				int distanceCnt = this.distanceInfoMapper.countByExample(distanceInfoExample);
				
				if(distanceCnt == 0) {
					returnMessage = new StringBuilder("<response><messageHead>-1</messageHead><message>" + stationInfo.getStationNme() + "与" + nextStation.getStationNme() +"间无间距信息</message></response>");
					flag = false;
					break out;
				}
			}
		}
		
		if(flag) {
			priceInfoMapper.deleteByExample(null);
			DataBuilder dataBuilder = new DataBuilder();
			PriceUtil priceUtil = new PriceUtil();
			try {
				long t1 = System.currentTimeMillis();
				//DataBuilder dataBuilder = new DataBuilder();
				int b = dataBuilder.totalStaion;
				for (int i = 0; i < b; i++) {
					for (int y = 0; y < b; y++) {
						Subway sw = new Subway(dataBuilder, priceUtil);
						sw.calculate(dataBuilder.lines.get(i), dataBuilder.lines.get(y), priceInfoMapper);
					}
				}
				long t2 = System.currentTimeMillis();
				logger.info("耗时：" + (t2 - t1) + "ms");
				returnMessage = new StringBuilder("<response><messageHead>0</messageHead><message>更新线网票价信息成功</message></response>");
			} catch (Exception e) {
				e.printStackTrace();
				returnMessage = new StringBuilder("<response><messageHead>-1</messageHead><message>更新线网票价信息失败</message></response>");
			} 
			
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
	
	
	public String createPriceMap() {
		this.beanInit();
		PriceInfoExample priceInfoExample = new PriceInfoExample();
		priceInfoExample.createCriteria().andAuditFlgEqualTo("N");
		int cnt = this.priceInfoMapper.countByExample(priceInfoExample);
		StringBuilder returnMessage = null;
		if(cnt > 0) {
			returnMessage = new StringBuilder("<response><messageHead>-1</messageHead><message>存在未审核的票价记录</message></response>");
		}else {
			 //创建工作簿  
	        HSSFWorkbook workBook = new HSSFWorkbook();  
	        //创建工作表  工作表的名字叫helloWorld  
	        HSSFSheet sheet = workBook.createSheet("票价矩阵");  
	        
	        DataBuilder dataBuilder = new DataBuilder();
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
	        	
	        	//创建行,第3行  
	            HSSFRow row = sheet.createRow(i);
	            
	            HSSFCell cellStation = row.createCell(0, CellType.STRING);  
	            cellStation.setCellValue(desStation.getName());  
	            int index = 1;
	            for(PriceInfo priceInfo : priceInfoList) {
	            	//创建单元格，操作第三行第三列  
	                HSSFCell cellPrice = row.createCell(index++, CellType.STRING);  
	                cellPrice.setCellValue(priceInfo.getPrice());  
	            }
	        }
	        
	        //末尾行，设重点站
	        HSSFRow row = sheet.createRow(dataBuilder.lines.size());
	        int index = 1;
	        for(Station station : dataBuilder.lines) {
	        	//创建单元格，操作第三行第三列  
	            HSSFCell cellPrice = row.createCell(index++, CellType.STRING);  
	            cellPrice.setCellValue(station.getName());  
	        }
	         
	        ResourceBundle rb = ResourceBundle.getBundle("system_file_store");
	        String path = rb.getString("down_path");
	        try {
				workBook.write(new File(path, "票价矩阵.xls"));
				 workBook.close();//最后记得关闭工作簿  
			} catch (IOException e) {
				returnMessage = new StringBuilder("<response><messageHead>-1</messageHead><message>系统创建票价矩阵文件出错</message></response>");
			}  
	        returnMessage = new StringBuilder("<response><messageHead>0</messageHead><message>生成票价矩阵文件成功</message><file>票价矩阵.xls</file></response>");
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
	
//	/**
//	 * 运距删除
//	 * @return
//	 */
//	public String delete() {
//		this.beanInit();
//		
//		if(this.getDistanceInfo() == null || this.getDistanceInfo().getOriStationNo() == null || "".equals(this.getDistanceInfo().getOriStationNo())) {
//			logger.info("get distance OriStationNo faild");
//			return ExceptionProcess.exceptionProcess("无法接受运距起始站信息");
//		}
//		
//		if(this.getDistanceInfo() == null || this.getDistanceInfo().getDesStationNo() == null || "".equals(this.getDistanceInfo().getDesStationNo())) {
//			logger.info("get distance DesStationNo faild");
//			return ExceptionProcess.exceptionProcess("无法接受运距目的站信息");
//		}
//		
//		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
//		distanceInfoExample.createCriteria()
//		.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo())
//		.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
//		
//		this.distanceInfoMapper.deleteByExample(distanceInfoExample);
//		
//		//删除运距
//		ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
//		return "success";
//	}
//	
//	/**
//	 * 运距新增
//	 */
//	public String add() {
//		this.beanInit();
//		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
//		com.nngdjt.pricemng.entity.DistanceInfoExample.Criteria criteria = distanceInfoExample.createCriteria();
//		if(this.getDistanceInfo() != null && this.getDistanceInfo().getOriStationNo() != null && !"".equals(this.getDistanceInfo().getOriStationNo())) {
//			criteria.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo());
//		}
//		
//		if(this.getDistanceInfo() != null && this.getDistanceInfo().getDesStationNo() != null && !"".equals(this.getDistanceInfo().getDesStationNo())) {
//			criteria.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
//		}
//		
//		List<DistanceInfo> distanceInfoList = this.distanceInfoMapper.selectByExample(distanceInfoExample);
//		if(distanceInfoList != null && distanceInfoList.size() != 0) {
//			logger.info("exist the same distance info");
//			return ExceptionProcess.exceptionProcess("已存在相同起始和终点的间距信息","distanceManage/distanceImportView");
//		}
//		//新增用户
//		DistanceInfo distanceInfoIntoDb = new DistanceInfo();
//		distanceInfoIntoDb.setId(BaseUtil.getSeqLong());
//		distanceInfoIntoDb.setOriStationNo(this.getDistanceInfo().getOriStationNo());
//		distanceInfoIntoDb.setDesStationNo(this.getDistanceInfo().getDesStationNo());
//		distanceInfoIntoDb.setDistance(this.getDistanceInfo().getDistance());
//		this.distanceInfoMapper.insert(distanceInfoIntoDb);
//		
//		ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
//		return "success";
//	}
//	
//	/**
//	 * 跳转更新页面
//	 * @return
//	 */
//	public String distanceUpdView() {
//		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		this.beanInit();
//		
//		if(this.getDistanceInfo() == null || this.getDistanceInfo().getOriStationNo() == null || "".equals(this.getDistanceInfo().getOriStationNo())) {
//			logger.info("get distance OriStationNo faild");
//			return ExceptionProcess.exceptionProcess("无法接受运距起始站信息");
//		}
//		
//		if(this.getDistanceInfo() == null || this.getDistanceInfo().getDesStationNo() == null || "".equals(this.getDistanceInfo().getDesStationNo())) {
//			logger.info("get distance DesStationNo faild");
//			return ExceptionProcess.exceptionProcess("无法接受运距目的站信息");
//		}
//		
//		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
//		distanceInfoExample.createCriteria()
//		.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo())
//		.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
//		this.distanceInfo = this.distanceInfoMapper.selectByExample(distanceInfoExample).get(0);
//		
//		StationInfoExample StationInfoExample = new StationInfoExample();
//		StationInfoExample.createCriteria().andStationNoEqualTo(this.distanceInfo.getOriStationNo());
//		this.oriLineNo = this.stationInfoMapper.selectByExample(StationInfoExample).get(0).getLineNo();
//		
//		StationInfoExample = new StationInfoExample();
//		StationInfoExample.createCriteria().andStationNoEqualTo(this.distanceInfo.getDesStationNo());
//		this.desLineNo = this.stationInfoMapper.selectByExample(StationInfoExample).get(0).getLineNo();
//		
//		return "success";
//	}
//	
//	/**
//	 * 跳转更新页面
//	 * @return
//	 */
//	public String upd() {
//		this.beanInit();
//		DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
//		com.nngdjt.pricemng.entity.DistanceInfoExample.Criteria criteria = distanceInfoExample.createCriteria();
//		if(this.getDistanceInfo() != null && this.getDistanceInfo().getOriStationNo() != null && !"".equals(this.getDistanceInfo().getOriStationNo())) {
//			criteria.andOriStationNoEqualTo(this.getDistanceInfo().getOriStationNo());
//		}
//		
//		if(this.getDistanceInfo() != null && this.getDistanceInfo().getDesStationNo() != null && !"".equals(this.getDistanceInfo().getDesStationNo())) {
//			criteria.andDesStationNoEqualTo(this.getDistanceInfo().getDesStationNo());
//		}
//		
//		List<DistanceInfo> distanceInfoList = this.distanceInfoMapper.selectByExample(distanceInfoExample);
//		if(distanceInfoList == null && distanceInfoList.size() == 0) {
//			logger.info("the distance info no found");
//			return ExceptionProcess.exceptionProcess("无法获取运距信息","distanceManage/distanceQueryByCondition");
//		}
//		
//		DistanceInfo distanceInfoUpd = distanceInfoList.get(0);
//		distanceInfoUpd.setDistance(this.getDistanceInfo().getDistance());
//		int i = this.distanceInfoMapper.updateByPrimaryKey(distanceInfoUpd);
//		if(i == 1) {
//			ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
//			return "success";
//		}else {
//			return ExceptionProcess.exceptionProcess("系统更新失败","distanceManage/distanceQueryByCondition");
//		}
//	}
//	
//	/**
//	 * 批量新增更新
//	 * @return
//	 */
//	public String addBatch() {
//		logger.info(">>>>>>>add batch");
//		this.beanInit();
//		logger.info(">>>>>>>file>>>>>>>" + this.getFileFileName());
//		ResourceBundle rb = ResourceBundle.getBundle("system_file_store");
//		String path = rb.getString("up_path");
//		
//		//写文件
//		File saveFile = new File(path,this.getFileFileName());
//		InputStream is;
//		try {
//			is = new FileInputStream(this.getFile());
//			OutputStream os = new FileOutputStream(saveFile);
//			byte[] b = new byte[2048000];
//			int len = -1;
//			while((len = is.read(b)) != -1) {
//				System.out.println("uploading....");
//				os.write(b,0,len);
//				os.flush();
//			}
//			os.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return ExceptionProcess.exceptionProcess("文件上传失败","distanceManage/distanceImportView");
//		} catch (IOException e) {
//			e.printStackTrace();
//			return ExceptionProcess.exceptionProcess("文件上传失败","distanceManage/distanceImportView");
//		}
//		
//		List<Map<String,String>> excelData = Excel.getExcelData(path + "/" + this.getFileFileName(), new String[]{"oriStationNo","desStationNo","distance"});
//		
//		//数据校验
//		List<DistanceInfo> distanceInfoListIntoDb = new ArrayList<DistanceInfo>();
//		int rowindex = 0;
//		for(Map<String,String> map : excelData) {
//			rowindex++;
//			String oriStationNo = map.get("oriStationNo");
//			String desStationNo = map.get("desStationNo");
//			String distance = map.get("distance");
//			//校验数据是否为空
//			if(oriStationNo == null || "".equals(oriStationNo.trim())) {
//				logger.info("oriStation is null");
//				return ExceptionProcess.exceptionProcess("数据文件中第" +rowindex + "行,起始站点获取失败","distanceManage/distanceImportView");
//			}
//			
//			if(desStationNo == null || "".equals(desStationNo.trim())) {
//				logger.info("desStation is null");
//				return ExceptionProcess.exceptionProcess("数据文件中第" +rowindex + "行,目的站点获取失败","distanceManage/distanceImportView");
//			}
//			
//			if(distance == null || "".equals(distance.trim())) {
//				logger.info("desStation is null");
//				return ExceptionProcess.exceptionProcess("数据文件中第" +rowindex + "行,间距获取失败","distanceManage/distanceImportView");
//			}
//			
//			oriStationNo = oriStationNo.trim();
//			desStationNo = desStationNo.trim();
//			distance = distance.trim();
//			
//			//查询是否存在站点信息
//			StationInfoExample stationInfoExample = new StationInfoExample();
//			stationInfoExample.createCriteria().andStationNoEqualTo(oriStationNo);
//			if(this.stationInfoMapper.countByExample(stationInfoExample) == 0) {
//				logger.info("station info: " + oriStationNo + " is null");
//				return ExceptionProcess.exceptionProcess("编号为:" + oriStationNo + " 站点系统中不存在","distanceManage/distanceImportView");
//			}
//			
//			stationInfoExample = new StationInfoExample();
//			stationInfoExample.createCriteria().andStationNoEqualTo(desStationNo);
//			if(this.stationInfoMapper.countByExample(stationInfoExample) == 0) {
//				logger.info("station info: " + oriStationNo + " is null");
//				return ExceptionProcess.exceptionProcess("编号为:" + desStationNo + " 站点系统中不存在","distanceManage/distanceImportView");
//			}
//			
//			DistanceInfo distanceInfo = new DistanceInfo();
//			distanceInfo.setId(BaseUtil.getSeqLong());
//			distanceInfo.setOriStationNo(oriStationNo);
//			distanceInfo.setDesStationNo(desStationNo);
//			distanceInfo.setDistance(distance);
//			distanceInfoListIntoDb.add(distanceInfo);
//		}
//		
//		for(DistanceInfo distanceInfo : distanceInfoListIntoDb) {
//			DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
//			distanceInfoExample.createCriteria()
//			.andOriStationNoEqualTo(distanceInfo.getOriStationNo())
//			.andDesStationNoEqualTo(distanceInfo.getDesStationNo());
//			List<DistanceInfo> distanceInfoList = this.distanceInfoMapper.selectByExample(distanceInfoExample);
//			if(distanceInfoList != null && distanceInfoList.size() != 0) {
//				distanceInfo.setId(distanceInfoList.get(0).getId());
//				this.distanceInfoMapper.updateByPrimaryKey(distanceInfo);
//			}else {
//				this.distanceInfoMapper.insert(distanceInfo);
//			}
//		}
//		
//		ServletActionContext.getRequest().setAttribute("returnPage", "distanceManage/distanceQueryByCondition");
//		return "success";
//	}
}
