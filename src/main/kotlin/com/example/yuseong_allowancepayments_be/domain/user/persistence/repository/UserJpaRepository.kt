package com.example.yuseong_allowancepayments_be.domain.user.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.user.persistence.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
    fun findByAccountId(accountId: String): User?
}