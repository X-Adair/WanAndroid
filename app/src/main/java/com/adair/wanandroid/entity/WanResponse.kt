package com.adair.wanandroid.entity

import com.adair.net.entity.BaseResponse
import com.adair.net.exception.NotLoginException
import com.adair.net.exception.ServiceUnknownException


class WanResponse<out T>(errorCode: Int, errorMsg: String, data: T) : BaseResponse<T>(
    errorCode, errorMsg, data
) {
    companion object {
        const val ERROR_NOT_LOGIN = -1001
    }

    override fun coverData(): T {
        if (isSuccessful()) {
            return data
        }
        if (errorCode == ERROR_NOT_LOGIN) {
            throw NotLoginException(errorCode, errorMsg)
        }
        throw ServiceUnknownException(errorCode, errorMsg)
    }
}