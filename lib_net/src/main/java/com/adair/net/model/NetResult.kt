package com.adair.net.model

import java.lang.Exception

/**
 * 网络请求结果密封类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
sealed class NetResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : NetResult<T>()

    data class Error(val exception: Exception) : NetResult<Nothing>()
}