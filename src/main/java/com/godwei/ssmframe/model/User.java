package com.godwei.ssmframe.model;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String userName;
    private String passWord;

    public User(){

    }
    public User(Long id, String name, String password){
        this.id = id;
        this.userName = name;
        this.passWord = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
