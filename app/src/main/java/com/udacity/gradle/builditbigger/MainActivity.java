package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import gridentertainment.net.showjoke.JokeActivity;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.Callback{

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("StaticFieldLeak")
    public void tellJoke(View view) {
        pd =  ProgressDialog.show(this, "Loading", "Getting a fresh joke for ya");
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onFinished(String result) {
        pd.dismiss();
        Intent intent = new Intent(MainActivity.this, JokeActivity.class);
        intent.putExtra(JokeActivity.JK, result);
        startActivity(intent);
    }
}
