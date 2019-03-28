package com.example.fitness.scripfit.Menu.Blog.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Blog.Model.BlogModel;
import com.example.fitness.scripfit.Menu.Blog.Presenter.BlogPresenter;
import com.example.fitness.scripfit.R;

import java.util.List;

public class BlogDetail extends AppCompatActivity implements BlogPresenter.View {
    ImageView iv_BlogDetail;
    TextView tv_judulBlog;
    TextView tv_keteranganBlogDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);
        iv_BlogDetail = (ImageView) findViewById(R.id.iv_blogDetail);
        tv_judulBlog = (TextView) findViewById(R.id.tv_judulBlog);
        tv_keteranganBlogDetail = (TextView) findViewById(R.id.tv_keteranganBlogDetail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        getSupportActionBar().setTitle("NEWS");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        BlogPresenter blogPresenter = new BlogPresenter(this);
        blogPresenter.getListBlogById(id);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resultDataDetail(List<BlogModel> data) {
        for(BlogModel blogModel : data){
            tv_judulBlog.setText(blogModel.getJudul());
            tv_keteranganBlogDetail.setText(blogModel.getKeteranganDetail());
            Glide.with(getApplicationContext())
                    .load(blogModel.getLinkImage())
                    .into(iv_BlogDetail);
        }
    }
}
