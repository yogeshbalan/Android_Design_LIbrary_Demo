package com.yogesh.androiddesignlibrarydemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yogesh.androiddesignlibrarydemo.R;
import com.yogesh.androiddesignlibrarydemo.activity.ScrollingActivity;
import com.yogesh.androiddesignlibrarydemo.model.Cheeses;

import java.util.List;

/**
 * Created by yogesh on 1/7/16.
 */
public class SimpleStringRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<String> mValues;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String mBoundString;

        public final View mView;
        public final ImageView mImageView;
        public final TextView mTextView;
        public final LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.avatar);
            mTextView = (TextView) view.findViewById(android.R.id.text1);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView.getText();
        }
    }

    public String getValueAt(int position) {
        return mValues.get(position);
    }

    public SimpleStringRecyclerViewAdapter(Activity activity, List<String> items) {
        activity.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mValues = items;
        mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mBoundString = mValues.get(position);
        holder.mTextView.setText(mValues.get(position));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ScrollingActivity.class);
                intent.putExtra(ScrollingActivity.EXTRA_NAME, holder.mBoundString);

                /*if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    String transitionName = context.getString(R.string.transition_string);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, holder.linearLayout, transitionName);
                    context.startActivity(intent, options.toBundle());
                } else {
                    context.startActivity(intent);
                }*/

                context.startActivity(intent);

            }
        });

        Glide.with(holder.mImageView.getContext())
                .load(Cheeses.getRandomCheeseDrawable())
                .fitCenter()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}

