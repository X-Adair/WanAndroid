package com.adair.wanandroid.ui.home

import com.adair.net.RetrofitFactory
import com.adair.net.model.NetResult
import com.adair.wanandroid.api.HomeService
import com.adair.wanandroid.common.base.BaseRepository
import com.adair.wanandroid.entity.Banner

/**
 * home数据仓库
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
class HomeRepository constructor(private val retrofit: RetrofitFactory) : BaseRepository() {

    /**
     * 请求banner数据
     */
    suspend fun getBanner(): List<Banner> {
        return retrofit.create(HomeService::class.java)
                .getBanner()
                .coverData()
    }
}