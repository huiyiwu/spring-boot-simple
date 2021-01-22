package com.huchx.rest.entity;

import java.util.Objects;

/**
 * Author: Huchx
 * Date: 2021/1/22 15:07
 */
public class AddressInfo {
    private String adcode;
    private String people_count_2010;
    private String lat;
    private String lng;
    private String name;
    private String level;
    private String parent;

    public AddressInfo() {
    }

    public AddressInfo(String adcode, String people_count_2010, String lat, String lng, String name, String level, String parent) {
        this.adcode = adcode;
        this.people_count_2010 = people_count_2010;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.level = level;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "adcode='" + adcode + '\'' +
                ", people_count_2010='" + people_count_2010 + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressInfo that = (AddressInfo) o;
        return Objects.equals(adcode, that.adcode) &&
                Objects.equals(people_count_2010, that.people_count_2010) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(lng, that.lng) &&
                Objects.equals(name, that.name) &&
                Objects.equals(level, that.level) &&
                Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adcode, people_count_2010, lat, lng, name, level, parent);
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getPeople_count_2010() {
        return people_count_2010;
    }

    public void setPeople_count_2010(String people_count_2010) {
        this.people_count_2010 = people_count_2010;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
