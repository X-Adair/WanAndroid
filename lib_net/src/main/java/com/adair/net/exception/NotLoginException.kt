package com.adair.net.exception

/**
 * 未登录异常
 *
 * @author XuShuai
 * @version v1.0
 * @date 2020/7/8
 */
class NotLoginException(code: Int, errorMessage: String) : ApiException(code, errorMessage) {}