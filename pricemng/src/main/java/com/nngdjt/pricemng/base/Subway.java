package com.nngdjt.pricemng.base;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.nngdjt.pricemng.entity.PriceInfo;
import com.nngdjt.pricemng.mapper.PriceInfoMapper;
import com.vane.utils.BaseUtil;

/**
 * desc：利用Dijkstra算法，计算地铁站经过路径，以南京地铁为例
 * 
 * @author chaisson
 * @since 2015-5-31 上午9:43:38
 * 
 */
public class Subway {
	/* 记录所有经过的站点 */
	private List<Station> outList = new ArrayList<Station>();// 记录已经分析过的站点
	
//	private DataBuilder dataBuilder = new DataBuilder();
//	
//	private PriceUtil priceUtil = new PriceUtil();
	
	private DataBuilder dataBuilder;
	
	private PriceUtil priceUtil;
	
	public Subway() {}
	
	public Subway(DataBuilder dataBuilder, PriceUtil priceUtil) {
		this.dataBuilder = dataBuilder;
		this.priceUtil = priceUtil;
	}

	// 计算从s1站到s2站的最短经过路径 s1初始站点 s2目的站点
	public void calculate(Station s1, Station s2, FileWriter fw) throws Exception {

		/* 表示全部找完了 可以打印了 */
		if (outList.size() == dataBuilder.totalStaion) {
			PrintInfo(s1, s2, fw);
			return;
		}

		/* 先把第一站弄进去 */
		if (!outList.contains(s1)) {
			outList.add(s1);
		}

		// 如果起点站的OrderSetMap为空，则第一次用起点站的前后站点初始化之
		if (s1.getOrderSetMap().isEmpty()) {
			List<Station> Linkedstations = getAllLinkedStations(s1);
			for (Station s : Linkedstations) {
				s1.getAllPassedStations(s).add(s);
			}
		}

		Station parent = getShortestPath(s1);// 获取距离起点站s1最近的一个站（有多个的话，随意取一个）
		
		if (parent == s2) {
			PrintInfo(s1, s2, fw);
			return;
		}
		for (Station child : getAllLinkedStations(parent)) {
			if (outList.contains(child)) {
				continue;
			}
			
			int shortestPath = (s1.getAllPassedStations(parent).size() - 1) + priceUtil.getDistance(parent.getStationNo(), child.getStationNo());// 前面这个1表示计算路径需要去除自身站点，后面这个1表示增加了1站距离  1变成查表的数据
			
			if (s1.getAllPassedStations(child).contains(child)) {
				// 如果s1已经计算过到此child的经过距离，那么比较出最小的距离
				if ((s1.getAllPassedStations(child).size() - 1) > shortestPath) {
					// 重置S1到周围各站的最小路径
					s1.getAllPassedStations(child).clear();
					s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
					s1.getAllPassedStations(child).add(child);
				}
			} else {
				// 如果s1还没有计算过到此child的经过距离
				s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
				s1.getAllPassedStations(child).add(child);
			   
			}
			
		}
		outList.add(parent);
		
		calculate(s1, s2, fw);// 重复计算，往外面站点扩展
	}

	private void PrintInfo(Station s1, Station s2, FileWriter fw) throws Exception {

		StringBuilder sb = new StringBuilder(200);
		fw.append("起始站 :" + s1.getName() + "  目标站点：" + s2.getName() + "，共经过" + (s1.getAllPassedStations(s2).size())
				+ "站");
		fw.append("\r\n");
		for (Station station : s1.getAllPassedStations(s2)) {
			sb.append(station.getName() + "->");

		}

		sb.delete(sb.length() - 2, sb.length());

		fw.append(sb.toString());
		fw.append("\r\n");
		
		// 计算最短路径

		int totaldis=0;
		Station sstart = s1;
		for (Station station : s1.getAllPassedStations(s2)) {
			if(station==sstart)
				continue;
			totaldis+= priceUtil.getDistance(sstart.getStationNo(), station.getStationNo());
			sstart = station;

		}
		
		fw.append("总公里数:"+totaldis+" 票价:"+PriceUtil.getPrivce(totaldis)+"\r\n");
		
	}

