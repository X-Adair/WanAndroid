package com.adair.glide

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 *
 * 基础AppGlideModel
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/13
 */
@GlideModule
class BaseAppGlideModel : AppGlideModule() {


    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}