package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import uk.co.alibros.myapplication.backend.jokeApi.JokeApi;

/**
 * Created by Ali on 08/08/15.
 */
public class JokeClient {

    private JokeClientListener mListener;
    private EndpointsAsyncTask task;
    public interface JokeClientListener{
        void jokeReceived(String joke);
    }

    public JokeClient(JokeClientListener listener){
            mListener = listener;
    }

    public void getAJoke(){
        task = new EndpointsAsyncTask();
        task.execute();
    }
    public String getTask() throws ExecutionException, InterruptedException {
        String joke = task.get();
        return joke;
    }

    class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
        private JokeApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Void... params) {
            if(myApiService == null) {  // Only do this once
//                JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
//                        new AndroidJsonFactory(), null)
//                        // options for running against local devappserver
//                        // - 10.0.2.2 is localhost's IP address in Android emulator
//                        // - turn off compression when running against local devappserver
//                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });
//                // end options for devappserver

                JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://abjokesupplier.appspot.com/_ah/api/");
                myApiService = builder.build();
            }


            try {
                return myApiService.getjoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            mListener.jokeReceived(result);
        }
    }


}
