package com.example.guiltyrecycling.models;

public class Element {

    private String title;
    private String category;
    private boolean isRecyclable;

    public Element() {
    }

    public Element(String title, boolean isRecyclable) {
        this.title = title;
        this.isRecyclable = isRecyclable;
    }

    public Element(String title, String category, boolean isRecyclable) {
        this.title = title;
        this.category = category;
        this.isRecyclable = isRecyclable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRecyclable() {
        return isRecyclable;
    }

    public void setRecyclable(boolean recyclable) {
        isRecyclable = recyclable;
    }
}
