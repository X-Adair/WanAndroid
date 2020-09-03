package com.adair.net.model

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/9/3
 */
data class Resource<out T>(val status: Status, val data: T?, val throwable: Throwable?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(throwable: Throwable?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, throwable)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null);
        }
    }
}