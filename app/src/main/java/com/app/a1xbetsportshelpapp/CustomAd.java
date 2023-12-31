package com.app.a1xbetsportshelpapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CustomAd extends Activity {
    Context context;

    public CustomAd(Context context) {
        this.context = context;
    }

    public void showAd(){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("ads");

        databaseReference.child("link").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                if(value.equals("false")){
                    return;
                } else{
                    String url = "https://www.wikipedia.org/";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
