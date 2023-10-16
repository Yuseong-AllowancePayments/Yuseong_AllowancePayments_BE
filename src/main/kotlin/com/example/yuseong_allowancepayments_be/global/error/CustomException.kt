package com.example.yuseong_allowancepayments_be.global.error

import com.example.yuseong_allowancepayments_be.global.error.response.ErrorResponse


open class CustomException(private val error: ErrorResponse) : RuntimeException() {

    val status: Int
        get() = error.status

    override val message: String
        get() = error.message

}