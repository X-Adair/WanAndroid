package com.adair.wanandroid.common.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewModelScope
import com.adair.net.Request
import kotlinx.coroutines.CoroutineScope

/**
 *
 * 基础ViewModel
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
open class BaseAndroidViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * 异步请求数据方法，可以请求网络数据和本地数据，默认在viewModelScoop生命周期执行
     */
    inline fun <T> launcher(coroutineScope: CoroutineScope = viewModelScope, buildRequest: Request<T>.() -> Unit) {
        Request<T>().apply(buildRequest)
                .request(coroutineScope)
    }
}