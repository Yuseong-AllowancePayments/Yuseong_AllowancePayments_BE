package com.example.yuseong_allowancepayments_be.domain.auth.persistence.repository

import com.example.yuseong_allowancepayments_be.domain.auth.persistence.PinCode
import org.springframework.data.jpa.repository.JpaRepository

interface PinCodeRepository : JpaRepository<PinCode, String> {
    fun findByCode(code: String): PinCode?

    fun existsByCenterName(centerName: String): Boolean
}