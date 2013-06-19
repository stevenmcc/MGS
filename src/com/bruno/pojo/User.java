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

    public User() {
    }

    public User(String username, String password, String userrole) {
        this.username = username;
        this.password = password;
        this.userrole = userrole;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
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

    @Override
    public String toString() {
         //To change body of overridden methods use File | Settings | File Templates.
        return this.getUsername() + ":" + this.getPassword()+":"+this.getUserrole();
    }
}
