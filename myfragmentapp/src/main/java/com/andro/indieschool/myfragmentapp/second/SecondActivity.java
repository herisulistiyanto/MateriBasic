package com.andro.indieschool.myfragmentapp.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andro.indieschool.myfragmentapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by herisulistiyanto on 8/29/17.
 */

public class SecondActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private final String TAG = SecondActivity.class.getSimpleName();

    private ArrayList<ImageView> indicators;
    private List<SlideFragment> fragmentList;
    private ViewPager slideViewPager;
    private LinearLayout layoutIndicator;
    private TextView tvClose;

    private final int NUM_PAGES = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fragmentList = new ArrayList<>();
        fragmentList.add(SlideFragment.newInstance("PERTAMA"));
        fragmentList.add(SlideFragment.newInstance("KEDUA"));
        fragmentList.add(SlideFragment.newInstance("KETIGA"));

        indicators = new ArrayList<>(NUM_PAGES);
        layoutIndicator = (LinearLayout) findViewById(R.id.layout_indicator);
        tvClose = (TextView) findViewById(R.id.tv_close);
        tvClose.setVisibility(View.GONE);
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                SecondActivity.this.finish();
            }
        });

        slideViewPager = (ViewPager) findViewById(R.id.pager_slide);
        SecondPagerAdapter pagerAdapter = new SecondPagerAdapter(getSupportFragmentManager(), fragmentList);
        slideViewPager.setAdapter(pagerAdapter);
        slideViewPager.addOnPageChangeListener(this);

        Log.e(TAG, "onCreate: " + indicators.size());

        setupPagerIndicator(NUM_PAGES);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < NUM_PAGES; i++) {
            indicators.get(i).setImageDrawable(ContextCompat.getDrawable(SecondActivity.this, R.drawable.dot_indicator_disabled));
        }
        indicators.get(position).setImageDrawable(ContextCompat.getDrawable(SecondActivity.this, R.drawable.dot_indicator));

        tvClose.setVisibility(
                (position == (NUM_PAGES - 1)) ? View.VISIBLE : View.GONE
        );
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setupPagerIndicator(final int size) {

        for (int i = 0; i < size; i++) {
            indicators.add(new ImageView(SecondActivity.this));
            indicators.get(i).setImageDrawable(
                    ContextCompat.getDrawable(SecondActivity.this,
                            (i == 0) ? R.drawable.dot_indicator : R.drawable.dot_indicator_disabled)
            );

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            int margin = getResources().getDimensionPixelSize(R.dimen.dimen_8dp);
            params.setMargins(
                    margin,
                    0,
                    margin,
                    0
            );
            layoutIndicator.addView(indicators.get(i), params);
        }
        indicators.get(0).setSelected(true);
    }

}
