package com.adair.net

import com.adair.net.exception.EmptyDataException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 数据请求类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/8
 */
class Request<T> {
    private var onStart: (() -> Unit)? = null
    private lateinit var onRequest: suspend () -> T
    private var onSuccess: ((T) -> Unit)? = null
    private var onEmpty: (() -> Unit)? = null
    private var onError: ((Exception) -> Unit)? = null
    private var onComplete: (() -> Unit)? = null

    infix fun onStart(onStart: (() -> Unit)?) {
        this.onStart = onStart
    }

    infix fun onRequest(onRequest: suspend () -> T) {
        this.onRequest = onRequest
    }

    infix fun onSuccess(onSuccess: ((T) -> Unit)?) {
        this.onSuccess = onSuccess
    }

    infix fun onEmpty(onEmpty: (() -> Unit)?) {
        this.onEmpty = onEmpty
    }

    infix fun onError(onError: ((Exception) -> Unit)?) {
        this.onError = onError
    }

    infix fun onComplete(onComplete: (() -> Unit)?) {
        this.onComplete = onComplete
    }

    fun request(coroutineScope: CoroutineScope) {
        coroutineScope.launch(context = Dispatchers.Main) {
            onStart?.invoke()
            try {
                val result = onRequest.invoke()
                onSuccess?.invoke(result)
            } catch (e: Exception) {
                when (e) {
                    is EmptyDataException -> onEmpty?.invoke()
                    else -> onError?.invoke(e)
                }
            } finally {
                onComplete?.invoke()
            }
        }
    }
}