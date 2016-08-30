package com.example.zw.androiduilibrary.appurtenance;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zw.androiduilibrary.R;
import com.example.zw.library.appurtenance.ImageView;

/**
 * Created by lujinxin on 16/8/27.
 */
public class PictureViewActivity extends Activity implements ImageView.Listener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictureview);
        ImageView imageView = (ImageView) findViewById(R.id.imageview);
        imageView.setListener(this);
    }

    @Override
    public void onClick() {
        Toast.makeText(this,"singleclick",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDoubleClick() {
        Toast.makeText(this,"doubleclick",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLongClick() {
        Toast.makeText(this,"longclick",Toast.LENGTH_LONG).show();
    }
}
