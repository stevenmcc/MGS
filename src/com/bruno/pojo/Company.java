package com.bruno.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */
public class Company implements Serializable {
    String name;
    String phone;

    public Company() {
    }

    public Company(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.getName()+":"+this.getPhone();
    }
}
