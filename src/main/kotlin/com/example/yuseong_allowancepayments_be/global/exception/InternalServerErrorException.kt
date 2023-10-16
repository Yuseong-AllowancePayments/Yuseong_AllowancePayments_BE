package com.example.yuseong_allowancepayments_be.global.exception

import com.example.yuseong_allowancepayments_be.global.error.CustomException
import com.example.yuseong_allowancepayments_be.global.error.ErrorCode

class InternalServerErrorException private constructor() : CustomException(ErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }

}