package com.asia00.testservlet.bean;

public class UserInfoNew {
    private String userName;
    private String userTel;

    public UserInfoNew(String userName, String userTel) {
        this.userName = userName;
        this.userTel = userTel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
