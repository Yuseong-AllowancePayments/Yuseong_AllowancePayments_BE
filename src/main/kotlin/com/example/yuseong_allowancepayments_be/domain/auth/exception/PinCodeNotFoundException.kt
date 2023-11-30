package com.example.yuseong_allowancepayments_be.domain.auth.exception

import com.example.yuseong_allowancepayments_be.global.error.CustomException
import com.example.yuseong_allowancepayments_be.global.error.ErrorCode

object PinCodeNotFoundException: CustomException(ErrorCode.PIN_CODE_NOT_FOUND) {
}