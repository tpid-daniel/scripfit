package com.example.fitness.scripfit.Menu.Latihan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LatihanModel {
//    private int Gambar = 0;
    private String keterangan = null;

    public LatihanModel(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("tingkat")
    @Expose
    private String tingkat;
    @SerializedName("peralatan")
    @Expose
    private String peralatan;
    @SerializedName("bagianOtot")
    @Expose
    private String bagianOtot;
    @SerializedName("petunjuk")
    @Expose
    private String petunjuk;
    @SerializedName("linkImage")
    @Expose
    private String linkImage;
    @SerializedName("linkGif")
    @Expose
    private String linkGif;
    @SerializedName("linkVideo")
    @Expose
    private String linkVideo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTingkat() {
        return tingkat;
    }

    public void setTingkat(String tingkat) {
        this.tingkat = tingkat;
    }

    public String getPeralatan() {
        return peralatan;
    }

    public void setPeralatan(String peralatan) {
        this.peralatan = peralatan;
    }

    public String getBagianOtot() {
        return bagianOtot;
    }

    public void setBagianOtot(String bagianOtot) {
        this.bagianOtot = bagianOtot;
    }

    public String getPetunjuk() {
        return petunjuk;
    }

    public void setPetunjuk(String petunjuk) {
        this.petunjuk = petunjuk;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLinkGif() {
        return linkGif;
    }

    public void setLinkGif(String linkGif) {
        this.linkGif = linkGif;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }
}
