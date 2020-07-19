package com.adair.wanandroid.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.adair.wanandroid.R
import com.adair.wanandroid.common.extends.hideBottomUi
import com.adair.wanandroid.common.extends.postDelayed2

/**
 * 欢迎页
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/15
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        hideBottomUi()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed2(2000L) {
            toMain()
            finish()
        }
    }


    private fun toMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}