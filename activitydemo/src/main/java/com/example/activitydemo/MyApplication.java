package com.example.activitydemo;

import android.app.Application;
import android.content.Context;

/**
 * @TODO: 自定义MyApplication 不能是单例的写法，因为系统组件需要系统去初始化.
 * @Date: 2021/2/2 16:58
 * @User: lay
 */
    // 不要在这里缓存数据。
    // Application 执行顺序：构造函数 -> attachBaseContext() -> onCreate()
public class MyApplication extends Application {
    private static MyApplication myApp;

    public static MyApplication getInstance(){
        return myApp;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }
}
