package com.app.a1xbetsportshelpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    ImageView backButton;
    LinearLayout category1;
    LinearLayout category2;
    LinearLayout category3;
    LinearLayout category4;
    LinearLayout category5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

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
            }
        });


        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                intent.putExtra("category", "category1");
                startActivity(intent);
            }
        });

        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                intent.putExtra("category", "category2");
                startActivity(intent);
            }
        });

        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                intent.putExtra("category", "category3");
                startActivity(intent);
            }
        });

        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                intent.putExtra("category", "category4");
                startActivity(intent);
            }
        });

        category5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, SubCategoryActivity.class);
                intent.putExtra("category", "category5");
                startActivity(intent);
            }
        });
    }
}