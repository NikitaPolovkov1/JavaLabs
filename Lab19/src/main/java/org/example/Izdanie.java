package org.example;

public class Izdanie {

    private String title;
    private Types type;
    private String monthly;
    private boolean color;
    private int pages;
    private boolean glossy;
    private String subscriptionIndex;
    private char[] chars;
    public Izdanie(String title, Types type, String monthly, boolean color, int pages, boolean glossy, String subscriptionIndex, char[] arr) {
        this.title = title;
        this.type = type;
        this.monthly = monthly;
        this.color = color;
        this.pages = pages;
        this.glossy = glossy;
        this.subscriptionIndex = subscriptionIndex;
        this.chars = arr;

    }
    public Izdanie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getMonthly() {
        return monthly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }

    public String getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(String subscriptionIndex) {
        this.subscriptionIndex = subscriptionIndex;
    }
    public char[] getChars() {return chars;}

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Type: " + type + ", Monthly: " + monthly
                + ", Color: " + color + ", Pages: " + pages + ", Glossy: " + glossy
                + ", Subscription Index: " + subscriptionIndex;
    }
}
