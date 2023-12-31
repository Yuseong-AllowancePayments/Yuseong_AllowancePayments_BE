package com.example.yuseong_allowancepayments_be.domain.auth.service

import com.example.yuseong_allowancepayments_be.domain.allowance.dto.AdminLoginRequest
import com.example.yuseong_allowancepayments_be.domain.auth.dto.TokenResponse
import com.example.yuseong_allowancepayments_be.domain.auth.exception.PasswordMismatchException
import com.example.yuseong_allowancepayments_be.domain.user.persistence.repository.UserJpaRepository
import com.example.yuseong_allowancepayments_be.domain.user.exception.UserNotFoundException
import com.example.yuseong_allowancepayments_be.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminLoginService(
    private val userJpaRepository: UserJpaRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun execute(request: AdminLoginRequest): TokenResponse {
        val user = userJpaRepository.findByAccountId(request.accountId)
            ?: throw UserNotFoundException.EXCEPTION

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMismatchException
        }

        return jwtTokenProvider.getToken(request.accountId)
    }
}