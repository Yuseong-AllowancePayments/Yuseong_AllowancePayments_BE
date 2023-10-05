package com.example.yuseong_allowancepayments_be.domain.allowance.domain.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.Newcomer
import org.springframework.data.jpa.repository.JpaRepository

interface NewcomerJpaRepository : JpaRepository<Newcomer, Long> {
}