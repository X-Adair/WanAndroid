package com.adair.wanandroid.entity

/**
 * 主页banner对象
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/7
 */
data class BannerEntity(
    var id: Int,
    var type: Int,
    var desc: String,
    var title: String,
    var imagePath: String,
    var url: String,
    var isVisible: Int,
    var order: Int
)