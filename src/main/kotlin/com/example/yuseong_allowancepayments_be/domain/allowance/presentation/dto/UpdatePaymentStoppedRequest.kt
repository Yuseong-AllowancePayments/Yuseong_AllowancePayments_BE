package com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto

data class UpdatePaymentStoppedRequest(
    val serialNumber: String,
    val hangJungDong: String,
    val veteransNumber: String,
    val residentRegistrationNumber: String,
    val name: String,
    val address: String,
    val depositType: String,
    val bankName: String,
    val accountHolder: String,
    val bankAccountNumber: String,
    val note: String,
    val stoppedReason: String,
    val stoppedDate: String,
    val transferAddress: String
)
