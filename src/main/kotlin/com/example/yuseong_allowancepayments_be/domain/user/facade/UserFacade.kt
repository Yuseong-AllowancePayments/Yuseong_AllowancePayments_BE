package com.example.yuseong_allowancepayments_be.domain.user.facade

import com.example.yuseong_allowancepayments_be.domain.user.exception.UserNotFoundException
import com.example.yuseong_allowancepayments_be.domain.user.persistence.User
import com.example.yuseong_allowancepayments_be.domain.user.persistence.repository.UserJpaRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserJpaRepository
) {
    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId)
            ?: throw UserNotFoundException.EXCEPTION
    }

    fun getCurrentUser(): User {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION
    }
}