package com.example.yuseong_allowancepayments_be.domain.allowance.service
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentTargetJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdatePaymentTargetRequest
import com.example.yuseong_allowancepayments_be.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdatePaymentTargetService(
    private val paymentTargetRepository: PaymentTargetJpaRepository
) {
    @Transactional
    fun execute(id: Long, request: UpdatePaymentTargetRequest) {
        val paymentTarget = paymentTargetRepository.findPaymentTargetById(id) ?: throw UserNotFoundException.EXCEPTION
        paymentTarget.update(request)
    }
}