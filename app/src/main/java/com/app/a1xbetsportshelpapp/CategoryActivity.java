package com.app.a1xbetsportshelpapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    CustomAd customAd = new CustomAd(CategoryActivity.this);
    ImageView backButton;
    LinearLayout category1;
    LinearLayout category2;
    LinearLayout category3;
    LinearLayout category4;
    LinearLayout category5;

    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        loadInterstitialAd();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        bannerAdsStatus(mAdView);

        backButton = findViewById(R.id.backButton);
        category1 = findViewById(R.id.c1);
        category2 = findViewById(R.id.c2);
        category3 = findViewById(R.id.c3);
        category4 = findViewById(R.id.c4);
        category5 = findViewById(R.id.c5);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                customAd.showAd();
            }
        });


        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd("cricket");
            }
        });

        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd("football");
            }
        });

        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd("hockey");
            }
        });

        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd("rugby football");
            }
        });

        category5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialAd("basketball");
            }
        });
    }

    public void showInterstitialAd(String valueStr) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("ads");

        databaseReference.child("interstitial").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                if(value.equals("false")){
                    Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                    intent.putExtra("category", valueStr);
                    startActivity(intent);
                    customAd.showAd();;
                } else{
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(CategoryActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                                intent.putExtra("category", valueStr);
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
                        Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                        intent.putExtra("category", valueStr);
                        startActivity(intent);
                        customAd.showAd();;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void loadInterstitialAd(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.interstitialCategory), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        customAd.showAd();
        super.onBackPressed();
    }

    public void bannerAdsStatus(AdView mAdView){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("ads");
        databaseReference.child("banner").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called when data is retrieved successfully
                String value = dataSnapshot.getValue(String.class);

                if (value.equals("false")) {
                    // The value of the "banner" key is true, so show the banner ad
                    mAdView.setVisibility(View.GONE);
                } else {
                    // The value of the "banner" key is false or null, so don't show the banner ad
                    mAdView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // This method is called when there's an error while retrieving data
                Log.e("FirebaseData", "Error: " + databaseError.getMessage());
            }
        });
    }
}