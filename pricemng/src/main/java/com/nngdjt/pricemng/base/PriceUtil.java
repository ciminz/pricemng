package com.nngdjt.pricemng.base;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.nngdjt.pricemng.entity.DistanceInfo;
import com.nngdjt.pricemng.entity.DistanceInfoExample;
import com.nngdjt.pricemng.mapper.DistanceInfoMapper;
import com.vane.base.LocalBeanFactory;

/**
 * 计算票价 根据公里数，两个od路径之间的最短路径开始计算 以米为单位
 * 
 * @author hp
 *
 */
public class PriceUtil {

	/* 只记录区间矩阵 */
	public HashMap<String, Integer> dis = new HashMap<String, Integer>();
	
	{
		DataBuilder dataBuilder = new DataBuilder();
		DistanceInfoMapper distanceInfoMapper = (DistanceInfoMapper)LocalBeanFactory.get(DistanceInfoMapper.class);
		
		for(Station station : dataBuilder.lines) {
			if(station.getNext() ==null) {
				continue;
			}
			DistanceInfoExample distanceInfoExample = new DistanceInfoExample();
			distanceInfoExample.createCriteria()
			.andOriStationNoEqualTo(station.getStationNo())
			.andDesStationNoEqualTo(station.getNext().getStationNo());
			List<DistanceInfo> distanceInfoList = distanceInfoMapper.selectByExample(distanceInfoExample);
			if(distanceInfoList == null || distanceInfoList.size() == 0) {
				continue;
			}
			dis.put(station.getStationNo() + station.getNext().getStationNo(), Integer.valueOf(new BigDecimal(distanceInfoList.get(0).getDistance()).multiply(new BigDecimal(1000)).setScale(0).toString()));//转换成毫米
		}
		
		/*一号线*/
//		dis.put("石埠站南职院站",1725);
//		dis.put("南职院站鹏飞路站",1041);
//		dis.put("鹏飞路站西乡塘客运站站",	1927);
//		dis.put("西乡塘客运站站民族大学站",	1355);
//		dis.put("民族大学站清川站",	2100);
//		dis.put("清川站动物园站",	1525);
//		dis.put("动物园站鲁班路站",1656);
//		dis.put("鲁班路站广西大学站",	1031);
//	    dis.put("广西大学站白苍岭站",	1614);
//		dis.put("白苍岭站火车站站",1373);
//		dis.put("火车站站朝阳广场站",	951);
//		dis.put("朝阳广场站新民路站",	997);
//		dis.put("新民路站民族广场站",	891);
//		dis.put("民族广场站麻村站",1166);
//		dis.put("麻村站南湖站",	1658);
//		dis.put("南湖站金湖广场站",899);
//		dis.put("金湖广场站会展中心站",1176);
//		dis.put("会展中心站万象城站",818);
//		dis.put("万象城站东盟商务区站",779);
//		dis.put("东盟商务区站凤岭站",1177);
//		dis.put("凤岭站埌东客运站站",	901);
//		dis.put("埌东客运站站百花岭站",	1439);
//		dis.put("百花岭站佛子岭站",1567);
//		dis.put("佛子岭站火车东站站",1651);
		
		
//		dis.put("01010102",1725);
//		dis.put("01020103",1041);
//		dis.put("01030104",	1927);
//		dis.put("01040105",	1355);
//		dis.put("01050106",	2100);
//		dis.put("01060107",	1525);
//		dis.put("01070108",1656);
//		dis.put("01080109",	1031);
//	    dis.put("01090110",	1614);
//		dis.put("01100111",1373);
//		dis.put("01110112",	951);
//		dis.put("01120113",	997);
//		dis.put("01130114",	891);
//		dis.put("01140115",1166);
//		dis.put("01150116",	1658);
//		dis.put("01160117",899);
//		dis.put("01170118",1176);
//		dis.put("01180119",818);
//		dis.put("01190120",779);
//		dis.put("01200121",1177);
//		dis.put("01210122",	901);
//		dis.put("01220123",	1439);
//		dis.put("01230124",1567);
//		dis.put("01240125",1651);
//
//		
//		/*二号线*/
//		dis.put("02010202",	1077);
//		dis.put("02020203",	1394);
//		dis.put("02030204",	1403);
//		dis.put("02040205",	1009);
//		dis.put("02050206",	827);
//		dis.put("02060207",1656);
//		dis.put("02070208",	809);
//		dis.put("02080209",	692);
//		dis.put("02090210",	1082);
//		dis.put("02100111",	1775);
//	    dis.put("01120213",1673);
//		dis.put("02130214",1202);
//		dis.put("02140215",1153);
//		dis.put("02150216",	1270);
//		dis.put("02160217",	1198);
//		dis.put("02170218",	1054);

		
		
		
	}

	public static int getPrivce(int distance) {//按毫米比对
		if (distance <= 6000*1000)
			return 2;
		else if (distance > 6000*1000 && distance <= 12000*1000)
			return 3;
		else if (distance > 12000*1000 && distance <= 18000*1000)
			return 4;
		else if (distance > 18000*1000 && distance <= 26000*1000)
			return 5;
		else if (distance > 26000*1000 && distance <= 34000*1000)
			return 6;
		else
			return (7 + (((int) distance - 34000*1000) / (10000*1000)));

	}

	
	
   public int getDistance(String s1,String s2){
	   System.out.println("s1:" + s1 + ",s2:" + s2);
	   if(dis.containsKey(s1+s2))
	   {
		   return dis.get(s1+s2);
	   }
	     
	   else if(dis.containsKey(s2+s1)) {
		   System.out.println("31313131");
		   return dis.get(s2+s1);
	   }
	   
	   else {
		   return 0;
	   }
   }
}
