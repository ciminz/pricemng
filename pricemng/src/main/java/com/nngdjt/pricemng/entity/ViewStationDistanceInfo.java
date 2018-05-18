package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class ViewStationDistanceInfo implements Serializable {
    private String oriStationNo;

    private String oriStationNme;

    private String desStationNo;

    private String desStationNme;

    private String distance;

    private static final long serialVersionUID = 1L;

    public String getOriStationNo() {
        return oriStationNo;
    }

    public void setOriStationNo(String oriStationNo) {
        this.oriStationNo = oriStationNo == null ? null : oriStationNo.trim();
    }

    public String getOriStationNme() {
        return oriStationNme;
    }

    public void setOriStationNme(String oriStationNme) {
        this.oriStationNme = oriStationNme == null ? null : oriStationNme.trim();
    }

    public String getDesStationNo() {
        return desStationNo;
    }

    public void setDesStationNo(String desStationNo) {
        this.desStationNo = desStationNo == null ? null : desStationNo.trim();
    }

    public String getDesStationNme() {
        return desStationNme;
    }

    public void setDesStationNme(String desStationNme) {
        this.desStationNme = desStationNme == null ? null : desStationNme.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }
}