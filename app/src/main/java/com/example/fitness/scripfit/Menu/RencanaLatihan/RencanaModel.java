package com.example.fitness.scripfit.Menu.RencanaLatihan;

public class RencanaModel {
    private String judul = null;
    private String judulKeterangan = null;
    private String keterangan = null;
    private String linkImage = null;
    private Boolean status = false;

    public RencanaModel(String judul, String judulKeterangan, String keterangan, String linkImage, Boolean status) {
        this.judul = judul;
        this.judulKeterangan = judulKeterangan;
        this.keterangan = keterangan;
        this.linkImage = linkImage;
        this.status = status;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudulKeterangan() {
        return judulKeterangan;
    }

    public void setJudulKeterangan(String judulKeterangan) {
        this.judulKeterangan = judulKeterangan;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
