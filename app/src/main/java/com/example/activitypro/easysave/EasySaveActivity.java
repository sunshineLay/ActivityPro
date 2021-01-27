package com.example.activitypro.easysave;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activitypro.R;
import com.example.activitypro.adapter.MainClidItemDecoration;
import com.example.activitypro.databinding.ActivityBxBinding;

import java.util.ArrayList;

/**
 * @TODO: 示例：简单数据的保存方法
 * @Date: 2021/1/27 9:08
 * @User: lay
 */
public class EasySaveActivity extends AppCompatActivity {

    private static final String NAME_KEY = "NAME_KEY";
    private ActivityBxBinding bxBinding;
    private RecyclerView recyTest;
    private ArrayList<TestCmd> testCmdArrayList;
    private NewEasySaveAdapter newEasySaveAdapter;
    private String stateString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bxBinding = ActivityBxBinding.inflate(getLayoutInflater());
        setContentView(bxBinding.getRoot());
        //初始化就必须实现的信息，在这一步恢复 - 恢复节点一号
        if(savedInstanceState !=null){
            stateString = savedInstanceState.getString(NAME_KEY);
            bxBinding.etName.setText(stateString+1);
        }
        initUI();
        initData();
        initRecyclerView();
    }

    private void initData() {
        testCmdArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TestCmd testCmd = new TestCmd();
            testCmd.setName("lay"+i);
            testCmdArrayList.add(testCmd);
        }
    }

    private void initUI() {
        recyTest = bxBinding.recyTest;
    }

    //保存节点
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(NAME_KEY,stateString);
        super.onSaveInstanceState(outState);
    }

    //恢复节点二号
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        bxBinding.etName.setText(savedInstanceState.getString(NAME_KEY)+2);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void initRecyclerView() {
        recyTest.setLayoutManager(new LinearLayoutManager(this));
        newEasySaveAdapter = new NewEasySaveAdapter(testCmdArrayList, this, R.layout.bx_item);
        recyTest.setAdapter(newEasySaveAdapter);
        if(recyTest.getItemDecorationCount() == 0){
            recyTest.addItemDecoration(new MainClidItemDecoration(this,R.drawable.itemdecoration));
        }
    }


}
