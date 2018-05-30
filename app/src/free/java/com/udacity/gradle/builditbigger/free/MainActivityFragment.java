package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android_library.ShowJokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

//import com.udacity.gradle.builditbigger.free.EndpointsAsyncTask;

import com.udacity.gradle.builditbigger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {

    private InterstitialAd mInterstitialAd;
    private static final String TAG = "MainActivity";

    public MainActivityFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        initButtonShowJoke(root);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @Override
    public void onStart(){
        super.onStart();
        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                com.udacity.gradle.builditbigger.EndpointsAsyncTask endpointsAsyncTask = new com.udacity.gradle.builditbigger.EndpointsAsyncTask(getContext());
                endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "Manfred"));
//                new EndpointsAsyncTask(getContext()).execute();

                Intent intent = new Intent(getContext(), ShowJokeActivity.class);
                intent.putExtra(ShowJokeActivity.SHOW_TEXT_JOKE, "PEDRO");
                startActivity(intent);
            }
        });
    }

    private void initButtonShowJoke(View  root){
        Button button = root.findViewById(R.id.button_show_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mInterstitialAd.isLoaded()){
                    Log.d(TAG, "The interstitial is load");
                    mInterstitialAd.show();
                }else{
                    Log.d(TAG, "The interstitial wasn't loaded yet");
                }
            }
        });
    }
}
