package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

/**
 * Created by Ali on 08/08/15.
 */
public class JokeClientTest extends AndroidTestCase {

    private boolean goOn = true;
    @SuppressWarnings("unchecked")
    public void test() throws ExecutionException, InterruptedException {
        String result = null;
        JokeClient client = new JokeClient(new JokeClient.JokeClientListener() {
            @Override
            public void jokeReceived(String joke) {
            }
        });
        client.getAJoke();
        String joke = client.getTask();
        assertNotNull(joke);
    }

}