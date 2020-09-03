package com.adair.wanandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.adair.net.model.Result
import com.adair.wanandroid.R
import com.orhanobut.logger.Logger
import com.youth.banner.Banner
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
class HomeFragment : Fragment() {


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var banner: Banner<com.adair.wanandroid.entity.BannerEntity, HomeBannerAdapter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }


    private fun initViews() {
        homeViewModel.bannerData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Loading -> {
                    Logger.d("加载中")
                }

                is Result.Success -> {
                    Logger.d(it.data.toString())
                }
                is Result.Error -> {
                    Logger.e(it.throwable, it.throwable.message+"")
                }
            }
        })

        homeViewModel.bannerDataV2.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Loading -> {
                    Logger.d("加载中")
                }

                is Result.Success -> {
                    Logger.d(it.data.toString())
                }
                is Result.Error -> {
                    Logger.e(it.throwable, "")
                }
            }
        })
    }


}