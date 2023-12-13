package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentTarget
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentTargetJpaRepository : JpaRepository<PaymentTarget, Long> {
    fun findByAllowanceTypeOrderBySerialNumberAsc(type: AllowanceType): List<PaymentTarget>
}