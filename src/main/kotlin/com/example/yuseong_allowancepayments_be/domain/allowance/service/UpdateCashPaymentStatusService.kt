package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.CashPaymentStatusJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdateCashPaymentStatusRequest
import com.example.yuseong_allowancepayments_be.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateCashPaymentStatusService(
    private val cashPaymentStatusJpaRepository: CashPaymentStatusJpaRepository,
) {
    @Transactional
    fun execute(id: Long, updateCashPaymentStatusRequest: UpdateCashPaymentStatusRequest) {
        val cashPaymentStatus =
            cashPaymentStatusJpaRepository.findCashPaymentStatusById(id) ?: throw UserNotFoundException.EXCEPTION
        cashPaymentStatus.update(updateCashPaymentStatusRequest)
    }
}