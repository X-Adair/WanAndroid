package com.adair.wanandroid.common.extends

import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * Activity 扩展
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/18
 */

fun AppCompatActivity.hideBottomUi() {
    val decorView = window.decorView
    val uiOptions =
        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN
    decorView.systemUiVisibility = uiOptions
}