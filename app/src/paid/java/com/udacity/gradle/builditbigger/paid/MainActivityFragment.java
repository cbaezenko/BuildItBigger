package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android_library.ShowJokeActivity;

import static java.security.AccessController.getContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        initButtonShowJoke(root);

        return root;
    }

    private void initButtonShowJoke(View root){
        Button button = root.findViewById(R.id.button_show_joke);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EspressoIdlingResource.increment();

                com.udacity.gradle.builditbigger.EndpointsAsyncTask endpointsAsyncTask = new com.udacity.gradle.builditbigger.EndpointsAsyncTask(getContext());
                endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "Manfred"));
            }
        });
    }
}
