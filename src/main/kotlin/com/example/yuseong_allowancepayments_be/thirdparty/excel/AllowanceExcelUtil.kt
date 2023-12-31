package com.example.yuseong_allowancepayments_be.thirdparty.excel

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.HONORABLE_ALLOWANCE
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.WAR_VETERAN
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.WAR_VETERAN_SPOUSE
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.CNewcomerInfo
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.CashPaymentInfo
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.NewcomerInfo
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.ParseAllowanceInfo
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.PaymentStoppedInfo
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.PaymentTargetInfo
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.SNewcomerInfo
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.VNewcomerInfo
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType.NUMERIC
import org.apache.poi.ss.usermodel.CellType.STRING
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class AllowanceExcelUtil {

    fun parseAllowanceExcel(file: MultipartFile, type: AllowanceType): ParseAllowanceInfo {
        val workbook = file.transferToExcel("2111")
        val paymentTargets = getPaymentTarget(workbook.getSheetAt(0))
        val cachePayments = getCashPayment(workbook.getSheetAt(1))
        val newcomers = getNewcomer(workbook.getSheetAt(2), type)
        val paymentStopped = getPaymentStopped(workbook.getSheetAt(3))

        return ParseAllowanceInfo(
            paymentTargets,
            cachePayments,
            newcomers,
            paymentStopped
        )
    }

    private fun getPaymentTarget(sheet: Sheet): List<PaymentTargetInfo> {
        val results = mutableListOf<PaymentTargetInfo>()
        for (i in 4..sheet.lastRowNum) {
            val row = sheet.getRow(i)
            results.add(
                PaymentTargetInfo(
                    serialNum = row.getCell(0).stringFormatCellValue(),
                    administrativeAddress = row.getCell(1).stringFormatCellValue(),
                    affairsNum = row.getCell(2).stringFormatCellValue(),
                    name = row.getCell(3).stringFormatCellValue(),
                    sin = row.getCell(4).stringFormatCellValue(),
                    address = row.getCell(5).stringFormatCellValue(),
                    depositType = row.getCell(6).stringFormatCellValue(),
                    bankName = row.getCell(7).stringFormatCellValue(),
                    accountOwner = row.getCell(8).stringFormatCellValue(),
                    account = row.getCell(9).stringFormatCellValue(),
                    sibi = row.getCell(10).stringFormatCellValue(),
                    gubi = row.getCell(11).stringFormatCellValue(),
                    note = row.getCell(12).stringFormatCellValue()
                )
            )
        }

        return results
    }

    private fun getCashPayment(sheet: Sheet): List<CashPaymentInfo> {
        val results = mutableListOf<CashPaymentInfo>()
        for (i in 3..sheet.lastRowNum) {
            val row = sheet.getRow(i)
            results.add(
                CashPaymentInfo(
                    serialNum = row.getCell(0).stringFormatCellValue(),
                    administrativeAddress = row.getCell(1).stringFormatCellValue(),
                    affairsNum = row.getCell(2).stringFormatCellValue(),
                    name = row.getCell(3).stringFormatCellValue(),
                    sin = row.getCell(4).stringFormatCellValue(),
                    address = row.getCell(5).stringFormatCellValue(),
                    depositType = row.getCell(6).stringFormatCellValue(),
                    sibi = row.getCell(7).stringFormatCellValue(),
                    gubi = row.getCell(8).stringFormatCellValue(),
                    note = row.getCell(9).stringFormatCellValue()
                )
            )
        }

        return results
    }

    private fun getNewcomer(sheet: Sheet, type: AllowanceType): List<NewcomerInfo> {
        val results = mutableListOf<NewcomerInfo>()
        for (i in 2..sheet.lastRowNum) {
            val row = sheet.getRow(i)
            results.add(generateNewcomerInfoByType(row, type))
        }

        return results
    }

    private fun generateNewcomerInfoByType(row: Row, type: AllowanceType): NewcomerInfo =
        when (type) {
            WAR_VETERAN -> VNewcomerInfo(
                serialNum = row.getCell(0).stringFormatCellValue(),
                administrativeAddress = row.getCell(1).stringFormatCellValue(),
                registrationNum = row.getCell(2).stringFormatCellValue(),
                name = row.getCell(3).stringFormatCellValue(),
                sin = row.getCell(4).stringFormatCellValue(),
                address = row.getCell(5).stringFormatCellValue(),
                depositType = row.getCell(6).stringFormatCellValue(),
                bankName = row.getCell(7).stringFormatCellValue(),
                accountOwner = row.getCell(8).stringFormatCellValue(),
                account = row.getCell(9).stringFormatCellValue(),
                moveInDate = row.getCell(10).stringFormatCellValue(),
                applicationDate = row.getCell(11).stringFormatCellValue(),
                applicationReason = row.getCell(12).stringFormatCellValue(),
                note = row.getCell(13).stringFormatCellValue()
            )

            WAR_VETERAN_SPOUSE -> SNewcomerInfo(
                serialNum = row.getCell(0).stringFormatCellValue(),
                administrativeAddress = row.getCell(1).stringFormatCellValue(),
                applicantName = row.getCell(2).stringFormatCellValue(),
                applicantSin = row.getCell(3).stringFormatCellValue(),
                applicantPhoneNum = row.getCell(4).stringFormatCellValue(),
                veteranName = row.getCell(5).stringFormatCellValue(),
                veteranSin = row.getCell(6).stringFormatCellValue(),
                affairsNum = row.getCell(7).stringFormatCellValue(),
                warName = row.getCell(8).stringFormatCellValue(),
                deathDate = row.getCell(9).stringFormatCellValue(),
                address = row.getCell(10).stringFormatCellValue(),
                depositType = row.getCell(11).stringFormatCellValue(),
                bankName = row.getCell(9).stringFormatCellValue(),
                accountOwner = row.getCell(10).stringFormatCellValue(),
                account = row.getCell(11).stringFormatCellValue(),
                moveInDate = row.getCell(12).stringFormatCellValue(),
                applicationDate = row.getCell(13).stringFormatCellValue(),
                applicationReason = row.getCell(14).stringFormatCellValue(),
                note = row.getCell(15).stringFormatCellValue()
            )

            HONORABLE_ALLOWANCE -> CNewcomerInfo(
                serialNum = row.getCell(0).stringFormatCellValue(),
                administrativeAddress = row.getCell(1).stringFormatCellValue(),
                affairsNum = row.getCell(2).stringFormatCellValue(),
                applicantName = row.getCell(3).stringFormatCellValue(),
                applicantSin = row.getCell(4).stringFormatCellValue(),
                veteranType = row.getCell(5).stringFormatCellValue(),
                applicantGender = row.getCell(6).stringFormatCellValue(),
                applicantPhoneNum = row.getCell(7).stringFormatCellValue(),
                address = row.getCell(8).stringFormatCellValue(),
                depositType = row.getCell(9).stringFormatCellValue(),
                bankName = row.getCell(10).stringFormatCellValue(),
                accountOwner = row.getCell(11).stringFormatCellValue(),
                account = row.getCell(9).stringFormatCellValue(),
                relation = row.getCell(10).stringFormatCellValue(),
                priority = row.getCell(11).stringFormatCellValue(),
                moveInDate = row.getCell(12).stringFormatCellValue(),
                applicationDate = row.getCell(13).stringFormatCellValue(),
                applicationReason = row.getCell(14).stringFormatCellValue(),
                note = row.getCell(15).stringFormatCellValue()
            )
        }

    private fun getPaymentStopped(sheet: Sheet): List<PaymentStoppedInfo> {
        val results = mutableListOf<PaymentStoppedInfo>()
        for (i in 3..sheet.lastRowNum) {
            val row = sheet.getRow(i)
            results.add(
                PaymentStoppedInfo(
                    serialNum = row.getCell(0).stringFormatCellValue(),
                    administrativeAddress = row.getCell(1).stringFormatCellValue(),
                    affairsNum = row.getCell(2).stringFormatCellValue(),
                    name = row.getCell(3).stringFormatCellValue(),
                    sin = row.getCell(4).stringFormatCellValue(),
                    address = row.getCell(5).stringFormatCellValue(),
                    depositType = row.getCell(6).stringFormatCellValue(),
                    bankName = row.getCell(7).stringFormatCellValue(),
                    accountOwner = row.getCell(8).stringFormatCellValue(),
                    account = row.getCell(9).stringFormatCellValue(),
                    stoppageReason = row.getCell(10).stringFormatCellValue(),
                    stoppageDate = row.getCell(11).stringFormatCellValue(),
                    note = row.getCell(12).stringFormatCellValue(),
                    moveInAddress = row.getCell(13).stringFormatCellValue()
                )
            )
        }

        return results
    }

}

fun Cell.stringFormatCellValue(): String =
    when (this.cellType) {
        NUMERIC -> this.numericCellValue.toString()
        STRING -> this.stringCellValue
        else -> ""
    }