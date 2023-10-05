package com.example.yuseong_allowancepayments_be.domain.user.domain.repository

import com.example.yuseong_allowancepayments_be.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
}