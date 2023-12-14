package com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType

data class UpdatePaymentStoppedRequest(
    val serialNumber: Int,
    val hangJungDong: String,
    val veteransNumber: String,
    val residentRegistrationNumber: String,
    val name: String,
    val address: String,
    val depositType: String,
    val bankName: String,
    val accountHolder: String,
    val bankAccountNumber: String,
    val allowanceType: AllowanceType,
    val note: String,
    val stoppedReason: String,
    val stoppedDate: String,
    val transferAddress: String
)
