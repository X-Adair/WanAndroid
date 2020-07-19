package com.adair.wanandroid.model

import com.adair.net.model.BaseModel
import com.adair.net.exception.NotLoginException
import com.adair.net.exception.ServiceUnknownException


class WanModel<out T>(errorCode: Int, errorMsg: String, data: T) : BaseModel<T>(
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