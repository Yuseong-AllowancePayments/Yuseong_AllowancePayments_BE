package com.example.yuseong_allowancepayments_be.domain.allowance.persistence

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdateNewcomerRequest
import com.example.yuseong_allowancepayments_be.domain.exel.dto.NewcomerResponse
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Newcomer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(columnDefinition = "VARCHAR(20)")
    var serialNumber: String,

    var warRegistrationNumber: String? = null,

    var applicantName: String,

    var applicantID: String,

    var applicantBirthday: String? = null,

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

    var veteransNumber: String? = null,

    var nationalMeritName: String? = null,

    var nationalMeritID: String? = null,

    var nationalMeritDateOfDeath: String? = null,

    var warType: String? = null,

    var veteransType: String? = null,

    var applicantGender: String? = null,

    var familyRelation: String? = null,

    var bereavedFamily: String? = null,

    var note: String,

    @Enumerated(EnumType.STRING)
    var allowanceType: AllowanceType
) {
    fun toResponse(): NewcomerResponse = NewcomerResponse(
        id, serialNumber, warRegistrationNumber, applicantName, applicantID,
        applicantBirthday, applicantPostalCode, applicantAddressDetail,
        applicantPhoneNumber, hangJungDong, bankName, bankAccountNumber,
        accountHolder, transferDate, applicationDate, applicationReason,
        veteransNumber, nationalMeritName, nationalMeritID, nationalMeritDateOfDeath,
        warType, veteransType, applicantGender, familyRelation, bereavedFamily, note
    )

    fun update(
        request: UpdateNewcomerRequest
    ) {
        this.serialNumber = request.serialNumber
        this.warRegistrationNumber = request.warRegistrationNumber
        this.applicantName = request.applicantName
        this.applicantID = request.applicantID
        this.applicantBirthday = request.applicantBirthday
        this.applicantPostalCode = request.applicantPostalCode
        this.applicantAddressDetail = request.applicantAddressDetail
        this.applicantPhoneNumber = request.applicantPhoneNumber
        this.hangJungDong = request.hangJungDong
        this.bankName = request.bankName
        this.bankAccountNumber = request.bankAccountNumber
        this.accountHolder = request.accountHolder
        this.transferDate = request.transferDate
        this.applicationDate = request.applicationDate
        this.applicationReason = request.applicationReason
        this.veteransNumber = request.veteransNumber
        this.nationalMeritName = request.nationalMeritName
        this.nationalMeritID = request.nationalMeritID
        this.nationalMeritDateOfDeath = request.nationalMeritDateOfDeath
        this.warType = request.warType
        this.veteransType = request.veteransType
        this.applicantGender = request.applicantGender
        this.familyRelation = request.familyRelation
        this.bereavedFamily = request.bereavedFamily
        this.note = request.note
    }
}