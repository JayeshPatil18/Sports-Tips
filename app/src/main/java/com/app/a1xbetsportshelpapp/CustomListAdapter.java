package com.app.a1xbetsportshelpapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<ListItemModel> {

    private Context context;
    private List<ListItemModel> itemList;

    public CustomListAdapter(Context context, List<ListItemModel> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        }

        // Get the current item from the list
        ListItemModel currentItem = itemList.get(position);

        // Find the ImageView and TextView in the layout
        TextView textView = listItemView.findViewById(R.id.textView);

        // Set the image and text for the current item
        textView.setText(currentItem.getText());

        return listItemView;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
