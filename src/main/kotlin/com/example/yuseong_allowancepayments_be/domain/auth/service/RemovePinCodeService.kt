package com.example.yuseong_allowancepayments_be.domain.auth.service

import com.example.yuseong_allowancepayments_be.domain.auth.exception.PinCodeNotFoundException
import com.example.yuseong_allowancepayments_be.domain.auth.persistence.repository.PinCodeRepository
import org.springframework.stereotype.Service

@Service
class RemovePinCodeService(
    private val pinCodeRepository: PinCodeRepository
) {

    fun execute(pin: String) {
        val code = pinCodeRepository.findByCode(pin)
            ?: throw PinCodeNotFoundException

        pinCodeRepository.delete(code)
    }
}