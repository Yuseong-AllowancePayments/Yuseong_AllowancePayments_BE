package com.example.yuseong_allowancepayments_be.domain.auth.dto

import java.util.*

data class TokenResponse(
        val accessToken: String,
        val refreshToken: String,
        val accessTokenExp: Date
)