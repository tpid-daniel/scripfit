package com.example.fitness.scripfit.Menu.Blog.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlogModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("keteranganDetail")
    @Expose
    private String keteranganDetail;
    @SerializedName("linkImage")
    @Expose
    private String linkImage;

    public BlogModel(String judul, String keterangan, String linkImage) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.linkImage = linkImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getKeteranganDetail() {
        return keteranganDetail;
    }

    public void setKeteranganDetail(String keteranganDetail) {
        this.keteranganDetail = keteranganDetail;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

}


