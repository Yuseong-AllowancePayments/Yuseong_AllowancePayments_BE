package com.example.yuseong_allowancepayments_be.domain.auth.service

import com.example.yuseong_allowancepayments_be.domain.allowance.dto.LoginRequest
import com.example.yuseong_allowancepayments_be.domain.auth.dto.TokenResponse
import com.example.yuseong_allowancepayments_be.domain.auth.exception.PinCodeNotFoundException
import com.example.yuseong_allowancepayments_be.domain.auth.persistence.repository.PinCodeRepository
import com.example.yuseong_allowancepayments_be.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val pinCodeRepository: PinCodeRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun execute(request: LoginRequest): TokenResponse {
        val pinCode = pinCodeRepository.findByCode(request.pin) ?: throw PinCodeNotFoundException

        return jwtTokenProvider.getToken(pinCode.code)
    }
}