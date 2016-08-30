package com.example.zw.androiduilibrary.content;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.zw.androiduilibrary.R;
import com.example.zw.library.content.PullToRefreshListView;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by lujinxin on 16/8/27.
 */
public class ContentListActivity extends Activity{
    private LinkedList<String> mListItems;
    PullToRefreshListView pullToRefreshListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentlist);
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.list);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });

        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mListItems);

        pullToRefreshListView.setAdapter(adapter);
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                ;
            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {
            mListItems.addFirst("Added after refresh...");

            // Call onRefreshComplete when the list has been refreshed.
            pullToRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }

    private String[] mStrings = {
            "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam",
            "Abondance", "Ackawi", "Acorn", "Adelost", "Affidelice au Chablis",
            "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};

}
