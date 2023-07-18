package com.app.a1xbetsportshelpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContinueActivity extends AppCompatActivity {

    CustomAd customAd = new CustomAd(ContinueActivity.this);
    Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);


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