package com.example.android_library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    public static final String SHOW_TEXT_JOKE = "show_text_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        if (getIntent().getExtras() != null) {
            String text = getIntent().getExtras().getString(SHOW_TEXT_JOKE);
            TextView textView = findViewById(R.id.textView);
            textView.setText(text);
        }
    }
}
