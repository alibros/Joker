package com.alibros;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Ali on 08/08/15.
 */
public class Supplier {

    String[] jokes = {"I bet earth makes fun of the other planets for having no life,",
            "What's the difference between snowmen and snowladies? Snowballs",
            "How do you make holy water? You boil the hell out of it.",
    "What did the fish say when he swam into the wall? -- Damn"};

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
