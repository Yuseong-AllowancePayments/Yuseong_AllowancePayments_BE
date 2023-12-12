package com.example.yuseong_allowancepayments_be.domain.allowance.persistence

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.exel.dto.PaymentStoppedResponse
import java.time.LocalDate
import javax.persistence.*

@Entity
class PaymentStopped(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(columnDefinition = "INTEGER")
    val serialNumber: Int,

    @Column(columnDefinition = "VARCHAR(30)")
    val hangJungDong: String,

    @Column(columnDefinition = "VARCHAR(30)")
    val veteransNumber: String,

    @Column(columnDefinition = "VARCHAR(13)")
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(19)")
    val allowanceType: AllowanceType,

    @Column(columnDefinition = "VARCHAR(100)")
    val note: String,

    @Column(columnDefinition = "VARCHAR(100)")
    val stoppedReason: String,

    @Column(columnDefinition = "VARCHAR(100)")
    val stoppedDate: String,

    @Column(columnDefinition = "VARCHAR(100)")
    val transferAddress: String
) {
    fun toResponse(): PaymentStoppedResponse = PaymentStoppedResponse(
        serialNumber, hangJungDong, veteransNumber, residentRegistrationNumber, name, address, depositType, bankName, accountHolder, bankAccountNumber, note, stoppedReason, stoppedDate, transferAddress
    )
}