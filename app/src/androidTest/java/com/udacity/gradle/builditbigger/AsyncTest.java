package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.support.test.filters.LargeTest;
import android.test.AndroidTestCase;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncTest {

    @Test
    public void testJokeTask() {

        AsyncTask asyncTask = new EndpointsAsyncTask().execute();
        String joke = null;
        try {
            joke = asyncTask.get(30, TimeUnit.SECONDS).toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(!TextUtils.isEmpty(joke));
        Assert.assertNotNull(joke);
    }
}