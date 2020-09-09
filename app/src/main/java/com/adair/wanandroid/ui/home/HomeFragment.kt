package com.adair.wanandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.adair.net.model.Result
import com.adair.wanandroid.R
import com.adair.wanandroid.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.header_home_banner.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
class HomeFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var bannerAdapter: HomeBannerAdapter

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

    override fun initViews(view: View, savedInstanceState: Bundle?) {
        val headerView = LayoutInflater.from(context).inflate(R.layout.header_home_banner, null)
        headerView.banner.apply {
            addBannerLifecycleObserver(viewLifecycleOwner)
        }

        articleAdapter = ArticleAdapter(R.layout.item_home_article)
        articleAdapter.addHeaderView(headerView)

        rvArticle.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = articleAdapter
        }

        homeViewModel.bannerData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Success -> {
                    bannerAdapter = HomeBannerAdapter(it.data)
                    headerView.banner.adapter = bannerAdapter
                }
            }
        })
    }
}