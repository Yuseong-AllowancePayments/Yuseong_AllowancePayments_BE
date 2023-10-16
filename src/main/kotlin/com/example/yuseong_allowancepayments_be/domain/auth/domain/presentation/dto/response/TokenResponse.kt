package com.example.yuseong_allowancepayments_be.domain.auth.domain.presentation.dto.response

import java.util.*

data class TokenResponse(
        val accessToken: String,
        val refreshToken: String,
        val accessTokenExp: Date
)