package com.app.a1xbetsportshelpapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    CustomAd customAd = new CustomAd(DetailsActivity.this);

    ListView listView;
    CustomListAdapter adapter;

    ImageView backButton;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        bannerAdsStatus(mAdView);

        Bundle extras = getIntent().getExtras();
        String category = extras.getString("category");
        String subCategory = extras.getString("sub_category");

        listView = findViewById(R.id.listview);
        backButton = findViewById(R.id.backButton);

        List<String> itemList = new ArrayList<>();

        adapter = new CustomListAdapter(this, itemList);

        // Get a reference to the Firebase Realtime Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference gamesRef = database.getReference().child("games").child(category).child(subCategory);

        // Read data from Firebase
        gamesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String data = childSnapshot.getValue(String.class);
                    System.out.println(data);
                    itemList.add(data);

                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "Error: " + databaseError.getMessage());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                customAd.showAd();
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