package com.adair.wanandroid.app

import android.app.Application
import com.adair.net.RetrofitFactory
import com.adair.wanandroid.di.otherModule
import com.adair.wanandroid.di.repoModule
import com.adair.wanandroid.di.viewModelModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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
        Logger.addLogAdapter(AndroidLogAdapter())
        RetrofitFactory.init("https://www.wanandroid.com")
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            androidFileProperties()
            modules(otherModule, repoModule, viewModelModule)
        }
    }
}