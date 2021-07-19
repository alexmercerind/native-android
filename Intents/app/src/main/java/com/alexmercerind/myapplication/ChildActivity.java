package com.alexmercerind.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child2);
        ((TextView)findViewById(R.id.TextView)).setText(this.getIntent().getStringExtra("Text"));
        ((Button)findViewById(R.id.Button)).setOnClickListener(
                (View view) -> {
                    this.finish();
                }
        );
    }
}