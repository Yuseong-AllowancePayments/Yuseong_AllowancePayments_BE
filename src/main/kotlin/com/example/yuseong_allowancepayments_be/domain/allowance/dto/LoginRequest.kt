package com.example.yuseong_allowancepayments_be.domain.allowance.dto

data class LoginRequest(
    val pin: String
)

data class AdminLoginRequest(
    val accountId: String,
    val password: String
)