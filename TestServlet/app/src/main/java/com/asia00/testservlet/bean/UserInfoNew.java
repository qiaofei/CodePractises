package com.asia00.testservlet.bean;

public class UserInfoNew {
    private String userName;
    private String userTel;
    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserInfoNew(String userName, String userTel, String userPassword) {
        this.userName = userName;
        this.userTel = userTel;
        this.userPassword = userPassword;
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
