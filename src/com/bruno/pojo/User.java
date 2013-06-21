package com.bruno.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable{
    String username;
    String password;
    String userrole;
    String fname;
    String lname;
    String phone;
    String email;

    public User() {
    }

    public User(String username, String password, String userrole, String fname, String lname, String phone, String email) {
        this.username = username;
        this.password = password;
        this.userrole = userrole;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
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
         //To change body of overridden methods use File | Settings | File Templates.
        return this.getUsername() + ":" + this.getPassword()+":"+this.getUserrole();
    }
}
