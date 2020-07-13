package com.adair.net

import android.text.TextUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * retrofit 初始化管理类
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/6
 */
class RetrofitFactory private constructor() {

    private var retrofit: Retrofit

    companion object {
        private var HTTP_BASE_URL = ""
        private var CONNECT_TIMEOUT: Long = 10
        private var READ_TIMEOUT: Long = 10
        private var WRITE_TIMEOUT: Long = 10

        fun init(baseUrl: String, connectTimeOut: Long, readTimeOut: Long, writeTimeout: Long) {
            HTTP_BASE_URL = baseUrl
            CONNECT_TIMEOUT = connectTimeOut
            READ_TIMEOUT = readTimeOut
            WRITE_TIMEOUT = writeTimeout
        }

        fun init(baseUrl: String) {
            HTTP_BASE_URL = baseUrl
        }

        val INSTANCE: RetrofitFactory by lazy { RetrofitFactory() }
    }

    init {
        if (TextUtils.isEmpty(HTTP_BASE_URL)) {
            throw RuntimeException("RetrofitFactory is not initialized,pleas call RetrofitFactory.init() in application.onCreate()...")
        }
        retrofit = Retrofit.Builder()
                .baseUrl(HTTP_BASE_URL)
                .client(initOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    private fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build()
    }

    private fun initLogInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }
        return loggingInterceptor
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}