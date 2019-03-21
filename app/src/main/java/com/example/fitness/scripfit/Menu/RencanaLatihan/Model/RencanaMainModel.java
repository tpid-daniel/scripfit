package com.example.fitness.scripfit.Menu.RencanaLatihan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RencanaMainModel {
    @SerializedName("rencana")
    @Expose
    private List<RencanaModel> rencana = null;

    public List<RencanaModel> getRencana() {
        return rencana;
    }

    public void setRencana(List<RencanaModel> rencana) {
        this.rencana = rencana;
    }
}
