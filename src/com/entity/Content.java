package com.entity;

public class Content {
    private String Title;
    private String ApplyTime;
    private String AnnounceTime;
    private String Owner;
    private String Category;
    private String Detail;
    private String Url;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getApplyTime() {
        return ApplyTime;
    }

    public void setApplyTime(String applyTime) {
        ApplyTime = applyTime;
    }

    public String getAnnounceTime() {
        return AnnounceTime;
    }

    public void setAnnounceTime(String announceTime) {
        AnnounceTime = announceTime;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner.replace("Patentee ","");

    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
