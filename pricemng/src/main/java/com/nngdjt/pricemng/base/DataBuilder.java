package com.nngdjt.pricemng.base;
import java.util.ArrayList;  
import java.util.HashSet;  
import java.util.List;  
import java.util.Set;

/**
 * 
 * 如果名称一样，即认为是换成站
 * 以上行顺序为主
 * @author hp
 *
 */
public class DataBuilder {
	    public static List<Station> line1 = new ArrayList<Station>();//1号线  
	    public static List<Station> line2 = new ArrayList<Station>();//2号线 
	    public static List<Station> lines = new ArrayList<Station>();//所有站点的集合
	    
	    
	    public static Set<List<Station>> lineSet = new HashSet<List<Station>>();//所有线集合  
	    public static int totalStaion = 0;//总的站点数量  
	    static {          
	        //1号线  
	        String line1Str = "石埠站-南职院站-鹏飞路站-西乡塘客运站站-民族大学站-清川站-动物园站-鲁班路站-广西大学站-白苍岭站-火车站站-朝阳广场站-新民路站-民族广场站-麻村站-南湖站-金湖广场站-会展中心站-万象城站-东盟商务区站-凤岭站-埌东客运站站-百花岭站-佛子岭站-火车东站站";  
	        String line1StationNo = "0101-0102-0103-0104-0105-0106-0107-0108-0109-0110-0111-0112-0113-0114-0115-0116-0117-0118-0119-0120-0121-0122-0123-0124-0125";  
	        String[] line1Arr = line1Str.split("-");
	        String[] line1StArr = line1StationNo.split("-");
	        int index = 0;
	        for(String s : line1Arr){ 
	        	String stationNo = line1StArr[index];
	            line1.add(new Station(stationNo,s));  
	            lines.add(new Station(stationNo,s)); 
	            index++;
	        }  
	        
	        for(int i =0;i<line1.size();i++){  
	            if(i<line1.size()-1){  
	                line1.get(i).next = line1.get(i+1);  
	                line1.get(i+1).prev = line1.get(i);  
	            }  
	        }  
	          
	        /*******************************************************************************/  
	        //2号线  
	        String line2Str = "玉洞站-金象站-石子塘站-建设路站-大沙田站-江南客运站站-石柱岭站-亭洪路站-福建园站-南宁剧场站-朝阳广场站-火车站站-明秀路站-秀厢站站-三十三中站-苏卢站-安吉客运站站-西津站"; 
	        String line2StationNo = "0201-0202-0203-0204-0205-0206-0207-0208-0209-0210-0111-0112-0213-0214-0215-0216-0217-0218";
	        String[] line2Arr = line2Str.split("-");  
	        String[] line2StArr = line2StationNo.split("-");
	        index = 0;
	        for(String s : line2Arr){  
	        	String stationNo = line2StArr[index];
	            line2.add(new Station(stationNo,s));  
	            lines.add(new Station(stationNo,s)); 
	            index++;
	        }  
	        for(int i =0;i<line2.size();i++){  
	            if(i<line2.size()-1){  
	                line2.get(i).next = line2.get(i+1);  
	                line2.get(i+1).prev = line2.get(i);  
	            }  
	        }  
	        totalStaion = line1.size()+line2.size();
	        lineSet.add(line1);  
	        lineSet.add(line2); 
}
	    
	    
	
	    
	    
}