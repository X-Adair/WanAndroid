package com.adair.net.model

/**
 * 网络请求结果密封类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
sealed class Result<out T> {

    object Loading : Result<Nothing>()

    data class Success<out T>(val data: T) : Result<T>()

    data class Error(val throwable: Throwable) : Result<Nothing>()
}