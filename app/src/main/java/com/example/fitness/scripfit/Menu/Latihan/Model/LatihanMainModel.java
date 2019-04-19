package com.example.fitness.scripfit.Menu.Latihan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatihanMainModel {
    @SerializedName("latihan")
    @Expose
    private List<LatihanModel> latihan = null;

    public List<LatihanModel> getLatihan() {

        return latihan;
    }

    public void setLatihan(List<LatihanModel> latihan) {

        this.latihan = latihan;
    }
}
