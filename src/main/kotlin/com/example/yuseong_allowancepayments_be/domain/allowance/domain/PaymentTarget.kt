package com.example.yuseong_allowancepayments_be.domain.allowance.domain

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.enums.AllowanceType
import jakarta.persistence.*

@Entity
class PaymentTarget(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

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

    @Column(columnDefinition = "INTEGER")
    val fertilization: Int,

    @Column(columnDefinition = "INTEGER")
    val provision: Int,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(19)")
    val allowanceType: AllowanceType
) {
}