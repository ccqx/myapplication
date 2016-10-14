package com.bruce.test.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    PullToRefreshListView mLvNews;
    ListMatchAdapter mAdapter;
    List<String> listNews;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNews = new ArrayList<String>();
        listNews.add("111");
        listNews.add("222");
        listNews.add("333");
        listNews.add("444");
        mLvNews=(PullToRefreshListView)findViewById(R.id.listview);
        mAdapter = new ListMatchAdapter(this, listNews);
        mLvNews.setAdapter(mAdapter);
        mLvNews.setMode(PullToRefreshBase.Mode.BOTH);

        mLvNews.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                listNews.clear();
                listNews.add("111");
                listNews.add("222");
                listNews.add("333");
                listNews.add("444");
                mAdapter.notifyDataSetChanged();
                mLvNews.post(new Runnable() {
                    @Override
                    public void run() {
                        mLvNews.onRefreshComplete();
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                listNews.add("111");
                listNews.add("222");
                listNews.add("333");
                listNews.add("444");
                mAdapter.notifyDataSetChanged();
                mLvNews.post(new Runnable() {
                    @Override
                    public void run() {
                        mLvNews.onRefreshComplete();
                    }
                });
            }
        });
    }
}
