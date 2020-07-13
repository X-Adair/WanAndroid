package com.adair.net.exception

/**
 *  请求错误信息
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/8
 */
open class ApiException constructor(var code: Int, val errorMessage: String, e: Throwable? = null) : Exception() {}