package com.yogesh.androiddesignlibrarydemo.activity.coordinator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.yogesh.androiddesignlibrarydemo.R;

public class SwipeBehaviorExampleActivity extends AppCompatActivity {

	private CardView mCardView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_behavior);
		mCardView = (CardView) findViewById(R.id.swipe_card);

		final SwipeDismissBehavior<CardView> swipe = new SwipeDismissBehavior();
		swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
		swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
			@Override public void onDismiss(View view) {
				Snackbar.make(view, "Card swiped!!", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}

			@Override public void onDragStateChanged(int state) {}
		});

		LayoutParams coordinatorParams = (LayoutParams) mCardView.getLayoutParams();
		coordinatorParams.setBehavior(swipe);
	}

}
