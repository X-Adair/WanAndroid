package com.adair.net

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

/**
 * 扩展函数
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/8
 */

fun <T> ViewModel.launcher(buildRequest: Request<T>.() -> Unit) {
    Request<T>().apply(buildRequest)
            .request(viewModelScope)
}