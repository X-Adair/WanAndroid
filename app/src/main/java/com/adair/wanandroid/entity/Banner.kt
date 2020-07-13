package com.adair.wanandroid.entity

/**
 * 主页banner对象
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/7
 */
data class Banner(
    val id: Int,
    val type: Int,
    val desc: String,
    val title: String,
    val imagePath: String,
    val url: String,
    val isVisible: Int,
    val order: Int
)