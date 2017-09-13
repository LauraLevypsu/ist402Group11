package com.example.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.*;

import com.example.good_morning.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signInButton = (Button) findViewById(R.id.bLogin);
        /*EditText emailEditText = (EditText) findViewById(R.id.etEmail);
        EditText passwordEditText = (EditText) findViewById(R.id.etPassword);

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();*/

        signInButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View activity_main){
                        //Intent intent = new Intent (MainActivity.this, AccountSettingsActivityView.class);
                        //startActivity(intent);//////////////
                        //startActivity(new Intent(MainActivity.this, AccountSettingsActivityView.class));
                    }
                }
        );
    }
}
