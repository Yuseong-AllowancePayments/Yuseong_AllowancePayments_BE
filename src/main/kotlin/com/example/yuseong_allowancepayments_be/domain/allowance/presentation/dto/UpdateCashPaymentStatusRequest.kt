package com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto

data class UpdateCashPaymentStatusRequest(
    val serialNumber: String,
    val hangJungDong: String,
    val veteransNumber: String,
    val residentRegistrationNumber: String,
    val name: String,
    val address: String,
    val depositType: String,
    val sibi: Int,
    val gubi: Int,
    val note: String
)
