package com.example.activitydemo.base

import android.os.Bundle
import android.view.SearchEvent
import androidx.appcompat.app.AppCompatActivity
import com.safframework.log.L


//还和架构无关的时候BaseActivity应该做到的事情
// 1. 生命周期的log - log 框架的问题 - 不能直接得到当前方法名
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        L.i("onCreate()")
    }

    abstract fun initUI()

    override fun onRestart() {
        super.onRestart()
        L.i("onRestart()")
    }

    override fun onStart() {
        super.onStart()
        L.i("onStart()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        L.i("onRestoreInstanceState()")
    }

    override fun onResume() {
        super.onResume()
        L.i("onResume()")
    }

    override fun onPause() {
        super.onPause()
        L.i("onPause()")
    }

    override fun onStop() {
        super.onStop()
        L.i("onStop()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        L.i("onSaveInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        L.i("onDestroy()")
    }

}