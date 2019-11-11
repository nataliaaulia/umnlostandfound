package com.example.bottom_navigation.ui.home;

/**
 * Created by karanjaswani on 1/12/18.
 */

public class Product {
    private int id;
    private String title;
    private String shortdesc;
    private String contactinfo;
    private int image;

    public Product(int id, String title, String shortdesc, String contactinfo, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.contactinfo = contactinfo;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getContactinfo() { return contactinfo;}

    public int getImage() {
        return image;
    }
}
