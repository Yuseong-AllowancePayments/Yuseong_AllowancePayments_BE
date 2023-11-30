package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentTarget
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentTargetJpaRepository : JpaRepository<PaymentTarget, Long> {
}