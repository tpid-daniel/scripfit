package com.example.fitness.scripfit.Menu.RencanaLatihan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RencanaModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("judulketerangan")
    @Expose
    private String judulketerangan;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("linkimage")
    @Expose
    private String linkimage;
    @SerializedName("open")
    @Expose
    private Integer open;


    public RencanaModel(String judul, String judulketerangan, String keterangan, String linkimage) {
        this.judul = judul;
        this.judulketerangan = judulketerangan;
        this.keterangan = keterangan;
        this.linkimage = linkimage;
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

    public String getJudulketerangan() {
        return judulketerangan;
    }

    public void setJudulketerangan(String judulketerangan) {
        this.judulketerangan = judulketerangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLinkimage() {
        return linkimage;
    }

    public void setLinkimage(String linkimage) {
        this.linkimage = linkimage;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }
}
