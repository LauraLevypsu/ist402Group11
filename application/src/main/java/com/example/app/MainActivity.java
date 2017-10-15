
package com.example.app;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.*;

import com.example.good_morning.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.android.OpenCVLoader;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "https://ist402wang.ist.psu.edu/team11/app/getData.php";

    ArrayList<HashMap<String, String>> userList;
    private Button toAccountButton;

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

        userList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetUsers().execute();

        if (!OpenCVLoader.initDebug()) {
            Log.e(this.getClass().getSimpleName(), "  OpenCVLoader.initDebug(), not working.");
        } else {
            Log.d(this.getClass().getSimpleName(), "  OpenCVLoader.initDebug(), working.");
        }
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetUsers extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray jsonObj = new JSONArray(jsonStr);

                    // Getting JSON Array node

                    // looping through All Contacts
                    for (int i = 0; i < jsonObj.length(); i++) {
                        JSONObject c = jsonObj.getJSONObject(i);

                        String username1 = c.getString("username");
                        // tmp hash map for single contact
                        HashMap<String, String> user = new HashMap<>();

                        // adding each child node to HashMap key => value
                        user.put("username", username1);

                        // adding contact to contact list
                        userList.add(user);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, userList,
                    R.layout.list_item, new String[]{"username"}, new int[]{R.id.username});

            lv.setAdapter(adapter);
        }



    }
}
