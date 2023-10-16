package com.example.yuseong_allowancepayments_be.global.exception

import com.example.yuseong_allowancepayments_be.global.error.CustomException
import com.example.yuseong_allowancepayments_be.global.error.ErrorCode

object InvalidTokenException : CustomException(ErrorCode.INVALID_TOKEN) {

    val EXCEPTION = InvalidTokenException

}