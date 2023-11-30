package com.example.yuseong_allowancepayments_be.domain.auth.dto

data class GetCenterPinCodesResponse(
    val codes: List<PinCodeResponse>
)

data class PinCodeResponse(
    val code: String,
    val centerName: String
)