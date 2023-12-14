package com.example.yuseong_allowancepayments_be.domain.exel.dto

data class ParseExelResponse(
    val paymentTargetTab: List<PaymentTargetResponse>,
    val cashPaymentTab: List<CashPaymentResponse>,
    val newComerTab: List<NewcomerResponse>,
    val paymentStoppedTab: List<PaymentStoppedResponse>
)

data class PaymentTargetResponse(
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

data class CashPaymentResponse(
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

data class NewcomerResponse(
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

    val transferReason: String,

    val transferDate: String
)

data class PaymentStoppedResponse(
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

