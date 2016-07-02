package com.yogesh.androiddesignlibrarydemo.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yogesh.androiddesignlibrarydemo.R;

public class SnackBarDemoActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private Button btnSimpleSnackbar, btnActionCallback, btnCustomView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);
        btnSimpleSnackbar = (Button) findViewById(R.id.btnSimpleSnackbar);
        btnActionCallback = (Button) findViewById(R.id.btnActionCallback);
        btnCustomView = (Button) findViewById(R.id.btnCustomSnackbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setImageDrawable(SnackBarDemoActivity.this.getResources().getDrawable(R.drawable.ic_done_white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                // Changing message text color
                snackbar.setActionTextColor(SnackBarDemoActivity.this.getResources().getColor(R.color.md_pink_500));

                // Changing action button text color
                View sbView = snackbar.getView();
                sbView.setBackgroundColor(SnackBarDemoActivity.this.getResources().getColor(R.color.md_blue_grey_800));
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(SnackBarDemoActivity.this.getResources().getColor(R.color.md_amber_500));

                snackbar.show();
            }
        });

        btnSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Welcome to HelloMeets", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });

        btnActionCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
            }
        });

    }

}
