package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.concurrent.TimeUnit;

import gridentertainment.net.showjoke.JokeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("StaticFieldLeak")
    public void tellJoke(View view) {

        final ProgressDialog progress = ProgressDialog.show(this, "Loading", "Getting a fresh joke for ya");
        final AsyncTask endpointTask = new EndpointsAsyncTask().execute();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String joke;
                try {
                    joke = endpointTask.get(30, TimeUnit.SECONDS).toString();
                    final String finalJoke = joke;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                            intent.putExtra(JokeActivity.JK, finalJoke);
                            startActivity(intent);
                            progress.dismiss();
                        }
                    });
                } catch (Exception e)
                {
                    progress.dismiss();
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
