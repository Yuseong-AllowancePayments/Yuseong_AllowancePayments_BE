package com.example.yuseong_allowancepayments_be.domain.auth.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(
    @Id
    val email: String,

    @Indexed
    val token: String,

    @TimeToLive
    val expiredAt: Long
)