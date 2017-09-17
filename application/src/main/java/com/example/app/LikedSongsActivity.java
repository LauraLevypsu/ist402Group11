package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.example.good_morning.R;

/**
 * Created by Laura on 9/17/2017.
 */

public class LikedSongsActivity extends AppCompatActivity {

    public Button toRecommenededSongsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liked_songs_activity);

        ////recommended songs are a recyclerview below liked songs,
        // probably in a different color
    }

}
