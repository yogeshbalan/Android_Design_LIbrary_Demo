package com.yogesh.androiddesignlibrarydemo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yogesh.androiddesignlibrarydemo.R;

public class CustomBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.fab_custom_behavior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.container_layout), "Voila! Here's a custom behavior", Snackbar.LENGTH_LONG).show();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
