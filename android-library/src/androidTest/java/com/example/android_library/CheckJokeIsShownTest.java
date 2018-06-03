package com.example.android_library;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.android_library.ShowJokeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class CheckJokeIsShownTest {

    @Rule
    public ActivityTestRule<ShowJokeActivity> mActivityTestRule =
            new ActivityTestRule<>(ShowJokeActivity.class);

    @Test
    public void checkTJokeTextIsNotEmpty(){

//        onView(withId(R.id.button_show_joke)).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("This is a joke 2")));
    }

}