	// 取参数station到各个站的最短距离，相隔1站，距离为1，依次类推
	private Station getShortestPath(Station station) {
		int minPatn = Integer.MAX_VALUE;
		Station rets = null;
		// 相邻的站点 肯定是距离最短的站点 如果经过的站点已经包括的相邻站点，则继续
		for (Station s : station.getOrderSetMap().keySet()) {
			if (outList.contains(s)) {
				continue;
			}
			LinkedHashSet<Station> set = station.getAllPassedStations(s);// 参数station到s所经过的所有站点的集合
			if (set.size() < minPatn) {
				minPatn = set.size();
				rets = s;
			}
		}
		return rets;
	}

	// 获取参数station直接相连的所有站，包括交叉线上面的站 只存储相邻的站
	private List<Station> getAllLinkedStations(Station station) {
		List<Station> linkedStaions = new ArrayList<Station>();
		for (List<Station> line : dataBuilder.lineSet) {
			if (line.contains(station)) {// 如果某一条线包含了此站，注意由于重写了hashcode方法，只有name相同，即认为是同一个对象
				Station s = line.get(line.indexOf(station));

				if (s.prev != null) {
					linkedStaions.add(s.prev);
				}
				if (s.next != null) {
					linkedStaions.add(s.next);
				}
			}
		}

		return linkedStaions;
	}
	
	
	// 计算从s1站到s2站的最短经过路径 s1初始站点 s2目的站点
	public void calculate(Station s1, Station s2, PriceInfoMapper priceInfoMapper) throws Exception {

		/* 表示全部找完了 可以打印了 */
		if (outList.size() == dataBuilder.totalStaion) {
			PrintInfo(s1, s2, priceInfoMapper);
			return;
		}

		/* 先把第一站弄进去 */
		if (!outList.contains(s1)) {
			outList.add(s1);
		}

		// 如果起点站的OrderSetMap为空，则第一次用起点站的前后站点初始化之
		if (s1.getOrderSetMap().isEmpty()) {
			List<Station> Linkedstations = getAllLinkedStations(s1);
			for (Station s : Linkedstations) {
				s1.getAllPassedStations(s).add(s);
			}
		}

		Station parent = getShortestPath(s1);// 获取距离起点站s1最近的一个站（有多个的话，随意取一个）
		
		if (parent == s2) {
			PrintInfo(s1, s2, priceInfoMapper);
			return;
		}
		for (Station child : getAllLinkedStations(parent)) {
			if (outList.contains(child)) {
				continue;
			}
			
			//int shortestPath = (s1.getAllPassedStations(parent).size() - 1) + priceUtil.getDistance(parent.getStationNo(), child.getStationNo());// 前面这个1表示计算路径需要去除自身站点，后面这个1表示增加了1站距离  1变成查表的数据
			int shortestPath = this.getDistanceBetweenStation(s1, s1.getAllPassedStations(parent)) + priceUtil.getDistance(parent.getStationNo(), child.getStationNo());
			if (s1.getAllPassedStations(child).contains(child)) {
				// 如果s1已经计算过到此child的经过距离，那么比较出最小的距离
				//if ((s1.getAllPassedStations(child).size() - 1) > shortestPath) {
				if (this.getDistanceBetweenStation(s1, s1.getAllPassedStations(child)) > shortestPath) {	
//					throw new RuntimeException("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					// 重置S1到周围各站的最小路径
					s1.getAllPassedStations(child).clear();
					s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
					s1.getAllPassedStations(child).add(child);
				}
			} else {
				// 如果s1还没有计算过到此child的经过距离
				s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
				s1.getAllPassedStations(child).add(child);
			   
			}
			
		}
		outList.add(parent);
		
		calculate(s1, s2, priceInfoMapper);// 重复计算，往外面站点扩展
	}
	
	
	private void PrintInfo(Station s1, Station s2, PriceInfoMapper priceInfoMapper) throws Exception {
		System.out.println("===s1:===" + s1.getStationNo() + "======s2=====" + s2.getStationNo());
        LinkedHashSet<Station> stationPathSet = null;
        boolean recalcutelateFlg = false;
        int distance1 = 0;
        int distance2 = 0;
		if(s2.getOrderSetMap() != null 
		   && s2.getOrderSetMap().get(s1) != null 
		   && s2.getAllPassedStations(s1) != null 
		   && s1.getAllPassedStations(s2).size() == s2.getAllPassedStations(s1).size()) {
			System.out.println("======================compare===========================");
			Station sstart = s1;
			for (Station station : s1.getAllPassedStations(s2)) {
				if(station==sstart)
					continue;
				distance1+= priceUtil.getDistance(sstart.getStationNo(), station.getStationNo());
			}
			
			sstart = s2;
			for (Station station : s2.getAllPassedStations(s1)) {
				if(station==sstart)
					continue;
				distance2+= priceUtil.getDistance(sstart.getStationNo(), station.getStationNo());
			}
			
			if(distance1 <= distance2) {
				System.out.println("===========distance1 <= distance2===========");
				stationPathSet = s1.getAllPassedStations(s2);
				recalcutelateFlg = true;
			}else {
				System.out.println("==========distance1 > distance2===========");
				stationPathSet = s2.getAllPassedStations(s1);
				LinkedHashSet<Station> stationPathSet2 = new LinkedHashSet<Station>();
				Iterator<Station> it = stationPathSet.iterator();
				List<Station> stationList = new ArrayList<Station>();
				while(it.hasNext()) {
					stationList.add(it.next());
				}
				for(int i = stationPathSet.size() -1; i >=0; i--) {
					stationPathSet2.add(stationList.get(i));
				}
				stationPathSet = stationPathSet2;
			}
			
		}else {
			System.out.println("======================not compare===========================");
			stationPathSet = s1.getAllPassedStations(s2);
		}
		
		System.out.println("======stationPathSet.size====" + stationPathSet.size());
		
		Map<String,Object> newPriceInfoMap = (Map<String,Object>)ServletActionContext.getRequest().getAttribute("newPriceInfoMap");
		
		
		StringBuilder sb = new StringBuilder(200);
		StringBuilder sb2 = new StringBuilder("");
		StringBuilder fw = new StringBuilder();
		fw.append("起始站 :" + s1.getName() + "  目标站点：" + s2.getName() + "，共经过" + (stationPathSet.size()) + "站");
		fw.append("\r\n");
		for (Station station : stationPathSet) {
			sb.append(station.getName() + "->");
			sb2.append(station.getName() + "->");
		}

		sb.delete(sb.length() - 2, sb.length());
		sb2.delete(sb2.length() - 2, sb2.length());
		fw.append(sb.toString());
		fw.append("\r\n");
		
		// 计算最短路径

		int totaldis=0;
		Station sstart = s1;
		for (Station station : stationPathSet) {
			if(station==sstart)
				continue;
			totaldis+= priceUtil.getDistance(sstart.getStationNo(), station.getStationNo());
			sstart = station;

		}
		
		String totaldisStr = "";
		BigDecimal totaldisDec = new BigDecimal(totaldis);
		BigDecimal resultDec = totaldisDec.divide(new BigDecimal(1000));
		resultDec = resultDec.setScale(3,BigDecimal.ROUND_HALF_DOWN);
		totaldisStr = resultDec.toString();
		fw.append("，乘距:"+totaldisStr+"米，票价:"+PriceUtil.getPrivce(totaldis)+"元\r\n");
		
//		PriceInfoExample priceInfoExample = new PriceInfoExample();
//		priceInfoExample.createCriteria()
//		.andOriStationNoEqualTo(s1.getStationNo())
//		.andDesStationNoEqualTo(s2.getStationNo());
//		List<PriceInfo> priceInfoList = priceInfoMapper.selectByExample(priceInfoExample);
//		if(priceInfoList != null && priceInfoList.size() != 0) {
//			PriceInfo priceInfoTmp = priceInfoList.get(0);
//			if(!priceInfoTmp.getPrice().equals(PriceUtil.getPrivce(totaldis) + "")) {
//				//priceInfoMapper.deleteByPrimaryKey(priceInfoTmp.getId());
//				PriceInfo priceInfo = new PriceInfo();
//				priceInfo.setId(BaseUtil.getSeqLong());
//				priceInfo.setOriStationNo(s1.getStationNo());
//				priceInfo.setDesStationNo(s2.getStationNo());
//				priceInfo.setPrice(PriceUtil.getPrivce(totaldis) + "");
//				priceInfo.setAuditFlg("N");
//				priceInfo.setBakFld1(fw.toString());
//				priceInfo.setBakFld2(totaldis + "");
//				//priceInfoMapper.insert(priceInfo);
//				newPriceInfoMap.put(priceInfoTmp.getOriStationNo() + priceInfoTmp.getDesStationNo(), priceInfo);
//			}
//		}else {
//			PriceInfo priceInfo = new PriceInfo();
//			priceInfo.setId(BaseUtil.getSeqLong());
//			priceInfo.setOriStationNo(s1.getStationNo());
//			priceInfo.setDesStationNo(s2.getStationNo());
//			priceInfo.setPrice(PriceUtil.getPrivce(totaldis) + "");
//			priceInfo.setAuditFlg("N");
//			priceInfo.setBakFld1(fw.toString());
//			priceInfo.setBakFld2(totaldis + "");
//			//priceInfoMapper.insert(priceInfo);
//			newPriceInfoMap.put(priceInfo.getOriStationNo() + priceInfo.getDesStationNo(), priceInfo);
//		}
		PriceInfo priceInfo = new PriceInfo();
		priceInfo.setId(BaseUtil.getSeqLong());
		priceInfo.setOriStationNo(s1.getStationNo());
		priceInfo.setDesStationNo(s2.getStationNo());
		priceInfo.setPrice(PriceUtil.getPrivce(totaldis) + "");
		priceInfo.setAuditFlg("N");
		priceInfo.setBakFld1(fw.toString());
		priceInfo.setBakFld2(totaldisStr + "");
		priceInfo.setBakFld3(sb2.toString() + "");
		//priceInfoMapper.insert(priceInfo);
		newPriceInfoMap.put(priceInfo.getOriStationNo() + priceInfo.getDesStationNo(), priceInfo);
		
		
		
		if(recalcutelateFlg) {
			stationPathSet = s1.getAllPassedStations(s2);
			LinkedHashSet<Station> stationPathSet2 = new LinkedHashSet<Station>();
			Iterator<Station> it = stationPathSet.iterator();
			List<Station> stationList = new ArrayList<Station>();
			while(it.hasNext()) {
				stationList.add(it.next());
			}
			for(int i = stationPathSet.size() -1; i >=0; i--) {
				stationPathSet2.add(stationList.get(i));
			}
			stationPathSet = stationPathSet2;
			sb = new StringBuilder(200);
			sb2 = new StringBuilder("");
		    fw = new StringBuilder();
			fw.append("起始站:" + s2.getName() + "  目标站点：" + s1.getName() + "，共经过" + (stationPathSet.size()) + "站");
			fw.append("\r\n");
			for (Station station : stationPathSet) {
				sb.append(station.getName() + "->");
				sb2.append(station.getName() + "->");
			}

			sb.delete(sb.length() - 2, sb.length());
			sb2.delete(sb2.length() - 2, sb2.length());
			fw.append(sb.toString());
			fw.append("\r\n");
			
			// 计算最短路径

			totaldis=0;
			sstart = s2;
			for (Station station : stationPathSet) {
				if(station==sstart)
					continue;
				totaldis+= priceUtil.getDistance(sstart.getStationNo(), station.getStationNo());
				sstart = station;

			}
			
			totaldisStr = "";
			totaldisDec = new BigDecimal(totaldis);
			resultDec = totaldisDec.divide(new BigDecimal(1000));
			resultDec = resultDec.setScale(3,BigDecimal.ROUND_HALF_DOWN);
			totaldisStr = resultDec.toString();
			
			fw.append("，乘距:"+totaldisStr+"米，票价:"+PriceUtil.getPrivce(totaldis)+"元\r\n");
			
//			priceInfoExample = new PriceInfoExample();
//			priceInfoExample.createCriteria()
//			.andOriStationNoEqualTo(s2.getStationNo())
//			.andDesStationNoEqualTo(s1.getStationNo());
//			priceInfoList = priceInfoMapper.selectByExample(priceInfoExample);
//			if(priceInfoList != null && priceInfoList.size() != 0) {
//				PriceInfo priceInfoTmp = priceInfoList.get(0);
//				Map<String,Object> oriPriceMap = (Map<String,Object>)ServletActionContext.getRequest().getAttribute("oriPriceInfoMap");
////				String oriPrice = (String)oriPriceMap.get(priceInfoTmp.getOriStationNo()+priceInfoTmp.getDesStationNo());
//				String oriPrice = priceInfoTmp.getPrice();
//				if(oriPrice != null && !oriPrice.equals(PriceUtil.getPrivce(totaldis) + "")) {
//					//priceInfoMapper.deleteByPrimaryKey(priceInfoTmp.getId());
//					PriceInfo priceInfo = new PriceInfo();
//					priceInfo.setId(BaseUtil.getSeqLong());
//					priceInfo.setOriStationNo(s2.getStationNo());
//					priceInfo.setDesStationNo(s1.getStationNo());
//					priceInfo.setPrice(PriceUtil.getPrivce(totaldis) + "");
//					priceInfo.setAuditFlg("N");
//					priceInfo.setBakFld1(fw.toString());
//					priceInfo.setBakFld2(totaldis + "");
//					priceInfo.setBakFld3(priceInfoTmp.getOriStationNo() + "," + priceInfoTmp.getDesStationNo() + "," + priceInfoTmp.getPrice());
//					//priceInfoMapper.insert(priceInfo);
//					newPriceInfoMap.put(priceInfoTmp.getOriStationNo() + priceInfoTmp.getDesStationNo(), priceInfo);
//				}
//			}else {
//				PriceInfo priceInfo = new PriceInfo();
//				priceInfo.setId(BaseUtil.getSeqLong());
//				priceInfo.setOriStationNo(s2.getStationNo());
//				priceInfo.setDesStationNo(s1.getStationNo());
//				priceInfo.setPrice(PriceUtil.getPrivce(totaldis) + "");
//				priceInfo.setAuditFlg("N");
//				priceInfo.setBakFld1(fw.toString());
//				priceInfo.setBakFld2(totaldis + "");
//				//priceInfoMapper.insert(priceInfo);
//				newPriceInfoMap.put(priceInfo.getOriStationNo() + priceInfo.getDesStationNo(), priceInfo);
//			}
			
			priceInfo = new PriceInfo();
			priceInfo.setId(BaseUtil.getSeqLong());
			priceInfo.setOriStationNo(s2.getStationNo());
			priceInfo.setDesStationNo(s1.getStationNo());
			priceInfo.setPrice(PriceUtil.getPrivce(totaldis) + "");
			priceInfo.setAuditFlg("N");
			priceInfo.setBakFld1(fw.toString());
			priceInfo.setBakFld2(totaldisStr + "");
			priceInfo.setBakFld3(sb2.toString() + "");
			//priceInfoMapper.insert(priceInfo);
			newPriceInfoMap.put(priceInfo.getOriStationNo() + priceInfo.getDesStationNo(), priceInfo);
		}
		
		ServletActionContext.getRequest().setAttribute("newPriceInfoMap", newPriceInfoMap);
	}
	
	
	public int getDistanceBetweenStation(Station s1,LinkedHashSet<Station> stationPathSet) {
		int totaldis=0;
		Station sstart = s1;
		for (Station station : stationPathSet) {
			if(station==sstart)
				continue;
			totaldis+= priceUtil.getDistance(sstart.getStationNo(), station.getStationNo());
			sstart = station;
		}
		return totaldis;
	} 

	/**
	 * desc: How to use the method author chaisson since 2015-5-31 version 1.0
	 */
//	public static void main(String[] args) {
//		DataBuilder dataBuilder = new DataBuilder();
//		FileWriter fw = null;
//
//		try {
//			fw = new FileWriter("d://2.txt");
//
//			long t1 = System.currentTimeMillis();
//			Subway sw = new Subway();
//
//			int b = dataBuilder.totalStaion;
//
//		for (int i = 0; i < b; i++)
//				for (int y = 0; y < b; y++) {
//					sw = new Subway();
//					sw.calculate(dataBuilder.lines.get(i), dataBuilder.lines.get(y), fw);
//					fw.append(
//							"-----------------------------------------------------------------------------------------------------------\r\n");
//				}
//			long t2 = System.currentTimeMillis();
//			System.out.println();
//			System.out.println("耗时：" + (t2 - t1) + "ms");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (null != fw)
//				try {
//					fw.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
//	}
}
