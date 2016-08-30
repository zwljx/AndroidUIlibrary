package com.example.zw.androiduilibrary.entrance;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.zw.androiduilibrary.R;
import com.example.zw.library.entrance.SpringIndicator;

/**
 * Created by lujinxin on 16/8/27.
 */
public class GuideActivity extends Activity{
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        springIndicator.setViewPager(viewPager);
    }
}
