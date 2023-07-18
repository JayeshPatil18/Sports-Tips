package com.app.a1xbetsportshelpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class ContinueActivity extends AppCompatActivity {

    CustomAd customAd = new CustomAd(ContinueActivity.this);
    Button continueBtn;

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        continueBtn = findViewById(R.id.continue_btn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContinueActivity.this, StartActivity.class);
                startActivity(intent);
                customAd.showAd();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ContinueActivity.this, ExitActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}