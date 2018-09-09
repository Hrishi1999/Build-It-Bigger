package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeapi.Jokeapi;

import java.io.IOException;

/**
 * Created by Hrishi Patel on 07/09/18.
 */
@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static Jokeapi myApiService = null;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void ...params) {
        if(myApiService == null) {  // Only do this once
            Jokeapi.Builder builder = new Jokeapi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
    }
}