package com.example.yuseong_allowancepayments_be.domain.allowance.service

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.CashPaymentStatusJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.NewcomerJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentStoppedJpaRepository
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.repository.PaymentTargetJpaRepository
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
        val sheet = excel.createSheet()
        val headerRow = sheet.createRow(0)
        headerRow.createCell(0).setCellValue("연번")
        headerRow.createCell(1).setCellValue("행정동")
        headerRow.createCell(2).setCellValue("보훈번호")
        headerRow.createCell(3).setCellValue("성명")
        headerRow.createCell(4).setCellValue("주민등록번호")
        headerRow.createCell(5).setCellValue("주소")
        headerRow.createCell(6).setCellValue("입금유형")
        headerRow.createCell(7).setCellValue("은행명")
        headerRow.createCell(8).setCellValue("예금주")
        headerRow.createCell(9).setCellValue("계좌번호")
        headerRow.createCell(10).setCellValue("시비")
        headerRow.createCell(11).setCellValue("구비")
        headerRow.createCell(11).setCellValue("비고")

        val paymentTargets = paymentTargetJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
        paymentTargets.forEachIndexed { idx, it ->
            val row = sheet.createRow(idx + 1)
            row.createCell(0).setCellValue(it.serialNumber.toString())
            row.createCell(1).setCellValue(it.hangJungDong)
            row.createCell(2).setCellValue(it.veteransNumber)
            row.createCell(3).setCellValue(it.name)
            row.createCell(4).setCellValue(it.residentRegistrationNumber)
            row.createCell(5).setCellValue(it.address)
            row.createCell(6).setCellValue(it.depositType)
            row.createCell(7).setCellValue(it.bankName)
            row.createCell(8).setCellValue(it.accountHolder)
            row.createCell(9).setCellValue(it.bankAccountNumber)
            row.createCell(10).setCellValue(it.sibi.toString())
            row.createCell(11).setCellValue(it.gubi.toString())
            row.createCell(11).setCellValue(it.note)
        }
    }

    private fun createCashPaymentSheet(excel: Workbook, type: AllowanceType) {
        val sheet = excel.createSheet()
        val headerRow = sheet.createRow(0)
        headerRow.createCell(0).setCellValue("연번")
        headerRow.createCell(1).setCellValue("행정동")
        headerRow.createCell(2).setCellValue("보훈번호")
        headerRow.createCell(3).setCellValue("성명")
        headerRow.createCell(4).setCellValue("주민등록번호")
        headerRow.createCell(5).setCellValue("주소")
        headerRow.createCell(6).setCellValue("입금유형")
        headerRow.createCell(7).setCellValue("시비")
        headerRow.createCell(8).setCellValue("구비")
        headerRow.createCell(9).setCellValue("비고")

        val cashPayments = cashPaymentStatusJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
        cashPayments.forEachIndexed { idx, it ->
            val row = sheet.createRow(idx + 1)
            row.createCell(0).setCellValue(it.serialNumber.toString())
            row.createCell(1).setCellValue(it.hangJungDong)
            row.createCell(2).setCellValue(it.veteransNumber)
            row.createCell(3).setCellValue(it.name)
            row.createCell(4).setCellValue(it.residentRegistrationNumber)
            row.createCell(5).setCellValue(it.address)
            row.createCell(6).setCellValue(it.depositType)
            row.createCell(7).setCellValue(it.sibi.toString())
            row.createCell(8).setCellValue(it.gubi.toString())
            row.createCell(9).setCellValue(it.note)
        }
    }

    private fun createNewcomerSheet(excel: Workbook, type: AllowanceType) {
        val sheet = excel.createSheet()
        val headerRow = sheet.createRow(0)
        headerRow.createCell(0).setCellValue("연번")
        headerRow.createCell(1).setCellValue("행정동")
        headerRow.createCell(2).setCellValue("보훈번호")
        headerRow.createCell(3).setCellValue("성명")
        headerRow.createCell(4).setCellValue("주민등록번호")
        headerRow.createCell(5).setCellValue("주소")
        headerRow.createCell(6).setCellValue("입금유형")
        headerRow.createCell(7).setCellValue("은행명")
        headerRow.createCell(8).setCellValue("예금주")
        headerRow.createCell(9).setCellValue("계좌번호")
        headerRow.createCell(10).setCellValue("신규사유")
        headerRow.createCell(11).setCellValue("전입(등록)일")
        headerRow.createCell(12).setCellValue("비고")

//        val newcomers = newcomerJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
//        newcomers.forEachIndexed { idx, it ->
//            val row = sheet.createRow(idx + 1)
//            row.createCell(0).setCellValue(it.serialNumber)
//            row.createCell(1).setCellValue(it.hangJungDong)
//            row.createCell(2).setCellValue(it.veteransNumber)
//            row.createCell(3).setCellValue(it.name)
//            row.createCell(4).setCellValue(it.residentRegistrationNumber)
//            row.createCell(5).setCellValue(it.address)
//            row.createCell(6).setCellValue(it.depositType)
//            row.createCell(7).setCellValue(it.bankName)
//            row.createCell(8).setCellValue(it.accountHolder)
//            row.createCell(9).setCellValue(it.bankAccountNumber)
//            row.createCell(10).setCellValue(it.transferReason)
//            row.createCell(11).setCellValue(it.transferDate)
//            row.createCell(12).setCellValue(it.note)
//        }
    }

    private fun createPaymentStoppedSheet(excel: Workbook, type: AllowanceType) {
        val sheet = excel.createSheet()
        val headerRow = sheet.createRow(0)
        headerRow.createCell(0).setCellValue("연번")
        headerRow.createCell(1).setCellValue("행정동")
        headerRow.createCell(2).setCellValue("보훈번호")
        headerRow.createCell(3).setCellValue("성명")
        headerRow.createCell(4).setCellValue("주민등록번호")
        headerRow.createCell(5).setCellValue("주소")
        headerRow.createCell(6).setCellValue("입금유형")
        headerRow.createCell(7).setCellValue("은행명")
        headerRow.createCell(8).setCellValue("예금주")
        headerRow.createCell(9).setCellValue("계좌번호")
        headerRow.createCell(10).setCellValue("중단사유")
        headerRow.createCell(11).setCellValue("중단사유 발생일")
        headerRow.createCell(12).setCellValue("비고")
        headerRow.createCell(13).setCellValue("전입지 주소")

        val newcomers = paymentStoppedJpaRepository.findByAllowanceTypeOrderBySerialNumberAsc(type)
        newcomers.forEachIndexed { idx, it ->
            val row = sheet.createRow(idx + 1)
            row.createCell(0).setCellValue(it.serialNumber.toString())
            row.createCell(1).setCellValue(it.hangJungDong)
            row.createCell(2).setCellValue(it.veteransNumber)
            row.createCell(3).setCellValue(it.name)
            row.createCell(4).setCellValue(it.residentRegistrationNumber)
            row.createCell(5).setCellValue(it.address)
            row.createCell(6).setCellValue(it.depositType)
            row.createCell(7).setCellValue(it.bankName)
            row.createCell(8).setCellValue(it.accountHolder)
            row.createCell(9).setCellValue(it.bankAccountNumber)
            row.createCell(10).setCellValue(it.stoppedReason)
            row.createCell(11).setCellValue(it.stoppedDate)
            row.createCell(12).setCellValue(it.note)
            row.createCell(13).setCellValue(it.transferAddress)
        }
    }
}