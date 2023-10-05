package com.example.yuseong_allowancepayments_be.domain.allowance.domain.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.CashPaymentStatus
import org.springframework.data.jpa.repository.JpaRepository

interface CashPaymentStatusJpaRepository : JpaRepository<CashPaymentStatus, Long> {
}