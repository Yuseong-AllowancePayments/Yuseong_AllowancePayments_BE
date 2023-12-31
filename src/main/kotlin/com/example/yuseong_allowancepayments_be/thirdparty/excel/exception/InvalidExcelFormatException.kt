package com.example.yuseong_allowancepayments_be.thirdparty.excel.exception

import com.example.yuseong_allowancepayments_be.global.error.CustomException
import com.example.yuseong_allowancepayments_be.global.error.ErrorCode

object InvalidExcelFormatException : CustomException(ErrorCode.INVALID_EXCEL_FORMAT) {
    private fun readResolve(): Any = InvalidExcelFormatException
}