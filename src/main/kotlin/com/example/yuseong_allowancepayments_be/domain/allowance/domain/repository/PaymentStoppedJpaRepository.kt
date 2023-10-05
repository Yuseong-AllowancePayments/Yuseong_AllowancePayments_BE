package com.example.yuseong_allowancepayments_be.domain.allowance.domain.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.PaymentStopped
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentStoppedJpaRepository: JpaRepository<PaymentStopped, Long> {
}