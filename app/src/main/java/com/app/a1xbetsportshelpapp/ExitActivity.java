package com.app.a1xbetsportshelpapp;

import static com.app.a1xbetsportshelpapp.R.id.nobtn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExitActivity extends AppCompatActivity {
    Button noBtn;
    Button yesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        noBtn = findViewById(nobtn);
        yesBtn = findViewById(R.id.yesbtn);

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExitActivity.this, ContinueActivity.class);
                startActivity(intent);
                finish();
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}