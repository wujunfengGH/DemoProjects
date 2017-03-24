package com.example.vincent.wxphotodemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @创建者 Vincent
 * @创时间 2017/3/22
 * @描述 ${TODO}
 */

public class SecondActivity extends Activity {

    private RecyclerView mRecyclerView;
    private SecondAdapter mSecondAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mRecyclerView = (RecyclerView) findViewById(R.id.second_recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(this).setSpace(14).setSpaceColor(0xFFECECEC));
        mSecondAdapter = new SecondAdapter(this);
        mRecyclerView.setAdapter(mSecondAdapter);
    }
}
