package com.example.activitydemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//还和架构无关的时候BaseActivity应该做到的事情
// 1. 生命周期的log
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    abstract fun initUI()

    override fun onRestart() {
        super.onRestart()
    }

}