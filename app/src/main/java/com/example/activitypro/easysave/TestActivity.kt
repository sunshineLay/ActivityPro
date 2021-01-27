package com.example.activitypro.easysave

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activitypro.databinding.ActivityBxBinding

/**
 * @TODO:
 * @Date: 2021/1/27 13:04
 * @User: lay
 */
class TestActivity : AppCompatActivity() {
    private var stateString: String? = null
    private var bxBinding: ActivityBxBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bxBinding = ActivityBxBinding.inflate(layoutInflater)
        setContentView(bxBinding!!.root)
        //初始化就必须实现的信息，在这一步恢复 - 恢复节点一号
        stateString = savedInstanceState?.getString(NAME_KEY)
        bxBinding?.etName?.setText(stateString)
    }

    companion object {
        private const val NAME_KEY = "NAME_KEY"
    }
}