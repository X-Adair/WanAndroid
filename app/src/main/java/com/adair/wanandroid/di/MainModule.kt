package com.adair.wanandroid.di

import com.adair.net.RetrofitFactory
import com.adair.wanandroid.api.HomeService
import com.adair.wanandroid.ui.home.HomeRepository
import com.adair.wanandroid.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * koin依赖注入 module
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */

val otherModule = module {
    single { RetrofitFactory.INSTANCE }
    single { RetrofitFactory.INSTANCE.create(HomeService::class.java) }
}

val repoModule = module {
    single { HomeRepository(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
}