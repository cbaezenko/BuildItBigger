package com.example.java_lib_jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joke {

    private List<String> jokeList = new ArrayList<>();

    public String getJoke() {
//        Random random = new Random();
        fillListJokes();
        return jokeList.get(1);
                //jokeList.get(random.nextInt(jokeList.size()));
    }

    private void fillListJokes(){
        jokeList.add("This is a joke 1");
        jokeList.add("This is a joke 2");
        jokeList.add("This is a joke 3");
        jokeList.add("This is a joke 4");
        jokeList.add("This is a joke 5");
        jokeList.add("This is a joke 6");
        jokeList.add("This is a joke 7");
        jokeList.add("This is a joke 8");
        jokeList.add("This is a joke 9");
    }
}
