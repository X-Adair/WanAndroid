package com.adair.wanandroid.api

import com.adair.net.entity.BaseResponse
import com.adair.wanandroid.entity.Banner
import retrofit2.http.GET

/**
 *
 * 主页接口
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/7
 */
interface HomeService {

    @GET("/banner/json1")
    suspend fun getBanner(): BaseResponse<List<Banner>>
}