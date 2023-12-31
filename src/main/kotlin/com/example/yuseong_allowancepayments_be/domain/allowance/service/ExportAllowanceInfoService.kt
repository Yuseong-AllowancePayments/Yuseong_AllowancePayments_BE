package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.CashPaymentStatusJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.NewcomerJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentStoppedJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentTargetJpaRepository
import com.example.yuseong_allowancepayments_be.global.utill.AllowanceConstraints
import com.example.yuseong_allowancepayments_be.global.utill.toExcelRow
import com.example.yuseong_allowancepayments_be.thirdparty.excel.setUpAllowanceSheetWithHeader
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream

@Service
class ExportAllowanceInfoService(
    private val paymentTargetJpaRepository: PaymentTargetJpaRepository,
    private val cashPaymentStatusJpaRepository: CashPaymentStatusJpaRepository,
    private val newcomerJpaRepository: NewcomerJpaRepository,
    private val paymentStoppedJpaRepository: PaymentStoppedJpaRepository
) {

    fun execute(type: AllowanceType): ByteArray {
        val excel = XSSFWorkbook()
        createPaymentTargetSheet(excel, type)
        createCashPaymentSheet(excel, type)
        createNewcomerSheet(excel, type)
        createPaymentStoppedSheet(excel, type)

        ByteArrayOutputStream().use { stream ->
            excel.write(stream)
            return stream.toByteArray()
        }
    }

    private fun createPaymentTargetSheet(excel: Workbook, type: AllowanceType) {
        val sheet = excel.setUpAllowanceSheetWithHeader("지급대상자현황", AllowanceConstraints.PAYMENT_TARGET_HEADER_ITEMS)

        val paymentTargets = paymentTargetJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
        paymentTargets.forEachIndexed { idx, it -> it.toExcelRow(sheet, idx + 1) }
    }

    private fun createCashPaymentSheet(excel: Workbook, type: AllowanceType) {
        val sheet = excel.setUpAllowanceSheetWithHeader("현금지급", AllowanceConstraints.CASH_PAYMENT_HEADER_ITEMS)

        val cashPayments = cashPaymentStatusJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
        cashPayments.forEachIndexed { idx, it -> it.toExcelRow(sheet, idx + 1) }
    }

    private fun createNewcomerSheet(excel: Workbook, type: AllowanceType) {
        val sheet = excel.setUpAllowanceSheetWithHeader("신규자", AllowanceConstraints.NEWCOMER_HEADER_ITEMS(type))

        val newcomers = newcomerJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
        newcomers.forEachIndexed { idx, it -> it.toExcelRow(sheet, idx + 1) }
    }

    private fun createPaymentStoppedSheet(excel: Workbook, type: AllowanceType) {
        val sheet = excel.setUpAllowanceSheetWithHeader("지급중지자", AllowanceConstraints.PAYMENT_STOPPED_HEADER_ITEMS)

        val paymentStopped = paymentStoppedJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
        paymentStopped.forEachIndexed { idx, it -> it.toExcelRow(sheet, idx) }
    }
}