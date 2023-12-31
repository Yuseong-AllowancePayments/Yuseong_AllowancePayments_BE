package com.example.yuseong_allowancepayments_be.global.error.response

import com.example.yuseong_allowancepayments_be.global.error.CustomException

class BaseErrorResponse(
    val status: Int,
    val message: String
) {

    companion object {
        fun of(e: CustomException): BaseErrorResponse {
            return BaseErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }

}