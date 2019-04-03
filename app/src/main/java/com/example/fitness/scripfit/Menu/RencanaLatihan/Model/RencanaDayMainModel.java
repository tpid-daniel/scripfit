package com.example.fitness.scripfit.Menu.RencanaLatihan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RencanaDayMainModel {
    @SerializedName("rencanaday")
    @Expose
    private List<RencanaDayModel> rencanaday = null;

    public List<RencanaDayModel> getRencanaday() {
        return rencanaday;
    }

    public void setRencanaday(List<RencanaDayModel> rencanaday) {
        this.rencanaday = rencanaday;
    }
}
