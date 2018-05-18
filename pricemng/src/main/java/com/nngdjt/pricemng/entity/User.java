package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;

    private String username;

    private String realusername;

    private String password;

    private String tel;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealusername() {
        return realusername;
    }

    public void setRealusername(String realusername) {
        this.realusername = realusername == null ? null : realusername.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}