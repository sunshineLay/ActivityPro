package com.example.activitypro.easysave;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.activitypro.R;
import com.example.activitypro.adapter.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * @TODO:
 * @Date: 2021/1/27 10:47
 * @User: lay
 */
public class NewEasySaveAdapter extends BaseRecyclerViewAdapter<TestCmd> {


    public NewEasySaveAdapter(List<TestCmd> testCmds, Context mContext, int layId) {
        super(testCmds, mContext, layId);
    }

    @Override
    public void convert(ViewHolder holder, TestCmd itemData) {
        holder.setText(R.id.tv_con,itemData.getName());
        holder.getViewAtId(R.id.lin_con).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ItemActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
}
