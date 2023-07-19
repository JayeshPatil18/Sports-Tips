package com.app.a1xbetsportshelpapp;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdsStatus {

    public static void interstitialAd(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("ads");

        databaseReference.child("interstitial").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                if(value.equals("false")){
                    return;
                } else{
                    return;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
