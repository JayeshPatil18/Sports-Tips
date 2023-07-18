package com.app.a1xbetsportshelpapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class SubCategoryActivity extends AppCompatActivity {

    CustomAd customAd = new CustomAd(SubCategoryActivity.this);

    ImageView backButton;
    LinearLayout subCategory1;
    LinearLayout subCategory2;
    LinearLayout subCategory3;
    LinearLayout subCategory4;
    LinearLayout subCategory5;

    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        loadInterstitialAd();

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
                showInterstitialAd(category, "score");
            }
        });

        subCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd(category, "live football");
            }
        });

        subCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd(category, "live cricket");
            }
        });

        subCategory4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd(category, "watch live match");
            }
        });

        subCategory5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd(category, "earn from games");
            }
        });
    }

    public void showInterstitialAd(String valueStr1, String valueStr2) {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(SubCategoryActivity.this);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                @Override
                public void onAdClicked() {
                    // Called when a click is recorded for an ad.
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    // Set the ad reference to null so you don't show the ad a second time.
                    Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                    intent.putExtra("category", valueStr1);
                    intent.putExtra("sub_category", valueStr2);
                    startActivity(intent);
                    customAd.showAd();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    // Called when ad fails to show.
                    mInterstitialAd = null;
                }

                @Override
                public void onAdImpression() {
                    // Called when an impression is recorded for an ad.
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                }
            });
        } else {
            Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
            intent.putExtra("category", valueStr1);
            intent.putExtra("sub_category", valueStr2);
            startActivity(intent);
            customAd.showAd();
        }
    }

    public void loadInterstitialAd(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.interstitialSubCategory), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        customAd.showAd();
        super.onBackPressed();
    }
}