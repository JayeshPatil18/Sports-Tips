package com.app.a1xbetsportshelpapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class CustomAd extends Activity {

    Context context;

    public CustomAd(Context context) {
        this.context = context;
    }

    public void showAd(){
        String url = "https://www.wikipedia.org/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }
}
