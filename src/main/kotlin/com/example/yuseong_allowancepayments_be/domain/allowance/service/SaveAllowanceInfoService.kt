package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.CashPaymentStatusJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.NewcomerJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentStoppedJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentTargetJpaRepository
import com.example.yuseong_allowancepayments_be.thirdparty.excel.ExcelUtil
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class SaveAllowanceInfoService(
    private val paymentTargetJpaRepository: PaymentTargetJpaRepository,
    private val cashPaymentStatusJpaRepository: CashPaymentStatusJpaRepository,
    private val newcomerJpaRepository: NewcomerJpaRepository,
    private val paymentStoppedJpaRepository: PaymentStoppedJpaRepository,
    private val excelUtil: ExcelUtil
) {

    fun execute(file: MultipartFile, type: AllowanceType) {
        val allowanceInfo = excelUtil.getAllowanceInfo(file, type)

        paymentTargetJpaRepository.saveAll(allowanceInfo.paymentTargets)
        cashPaymentStatusJpaRepository.saveAll(allowanceInfo.cashPayments)
        newcomerJpaRepository.saveAll(allowanceInfo.newcomers)
        paymentStoppedJpaRepository.saveAll(allowanceInfo.paymentStopped)
    }
}