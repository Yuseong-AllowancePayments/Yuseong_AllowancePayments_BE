package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.CashPaymentStatus
import org.springframework.data.jpa.repository.JpaRepository

interface CashPaymentStatusJpaRepository : JpaRepository<CashPaymentStatus, Long> {
}