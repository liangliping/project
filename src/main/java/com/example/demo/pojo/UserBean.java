package com.example.demo.pojo;

import java.io.Serializable;

/**
 * Description: UserBean <br>
 * 用户实体类(需要的时候在添加字段)
 *
 * @author Liang lp
 * Date: 2020/4/30 10:45 <br>
 */
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String account;

    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
