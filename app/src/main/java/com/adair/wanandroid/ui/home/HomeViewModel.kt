package com.adair.wanandroid.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
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

    val bannerData = liveData<Result<List<BannerEntity>>> {
        emit(Result.Loading)
        try {
            val data = homeRepository.getBanner()
            emit(Result.Success(data))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    val bannerDataV2: LiveData<Result<List<BannerEntity>>> = homeRepository.getBannerV2()
        .onStart {
            emit(Result.Loading)
        }
        .catch { e ->
            emit(Result.Error(e))
        }
        .asLiveData()
}