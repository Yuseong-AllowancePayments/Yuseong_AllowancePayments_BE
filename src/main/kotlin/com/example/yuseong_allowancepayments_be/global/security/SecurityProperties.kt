package com.example.yuseong_allowancepayments_be.global.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.Base64

@ConfigurationProperties(prefix = "jwt")
@ConstructorBinding
class SecurityProperties(
    accessExp: Long,
    refreshExp: Long,
    secretKey: String
) {
    val accessExp = accessExp * 1000
    val refreshExp = refreshExp * 1000
    val secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())!!

}