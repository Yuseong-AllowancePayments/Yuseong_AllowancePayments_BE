package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.Newcomer
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.NewcomerJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdateNewcomerRequest
import com.example.yuseong_allowancepayments_be.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateNewcomerService(
    private val newcomerJpaRepository: NewcomerJpaRepository
) {
    @Transactional
    fun execute(id: Long, request: UpdateNewcomerRequest) {
        val newcomer = newcomerJpaRepository.findNewcomerById(id) ?: throw UserNotFoundException.EXCEPTION
        newcomer.update(request)

    }
}