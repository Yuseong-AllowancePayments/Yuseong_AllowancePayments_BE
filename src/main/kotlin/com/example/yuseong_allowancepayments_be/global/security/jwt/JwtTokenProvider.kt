package com.example.yuseong_allowancepayments_be.global.security.jwt

import com.example.yuseong_allowancepayments_be.domain.auth.dto.TokenResponse
import com.example.yuseong_allowancepayments_be.domain.auth.persistence.RefreshToken
import com.example.yuseong_allowancepayments_be.domain.auth.persistence.repository.RefreshTokenRepository
import com.example.yuseong_allowancepayments_be.global.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenProvider(
    private val securityProperties: SecurityProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
) {

    private fun createAccessToken(email: String) =
        generateToken(email, JwtProperty.ACCESS_KEY, securityProperties.accessExp)

    private fun createRefreshToken(email: String): String {
        val token = generateToken(email, JwtProperty.REFRESH_KEY, securityProperties.refreshExp)

        refreshTokenRepository.save(
            RefreshToken(
                token = token,
                email = email,
                expiredAt = securityProperties.refreshExp / 1000
            )
        )
        return token
    }

    private fun generateToken(email: String, type: String, expiredAt: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .claim("email", email)
            .setHeaderParam(Header.JWT_TYPE, type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiredAt))
            .compact()

    fun getToken(email: String) = TokenResponse(
        accessToken = createAccessToken(email),
        refreshToken = createRefreshToken(email),
        accessTokenExp = Date(System.currentTimeMillis() + securityProperties.accessExp)
    )

}