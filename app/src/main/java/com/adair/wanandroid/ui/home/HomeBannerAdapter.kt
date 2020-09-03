package com.adair.wanandroid.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adair.wanandroid.R
import com.adair.wanandroid.entity.BannerEntity
import com.youth.banner.adapter.BannerAdapter

/**
 *
 * 主页banner适配器
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/8/18
 */
class HomeBannerAdapter(data: MutableList<BannerEntity>) : BannerAdapter<BannerEntity, BannerViewHolder>(data) {
    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_home_article, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindView(holder: BannerViewHolder?, data: BannerEntity?, position: Int, size: Int) {

    }
}

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {

    }
}
