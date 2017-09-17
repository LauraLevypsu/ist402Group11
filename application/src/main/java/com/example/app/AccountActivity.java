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

public class AccountActivity  extends AppCompatActivity{

    public Button toLikedSongsButton;
    public Button requestSongsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_activity);

        toLikedSongsButton = (Button) findViewById(R.id.bToLikedSongs);
        requestSongsButton = (Button) findViewById(R.id.bRequest);

        toLikedSongsButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View account_activity){
                        //Intent intent = new Intent
                        startActivity(new Intent(AccountActivity.this, LikedSongsActivity.class));
                    }
                }
        );

        requestSongsButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View account_activity){

                        //TODO: add dialog box to request songs
                    }
                }
        );

    }
}
