package com.entity;

public class Company {
    private String company;
    private String url;
    private String category;
    private String Content;
    private String Curtime;

    public String getCurtime() {
        return Curtime;
    }

    public void setCurtime(String curtime) {
        Curtime = curtime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return Content.trim();
    }

    public void setContent(String content) {
        Content = content;
    }
}
