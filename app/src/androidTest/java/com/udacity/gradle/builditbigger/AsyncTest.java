package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;

public class AsyncTest {

    @Test
    public void testJokeTask() throws InterruptedException, ExecutionException {
        EndpointsAsyncTask jk = new EndpointsAsyncTask(new EndpointsAsyncTask.Callback() {
            @Override
            public void onFinished(String result) {

            }
        });
        assertNotNull(jk.execute().get());
    }
}