package com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto

data class UpdateNewcomerRequest(
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

    var applicantPostalCode: String?,

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
