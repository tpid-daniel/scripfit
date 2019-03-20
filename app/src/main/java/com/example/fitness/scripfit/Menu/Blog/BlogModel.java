package com.example.fitness.scripfit.Menu.Blog;

public class BlogModel {
    private String judul = null;
    private String keterangan = null;
    private String linkImage = null;

    public BlogModel(String judul, String keterangan, String linkImage) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.linkImage = linkImage;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }
}


