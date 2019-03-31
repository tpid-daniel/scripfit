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
    @SerializedName("tingkatpelatihan")
    @Expose
    private String tingkatpelatihan;
    @SerializedName("linkimage")
    @Expose
    private String linkimage;
    @SerializedName("open")
    @Expose
    private Integer open;
    @SerializedName("subketerangan")
    @Expose
    private String subketerangan;
    @SerializedName("subketerangandetail")
    @Expose
    private String subketerangandetail;
    @SerializedName("durasi")
    @Expose
    private String durasi;
    @SerializedName("hari")
    @Expose
    private Integer hari;
    @SerializedName("senin")
    @Expose
    private String senin;
    @SerializedName("selasa")
    @Expose
    private String selasa;
    @SerializedName("rabu")
    @Expose
    private String rabu;
    @SerializedName("kamis")
    @Expose
    private String kamis;
    @SerializedName("jumat")
    @Expose
    private String jumat;
    @SerializedName("sabtu")
    @Expose
    private String sabtu;
    @SerializedName("minggu")
    @Expose
    private String minggu;
    @SerializedName("tujuanutama")
    @Expose
    private String tujuanutama;
    @SerializedName("waktuperlatihan")
    @Expose
    private String waktuperlatihan;
    @SerializedName("peralatan")
    @Expose
    private String peralatan;
    @SerializedName("penulis")
    @Expose
    private String penulis;
    @SerializedName("sumber")
    @Expose
    private String sumber;


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

    public String getTingkatpelatihan() {
        return tingkatpelatihan;
    }

    public void setTingkatpelatihan(String tingkatpelatihan) {
        this.tingkatpelatihan = tingkatpelatihan;
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

    public String getSubketerangan() {
        return subketerangan;
    }

    public void setSubketerangan(String subketerangan) {
        this.subketerangan = subketerangan;
    }

    public String getSubketerangandetail() {
        return subketerangandetail;
    }

    public void setSubketerangandetail(String subketerangandetail) {
        this.subketerangandetail = subketerangandetail;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public Integer getHari() {
        return hari;
    }

    public void setHari(Integer hari) {
        this.hari = hari;
    }

    public String getSenin() {
        return senin;
    }

    public void setSenin(String senin) {
        this.senin = senin;
    }

    public String getSelasa() {
        return selasa;
    }

    public void setSelasa(String selasa) {
        this.selasa = selasa;
    }

    public String getRabu() {
        return rabu;
    }

    public void setRabu(String rabu) {
        this.rabu = rabu;
    }

    public String getKamis() {
        return kamis;
    }

    public void setKamis(String kamis) {
        this.kamis = kamis;
    }

    public String getJumat() {
        return jumat;
    }

    public void setJumat(String jumat) {
        this.jumat = jumat;
    }

    public String getSabtu() {
        return sabtu;
    }

    public void setSabtu(String sabtu) {
        this.sabtu = sabtu;
    }

    public String getMinggu() {
        return minggu;
    }

    public void setMinggu(String minggu) {
        this.minggu = minggu;
    }

    public String getTujuanutama() {
        return tujuanutama;
    }

    public void setTujuanutama(String tujuanutama) {
        this.tujuanutama = tujuanutama;
    }

    public String getWaktuperlatihan() {
        return waktuperlatihan;
    }

    public void setWaktuperlatihan(String waktuperlatihan) {
        this.waktuperlatihan = waktuperlatihan;
    }

    public String getPeralatan() {
        return peralatan;
    }

    public void setPeralatan(String peralatan) {
        this.peralatan = peralatan;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

}
