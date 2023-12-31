package com.example.yuseong_allowancepayments_be.domain.allowance.persistence

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.CashPaymentResponse
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdateCashPaymentStatusRequest
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class CashPaymentStatus(
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
    fun toResponse(): CashPaymentResponse = CashPaymentResponse(
        id!!,
        serialNumber,
        hangJungDong,
        veteransNumber,
        residentRegistrationNumber,
        name,
        address,
        depositType,
        sibi,
        gubi,
        note
    )

    fun update(
        request: UpdateCashPaymentStatusRequest
    ) {
        this.serialNumber = request.serialNumber
        this.hangJungDong = request.hangJungDong
        this.veteransNumber = request.veteransNumber
        this.residentRegistrationNumber = request.residentRegistrationNumber
        this.name = request.name
        this.address = request.address
        this.depositType = request.depositType
        this.sibi = request.sibi
        this.gubi = request.gubi
        this.note = request.note
    }
}