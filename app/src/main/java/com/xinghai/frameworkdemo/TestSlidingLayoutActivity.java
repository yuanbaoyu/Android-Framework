package com.xinghai.frameworkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TestSlidingLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sliding_layout);
    }

    public void toWebView(View view){
        startActivity(new Intent(this, WebViewActivity.class));
    }

    public void toListView(View view){
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void toRecyclerView(View view){
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
