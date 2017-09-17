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

public class LoginActivity extends AppCompatActivity{

    public Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_login_activity);

        loginButton = (Button)findViewById(R.id.bLogin);
        loginButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View account_login_activity){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }
        );



    }
}
