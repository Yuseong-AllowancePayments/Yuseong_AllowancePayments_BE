package com.example.yuseong_allowancepayments_be.domain.allowance.persistence

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdateNewcomerRequest
import com.example.yuseong_allowancepayments_be.domain.exel.dto.NewcomerResponse
import java.time.LocalDate
import javax.persistence.*

@Entity
class Newcomer(
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
    var transferReason: String,

    @Column(columnDefinition = "VARCHAR(100)")
    var transferDate: String
) {
    fun toResponse(): NewcomerResponse = NewcomerResponse(
        id, serialNumber, hangJungDong, veteransNumber, residentRegistrationNumber, name, address, depositType, bankName, accountHolder, bankAccountNumber, note, transferReason, transferDate
    )

    fun update(
        request: UpdateNewcomerRequest
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
        this.allowanceType = request.allowanceType
        this.note = request.note
        this.transferReason = request.transferReason
        this.transferDate = request.transferDate
    }
}