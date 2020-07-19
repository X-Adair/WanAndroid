package com.adair.wanandroid.common.base

import com.adair.net.model.NetResult
import java.lang.Exception

/**
 * 基础数据仓库
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/19
 */
open class BaseRepository {

    /**
     * 拦截请求结果，无论正确或者错误，转化为NetResult对象，方便还需要结果做后续操作（比如:网络返回错误，需要返回本地数据）
     */
    suspend fun <T : Any> handlerModel(request: suspend () -> T): NetResult<T> {
        return try {
            NetResult.Success(request.invoke())
        } catch (e: Exception) {
            NetResult.Error(e)
        }
    }
}