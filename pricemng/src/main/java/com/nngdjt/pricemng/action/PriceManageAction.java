package com.nngdjt.pricemng.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nngdjt.pricemng.base.DataBuilder;
import com.nngdjt.pricemng.base.ExceptionProcess;
import com.nngdjt.pricemng.base.Page;
import com.nngdjt.pricemng.base.PriceUtil;
import com.nngdjt.pricemng.base.Station;
import com.nngdjt.pricemng.base.Subway;
import com.nngdjt.pricemng.entity.DistanceInfoExample;
import com.nngdjt.pricemng.entity.LineInfo;
import com.nngdjt.pricemng.entity.PriceInfo;
import com.nngdjt.pricemng.entity.PriceInfoExample;
import com.nngdjt.pricemng.entity.StationInfo;
import com.nngdjt.pricemng.entity.StationInfoExample;
import com.nngdjt.pricemng.entity.User;
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
		
		if(this.getOriLineNo() != null && !"-1".equals(this.getOriLineNo())) {
			criteria.andOriLineNoEqualTo(this.getOriLineNo());
		}
		
		if(this.getDesLineNo() != null && !"-1".equals(this.getDesLineNo())) {
			criteria.andDesLineNoEqualTo(this.getDesLineNo());
		}
		
		viewPriceInfoExample.setOrderByClause("ori_station_no,des_station_no");
		List<ViewPriceInfo> vPriceInfoList = this.viewPriceInfoMapper.selectByExampleWithRowbounds(viewPriceInfoExample,
				new RowBounds(Page.getOffSet(this.getNowpage(), this.getPagesize()), Integer.valueOf(this.getPagesize())));
		int totalPageSize = Page.getTotolSize(Integer.valueOf(this.getPagesize()) ,this.viewPriceInfoMapper.countByExample(viewPriceInfoExample)); 
		ServletActionContext.getRequest().setAttribute("queryResult", vPriceInfoList);
		ServletActionContext.getRequest().setAttribute("totalPageSize", totalPageSize + "");
		return "success";
	}
	
	
	/**
	 * 票价查询
	 * @return
	 */
	public String query4User() {
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
		
		if(this.getOriLineNo() != null && !"-1".equals(this.getOriLineNo())) {
			criteria.andOriLineNoEqualTo(this.getOriLineNo());
		}
		
		if(this.getDesLineNo() != null && !"-1".equals(this.getDesLineNo())) {
			criteria.andDesLineNoEqualTo(this.getDesLineNo());
		}
		
		criteria.andAuditFlgEqualTo("Y");
		
		viewPriceInfoExample.setOrderByClause("ori_station_no,des_station_no");
		List<ViewPriceInfo> vPriceInfoList = this.viewPriceInfoMapper.selectByExampleWithRowbounds(viewPriceInfoExample,
				new RowBounds(Page.getOffSet(this.getNowpage(), this.getPagesize()), Integer.valueOf(this.getPagesize())));
		int totalPageSize = Page.getTotolSize(Integer.valueOf(this.getPagesize()) ,this.viewPriceInfoMapper.countByExample(viewPriceInfoExample)); 
		ServletActionContext.getRequest().setAttribute("queryResult", vPriceInfoList);
		ServletActionContext.getRequest().setAttribute("totalPageSize", totalPageSize + "");
		logger.info("query complete.....................");
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
					logger.info(oriStationNo + "至" + desStationNo +"无间距信息");
					distanceInfoExample = new DistanceInfoExample();
					distanceInfoExample.createCriteria().
					andOriStationNoEqualTo(desStationNo)
					.andDesStationNoEqualTo(oriStationNo);
					distanceCnt = this.distanceInfoMapper.countByExample(distanceInfoExample);
				}
				
				if(distanceCnt == 0) {
					logger.info(oriStationNo + "至" + desStationNo +"无间距信息");
					returnMessage = new StringBuilder("<response><messageHead>-1</messageHead><message>" + stationInfo.getStationNme() + "与" + nextStation.getStationNme() +"间无间距信息</message></response>");
					flag = false;
					break out;
				}
			}
		}
		
		if(flag) {
			//priceInfoMapper.deleteByExample(null);
			DataBuilder dataBuilder = new DataBuilder();
			PriceUtil priceUtil = new PriceUtil();
			Map<String,Object> oriPriceInfoMap = new HashMap<String, Object>();
			List<PriceInfo> priceInfoList = priceInfoMapper.selectByExample(null);
			for(PriceInfo priceInfo : priceInfoList) {
				oriPriceInfoMap.put(priceInfo.getOriStationNo()+priceInfo.getDesStationNo(), priceInfo.getPrice());
			}
			ServletActionContext.getRequest().setAttribute("oriPriceInfoMap", oriPriceInfoMap);
			
			Map<String,Object> newPriceInfoMap = new HashMap<String, Object>();
			ServletActionContext.getRequest().setAttribute("newPriceInfoMap", newPriceInfoMap);
			
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
				
				newPriceInfoMap = (Map<String,Object>)ServletActionContext.getRequest().getAttribute("newPriceInfoMap");
				Collection<Object> newPriceInfoList = (Collection<Object>)newPriceInfoMap.values();
				for(Object o : newPriceInfoList) {
					PriceInfo priceInfo = (PriceInfo)o;
					if(oriPriceInfoMap.get(priceInfo.getOriStationNo()+priceInfo.getDesStationNo()) == null) {
						priceInfoMapper.insert(priceInfo);
					}else {
						String oriPrice = (String)oriPriceInfoMap.get(priceInfo.getOriStationNo()+priceInfo.getDesStationNo());
						String newPrice = priceInfo.getPrice();
						if(!oriPrice.equals(newPrice)) {
							PriceInfoExample priceInfoExample = new PriceInfoExample();
							priceInfoExample.createCriteria()
							.andOriStationNoEqualTo(priceInfo.getOriStationNo())
							.andDesStationNoEqualTo(priceInfo.getDesStationNo());
							priceInfoList = priceInfoMapper.selectByExample(priceInfoExample);
							PriceInfo priceInfoTmp = priceInfoList.get(0);
							priceInfoMapper.deleteByPrimaryKey(priceInfoTmp.getId());
							priceInfoMapper.insert(priceInfo);
						}
					}
				}
				long t2 = System.currentTimeMillis();
				logger.info("耗时：" + (t2 - t1) + "ms");
				returnMessage = new StringBuilder("<response><messageHead>0</messageHead><message>更新线网票价信息成功</message></response>");
			} catch (Exception e) {
				e.printStackTrace();
				returnMessage = new StringBuilder("<response><messageHead>-1</messageHead><message>更新线网票价信息失败 " + e.getCause().getMessage()+"</message></response>");
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
		
		this.initPriceTable();
		
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
	        
	        
	        HSSFCellStyle style2 = workBook.createCellStyle();  
	        style2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
	        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
	        HSSFCellStyle style3 = workBook.createCellStyle();  
	        style3.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
	        style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
	        HSSFCellStyle style4 = workBook.createCellStyle();  
	        style4.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.index);
	        style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
	        HSSFCellStyle style5 = workBook.createCellStyle();  
	        style5.setFillForegroundColor(IndexedColors.LIGHT_BLUE.index);
	        style5.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
	        HSSFCellStyle style6 = workBook.createCellStyle();  
	        style6.setFillForegroundColor(IndexedColors.PINK.index);
	        style6.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
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
	                if("2".equals(priceInfo.getPrice())) {
	                	System.out.println(priceInfo.getPrice());
	                	cellPrice.setCellStyle(style2);
	                }else if("3".equals(priceInfo.getPrice())) {
	                	cellPrice.setCellStyle(style3);
	                }else if("4".equals(priceInfo.getPrice())) {
	                	cellPrice.setCellStyle(style4);
	                }else if("5".equals(priceInfo.getPrice())) {
	                	cellPrice.setCellStyle(style5);
	                }else if("6".equals(priceInfo.getPrice())) {
	                	cellPrice.setCellStyle(style6);
	                }
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
	

	public String createPriceTable() {
		this.beanInit();
		initPriceTable();
		ServletActionContext.getRequest().setAttribute("iframelarge", "1");
		List<List<String>> priceList = null;
		if(this.getOriLineNo() == null && this.getDesLineNo() == null) {
			priceList = (List<List<String>>)ServletActionContext.getRequest().getSession().getAttribute("priceList");
			ServletActionContext.getRequest().setAttribute("priceList", priceList);
		}else if("-1" .equals(this.getOriLineNo()) || "-1".equals(this.getDesLineNo())) {
			priceList = (List<List<String>>)ServletActionContext.getRequest().getSession().getAttribute("priceList");
			ServletActionContext.getRequest().setAttribute("priceList", priceList);
		}else {
		    priceList = new ArrayList<List<String>>();
			DataBuilder dataBuilder = (DataBuilder)ServletActionContext.getRequest().getSession().getAttribute("dataBuilder");
			Set<String> stationNoSet = new HashSet<String>();
			
			List<Station> stationLst = new ArrayList<Station>();
			Set<String> stationNoAdded = new HashSet<String>();
			
			StationInfoExample stationInfoExample = new StationInfoExample();
			stationInfoExample.createCriteria().andLineNoEqualTo(this.getOriLineNo());
			List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
			for(StationInfo sti : stationInfoList) {
				if("Y".equals(sti.getExchangeFlg())) {
					stationNoSet.add(sti.getExchangeStNo());
					continue;
				}
				stationNoSet.add(sti.getStationNo());
			}
			logger.info("=====================" + (dataBuilder == null));
			logger.info("=====================" + (dataBuilder.lines == null));
			for(Station st: dataBuilder.lines) {
				
				if(stationNoSet.contains(st.getStationNo())) {
					if(stationNoAdded.contains(st.getStationNo()) || !st.getLineNo().equals(this.getOriLineNo())) {
						continue;
					}
					stationLst.add(st);
					stationNoAdded.add(st.getStationNo());
				}
			}
			
			stationInfoExample = new StationInfoExample();
			stationInfoExample.createCriteria().andLineNoEqualTo(this.getDesLineNo());
			stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
			for(StationInfo sti : stationInfoList) {
				if("Y".equals(sti.getExchangeFlg())) {
					stationNoSet.add(sti.getExchangeStNo());
					continue;
				}
				stationNoSet.add(sti.getStationNo());
			}
			for(StationInfo sti : stationInfoList) {
				if("Y".equals(sti.getExchangeFlg())) {
					stationNoSet.add(sti.getExchangeStNo());
					continue;
				}
				stationNoSet.add(sti.getStationNo());
			}
			for(Station st: dataBuilder.lines) {
				if(stationNoSet.contains(st.getStationNo())) {
					if(stationNoAdded.contains(st.getStationNo()) || !st.getLineNo().equals(this.getDesLineNo())) {
						continue;
					}
					stationLst.add(st);
					stationNoAdded.add(st.getStationNo());
				}
			}
			
			
			for(int i = 0; i < stationLst.size(); i++) {
				Station desStation = stationLst.get(i);
				List<PriceInfo> priceInfoList = new ArrayList<PriceInfo>();
				for(int j = 0; j <= i; j++) {
					Station oriStation =  stationLst.get(j);
					PriceInfoExample priceInfoExcample = new PriceInfoExample();
					priceInfoExcample.createCriteria()
					.andOriStationNoEqualTo(oriStation.getStationNo())
					.andDesStationNoEqualTo(desStation.getStationNo())
					.andAuditFlgEqualTo("Y");
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
				
				int size = stationLst.size();
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
			for(Station station : stationLst) {
			   priceRow.add(station.getName());  
			}
			priceList.add(priceRow);
			ServletActionContext.getRequest().setAttribute("priceList", priceList);
		}

		return "success";
	}
	
	/**
	 * 审核
	 * @return
	 */
	public String priceAudit() {
		this.beanInit();
		
		String oStNo = null;
		String dStNo = null;
		
		if(this.getViewPriceInfo() == null || this.getViewPriceInfo().getOriStationNo() == null || "".equals(this.getViewPriceInfo().getOriStationNo())) {
			logger.info("get distance OriStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受起始站信息");
		}else {
			StationInfoExample stationExample = new StationInfoExample();
			stationExample.createCriteria().andStationNoEqualTo(this.getViewPriceInfo().getOriStationNo());
			List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationExample);
			if(stationInfoList != null && stationInfoList.size() > 0) {
				oStNo = stationInfoList.get(0).getExchangeStNo();
			}
		}
		
		if(this.getViewPriceInfo() == null || this.getViewPriceInfo().getDesStationNo() == null || "".equals(this.getViewPriceInfo().getDesStationNo())) {
			logger.info("get distance DesStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受目的站信息");
		}else {
			StationInfoExample stationExample = new StationInfoExample();
			stationExample.createCriteria().andStationNoEqualTo(this.getViewPriceInfo().getDesStationNo());
			List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationExample);
			if(stationInfoList != null && stationInfoList.size() > 0) {
				dStNo = stationInfoList.get(0).getExchangeStNo();
			}
		}
		
		
		
		PriceInfoExample priceInfoExample = new PriceInfoExample();
		priceInfoExample.createCriteria()
		.andOriStationNoEqualTo(oStNo)
		.andDesStationNoEqualTo(dStNo);
		
		List<PriceInfo> priceInfoList = this.priceInfoMapper.selectByExample(priceInfoExample);
		if(priceInfoList == null || priceInfoList.size() == 0) {
			logger.info("the price info not found");
			return ExceptionProcess.exceptionProcess("无法获取票价信息","priceManage/priceQueryByCondition");
		}
		
		SimpleDateFormat dteSdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat tmeSdf = new SimpleDateFormat("HH:mm:ss");
		PriceInfo priceInfo = priceInfoList.get(0);
		priceInfo.setAuditFlg("Y");
		priceInfo.setAuditDate(dteSdf.format(new Date()));
		priceInfo.setAuditTme(tmeSdf.format(new Date()));
		User u = (User)ServletActionContext.getRequest().getSession().getAttribute("nowuser");
		priceInfo.setAuditUserId(u.getId() + "");
		this.priceInfoMapper.updateByPrimaryKey(priceInfo);
		
		StationInfoExample stationInfoExample = new StationInfoExample();
		stationInfoExample.createCriteria().andStationNoEqualTo(this.getViewPriceInfo().getOriStationNo());
		List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
		this.setOriLineNo(stationInfoList.get(0).getLineNo());
		
		stationInfoExample = new StationInfoExample();
		stationInfoExample.createCriteria().andStationNoEqualTo(this.getViewPriceInfo().getDesStationNo());
		stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
		this.setDesLineNo(stationInfoList.get(0).getLineNo());
		
		ServletActionContext.getRequest().setAttribute("desLineNo", this.getDesLineNo());
		ServletActionContext.getRequest().setAttribute("oriLineNo", this.getOriLineNo());
		
		
		return "success";
	}
	
	/**
	 * 跳转审核页面
	 * @return
	 */
	public String auditView() {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		this.beanInit();
		
		if(this.getPriceInfo() == null || this.getPriceInfo().getOriStationNo() == null || "".equals(this.getPriceInfo().getOriStationNo())) {
			logger.info("get priceinfo OriStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受间距起始站信息");
		}
		
		if(this.getPriceInfo() == null || this.getPriceInfo().getDesStationNo() == null || "".equals(this.getPriceInfo().getDesStationNo())) {
			logger.info("get priceinfo DesStationNo faild");
			return ExceptionProcess.exceptionProcess("无法接受间距目的站信息");
		}
		
		ViewPriceInfoExample vPriceInfoExample = new ViewPriceInfoExample();
		vPriceInfoExample.createCriteria()
		.andOriStationNoEqualTo(this.getPriceInfo().getOriStationNo())
		.andDesStationNoEqualTo(this.getPriceInfo().getDesStationNo());
		this.viewPriceInfo = this.viewPriceInfoMapper.selectByExample(vPriceInfoExample).get(0);
		
		return "success";
	}
	
	/**
	 * 更新
	 * @return
	 */
	public String upd() {
		this.beanInit();
		if(this.getPriceInfo() == null || this.getPriceInfo().getOriStationNo() == null || "".equals(this.getPriceInfo().getOriStationNo())) {
			logger.info("the price info OriStationNo not found");
			return ExceptionProcess.exceptionProcess("无法获取起点站信息","priceManage/priceQueryByCondition");
		}
		
		if(this.getPriceInfo() == null || this.getPriceInfo().getDesStationNo() == null || "".equals(this.getPriceInfo().getDesStationNo())) {
			logger.info("the price info DesStationNo not found");
			return ExceptionProcess.exceptionProcess("无法获取目的站信息","priceManage/priceQueryByCondition");
		}
		DataBuilder dataBuilder = new DataBuilder();
		PriceUtil priceUtil = new PriceUtil();
		
		Subway sw = new Subway(dataBuilder, priceUtil);
		
		int i = -1;
		int y = -1;
		
		for(Station station : dataBuilder.lines) {
			if(this.getPriceInfo().getOriStationNo().equals(station.getStationNo())) {
				i = dataBuilder.lines.indexOf(station);
			}
			
			if(this.getPriceInfo().getDesStationNo().equals(station.getStationNo())) {
				y = dataBuilder.lines.indexOf(station);
			}
		}
		
		try {
			PriceInfoExample priceInfoExample = new PriceInfoExample();
			priceInfoExample.createCriteria()
			.andOriStationNoEqualTo(this.getPriceInfo().getOriStationNo())
			.andDesStationNoEqualTo(this.getPriceInfo().getDesStationNo());
			this.priceInfoMapper.deleteByExample(priceInfoExample);
			sw.calculate(dataBuilder.lines.get(i), dataBuilder.lines.get(y), priceInfoMapper);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("the price info update failed");
			return ExceptionProcess.exceptionProcess("票价更新失败","priceManage/priceQueryByCondition");
		}
		
		this.initPriceTable();
		
		ServletActionContext.getRequest().setAttribute("returnPage", "priceManage/priceQueryByCondition");
		return "success";
	}
	
	
	public String mapQryPrice() {
		this.beanInit();
		this.getViewPriceInfo().setOriStationNo(this.getViewPriceInfo().getOriStationNo().substring(1));
		this.getViewPriceInfo().setDesStationNo(this.getViewPriceInfo().getDesStationNo().substring(1));
		StationInfoExample stationInfoExample = new StationInfoExample();
		stationInfoExample.createCriteria().andStationNoEqualTo(this.getViewPriceInfo().getOriStationNo());
		List<StationInfo> stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
		this.setOriLineNo(stationInfoList.get(0).getLineNo());
		
		stationInfoExample = new StationInfoExample();
		stationInfoExample.createCriteria().andStationNoEqualTo(this.getViewPriceInfo().getDesStationNo());
		stationInfoList = this.stationInfoMapper.selectByExample(stationInfoExample);
		this.setDesLineNo(stationInfoList.get(0).getLineNo());
		
		ServletActionContext.getRequest().setAttribute("desLineNo", this.getDesLineNo());
		ServletActionContext.getRequest().setAttribute("oriLineNo", this.getOriLineNo());
		return this.query4User();
	}
	
	
	public void initPriceTable() {
		this.beanInit();
	    List<List<String>> priceList = new ArrayList<List<String>>();
		DataBuilder dataBuilder = new DataBuilder();
		for(int i = 0; i < dataBuilder.lines.size(); i++) {
			Station desStation = dataBuilder.lines.get(i);
			List<PriceInfo> priceInfoList = new ArrayList<PriceInfo>();
			for(int j = 0; j <= i; j++) {
				Station oriStation =  dataBuilder.lines.get(j);
				PriceInfoExample priceInfoExcample = new PriceInfoExample();
				priceInfoExcample.createCriteria()
				.andOriStationNoEqualTo(oriStation.getStationNo())
				.andDesStationNoEqualTo(desStation.getStationNo())
				.andAuditFlgEqualTo("Y");
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
}
