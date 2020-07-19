package com.adair.wanandroid.api

import com.adair.wanandroid.entity.Banner
import com.adair.wanandroid.model.WanModel
import retrofit2.http.GET

/**
 *
 * 主页接口
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/7
 */
interface HomeService {

    @GET("/banner/json")
    suspend fun getBanner(): WanModel<List<Banner>>
}