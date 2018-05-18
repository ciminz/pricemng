package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private Long id;

    private String rolename;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}