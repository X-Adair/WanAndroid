package com.adair.wanandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.adair.wanandroid.R
import com.orhanobut.logger.Logger
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        homeViewModel.loadBanner()
    }


    private fun initViews() {
        homeViewModel.getBannerData()
                .observe(viewLifecycleOwner, Observer {
                    Logger.d(it)
                })
    }

}