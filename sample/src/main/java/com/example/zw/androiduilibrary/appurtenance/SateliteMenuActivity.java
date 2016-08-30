package com.example.zw.androiduilibrary.appurtenance;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zw.androiduilibrary.R;
import com.example.zw.library.appurtenance.SatelliteMenu;
import com.example.zw.library.appurtenance.SatelliteMenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lujinxin on 16/8/27.
 */
public class SateliteMenuActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satellitemenu);
        SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);
        List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
        items.add(new SatelliteMenuItem(1,R.mipmap.ic_launcher));
        items.add(new SatelliteMenuItem(2,R.mipmap.ic_launcher));
        items.add(new SatelliteMenuItem(3,R.mipmap.ic_launcher));
        items.add(new SatelliteMenuItem(4,R.mipmap.ic_launcher));
        items.add(new SatelliteMenuItem(5,R.mipmap.ic_launcher));
        items.add(new SatelliteMenuItem(6,R.mipmap.ic_launcher));
        menu.addItems(items);
        menu.setOnItemClickedListener(new SatelliteMenu.SateliteClickedListener(){

            @Override
            public void eventOccured(int id) {
                Toast.makeText(SateliteMenuActivity.this,id,Toast.LENGTH_LONG).show();
            }
        });

    }
}
