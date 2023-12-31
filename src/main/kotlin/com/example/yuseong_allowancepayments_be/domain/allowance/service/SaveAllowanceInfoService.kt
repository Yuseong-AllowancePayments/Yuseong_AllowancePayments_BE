package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.CashPaymentStatusJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.NewcomerJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentStoppedJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentTargetJpaRepository
import com.example.yuseong_allowancepayments_be.thirdparty.excel.AllowanceExcelUtil
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class SaveAllowanceInfoService(
    private val paymentTargetJpaRepository: PaymentTargetJpaRepository,
    private val cashPaymentStatusJpaRepository: CashPaymentStatusJpaRepository,
    private val newcomerJpaRepository: NewcomerJpaRepository,
    private val paymentStoppedJpaRepository: PaymentStoppedJpaRepository,
    private val excelUtil: AllowanceExcelUtil
) {

    fun execute(file: MultipartFile, type: AllowanceType) {
        val allowanceInfo = excelUtil.parseAllowanceExcel(file, type)

        paymentTargetJpaRepository.saveAll(allowanceInfo.paymentTargets.map { it.toEntity(type) })
        cashPaymentStatusJpaRepository.saveAll(allowanceInfo.cashPayments.map { it.toEntity(type) })
        newcomerJpaRepository.saveAll(allowanceInfo.newcomers.map { it.toEntity(type) })
        paymentStoppedJpaRepository.saveAll(allowanceInfo.paymentStopped.map { it.toEntity(type) })
    }
}