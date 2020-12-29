package com.huchx.json.pojo;

import com.huchx.json.annotation.GsonTransparent;

import java.io.Serializable;

public class AddressPojo implements Serializable {
    private String name;
    @GsonTransparent
    private String phone;
    private String address;

    public AddressPojo() {
    }

    public AddressPojo(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
