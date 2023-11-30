package com.example.yuseong_allowancepayments_be.domain.auth.exception

import com.example.yuseong_allowancepayments_be.global.error.CustomException
import com.example.yuseong_allowancepayments_be.global.error.ErrorCode

object PinCodeAlreadyExistsException: CustomException(ErrorCode.PIN_CODE_EXISTS) {
}