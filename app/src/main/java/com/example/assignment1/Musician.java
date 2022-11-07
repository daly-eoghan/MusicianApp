package com.example.assignment1;

import java.io.Serializable;

public class Musician implements Serializable {
    private String name;
    private String band;
    private String image;
    private String role;
    private String info;
    private String url;

    public Musician(String name, String band, String image,String role, String info, String url) {
        this.name = name;
        this.band = band;
        this.image = image;
        this.role = role;
        this.info = info;
        this.url = url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}