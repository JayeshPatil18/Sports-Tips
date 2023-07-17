package com.app.a1xbetsportshelpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SubCategoryActivity extends AppCompatActivity {

    ImageView backButton;
    LinearLayout subCategory1;
    LinearLayout subCategory2;
    LinearLayout subCategory3;
    LinearLayout subCategory4;
    LinearLayout subCategory5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        backButton = findViewById(R.id.backButton);
        subCategory1 = findViewById(R.id.sc1);
        subCategory2 = findViewById(R.id.sc2);
        subCategory3 = findViewById(R.id.sc3);
        subCategory4 = findViewById(R.id.sc4);
        subCategory5 = findViewById(R.id.sc5);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        subCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("category", "sub_category1");
                startActivity(intent);
            }
        });

        subCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("category", "sub_category2");
                startActivity(intent);
            }
        });

        subCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("category", "sub_category3");
                startActivity(intent);
            }
        });

        subCategory4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("category", "sub_category4");
                startActivity(intent);
            }
        });

        subCategory5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubCategoryActivity.this, DetailsActivity.class);
                intent.putExtra("category", "sub_category5");
                startActivity(intent);
            }
        });
    }
}