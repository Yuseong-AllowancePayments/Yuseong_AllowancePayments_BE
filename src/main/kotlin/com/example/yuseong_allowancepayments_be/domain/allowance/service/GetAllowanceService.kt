package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.CashPaymentStatusJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.NewcomerJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentStoppedJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentTargetJpaRepository
import com.example.yuseong_allowancepayments_be.domain.exel.dto.ParseExelResponse
import org.springframework.stereotype.Service

@Service
class GetAllowanceService(
    private val cashPaymentStatusJpaRepository: CashPaymentStatusJpaRepository,
    private val paymentTargetJpaRepository: PaymentTargetJpaRepository,
    private val newcomerJpaRepository: NewcomerJpaRepository,
    private val paymentStoppedJpaRepository: PaymentStoppedJpaRepository
) {
    fun execute(type: AllowanceType): ParseExelResponse {
        val paymentTargets = paymentTargetJpaRepository
            .findByAllowanceTypeOrderBySerialNumberAsc(type)
        val cashPaymentStatusList = cashPaymentStatusJpaRepository
            .findByAllowanceTypeOrderBySerialNumberAsc(type)
        val newcomers = newcomerJpaRepository
            .findByAllowanceTypeOrderBySerialNumberAsc(type)
        val paymentStoppedList = paymentStoppedJpaRepository
            .findByAllowanceTypeOrderBySerialNumberAsc(type)

        return ParseExelResponse(
            paymentTargetTab = paymentTargets.map { it.toResponse() },
            cashPaymentTab = cashPaymentStatusList.map { it.toResponse() },
            newComerTab = newcomers.map { it.toResponse() },
            paymentStoppedTab = paymentStoppedList.map { it.toResponse() }
        )
    }
}