package com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto

data class UpdatePaymentTargetRequest(
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
    val sibi: Int,
    val gubi: Int,
    val note: String
)