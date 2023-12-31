package com.example.yuseong_allowancepayments_be.domain.auth.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.auth.persistence.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshToken, String>