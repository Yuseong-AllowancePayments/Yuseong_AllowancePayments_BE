package com.example.yuseong_allowancepayments_be.domain.exel.dto

import java.util.UUID

data class ParseExelResponse(
    val paymentTargetTab: List<PaymentTargetResponse>,
    val cashPaymentTab: List<CashPaymentResponse>,
    val newComerTab: List<NewcomerResponse>,
    val paymentStoppedTab: List<PaymentStoppedResponse>
)

data class PaymentTargetResponse(
    val id: Long,

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
    val id: Long,

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
    val id: Long,

    var serialNumber: String,

    var applicantName: String,

    var applicantID: String,

    var applicantAddressDetail: String,

    var applicantPhoneNumber: String?,

    var hangJungDong: String,

    var bankName: String,

    var bankAccountNumber: String,

    var accountHolder: String,

    var transferDate: String,

    var applicationDate: String,

    var applicationReason: String,

    var depositType: String,

    var note: String,

    var applicantBirthday: String?,

    var warRegistrationNumber: String?,

    var veteransNumber: String?,

    var nationalMeritName: String?,

    var nationalMeritID: String?,

    var nationalMeritDateOfDeath: String?,

    var warType: String?,

    var veteransType: String?,

    var applicantGender: String?,

    var familyRelation: String?,

    var bereavedFamily: String?,
)

data class PaymentStoppedResponse(
    val id: Long,

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

