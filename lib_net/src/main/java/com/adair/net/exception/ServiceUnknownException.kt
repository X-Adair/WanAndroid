package com.adair.net.exception

/**
 * 服务器异常
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/8
 */
class ServiceUnknownException(code: Int, errorMessage: String) : ApiException(code, errorMessage) {}