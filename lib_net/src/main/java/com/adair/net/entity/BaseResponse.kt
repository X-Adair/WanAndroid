package com.adair.net.entity

import com.adair.net.exception.ServiceUnknownException

/**
 *
 *  服务器基础数据结构交互类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/6
 */
open class BaseResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T) {

    open fun isSuccessful(): Boolean {
        return errorCode == 0
    }

    open fun coverData(): T {
        if (isSuccessful()) {
            return data
        }
        throw ServiceUnknownException(errorCode, errorMsg)
    }
}