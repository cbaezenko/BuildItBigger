package com.udacity.gradle.builditbigger.free;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


import com.udacity.gradle.builditbigger.R;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkTJokeTextIsNotEmpty() {

        onView(withId(R.id.button_show_joke)).perform(click());

        onView(withId(com.example.android_library.R.id.textView)).check(matches(withText("This is a joke 2")));

    }
}