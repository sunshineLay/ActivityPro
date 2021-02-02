package com.example.activitypro


import android.content.Intent
import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.activitypro.intent.AActivity
import com.example.activitypro.intent.BActivity
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith


/**
 * @TODO:
 * @Date: 2021/1/28 11:59
 * @User: lay
 */
@RunWith(AndroidJUnit4::class)
class MyTestSuite {
    @get:Rule val activityScenarioRule = ActivityScenarioRule<AActivity>(AActivity::class.java)
     val TAG = "MyTestSuite"
    @Test
    fun testEvent() {
        //写法一：直接使用AScenario
        val scenario = ActivityScenario.launch(AActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
       scenario.onActivity { activity ->
           val intent = Intent(activity, BActivity::class.java)
           intent.putExtra(AActivity.PUT_KEY,"刘安异")
           startActivity(activity,intent,null)
       }
        val state = scenario.state
        Log.e(TAG, "testEvent: state " + state )
        scenario.close()
    }

    @Test
    fun testActivityCreate(){
        //写法二: 使用ActivityScenarioRule
//        val scenario = activityScenarioRule.scenario
        val scenario = ActivityScenario.launch(AActivity::class.java)
        scenario.onActivity { activity ->
            onView(withId(R.id.btn_jump)).perform(click())
        }
//        val state = scenario.state
//        Log.e(TAG, "testEvent: state " + state )
        scenario.close()
    }

    @Test
    fun testReCreate(){
        val scenario = activityScenarioRule.scenario
        scenario.recreate()
        Log.e(TAG, "testEvent: state " + scenario.state )
        scenario.close()
    }

    @Test
    fun testResult(){
        val scenario = activityScenarioRule.scenario
        scenario.onActivity { activity ->
            val intent = Intent(activity, BActivity::class.java)
            intent.putExtra(AActivity.PUT_KEY,"刘安异")
            startActivity(activity,intent,null)
        }
        val resultCode = scenario.result.resultCode
        val resultData = scenario.result.resultData
        Log.e(TAG, "testEvent: state " + scenario.state )
        Log.e(TAG, "testEvent: code " + resultCode )
        Log.e(TAG, "testEvent: data " + resultData )
        scenario.close()
    }

}