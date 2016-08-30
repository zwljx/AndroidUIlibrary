package com.example.zw.androiduilibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zw.androiduilibrary.appurtenance.DownloadActivity;
import com.example.zw.androiduilibrary.appurtenance.KeyboardActivity;
import com.example.zw.androiduilibrary.appurtenance.LoadingActivity;
import com.example.zw.androiduilibrary.appurtenance.PictureViewActivity;
import com.example.zw.androiduilibrary.appurtenance.SateliteMenuActivity;
import com.example.zw.androiduilibrary.content.ContentFlowActivity;
import com.example.zw.androiduilibrary.content.ContentListActivity;
import com.example.zw.androiduilibrary.content.ContentWaterfallActivity;
import com.example.zw.androiduilibrary.navigation.NavigationDrawerActivity;
import com.example.zw.androiduilibrary.navigation.NavigationTabActivity;
import com.example.zw.androiduilibrary.entrance.GuideActivity;
import com.example.zw.androiduilibrary.entrance.LoginActivity;
import com.example.zw.androiduilibrary.navigation.NavigationContentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login;
    private Button guide;
    private Button navigationDrawer;
    private Button navigationTab;
    private Button navigationContent;
    private Button contentList;
    private Button contentWaterfall;
    private Button contentFlow;
    private Button keyboard;
    private Button pictureView;
    private Button loading;
    private Button download;
    private Button satelite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        }

    private void initView() {
        login = (Button) findViewById(R.id.login);
        if (login != null) {
            login.setOnClickListener(this);
        }
        guide = (Button) findViewById(R.id.guide);
        if (guide != null) {
            guide.setOnClickListener(this);
        }
        navigationDrawer = (Button) findViewById(R.id.navigation_drawer);
        if (navigationDrawer != null) {
            navigationDrawer.setOnClickListener(this);
        }
        navigationTab = (Button) findViewById(R.id.navigation_tab);
        if (navigationTab != null) {
            navigationTab.setOnClickListener(this);
        }
        navigationContent = (Button) findViewById(R.id.navigation_content);
        if (navigationContent != null) {
            navigationContent.setOnClickListener(this);
        }
        contentList = (Button) findViewById(R.id.content_list);
        if (contentList != null) {
            contentList.setOnClickListener(this);
        }
        contentFlow = (Button) findViewById(R.id.content_flow);
        if (contentFlow != null) {
            contentFlow.setOnClickListener(this);
        }
        contentWaterfall = (Button) findViewById(R.id.content_waterfall);
        if (contentWaterfall != null) {
            contentWaterfall.setOnClickListener(this);
        }
        keyboard = (Button) findViewById(R.id.keyboard);
        if (keyboard != null) {
            keyboard.setOnClickListener(this);
        }
        pictureView = (Button) findViewById(R.id.picture_view);
        if (pictureView != null) {
            pictureView.setOnClickListener(this);
        }
        loading = (Button) findViewById(R.id.loading_tip);
        if (loading != null) {
            loading.setOnClickListener(this);
        }
        download = (Button) findViewById(R.id.download);
        if (download != null) {
            download.setOnClickListener(this);
        }
        satelite = (Button) findViewById(R.id.satelite_menu);
        if (satelite != null) {
            satelite.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent();
        switch (id){
            case R.id.login:
                intent.setClass(MainActivity.this,LoginActivity.class);
                break;
            case R.id.guide:
                intent.setClass(MainActivity.this,GuideActivity.class);
                break;
            case R.id.navigation_drawer:
                intent.setClass(MainActivity.this,NavigationDrawerActivity.class);
                break;
            case R.id.navigation_tab:
                intent.setClass(MainActivity.this,NavigationTabActivity.class);
                break;
            case R.id.navigation_content:
                intent.setClass(MainActivity.this,NavigationContentActivity.class);
                break;
            case R.id.content_flow:
                intent.setClass(MainActivity.this,ContentFlowActivity.class);
                break;
            case R.id.content_list:
                intent.setClass(MainActivity.this,ContentListActivity.class);
                break;
            case R.id.content_waterfall:
                intent.setClass(MainActivity.this,ContentWaterfallActivity.class);
                break;
            case R.id.keyboard:
                intent.setClass(MainActivity.this,KeyboardActivity.class);
                break;
            case R.id.picture_view:
                intent.setClass(MainActivity.this,PictureViewActivity.class);
                break;
            case R.id.loading_tip:
                intent.setClass(MainActivity.this,LoadingActivity.class);
                break;
            case R.id.download:
                intent.setClass(MainActivity.this,DownloadActivity.class);
                break;
            case R.id.satelite_menu:
                intent.setClass(MainActivity.this,SateliteMenuActivity.class);
                break;
        }
        startActivity(intent);
    }
}
