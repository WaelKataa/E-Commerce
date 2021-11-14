package com.wael.e_commerce.models;

public class ViewPagerModel {
    private int image;


    private String title , body;

    public ViewPagerModel(int image, String title, String body) {
        this.image = image;
        this.title = title;
        this.body = body;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
