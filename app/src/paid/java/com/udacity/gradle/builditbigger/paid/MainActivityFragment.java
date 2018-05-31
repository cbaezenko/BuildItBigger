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

//        AdView mAdView = (AdView) root.findViewById(R.id.adView);
//        // Create an ad request. Check logcat output for the hashed device ID to
//        // get test ads on a physical device. e.g.
//        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//        mAdView.loadAd(adRequest);
        return root;
    }

    private void initButtonShowJoke(View root){
        Button button = root.findViewById(R.id.button_show_joke);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//             Intent intent = new Intent(getContext(), ShowJokeActivity.class);
//             intent.putExtra(ShowJokeActivity.SHOW_TEXT_JOKE, "PEDRO");
//             startActivity(intent);
                com.udacity.gradle.builditbigger.EndpointsAsyncTask endpointsAsyncTask = new com.udacity.gradle.builditbigger.EndpointsAsyncTask(getContext());
                endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "Manfred"));
            }
        });
    }
}
