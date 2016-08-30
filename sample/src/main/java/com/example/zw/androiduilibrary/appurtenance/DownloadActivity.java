package com.example.zw.androiduilibrary.appurtenance;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.zw.androiduilibrary.R;
import com.example.zw.library.appurtenance.ProgressButton;

/**
 * Created by lujinxin on 16/8/27.
 */
public class DownloadActivity extends Activity{
    static ProgressButton progressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_download);
        progressButton = (ProgressButton) findViewById(R.id.download);
        progressButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                progressButton.animation(); //Need to call this method for animation and progression

                if (progressButton.flg_frmwrk_mode == 1) {

                    //Start state. Call any method that you want to execute

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            Toast.makeText(DownloadActivity.this,
                                    "Starting download", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                    new DownLoadSigTask().execute();
                }
                if (progressButton.flg_frmwrk_mode == 2) {

                    //Running state. Call any method that you want to execute

                    new DownLoadSigTask().cancel(true);
                    progressButton.reset();
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            Toast.makeText(DownloadActivity.this,
                                    "Download stopped", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                }
                if (progressButton.flg_frmwrk_mode == 3) {

                    //End state. Call any method that you want to execute.

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            Toast.makeText(DownloadActivity.this,
                                    "Download complete", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                }
            }
        });

    }

    static class DownLoadSigTask extends AsyncTask<String, Integer, String> {


        @Override
        protected void onPreExecute() {

        }


        @Override
        protected String doInBackground(final String... args) {

            //Creating dummy task and updating progress

            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50);

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                publishProgress(i);

            }


            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... progress) {

            //publishing progress to progress arc

            progressButton.cusview.setupprogress(progress[0]);
        }
    }

}
