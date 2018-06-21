package com.nngdjt.pricemng.base;
import java.util.HashMap;  
import java.util.LinkedHashSet;  
import java.util.Map;

/**
 * 地铁站名称
 * 以上行方向为证
 * @author hp
 *
 */
public class Station {  
    
	private String stationNo;
	
	private String name; //地铁站名称，假设具备唯一性  
      
    public Station prev; //本站在lineNo线上面的前一个站  
      
    public Station next; //本站在lineNo线上面的后一个站  
    
    public boolean direction = true;//默认方向是上行方向
      
    public byte lineno =0;//线路名称
    
    private String lineNo;
    
    public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	//本站到某一个目标站(key)所经过的所有站集合(value)，保持前后顺序  
    private Map<Station,LinkedHashSet<Station>> orderSetMap = new HashMap<Station,LinkedHashSet<Station>>();  
    
    public Station (String stationNo,String name) {
    	this.stationNo = stationNo;
    	this.name = name;
    }
    
    public Station (String stationNo,String name,String lineNo) {
    	this.stationNo = stationNo;
    	this.name = name;
    	this.lineNo = lineNo;
    }
    
    public Station (String name){  
        this.name = name;  
    }  
    
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
	public Station getPrev() {
		return prev;
	}

	public void setPrev(Station prev) {
		this.prev = prev;
	}

	public Station getNext() {
		return next;
	}

	public void setNext(Station next) {
		this.next = next;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public void setOrderSetMap(Map<Station, LinkedHashSet<Station>> orderSetMap) {
		this.orderSetMap = orderSetMap;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public LinkedHashSet<Station> getAllPassedStations(Station station) {  
        if(orderSetMap.get(station) == null){  
            LinkedHashSet<Station> set = new LinkedHashSet<Station>();   
            set.add(this);  
            orderSetMap.put(station, set);  
        }  
        return orderSetMap.get(station);  
    }  
  
    public Map<Station, LinkedHashSet<Station>> getOrderSetMap() {  
        return orderSetMap;  
    }  
      
    @Override  
    public boolean equals(Object obj) {  
        if(this == obj){  
            return true;  
        } else if(obj instanceof Station){  
            Station s = (Station) obj;  
            if(s.getStationNo().equals(this.getStationNo())){  
                return true;  
            } else {  
                return false;  
            }  
        } else {  
            return false;  
        }  
    }  
      
    @Override  
    public int hashCode() {  
        return this.getStationNo().hashCode();  
    }  
}  