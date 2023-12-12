package com.example.yuseong_allowancepayments_be.domain.allowance.persistence

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.exel.dto.PaymentTargetResponse
import javax.persistence.*

@Entity
class PaymentTarget(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(columnDefinition = "INTEGER")
    val serialNumber: Int,

    @Column(columnDefinition = "VARCHAR(30)")
    val hangJungDong: String,

    @Column(columnDefinition = "VARCHAR(30)")
    val veteransNumber: String,

    @Column(columnDefinition = "VARCHAR(14)")
    val residentRegistrationNumber: String,

    @Column(columnDefinition = "VARCHAR(10)")
    val name: String,

    @Column(columnDefinition = "VARCHAR(100)")
    val address: String,

    @Column(columnDefinition = "VARCHAR(30)")
    val depositType: String,

    @Column(columnDefinition = "VARCHAR(30)")
    val bankName: String,

    @Column(columnDefinition = "VARCHAR(10)")
    val accountHolder: String,

    @Column(columnDefinition = "VARCHAR(30)")
    val bankAccountNumber: String,

    @Column(columnDefinition = "INTEGER")
    val sibi: Int,

    @Column(columnDefinition = "INTEGER")
    val gubi: Int,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(19)")
    val allowanceType: AllowanceType,

    @Column(columnDefinition = "VARCHAR(100)")
    val note: String
) {
    fun toResponse(): PaymentTargetResponse = PaymentTargetResponse(
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
}