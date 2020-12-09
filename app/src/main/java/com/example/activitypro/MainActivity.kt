package com.example.activitypro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitypro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TEXT_VIEW_CONTENT
        get() = "textContent"

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    //恢复
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mainBinding.tvContent.text = savedInstanceState.getString(TEXT_VIEW_CONTENT)
    }

    //保存
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putString(TEXT_VIEW_CONTENT,mainBinding.tvContent.text.toString())
        }
    }

}