package com.adair.wanandroid.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 带懒加载的fragment
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/8/11
 */
abstract class BaseLazyFragment : BaseFragment() {

    //是否完成View的初始化
    private var isViewOk = false

    //是否是第一次加载
    private var isFirst = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        isViewOk = true
        return view
    }


}