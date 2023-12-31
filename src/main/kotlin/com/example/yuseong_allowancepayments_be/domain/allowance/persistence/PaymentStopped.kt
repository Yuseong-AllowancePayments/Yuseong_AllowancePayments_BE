package com.example.yuseong_allowancepayments_be.domain.allowance.persistence

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.PaymentStoppedResponse
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdatePaymentStoppedRequest
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PaymentStopped(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(columnDefinition = "VARCHAR(20)")
    var serialNumber: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var hangJungDong: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var veteransNumber: String,

    @Column(columnDefinition = "VARCHAR(13)")
    var residentRegistrationNumber: String,

    @Column(columnDefinition = "VARCHAR(10)")
    var name: String,

    @Column(columnDefinition = "VARCHAR(100)")
    var address: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var depositType: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var bankName: String,

    @Column(columnDefinition = "VARCHAR(10)")
    var accountHolder: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var bankAccountNumber: String,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(19)")
    var allowanceType: AllowanceType,

    @Column(columnDefinition = "VARCHAR(200)")
    var note: String,

    @Column(columnDefinition = "VARCHAR(100)")
    var stoppedReason: String,

    @Column(columnDefinition = "VARCHAR(100)")
    var stoppedDate: String,

    @Column(columnDefinition = "VARCHAR(100)")
    var transferAddress: String
) {
    fun toResponse(): PaymentStoppedResponse = PaymentStoppedResponse(
        id!!,
        serialNumber,
        hangJungDong,
        veteransNumber,
        residentRegistrationNumber,
        name,
        address,
        depositType,
        bankName,
        accountHolder,
        bankAccountNumber,
        note,
        stoppedReason,
        stoppedDate,
        transferAddress
    )

    fun update(
        request: UpdatePaymentStoppedRequest
    ) {
        this.serialNumber = request.serialNumber
        this.hangJungDong = request.hangJungDong
        this.veteransNumber = request.veteransNumber
        this.residentRegistrationNumber = request.residentRegistrationNumber
        this.name = request.name
        this.address = request.address
        this.depositType = request.depositType
        this.bankName = request.bankName
        this.bankAccountNumber = request.bankAccountNumber
        this.note = request.note
        this.stoppedReason = request.stoppedReason
        this.stoppedDate = request.stoppedDate
        this.transferAddress = request.transferAddress
    }
}