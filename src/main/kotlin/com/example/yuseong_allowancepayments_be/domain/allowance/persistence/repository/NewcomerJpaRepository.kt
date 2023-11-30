package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.Newcomer
import org.springframework.data.jpa.repository.JpaRepository

interface NewcomerJpaRepository : JpaRepository<Newcomer, Long> {
}