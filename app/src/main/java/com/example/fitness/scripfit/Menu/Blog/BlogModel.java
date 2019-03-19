package com.example.fitness.scripfit.Menu.Blog;

public class BlogModel {
    private String judul = null;
    private String keterangan = null;

    public BlogModel(String judul, String keterangan) {
        this.judul = judul;
        this.keterangan = keterangan;
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
}


