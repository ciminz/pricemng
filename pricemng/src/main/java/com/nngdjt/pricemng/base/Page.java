package com.nngdjt.pricemng.base;

public class Page {
	public static Integer getOffSet(String nowpage,String pagesize) {
		Integer nowpageL = Integer.valueOf(nowpage);
		Integer pagesizeL = Integer.valueOf(pagesize);
		return (nowpageL - 1) * pagesizeL;
	}
	
	public static Integer getTotolSize(int pagesize, int recordsize) {
		if(recordsize % pagesize == 0) {
			return recordsize/pagesize;
		}
		return recordsize/pagesize + 1;
	}
}
