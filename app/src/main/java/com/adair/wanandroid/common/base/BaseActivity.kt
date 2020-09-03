package com.adair.wanandroid.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * App Activity基础类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/18
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}