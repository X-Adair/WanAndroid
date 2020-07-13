package com.adair.wanandroid.app

import android.app.Application
import com.adair.net.RetrofitFactory

/**
 *
 * 自定义Application
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/7
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitFactory.init("https://www.wanandroid.com")
    }
}