package com.example.zw.androiduilibrary.appurtenance;

import android.app.Activity;
import android.os.Bundle;

import com.example.zw.androiduilibrary.R;
import com.example.zw.library.appurtenance.Titanic;
import com.example.zw.library.appurtenance.TitanicTextView;

/**
 * Created by lujinxin on 16/8/27.
 */
public class LoadingActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        TitanicTextView tv = (TitanicTextView) findViewById(R.id.loading);
        Titanic titanic = new Titanic();
        titanic.start(tv);
    }
}
