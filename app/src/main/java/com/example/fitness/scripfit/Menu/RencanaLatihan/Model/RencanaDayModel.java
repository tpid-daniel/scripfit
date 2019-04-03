package com.example.fitness.scripfit.Menu.RencanaLatihan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RencanaDayModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_rencana")
    @Expose
    private Integer idRencana;
    @SerializedName("hari")
    @Expose
    private Integer hari;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("set_number")
    @Expose
    private Integer setNumber;
    @SerializedName("repetisi")
    @Expose
    private String repetisi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRencana() {
        return idRencana;
    }

    public void setIdRencana(Integer idRencana) {
        this.idRencana = idRencana;
    }

    public Integer getHari() {
        return hari;
    }

    public void setHari(Integer hari) {
        this.hari = hari;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    public String getRepetisi() {
        return repetisi;
    }

    public void setRepetisi(String repetisi) {
        this.repetisi = repetisi;
    }

}
