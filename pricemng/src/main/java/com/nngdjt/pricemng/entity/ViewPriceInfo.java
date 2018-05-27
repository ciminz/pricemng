package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class ViewPriceInfo implements Serializable {
    private String oriStationNo;

    private String oriStationNme;

    private String desStationNo;

    private String desStationNme;

    private String price;

    private String auditUserId;

    private String auditUsername;

    private String auditRealusername;

    private String auditFlg;

    private String auditDate;

    private String auditTme;

    private String bakFld1;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId == null ? null : auditUserId.trim();
    }

    public String getAuditUsername() {
        return auditUsername;
    }

    public void setAuditUsername(String auditUsername) {
        this.auditUsername = auditUsername == null ? null : auditUsername.trim();
    }

    public String getAuditRealusername() {
        return auditRealusername;
    }

    public void setAuditRealusername(String auditRealusername) {
        this.auditRealusername = auditRealusername == null ? null : auditRealusername.trim();
    }

    public String getAuditFlg() {
        return auditFlg;
    }

    public void setAuditFlg(String auditFlg) {
        this.auditFlg = auditFlg == null ? null : auditFlg.trim();
    }

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate == null ? null : auditDate.trim();
    }

    public String getAuditTme() {
        return auditTme;
    }

    public void setAuditTme(String auditTme) {
        this.auditTme = auditTme == null ? null : auditTme.trim();
    }

    public String getBakFld1() {
        return bakFld1;
    }

    public void setBakFld1(String bakFld1) {
        this.bakFld1 = bakFld1 == null ? null : bakFld1.trim();
    }
}