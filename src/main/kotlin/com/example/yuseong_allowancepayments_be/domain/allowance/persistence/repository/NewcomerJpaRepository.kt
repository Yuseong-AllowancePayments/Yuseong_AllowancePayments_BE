package com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.Newcomer
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import org.springframework.data.jpa.repository.JpaRepository

interface NewcomerJpaRepository : JpaRepository<Newcomer, Long> {
    fun findByAllowanceTypeOrderBySerialNumberAsc(type: AllowanceType): List<Newcomer>
    fun findNewcomerById(id: Long): Newcomer?
}