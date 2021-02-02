package com.example.activitypro.intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.activitypro.databinding.ActivityIntentBinding


/**
 * @TODO:
 * @Date: 2021/1/27 14:24
 * @User: lay
 */
class AActivity : AppCompatActivity() {
    companion object{
        private val TAG = AActivity::class.java.name
        private const val REQUEST_CODE = 0x01
        const val PUT_KEY = "PUT_KEY"
    }
    private lateinit var intentBinding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intentBinding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(intentBinding.root)
        initOnClick()
        Log.e(TAG, "onCreate: AActivity" )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.e(TAG, "onBackPressed: 返回" )
    }

    private fun initOnClick() {
        intentBinding.btnJump.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, BActivity::class.java)
            intent.putExtra(PUT_KEY,"刘安异")
            startActivityForResult(intent, REQUEST_CODE)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_CODE ->
                if(resultCode == BActivity.RESULT_CODE){
                    val stringExtra = data?.getStringExtra(BActivity.BPUT_KEY)
                    intentBinding.tvCon.setText(stringExtra)
                }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "onSaveInstanceState: " )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG, "onRestoreInstanceState: " )
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: AActivity" )
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: AActivity " )
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: AActivity" )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: AActivity" )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: AActivity" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: AActivity" )
    }
}