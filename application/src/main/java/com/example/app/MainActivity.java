package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.*;

import com.example.good_morning.R;

public class MainActivity extends AppCompatActivity {

    public Button toAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toAccountButton = (Button) findViewById(R.id.bToAccount);

        toAccountButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View activity_main){
                        //Intent intent = new Intent
                        startActivity(new Intent(MainActivity.this, AccountActivity.class));
                    }
                }
        );

        //TODO: add media player/ songlist
        //TODO: add play/ pause
        //TODO: add like/ dislike








    }
}
