package com.example.fitness.scripfit.Menu.Latihan.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.Presenter.LatihanPresenter;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class LatihanDetailSub extends AppCompatActivity implements LatihanPresenter.View {
    int id;
    String jenis;
    WebView wv_latihan;
    RelativeLayout rl_latihan;
    TextView tv_judulLatihanSub;
    TextView tv_tingkatLatihanSub;
    TextView tv_peralatanLatihanSub;
    ImageView iv_bagianOtotLatihanSub;
    TextView tv_petunjukLatihanSub;
    List<LatihanModel> mData = new ArrayList<>();
    String urlVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_detail_sub);

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
        id = intent.getIntExtra("id", 0);
        jenis = intent.getStringExtra("jenis");
        tv_judulLatihanSub = (TextView) findViewById(R.id.tv_judulLatihanSub);
        tv_tingkatLatihanSub = (TextView) findViewById(R.id.tv_tingkatLatihanSub);
        tv_peralatanLatihanSub = (TextView) findViewById(R.id.tv_peralatanLatihanSub);
        iv_bagianOtotLatihanSub = (ImageView) findViewById(R.id.iv_bagianOtotLatihanSub);
        tv_petunjukLatihanSub = (TextView) findViewById(R.id.tv_petunjukLatihanSub);
        wv_latihan = (WebView) findViewById(R.id.wv_latihan);
        rl_latihan = (RelativeLayout) findViewById(R.id.rl_latihan);
        LatihanPresenter latihanPresenter = new LatihanPresenter(this);
        latihanPresenter.listLatihanById(id);


    }

    public void getText(){
        for(LatihanModel latihanModel : mData){
            tv_judulLatihanSub.setText(latihanModel.getJudul());
            tv_tingkatLatihanSub.setText("Tingkat : "+latihanModel.getTingkat());
            tv_peralatanLatihanSub.setText("Peralatan : "+latihanModel.getPeralatan());
            tv_petunjukLatihanSub.setText(latihanModel.getPetunjuk());
            Glide.with(getApplicationContext())
                    .load(latihanModel.getBagianOtot())
                    .into(iv_bagianOtotLatihanSub);
            urlVideo = latihanModel.getLinkVideo();
            urlVideo = urlVideo.replace("https://youtu.be/", "https://www.youtube.com/embed/");

            String frameVideo = "<html><body><br><iframe width=\"100%\" height=\"230px\" src=\""+urlVideo+"\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\" mozallowfullscreen=\"mozallowfullscreen\" msallowfullscreen=\"msallowfullscreen\" oallowfullscreen=\"oallowfullscreen\" webkitallowfullscreen=\"webkitallowfullscreen\"></iframe></body></html>";

            wv_latihan.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            WebSettings webSettings = wv_latihan.getSettings();
            webSettings.setJavaScriptEnabled(true);
            wv_latihan.getSettings().setPluginState(WebSettings.PluginState.ON);
            wv_latihan.setWebChromeClient(new MyWebClient());
            wv_latihan.loadData(frameVideo, "text/html", "utf-8");
        }
    }

    public class MyWebClient
            extends WebChromeClient
    {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        public MyWebClient() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (LatihanDetailSub.this == null) {
                return null;
            }
            return BitmapFactory.decodeResource(LatihanDetailSub.this.getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)LatihanDetailSub.this.getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            LatihanDetailSub.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            LatihanDetailSub.this.setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = LatihanDetailSub.this.getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = LatihanDetailSub.this.getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)LatihanDetailSub.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            LatihanDetailSub.this.getWindow().getDecorView().setSystemUiVisibility(3846);
        }
    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void resultDataDetail(List<LatihanModel> data) {
        mData = data;
        getText();
    }

}
