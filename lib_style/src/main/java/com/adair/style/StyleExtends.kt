package com.adair.style

import android.graphics.Color
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


/**
 * style相关扩展类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/14
 */

fun AppCompatActivity.immersionStyle() {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.statusBarColor = Color.TRANSPARENT
    window.navigationBarColor = Color.TRANSPARENT
}