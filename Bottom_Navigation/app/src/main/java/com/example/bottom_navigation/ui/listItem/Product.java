package com.example.bottom_navigation.ui.listItem;

public class Product {
    private int pos;
    private String title;
    private String shortdesc;
    private String contactinfo;
    private int image;

    public Product(int pos, String title, String shortdesc, String contactinfo, int image) {
        this.pos = pos;
        this.title = title;
        this.shortdesc = shortdesc;
        this.contactinfo = contactinfo;
        this.image = image;
    }

    public int getPos() {
        return pos;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public int getImage() {
        return image;
    }
}
