package com.ccnu.xiahongyun.stmanagementsystem.enums;

public enum  UserAuthority {
    USER_AUTHORITY("USER"),
    ADMIN_AUTHORITY("ADMIN");

    private String authority;

    UserAuthority(String authority){
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }
}
