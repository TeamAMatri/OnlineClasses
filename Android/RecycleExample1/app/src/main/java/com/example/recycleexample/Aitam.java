package com.example.recycleexample;

class Aitam {
    String name,author,title,desc,url,imglink,date,content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Aitam(String name, String author, String title, String desc, String url, String imglink, String date, String content) {
        this.name = name;
        this.author = author;
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.imglink= imglink;
        this.date = date;
        this.content = content;
    }
    public Aitam(){

    }
}
