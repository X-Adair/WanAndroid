package com.adair.wanandroid.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.adair.net.model.Result
import com.adair.wanandroid.common.base.BaseAndroidViewModel
import com.adair.wanandroid.entity.BannerEntity
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart

/**
 * 主页ViewModel
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
class HomeViewModel(application: Application, private val homeRepository: HomeRepository) :
    BaseAndroidViewModel(application) {

    val bannerData: LiveData<Result<List<BannerEntity>>>

    init {
        bannerData = homeRepository.getBanner()
            .onStart {
                emit(Result.Loading)
            }
            .catch { e ->
                emit(Result.Error(e))
            }
            .asLiveData()
    }
}