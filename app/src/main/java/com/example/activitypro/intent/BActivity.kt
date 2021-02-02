package com.example.activitypro.intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activitypro.databinding.ActivityMainBinding

/**
 * @TODO:
 * @Date: 2021/1/27 14:31
 * @User: lay
 */
class BActivity : AppCompatActivity() {
    companion object{
        private val TAG = BActivity::class.java.name
        const val BPUT_KEY = "PUT_KEY"
        const val RESULT_CODE = 0x02
    }

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initData()
        Log.e(TAG, "onCreate: BActivity" )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.e(TAG, "onBackPressed: "+"返回" )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "onSaveInstanceState: " )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG, "onRestoreInstanceState: " )
    }

    private fun initData() {
        val intent = intent
        val stringExtra = intent.getStringExtra(AActivity.PUT_KEY)
        mainBinding.tvContent.setText(stringExtra)
        mainBinding.tvContent.setOnClickListener {
            val intent = Intent(this, AActivity::class.java)
            intent.putExtra(BPUT_KEY,"完成+1")
            setResult(RESULT_CODE,intent)
            finish()
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: BActivity" )
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: BActivity" )
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: BActivity" )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: BActivity" )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: BActivity" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: BActivity" )
    }


}