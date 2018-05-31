package com.udacity.gradle.builditbigger.backend;

import com.example.java_lib_jokes.Joke;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {

        Joke joke = new Joke();
        myData = joke.getJoke();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}