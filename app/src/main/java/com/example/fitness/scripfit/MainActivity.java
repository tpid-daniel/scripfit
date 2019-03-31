package com.example.fitness.scripfit;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fitness.scripfit.Menu.Blog.View.BlogFragment;
import com.example.fitness.scripfit.Menu.Latihan.View.LatihanFragment;
import com.example.fitness.scripfit.Menu.Reminder.ReminderFragment;
import com.example.fitness.scripfit.Menu.RencanaLatihan.View.RencanaLatihanFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LatihanFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

                switch (menuItem.getItemId()){
                    case R.id.nav_latihan : selectedFragment = new LatihanFragment(); break;
                    case R.id.nav_rencanaLatihan : selectedFragment = new RencanaLatihanFragment(); break;
                    case R.id.nav_blog : selectedFragment = new BlogFragment(); break;
                    case R.id.nav_reminder : selectedFragment = new ReminderFragment(); break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }
}
