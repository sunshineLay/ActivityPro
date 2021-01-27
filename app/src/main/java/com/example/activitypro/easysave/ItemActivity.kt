package com.example.activitypro.easysave

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activitypro.databinding.ActivityMainBinding

/**
 * @TODO:
 * @Date: 2021/1/27 11:18
 * @User: lay
 */
class ItemActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    companion object{
        private var TAG = EasySActivity.javaClass.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "ItemActivity - onCreate: " )
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.tvContent.setOnClickListener { finish() }
    }
    override fun onStart() {
        super.onStart()
        Log.e(TAG, "ItemActivity - onStart: " )
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "ItemActivity - onResume: " )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "ItemActivity - onPause: " )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "ItemActivity - onStop: " )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "ItemActivity - onDestroy: " )
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "ItemActivity - onRestart: " )
    }

}