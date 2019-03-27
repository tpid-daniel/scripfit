package com.example.fitness.scripfit.Menu.Blog.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogMainModel {

    @SerializedName("blog")
    @Expose
    private List<BlogModel> blog = null;

    public List<BlogModel> getBlog() {
        return blog;
    }

    public void setBlog(List<BlogModel> blog) {
        this.blog = blog;
    }

}
