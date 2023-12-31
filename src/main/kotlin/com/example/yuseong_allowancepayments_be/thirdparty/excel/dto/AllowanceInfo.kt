package com.example.yuseong_allowancepayments_be.thirdparty.excel.dto

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.CashPaymentStatus
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.Newcomer
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentStopped
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentTarget
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType

data class ParseAllowanceInfo(
    val paymentTargets: List<PaymentTargetInfo>,
    val cashPayments: List<CashPaymentInfo>,
    val newcomers: List<NewcomerInfo>,
    val paymentStopped: List<PaymentStoppedInfo>
)

data class PaymentTargetInfo(
    val serialNum: String,
    val administrativeAddress: String,
    val affairsNum: String,
    val sin: String,
    val name: String,
    val address: String,
    val depositType: String,
    val bankName: String,
    val accountOwner: String,
    val account: String,
    val sibi: String,
    val gubi: String,
    val note: String
) {
    fun toEntity(type: AllowanceType): PaymentTarget =
        PaymentTarget(
            serialNumber = serialNum,
            hangJungDong = administrativeAddress,
            veteransNumber = affairsNum,
            residentRegistrationNumber = sin,
            name = name,
            address = address,
            depositType = depositType,
            bankName = bankName,
            accountHolder = accountOwner,
            bankAccountNumber = account,
            sibi = sibi.toDouble().toInt(),
            gubi = gubi.toDouble().toInt(),
            note = note,
            allowanceType = type
        )
}

data class CashPaymentInfo(
    val serialNum: String,
    val administrativeAddress: String,
    val affairsNum: String,
    val sin: String,
    val name: String,
    val address: String,
    val depositType: String,
    val sibi: String,
    val gubi: String,
    val note: String
) {
    fun toEntity(type: AllowanceType): CashPaymentStatus =
        CashPaymentStatus(
            serialNumber = serialNum,
            hangJungDong = administrativeAddress,
            veteransNumber = affairsNum,
            residentRegistrationNumber = sin,
            name = name,
            address = address,
            depositType = depositType,
            sibi = sibi.toDouble().toInt(),
            gubi = gubi.toDouble().toInt(),
            note = note,
            allowanceType = type
        )
}

data class VNewcomerInfo(
    val serialNum: String,
    val administrativeAddress: String,
    val registrationNum: String,
    val name: String,
    val sin: String,
    val address: String,
    val depositType: String,
    val bankName: String,
    val accountOwner: String,
    val account: String,
    val moveInDate: String,
    val applicationDate: String,
    val applicationReason: String,
    val note: String
) : NewcomerInfo {

    override fun toEntity(type: AllowanceType): Newcomer =
        Newcomer(
            serialNumber = serialNum,
            hangJungDong = administrativeAddress,
            veteransNumber = registrationNum,
            applicantName = name,
            applicantID = sin,
            applicantAddressDetail = address,
            depositType = depositType,
            bankName = bankName,
            accountHolder = accountOwner,
            bankAccountNumber = account,
            transferDate = moveInDate,
            applicationReason = applicationReason,
            applicationDate = applicationDate,
            note = note,
            allowanceType = type
        )
}

data class SNewcomerInfo(
    val serialNum: String,
    val administrativeAddress: String,
    val applicantName: String,
    val applicantSin: String,
    val applicantPhoneNum: String,
    val veteranName: String,
    val veteranSin: String,
    val affairsNum: String,
    val warName: String,
    val deathDate: String,
    val address: String,
    val depositType: String,
    val bankName: String,
    val accountOwner: String,
    val account: String,
    val moveInDate: String,
    val applicationDate: String,
    val applicationReason: String,
    val note: String
) : NewcomerInfo {
    override fun toEntity(type: AllowanceType): Newcomer =
        Newcomer(
            serialNumber = serialNum,
            hangJungDong = administrativeAddress,
            applicantName = applicantName,
            applicantID = applicantSin,
            applicantPhoneNumber = applicantPhoneNum,
            nationalMeritName = veteranName,
            nationalMeritID = veteranSin,
            veteransNumber = affairsNum,
            warType = warName,
            nationalMeritDateOfDeath = deathDate,
            applicantAddressDetail = address,
            depositType = depositType,
            bankName = bankName,
            accountHolder = accountOwner,
            bankAccountNumber = account,
            transferDate = moveInDate,
            applicationDate = applicationDate,
            applicationReason = applicationReason,
            note = note,
            allowanceType = type
        )
}

data class CNewcomerInfo(
    val serialNum: String,
    val administrativeAddress: String,
    val affairsNum: String,
    val applicantName: String,
    val applicantSin: String,
    val veteranType: String,
    val applicantGender: String,
    val applicantPhoneNum: String,
    val address: String,
    val depositType: String,
    val bankName: String,
    val accountOwner: String,
    val account: String,
    val relation: String,
    val priority: String,
    val moveInDate: String,
    val applicationDate: String,
    val applicationReason: String,
    val note: String
) : NewcomerInfo {
    override fun toEntity(type: AllowanceType): Newcomer =
        Newcomer(
            serialNumber = serialNum,
            hangJungDong = administrativeAddress,
            veteransNumber = affairsNum,
            applicantName = applicantName,
            applicantID = applicantSin,
            veteransType = veteranType,
            applicantGender = applicantGender,
            applicantPhoneNumber = applicantPhoneNum,
            applicantAddressDetail = address,
            depositType = depositType,
            bankName = bankName,
            accountHolder = accountOwner,
            bankAccountNumber = account,
            familyRelation = relation,
            bereavedFamily = priority,
            transferDate = moveInDate,
            applicationDate = applicationDate,
            applicationReason = applicationReason,
            note = note,
            allowanceType = type
        )
}

data class PaymentStoppedInfo(
    val serialNum: String,
    val administrativeAddress: String,
    val affairsNum: String,
    val name: String,
    val sin: String,
    val address: String,
    val depositType: String,
    val bankName: String,
    val accountOwner: String,
    val account: String,
    val stoppageReason: String,
    val stoppageDate: String,
    val note: String,
    val moveInAddress: String
) {
    fun toEntity(type: AllowanceType): PaymentStopped =
        PaymentStopped(
            serialNumber = serialNum,
            hangJungDong = administrativeAddress,
            veteransNumber = affairsNum,
            name = name,
            residentRegistrationNumber = sin,
            address = address,
            depositType = depositType,
            bankName = bankName,
            accountHolder = accountOwner,
            bankAccountNumber = account,
            stoppedReason = stoppageReason,
            stoppedDate = stoppageDate,
            note = note,
            transferAddress = moveInAddress,
            allowanceType = type
        )
}

interface NewcomerInfo {
    fun toEntity(type: AllowanceType): Newcomer
}