package com.adair.wanandroid.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adair.glide.GlideApp
import com.adair.wanandroid.R.layout.item_home_banner
import com.adair.wanandroid.entity.BannerEntity
import com.youth.banner.adapter.BannerAdapter
import kotlinx.android.synthetic.main.item_home_banner.view.*

/**
 *
 * 主页banner适配器
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/8/18
 */
class HomeBannerAdapter(data: List<BannerEntity>) :
    BannerAdapter<BannerEntity, BannerViewHolder>(data) {

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(item_home_banner,
            parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindView(
        holder: BannerViewHolder?,
        data: BannerEntity?,
        position: Int,
        size: Int
    ) {
        GlideApp.with(holder!!.itemView.context)
            .load(data!!.imagePath)
            .into(holder.itemView.ivCover)
        holder.itemView.tvTitle.text = data.title
    }
}

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
