package com.example.yuseong_allowancepayments_be.thirdparty.excel

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.CashPaymentStatus
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.Newcomer
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.PaymentStopped
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.PaymentTarget
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.domain.repository.NewcomerJpaRepository
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.AllowanceInfo
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Component
import org.springframework.util.PatternMatchUtils
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class ExcelUtil(
    private val newcomerJpaRepository: NewcomerJpaRepository
) {
    fun getAllowanceInfo(file: MultipartFile, type: AllowanceType): AllowanceInfo {
        val workbook = file.transferToExcel()
        val paymentTargets = getPaymentTarget(workbook.getSheetAt(0), type)
        val cachePayments = getCashPayment(workbook.getSheetAt(1), type)
        val newcomers = getNewcomer(workbook.getSheetAt(2), type)
        val paymentStopped = getPaymentStopped(workbook.getSheetAt(3), type)

        return AllowanceInfo(
            paymentTargets = paymentTargets,
            cashPayments = cachePayments,
            newcomers = newcomers,
            paymentStopped = paymentStopped
        )
    }

    fun MultipartFile.transferToExcel(): Workbook {
        val inputStream = this.inputStream

        return inputStream.use {
            runCatching {
                when (this.originalFilename?.split('.')?.get(1)) {
                    "xls" -> HSSFWorkbook(inputStream)
                    "xlsx" -> XSSFWorkbook(inputStream)
                    else -> throw RuntimeException("Invalid File")
                }
            }.onFailure {
                it.printStackTrace()
                throw RuntimeException("Invalid File")
            }.getOrThrow()
        }
    }

    private fun getPaymentTarget(workSheet: Sheet, allowanceType: AllowanceType): List<PaymentTarget> {
        val results = mutableListOf<PaymentTarget>()
        for (i in 2..workSheet.lastRowNum) {
            val row = workSheet.getRow(i)
            val depositType = row.getCell(6).stringCellValue
            PatternMatchUtils.simpleMatch("*:*", depositType)
            results.add(
                PaymentTarget(
                    serialNumber = row.getCell(0).numericCellValue.toInt(),
                    hangJungDong = row.getCell(1).stringCellValue,
                    veteransNumber = row.getCell(2).stringCellValue,
                    name = row.getCell(3).stringCellValue,
                    residentRegistrationNumber = row.getCell(4).stringCellValue,
                    address = row.getCell(5).stringCellValue,
                    depositType = row.getCell(6).stringCellValue,
                    bankName = row.getCell(7).stringCellValue,
                    accountHolder = row.getCell(8).stringCellValue,
                    bankAccountNumber = row.getCell(9).stringCellValue,
                    sibi = row.getCell(10).numericCellValue.toInt(),
                    gubi = row.getCell(11).numericCellValue.toInt(),
                    note = row.getCell(12).stringCellValue,
                    allowanceType = allowanceType
                )
            )
        }

        return results;
    }

    private fun getCashPayment(workSheet: Sheet, allowanceType: AllowanceType): List<CashPaymentStatus> {
        val results = mutableListOf<CashPaymentStatus>()
        for (i in 2..workSheet.lastRowNum) {
            val row = workSheet.getRow(i)
            results.add(
                CashPaymentStatus(
                    serialNumber = row.getCell(0).numericCellValue.toInt(),
                    hangJungDong = row.getCell(1).stringCellValue,
                    veteransNumber = row.getCell(2).stringCellValue,
                    name = row.getCell(3).stringCellValue,
                    residentRegistrationNumber = row.getCell(4).stringCellValue,
                    address = row.getCell(5).stringCellValue,
                    depositType = row.getCell(6).stringCellValue,
                    sibi = row.getCell(7).numericCellValue.toInt(),
                    gubi = row.getCell(8).numericCellValue.toInt(),
                    note = row.getCell(9).stringCellValue,
                    allowanceType = allowanceType
                )
            )
        }

        return results;
    }

    private fun getNewcomer(workSheet: Sheet, allowanceType: AllowanceType): List<Newcomer> {
        val results = mutableListOf<Newcomer>()
        for (i in 2..workSheet.lastRowNum) {
            val row = workSheet.getRow(i)
            results.add(
                Newcomer(
                    serialNumber = row.getCell(0).numericCellValue.toInt(),
                    hangJungDong = row.getCell(1).stringCellValue,
                    veteransNumber = row.getCell(2).stringCellValue,
                    name = row.getCell(3).stringCellValue,
                    residentRegistrationNumber = row.getCell(4).stringCellValue,
                    address = row.getCell(5).stringCellValue,
                    depositType = row.getCell(6).stringCellValue,
                    bankName = row.getCell(7).stringCellValue,
                    accountHolder = row.getCell(8).stringCellValue,
                    bankAccountNumber = row.getCell(9).stringCellValue,
                    transferReason = row.getCell(10).stringCellValue,
                    transferDate = LocalDate.parse(row.getCell(11).stringCellValue, DateTimeFormatter.ISO_DATE),
                    note = row.getCell(12).stringCellValue,
                    allowanceType = allowanceType
                )
            )
        }

        return results;
    }

    private fun getPaymentStopped(workSheet: Sheet, allowanceType: AllowanceType): List<PaymentStopped> {
        val results = mutableListOf<PaymentStopped>()
        for (i in 2..workSheet.lastRowNum) {
            val row = workSheet.getRow(i)
            results.add(
                PaymentStopped(
                    serialNumber = row.getCell(0).numericCellValue.toInt(),
                    hangJungDong = row.getCell(1).stringCellValue,
                    veteransNumber = row.getCell(2).stringCellValue,
                    name = row.getCell(3).stringCellValue,
                    residentRegistrationNumber = row.getCell(4).stringCellValue,
                    address = row.getCell(5).stringCellValue,
                    depositType = row.getCell(6).stringCellValue,
                    bankName = row.getCell(7).stringCellValue,
                    accountHolder = row.getCell(8).stringCellValue,
                    bankAccountNumber = row.getCell(9).stringCellValue,
                    stoppedReason = row.getCell(10).stringCellValue,
                    stoppedDate = LocalDate.parse(row.getCell(11).stringCellValue, DateTimeFormatter.ISO_DATE),
                    note = row.getCell(12).stringCellValue,
                    transferAddress = row.getCell(13).stringCellValue,
                    allowanceType = allowanceType
                )
            )
        }

        return results;
    }
}