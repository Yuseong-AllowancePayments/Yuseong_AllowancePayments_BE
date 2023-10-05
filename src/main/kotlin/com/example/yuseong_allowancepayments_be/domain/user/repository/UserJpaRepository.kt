package com.example.yuseong_allowancepayments_be.domain.user.repository

import com.example.yuseong_allowancepayments_be.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
}