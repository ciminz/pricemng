package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class LineInfo implements Serializable {
    private Long id;

    private String lineNo;

    private String lineNme;

    private String lineEnNme;

    private String lineColor;

    private String lineDes;

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

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo == null ? null : lineNo.trim();
    }

    public String getLineNme() {
        return lineNme;
    }

    public void setLineNme(String lineNme) {
        this.lineNme = lineNme == null ? null : lineNme.trim();
    }

    public String getLineEnNme() {
        return lineEnNme;
    }

    public void setLineEnNme(String lineEnNme) {
        this.lineEnNme = lineEnNme == null ? null : lineEnNme.trim();
    }

    public String getLineColor() {
        return lineColor;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor == null ? null : lineColor.trim();
    }

    public String getLineDes() {
        return lineDes;
    }

    public void setLineDes(String lineDes) {
        this.lineDes = lineDes == null ? null : lineDes.trim();
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