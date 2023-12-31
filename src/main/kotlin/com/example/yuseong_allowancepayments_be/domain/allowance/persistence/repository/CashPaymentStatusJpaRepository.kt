package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.CashPaymentStatus
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import org.springframework.data.jpa.repository.JpaRepository

interface CashPaymentStatusJpaRepository : JpaRepository<CashPaymentStatus, Long> {
    fun findByAllowanceTypeOrderBySerialNumberAsc(type: AllowanceType): List<CashPaymentStatus>
    fun findCashPaymentStatusById(id: Long): CashPaymentStatus?
}