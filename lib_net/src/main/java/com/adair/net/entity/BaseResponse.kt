package com.adair.net.entity

import com.adair.net.exception.NotLoginException
import com.adair.net.exception.ServiceUnknownException

/**
 *
 *  服务器基础数据结构交互类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/6
 */
data class BaseResponse<out T>(val code: Int, val message: String, val data: T) {

    fun coverData(): T {
        if (code == 0) {
            return data
        }
        if (code == -1001) {
            throw NotLoginException(code, message)
        }
        throw ServiceUnknownException(code, message)
    }
}