package com.example.yuseong_allowancepayments_be.global.error

import com.example.yuseong_allowancepayments_be.global.error.response.ErrorResponse

enum class ErrorCode(
    override val status: Int,
    override val message: String
) : ErrorResponse {
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    UNEXPECTED_TOKEN(401, "Unexpected Token"),

    USER_NOT_FOUND(404, "User Not Found"),
    PIN_CODE_NOT_FOUND(404, "Pin Code Not Found"),

    PIN_CODE_EXISTS(409, "Pin Code Already Exists"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    PASSWORD_MISMATCH(401, "Invalid Password"),

}