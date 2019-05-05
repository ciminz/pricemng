package com.nngdjt.pricemng.base;

import java.math.BigDecimal;
import java.util.Comparator;

import com.nngdjt.pricemng.entity.LineInfo;

public class LineInfoComparator implements Comparator<LineInfo>{

	@Override
	public int compare(LineInfo o1, LineInfo o2) {
		return new BigDecimal(o1.getLineNo()).compareTo(new BigDecimal(o2.getLineNo()));
	}
}
