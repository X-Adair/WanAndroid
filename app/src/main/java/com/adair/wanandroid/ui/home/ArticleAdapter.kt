package com.adair.wanandroid.ui.home

import com.adair.wanandroid.R
import com.adair.wanandroid.entity.Article
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * 文章列表适配器
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/8/17
 */
class ArticleAdapter(layoutResId: Int, data: MutableList<Article>? = null) :
    BaseQuickAdapter<Article, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder, item: Article) {
        holder.setText(R.id.tvTitle, item.title)
    }
}