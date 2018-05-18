package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class Menuitem implements Serializable {
    private Long id;

    private String menuitemname;

    private String url;

    private Integer isparent;

    private Long parent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuitemname() {
        return menuitemname;
    }

    public void setMenuitemname(String menuitemname) {
        this.menuitemname = menuitemname == null ? null : menuitemname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }
}