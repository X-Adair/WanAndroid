package com.adair.wanandroid.ui.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.adair.wanandroid.common.base.BaseAndroidViewModel
import com.adair.wanandroid.entity.Banner
import com.orhanobut.logger.Logger
import kotlinx.coroutines.GlobalScope

/**
 * 主页ViewModel
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
class HomeViewModel(application: Application, private val homeRepository: HomeRepository) :
    BaseAndroidViewModel(application) {

    private val bannerData = MutableLiveData<List<Banner>>()

    fun getBannerData(): MutableLiveData<List<Banner>> {
        return bannerData
    }

    fun loadBanner() {
        launcher<List<Banner>>(GlobalScope) {

            onStart {
                Logger.d("开始请求数据")
            }

            onRequest {
                homeRepository.getBanner()
            }

            onSuccess {
                bannerData.value = it
            }

            onError {
                Logger.e(it, "错误：")
            }

            onComplete {
                Logger.d("请求数据完成")
            }
        }
    }
}