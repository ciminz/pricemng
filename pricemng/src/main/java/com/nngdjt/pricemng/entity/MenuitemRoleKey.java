package com.nngdjt.pricemng.entity;

import java.io.Serializable;

public class MenuitemRoleKey implements Serializable {
    private Long menuItemId;

    private Long roleId;

    private static final long serialVersionUID = 1L;

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}