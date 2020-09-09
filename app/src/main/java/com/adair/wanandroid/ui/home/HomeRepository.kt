package com.adair.wanandroid.ui.home

import com.adair.net.model.Result
import com.adair.wanandroid.api.HomeService
import com.adair.wanandroid.common.base.BaseRepository
import com.adair.wanandroid.entity.BannerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * home数据仓库
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
class HomeRepository constructor(private val homeService: HomeService) : BaseRepository() {

    /**
     * 请求banner数据
     */
    fun getBanner(): Flow<Result<List<BannerEntity>>> {
        return flow<Result<List<BannerEntity>>> {
            val data = homeService
                .getBanner()
                .coverData()
            emit(Result.Success(data))
        }
    }
}