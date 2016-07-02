package com.yogesh.androiddesignlibrarydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.yogesh.androiddesignlibrarydemo.R;
import com.yogesh.androiddesignlibrarydemo.activity.coordinator.MaterialUpConceptActivity;
import com.yogesh.androiddesignlibrarydemo.activity.coordinator.SimpleCoordinatorActivity;
import com.yogesh.androiddesignlibrarydemo.activity.coordinator.SwipeBehaviorExampleActivity;

public class CoordinatorActivity extends AppCompatActivity {

    Button btnSimpleBehavior, btnMaterialProfileBehavior, btnSwipeBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnMaterialProfileBehavior = (Button) findViewById(R.id.btnMaterialUpBehavior);
        btnSimpleBehavior = (Button) findViewById(R.id.btnSimpleBehavior);
        btnSwipeBehavior = (Button) findViewById(R.id.btnSwipeBehavior);

        btnSwipeBehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoordinatorActivity.this, SwipeBehaviorExampleActivity.class));
            }
        });

        btnSimpleBehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoordinatorActivity.this, SimpleCoordinatorActivity.class));
            }
        });

        btnMaterialProfileBehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoordinatorActivity.this, MaterialUpConceptActivity.class));
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
