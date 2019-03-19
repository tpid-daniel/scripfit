package com.example.fitness.scripfit.Menu.Latihan;

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
}
