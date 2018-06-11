package com.example.java_lib_jokes;

import java.util.ArrayList;
import java.util.List;

public class Joke {

    private List<String> jokeList = new ArrayList<>();

    public String getJoke() {
        fillListJokes();
        return jokeList.get(1);
    }

    private void fillListJokes(){
        jokeList.add("I’d like to make the world a better place. But they won’t give me the source code…");
        jokeList.add("Definition, Algorithm: Word used by programmers when they do not want to explain what they did.");
        jokeList.add("Software developers like to solve problems. If there are no problems available, they will create their own problems. It’s an addiction.");
        jokeList.add("Definition, Programmer: An organism that turns caffeine and pizza into software.");
        jokeList.add("Q: How many programmers does it take to screw in a light bulb?\n" +
                "\n" +
                "A: None. It's a hardware problem.");
    }
}
