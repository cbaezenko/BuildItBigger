package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EspressoIdlingResource;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;


import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.R;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CheckDataRequestFree {

    @Rule
    public ActivityTestRule<MainActivity> mTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResource(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void checkTJokeTextIsNotEmpty() {

        onView(withId(R.id.button_show_joke)).perform(click());
        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Interstitial close button"), isDisplayed()));
        imageButton.perform(click());
        onView(withId(com.example.android_library.R.id.textView)).check(matches(withText("Definition, Algorithm: Word used by programmers when they do not want to explain what they did.")));

    }

    @After
    public void unregisterIdlingResource(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
    }
}