package com.xinghai.frameworkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xinghai.framework.common.adapter.CommonAdapter;
import com.xinghai.framework.common.adapter.ViewHolder;
import com.xinghai.framework.wrapper.EmptyWrapper;
import com.xinghai.frameworkdemo.baseadapterdemo.MultiItemRvActivity;
import com.xinghai.frameworkdemo.baseadapterdemo.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBaseAdapterActivity extends AppCompatActivity
{
    private List<String> mDatas = new ArrayList<>(Arrays.asList("RecyclerView",
            "MultiItem RecyclerView"));
    private RecyclerView mRecyclerView;

    private CommonAdapter<String> mAdapter;

    private View mEmptyView ;
    private EmptyWrapper mEmptyWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        mRecyclerView = ((RecyclerView) findViewById(R.id.id_listview_list));
        mEmptyView = findViewById(R.id.id_empty_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new CommonAdapter<String>(this, R.layout.item_list, mDatas)
        {
            @Override
            public void convert(ViewHolder holder, String o, final int pos)
            {
                holder.setText(R.id.id_item_list_title, o);
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = null;
                        switch (pos)
                        {
                            case 0:
                                intent = new Intent(TestBaseAdapterActivity.this, RecyclerViewActivity.class);
                                break;
                            case 1:
                                intent = new Intent(TestBaseAdapterActivity.this, MultiItemRvActivity.class);
                                break;

                        }
                        if (intent != null)
                            startActivity(intent);
                    }
                });
            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView)
            {
                super.onViewHolderCreated(holder, itemView);
            }
        });

        mEmptyWrapper = new EmptyWrapper(mAdapter);
        mEmptyWrapper.setEmptyView(mEmptyView);

    }


}
