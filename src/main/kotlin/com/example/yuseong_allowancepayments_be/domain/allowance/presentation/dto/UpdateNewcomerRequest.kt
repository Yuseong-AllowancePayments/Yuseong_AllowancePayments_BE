package com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto

data class UpdateNewcomerRequest(
    var serialNumber: String,

    var warRegistrationNumber: String?,

    var applicantName: String,

    var applicantID: String,

    var applicantBirthday: String?,

    var applicantPostalCode: String,

    var applicantAddressDetail: String,

    var applicantPhoneNumber: String,

    var hangJungDong: String,

    var bankName: String,

    var bankAccountNumber: String,

    var accountHolder: String,

    var transferDate: String,

    var applicationDate: String,

    var applicationReason: String,

    var veteransNumber: String?,

    var nationalMeritName: String?,

    var nationalMeritID: String?,

    var nationalMeritDateOfDeath: String?,

    var warType: String?,

    var veteransType: String?,

    var applicantGender: String?,

    var familyRelation: String?,

    var bereavedFamily: String?,

    var note: String,
)
