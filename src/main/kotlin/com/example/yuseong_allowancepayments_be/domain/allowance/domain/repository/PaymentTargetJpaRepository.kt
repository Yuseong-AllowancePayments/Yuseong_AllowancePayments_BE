package com.example.yuseong_allowancepayments_be.domain.allowance.domain.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.PaymentTarget
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentTargetJpaRepository : JpaRepository<PaymentTarget, Long> {
}