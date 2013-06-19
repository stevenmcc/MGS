package com.bruno.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public class Contact implements Serializable {
    String fname;
    String lname;
    String phone;
    String email;

    public Contact() {
    }

    public Contact(String fname, String lname, String phone, String email) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.getFname()+" "+this.getLname()+":"+this.getEmail()+":"+this.getPhone();
    }
}
