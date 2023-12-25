package com.example.yuseong_allowancepayments_be.domain.allowance.persistence

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdatePaymentTargetRequest
import com.example.yuseong_allowancepayments_be.domain.exel.dto.PaymentTargetResponse
import javax.persistence.*

@Entity
class PaymentTarget(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(columnDefinition = "VARCHAR(20)")
    var serialNumber: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var hangJungDong: String,

    @Column(columnDefinition = "VARCHAR(30)")
    var veteransNumber: String,

    @Column(columnDefinition = "VARCHAR(14)")
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

    @Column(columnDefinition = "INTEGER")
    var sibi: Int,

    @Column(columnDefinition = "INTEGER")
    var gubi: Int,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(19)")
    var allowanceType: AllowanceType,

    @Column(columnDefinition = "VARCHAR(200)")
    var note: String
) {
    fun toResponse(): PaymentTargetResponse = PaymentTargetResponse(
        id = id,
        serialNumber = serialNumber,
        hangJungDong = hangJungDong,
        veteransNumber = veteransNumber,
        residentRegistrationNumber = residentRegistrationNumber,
        name = name,
        address = address,
        depositType = depositType,
        bankName = bankName,
        accountHolder = accountHolder,
        bankAccountNumber = bankAccountNumber,
        sibi = sibi,
        gubi = gubi,
        note = note
    )
    fun update(
        request: UpdatePaymentTargetRequest
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
        this.sibi = request.sibi
        this.gubi = request.gubi
        this.note = request.note
    }
}