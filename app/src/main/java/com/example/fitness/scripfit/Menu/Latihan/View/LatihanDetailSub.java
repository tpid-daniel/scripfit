package com.example.fitness.scripfit.Menu.Latihan.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.Presenter.LatihanPresenter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaDayModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class LatihanDetailSub extends AppCompatActivity implements LatihanPresenter.View {
    int id;
    String jenis;
    VideoView vv_latihan;
    RelativeLayout rl_latihan;
    ImageView iv_playpause;
    ProgressDialog mProgress;
    TextView tv_judulLatihanSub;
    TextView tv_tingkatLatihanSub;
    TextView tv_peralatanLatihanSub;
    ImageView iv_bagianOtotLatihanSub;
    TextView tv_petunjukLatihanSub;
    List<LatihanModel> mData = new ArrayList<>();
    List<RencanaDayModel> mDay = new ArrayList<>();
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
        vv_latihan = (VideoView) findViewById(R.id.vv_latihan);
        rl_latihan = (RelativeLayout) findViewById(R.id.rl_latihan);
        iv_playpause = (ImageView) findViewById(R.id.iv_playpause);
        LatihanPresenter latihanPresenter = new LatihanPresenter(this);
        if(jenis.contains("latihan")){
            latihanPresenter.listLatihanById(id);
        }
        else{
            latihanPresenter.listLatihanByIdRencana(id);
        }

        rl_latihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vv_latihan.isPlaying()) {
                    vv_latihan.pause();
                    iv_playpause.setImageResource(R.drawable.ic_play_circle);
                }
                else{
                    mProgress = new ProgressDialog(LatihanDetailSub.this);
                    mProgress.setMessage("Please wait...");
                    mProgress.setCanceledOnTouchOutside(false);
                    if (urlVideo != null || urlVideo != "") {
                        mProgress.show();
                    }

                    iv_playpause.setImageResource(R.drawable.ic_stop);

                    try {
                        Uri uri = Uri.parse(urlVideo);
                        vv_latihan.setVideoURI(uri);
                        vv_latihan.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                iv_playpause.setImageResource(R.drawable.ic_stop);
                            }
                        });

                        if(urlVideo == null && mProgress.isShowing()){
                            mProgress.dismiss();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        if(urlVideo == null && mProgress.isShowing()){
                            mProgress.dismiss();
                        }
                    }
                    vv_latihan.requestFocus();
                    vv_latihan.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mProgress.dismiss();
                            mp.setLooping(true);
                            vv_latihan.start();
                        }
                    });

                }

            }
        });



    }

    public void getText(){
        if(jenis.contains("latihan")){
            for(LatihanModel latihanModel : mData){
                tv_judulLatihanSub.setText(latihanModel.getJudul());
                tv_tingkatLatihanSub.setText("Tingkat : "+latihanModel.getTingkat());
                tv_peralatanLatihanSub.setText("Peralatan : "+latihanModel.getPeralatan());
                tv_petunjukLatihanSub.setText(latihanModel.getPetunjuk());
                Glide.with(getApplicationContext())
                        .load(latihanModel.getBagianOtot())
                        .into(iv_bagianOtotLatihanSub);
                urlVideo = latihanModel.getLinkVideo();
            }
        }
        else{
            for(RencanaDayModel rencanaDayModel : mDay){
                tv_judulLatihanSub.setText(rencanaDayModel.getJudul());
                tv_tingkatLatihanSub.setText("Tingkat : "+rencanaDayModel.getTingkat());
                tv_peralatanLatihanSub.setText("Peralatan : "+rencanaDayModel.getPeralatan());
                tv_petunjukLatihanSub.setText(rencanaDayModel.getPetunjuk());
                Glide.with(getApplicationContext())
                        .load(rencanaDayModel.getBagianOtot())
                        .into(iv_bagianOtotLatihanSub);
                urlVideo = rencanaDayModel.getLinkVideo();

            }
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

    @Override
    public void resultDataDetailRencana(List<RencanaDayModel> data) {
        mDay = data;
        getText();
    }
}
