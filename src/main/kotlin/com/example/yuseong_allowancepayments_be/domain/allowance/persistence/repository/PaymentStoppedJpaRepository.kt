package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentStopped
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentStoppedJpaRepository: JpaRepository<PaymentStopped, Long> {
}