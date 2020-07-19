package com.adair.wanandroid.common.extends

import android.os.Handler


/**
 * Handler扩展类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/15
 */
fun Handler.postDelayed2(time: Long, run: () -> Unit) {
    postDelayed(run, time)
}