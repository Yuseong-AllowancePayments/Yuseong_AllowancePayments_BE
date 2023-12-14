package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentStoppedJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdatePaymentStoppedRequest
import com.example.yuseong_allowancepayments_be.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdatePaymentStoppedService(
    private val paymentStoppedJpaRepository: PaymentStoppedJpaRepository
) {
    @Transactional
    fun execute(id: Long, request: UpdatePaymentStoppedRequest) {
        val paymentStopped = paymentStoppedJpaRepository.findPaymentStoppedById(id) ?: throw UserNotFoundException.EXCEPTION
        paymentStopped.update(request)
    }
}