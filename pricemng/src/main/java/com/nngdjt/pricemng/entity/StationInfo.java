package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class StationInfo implements Serializable {
    private Long id;

    private String stationNo;

    private String stationNme;

    private String stationEnNme;

    private String lineNo;

    private String locationX;

    private String locationY;

    private String exchangeFlg;

    private String exchangeStNo;

    private String exchangeStLiNo;

    private String stationDes;

    private String sortId;

    private String bakFld1;

    private String bakFld2;

    private String bakFld3;

    private String bakFld4;

    private String bakFld5;

    private String bakFld6;

    private String bakFld7;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo == null ? null : stationNo.trim();
    }

    public String getStationNme() {
        return stationNme;
    }

    public void setStationNme(String stationNme) {
        this.stationNme = stationNme == null ? null : stationNme.trim();
    }

    public String getStationEnNme() {
        return stationEnNme;
    }

    public void setStationEnNme(String stationEnNme) {
        this.stationEnNme = stationEnNme == null ? null : stationEnNme.trim();
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo == null ? null : lineNo.trim();
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX == null ? null : locationX.trim();
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY == null ? null : locationY.trim();
    }

    public String getExchangeFlg() {
        return exchangeFlg;
    }

    public void setExchangeFlg(String exchangeFlg) {
        this.exchangeFlg = exchangeFlg == null ? null : exchangeFlg.trim();
    }

    public String getExchangeStNo() {
        return exchangeStNo;
    }

    public void setExchangeStNo(String exchangeStNo) {
        this.exchangeStNo = exchangeStNo == null ? null : exchangeStNo.trim();
    }

    public String getExchangeStLiNo() {
        return exchangeStLiNo;
    }

    public void setExchangeStLiNo(String exchangeStLiNo) {
        this.exchangeStLiNo = exchangeStLiNo == null ? null : exchangeStLiNo.trim();
    }

    public String getStationDes() {
        return stationDes;
    }

    public void setStationDes(String stationDes) {
        this.stationDes = stationDes == null ? null : stationDes.trim();
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId == null ? null : sortId.trim();
    }

    public String getBakFld1() {
        return bakFld1;
    }

    public void setBakFld1(String bakFld1) {
        this.bakFld1 = bakFld1 == null ? null : bakFld1.trim();
    }

    public String getBakFld2() {
        return bakFld2;
    }

    public void setBakFld2(String bakFld2) {
        this.bakFld2 = bakFld2 == null ? null : bakFld2.trim();
    }

    public String getBakFld3() {
        return bakFld3;
    }

    public void setBakFld3(String bakFld3) {
        this.bakFld3 = bakFld3 == null ? null : bakFld3.trim();
    }

    public String getBakFld4() {
        return bakFld4;
    }

    public void setBakFld4(String bakFld4) {
        this.bakFld4 = bakFld4 == null ? null : bakFld4.trim();
    }

    public String getBakFld5() {
        return bakFld5;
    }

    public void setBakFld5(String bakFld5) {
        this.bakFld5 = bakFld5 == null ? null : bakFld5.trim();
    }

    public String getBakFld6() {
        return bakFld6;
    }

    public void setBakFld6(String bakFld6) {
        this.bakFld6 = bakFld6 == null ? null : bakFld6.trim();
    }

    public String getBakFld7() {
        return bakFld7;
    }

    public void setBakFld7(String bakFld7) {
        this.bakFld7 = bakFld7 == null ? null : bakFld7.trim();
    }
}