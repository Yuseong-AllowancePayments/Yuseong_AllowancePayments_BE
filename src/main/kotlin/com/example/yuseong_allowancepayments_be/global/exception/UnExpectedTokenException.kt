package com.example.yuseong_allowancepayments_be.global.exception

import com.example.yuseong_allowancepayments_be.global.error.CustomException
import com.example.yuseong_allowancepayments_be.global.error.ErrorCode

object UnExpectedTokenException : CustomException(ErrorCode.UNEXPECTED_TOKEN) {

    val EXCEPTION = UnExpectedTokenException

}