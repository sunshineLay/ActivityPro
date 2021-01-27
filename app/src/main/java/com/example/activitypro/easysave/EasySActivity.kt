package com.example.activitypro.easysave

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.activitypro.R
import com.example.activitypro.adapter.MainClidItemDecoration
import com.example.activitypro.databinding.ActivityBxBinding

/**
 * @TODO:
 * @Date: 2021/1/27 11:25
 * @User: lay
 */
class EasySActivity : AppCompatActivity() {

    companion object{
        private const val NAME_KEY = "NAME_KEY"
        private var TAG = EasySActivity.javaClass.name
    }
    private lateinit var bxBinding: ActivityBxBinding
    private lateinit var testCmdList : ArrayList<TestCmd>
    private var nameString: String? = null

    private val recyclerView: RecyclerView
        get() = bxBinding.recyTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bxBinding = ActivityBxBinding.inflate(layoutInflater)
        setContentView(bxBinding.root)
        nameString = savedInstanceState?.getString(NAME_KEY)
        bxBinding.etName?.setText(nameString)
        initUI()
        Log.e(TAG, "onCreate: nameString"+nameString)
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: " )
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: " )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: " )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: " )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: " )
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: " )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(NAME_KEY,bxBinding.etName.text.toString())
        }
        super.onSaveInstanceState(outState)
        Log.e(TAG, "onSaveInstanceState: " )
        Log.e(TAG, "onSaveInstanceState: text " +bxBinding.etName.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bxBinding.etName.setText(savedInstanceState.getString(NAME_KEY)+2)
        Log.e(TAG, "onRestoreInstanceState: " )

    }

    private fun initUI() {
        initData()
        initRecyclerView()
    }

    private fun initData() {
        testCmdList = ArrayList<TestCmd>()
        for (i in 1..100){
            val testCmd = TestCmd()
            testCmd.name = "lay+$i"
            testCmdList.add(testCmd)
        }
    }




    private fun initRecyclerView() {
        bxBinding.run {
            recyTest.layoutManager = LinearLayoutManager(this@EasySActivity)
            recyTest.adapter = NewEasySaveAdapter(testCmdList,this@EasySActivity, R.layout.bx_item)
            if(recyTest.itemDecorationCount == 0){
                recyTest.addItemDecoration(MainClidItemDecoration(this@EasySActivity,R.drawable.itemdecoration))
            }
        }

    }
}