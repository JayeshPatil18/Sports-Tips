package com.app.a1xbetsportshelpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SubCategoryActivity extends AppCompatActivity {

    CustomAd customAd = new CustomAd(SubCategoryActivity.this);

    ImageView backButton;
    LinearLayout subCategory1;
    LinearLayout subCategory2;
    LinearLayout subCategory3;
    LinearLayout subCategory4;
    LinearLayout subCategory5;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        backButton = findViewById(R.id.backButton);
        subCategory1 = findViewById(R.id.sc1);
        subCategory2 = findViewById(R.id.sc2);
        subCategory3 = findViewById(R.id.sc3);
        subCategory4 = findViewById(R.id.sc4);
        subCategory5 = findViewById(R.id.sc5);

        Bundle extras = getIntent().getExtras();
        String category = extras.getString("category");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                customAd.showAd();
            }
        });


        subCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("sub_category", "score");
                intent.putExtra("category", category);
                startActivity(intent);
                customAd.showAd();
            }
        });

        subCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("sub_category", "live football");
                intent.putExtra("category", category);
                startActivity(intent);
                customAd.showAd();
            }
        });

        subCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("sub_category", "live cricket");
                intent.putExtra("category", category);
                startActivity(intent);
                customAd.showAd();
            }
        });

        subCategory4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("sub_category", "watch live match");
                intent.putExtra("category", category);
                startActivity(intent);
                customAd.showAd();
            }
        });

        subCategory5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("sub_category", "earn from games");
                intent.putExtra("category", category);
                startActivity(intent);
                customAd.showAd();
            }
        });
    }

    @Override
    public void onBackPressed() {
        customAd.showAd();
        super.onBackPressed();
    }
}