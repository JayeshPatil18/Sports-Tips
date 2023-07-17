package com.app.a1xbetsportshelpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        listView = findViewById(R.id.listview);

        List<ListItemModel> itemList = new ArrayList<>();
        itemList.add(new ListItemModel("Item 1"));
        itemList.add(new ListItemModel("Item 2"));

        CustomListAdapter adapter = new CustomListAdapter(this, itemList);
        listView.setAdapter(adapter);
    }
}