package com.alibros;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Ali on 08/08/15.
 */
public class Supplier {

    String[] jokes = {"joke1,","joke2","joke3"};

    public Supplier() {

    }

    public String getRandomJoke(){

        Random rnd = new Random();
        int cnt =jokes.length;
        int index = Math.round(rnd.nextFloat() * cnt);
        String s = jokes[index];
        return s;
    }


}
