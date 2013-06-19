package com.bruno.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 15/06/13
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
public class Address implements Serializable {
    String line1;
    String line2;
    String city;
    String postcode;

    public Address() {

    }

    public Address(String line1, String line2, String city, String postcode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.postcode = postcode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return this.getLine1()+"-"+this.getLine2()+":"+this.getCity()+":"+this.getPostcode();
    }
}

