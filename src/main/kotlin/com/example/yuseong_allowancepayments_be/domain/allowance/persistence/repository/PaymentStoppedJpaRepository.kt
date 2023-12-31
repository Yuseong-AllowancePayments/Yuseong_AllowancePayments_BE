package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentStopped
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentStoppedJpaRepository : JpaRepository<PaymentStopped, Long> {
    fun findByAllowanceTypeOrderBySerialNumberAsc(type: AllowanceType): List<PaymentStopped>
    fun findPaymentStoppedById(id: Long): PaymentStopped?
}