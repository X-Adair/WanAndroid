package com.adair.net.exception

/**
 * 空数据异常
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/8
 */
class EmptyDataException(code: Int, errorMessage: String) : ApiException(code, errorMessage)