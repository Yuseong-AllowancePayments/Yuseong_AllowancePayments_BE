package com.example.yuseong_allowancepayments_be.global.utill

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.CashPaymentStatus
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.Newcomer
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentStopped
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.PaymentTarget
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.HONORABLE_ALLOWANCE
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.WAR_VETERAN
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.WAR_VETERAN_SPOUSE
import org.apache.poi.ss.usermodel.Sheet

fun PaymentTarget.toExcelRow(sheet: Sheet, rowNum: Int) {
    val row = sheet.createRow(rowNum)

    row.createCell(0).setCellValue(this.serialNumber)
    row.createCell(1).setCellValue(this.hangJungDong)
    row.createCell(2).setCellValue(this.veteransNumber)
    row.createCell(3).setCellValue(this.name)
    row.createCell(4).setCellValue(this.residentRegistrationNumber)
    row.createCell(5).setCellValue(this.address)
    row.createCell(6).setCellValue(this.depositType)
    row.createCell(7).setCellValue(this.bankName)
    row.createCell(8).setCellValue(this.accountHolder)
    row.createCell(9).setCellValue(this.bankAccountNumber)
    row.createCell(10).setCellValue(this.sibi.toString())
    row.createCell(11).setCellValue(this.gubi.toString())
    row.createCell(11).setCellValue(this.note)
}

fun CashPaymentStatus.toExcelRow(sheet: Sheet, rowNum: Int) {
    val row = sheet.createRow(rowNum)

    row.createCell(0).setCellValue(this.serialNumber)
    row.createCell(1).setCellValue(this.hangJungDong)
    row.createCell(2).setCellValue(this.veteransNumber)
    row.createCell(3).setCellValue(this.name)
    row.createCell(4).setCellValue(this.residentRegistrationNumber)
    row.createCell(5).setCellValue(this.address)
    row.createCell(6).setCellValue(this.depositType)
    row.createCell(7).setCellValue(this.sibi.toString())
    row.createCell(8).setCellValue(this.gubi.toString())
    row.createCell(9).setCellValue(this.note)
}

fun Newcomer.toExcelRow(sheet: Sheet, rowNum: Int) {
    val row = sheet.createRow(rowNum)

    when (this.allowanceType) {
        WAR_VETERAN -> {
            row.createCell(0).setCellValue(this.serialNumber)
            row.createCell(1).setCellValue(this.hangJungDong)
            row.createCell(2).setCellValue(this.veteransNumber)
            row.createCell(3).setCellValue(this.applicantName)
            row.createCell(4).setCellValue(this.applicantID)
            row.createCell(5).setCellValue(this.applicantAddressDetail)
            row.createCell(6).setCellValue(this.depositType)
            row.createCell(7).setCellValue(this.bankName)
            row.createCell(8).setCellValue(this.accountHolder)
            row.createCell(9).setCellValue(this.bankAccountNumber)
            row.createCell(10).setCellValue(this.transferDate)
            row.createCell(11).setCellValue(this.applicationDate)
            row.createCell(12).setCellValue(this.applicationReason)
            row.createCell(13).setCellValue(this.note)
        }

        WAR_VETERAN_SPOUSE -> {
            row.createCell(0).setCellValue(this.serialNumber)
            row.createCell(1).setCellValue(this.hangJungDong)
            row.createCell(2).setCellValue(this.applicantName)
            row.createCell(3).setCellValue(this.applicantID)
            row.createCell(4).setCellValue(this.applicantPhoneNumber)
            row.createCell(5).setCellValue(this.nationalMeritName)
            row.createCell(6).setCellValue(this.nationalMeritID)
            row.createCell(7).setCellValue(this.warType)
            row.createCell(8).setCellValue(this.nationalMeritDateOfDeath)
            row.createCell(9).setCellValue(this.applicantAddressDetail)
            row.createCell(10).setCellValue(this.depositType)
            row.createCell(11).setCellValue(this.bankName)
            row.createCell(12).setCellValue(this.accountHolder)
            row.createCell(13).setCellValue(this.bankAccountNumber)
            row.createCell(14).setCellValue(this.transferDate)
            row.createCell(15).setCellValue(this.applicationDate)
            row.createCell(16).setCellValue(this.applicationReason)
            row.createCell(17).setCellValue(this.note)
        }

        HONORABLE_ALLOWANCE -> {
            row.createCell(0).setCellValue(this.serialNumber)
            row.createCell(1).setCellValue(this.hangJungDong)
            row.createCell(2).setCellValue(this.veteransNumber)
            row.createCell(3).setCellValue(this.applicantName)
            row.createCell(4).setCellValue(this.applicantID)
            row.createCell(5).setCellValue(this.veteransType)
            row.createCell(6).setCellValue(this.applicantGender)
            row.createCell(7).setCellValue(this.applicantPhoneNumber)
            row.createCell(8).setCellValue(this.applicantAddressDetail)
            row.createCell(9).setCellValue(this.depositType)
            row.createCell(10).setCellValue(this.bankName)
            row.createCell(11).setCellValue(this.accountHolder)
            row.createCell(12).setCellValue(this.bankAccountNumber)
            row.createCell(13).setCellValue(this.familyRelation)
            row.createCell(14).setCellValue(this.bereavedFamily)
            row.createCell(15).setCellValue(this.transferDate)
            row.createCell(16).setCellValue(this.applicationDate)
            row.createCell(17).setCellValue(this.applicationReason)
            row.createCell(18).setCellValue(this.note)
        }
    }
}

fun PaymentStopped.toExcelRow(sheet: Sheet, rowNum: Int) {
    val row = sheet.createRow(rowNum)

    row.createCell(0).setCellValue(this.serialNumber)
    row.createCell(1).setCellValue(this.hangJungDong)
    row.createCell(2).setCellValue(this.veteransNumber)
    row.createCell(3).setCellValue(this.name)
    row.createCell(4).setCellValue(this.residentRegistrationNumber)
    row.createCell(5).setCellValue(this.address)
    row.createCell(6).setCellValue(this.depositType)
    row.createCell(7).setCellValue(this.bankName)
    row.createCell(8).setCellValue(this.accountHolder)
    row.createCell(9).setCellValue(this.bankAccountNumber)
    row.createCell(10).setCellValue(this.stoppedReason)
    row.createCell(11).setCellValue(this.stoppedDate)
    row.createCell(12).setCellValue(this.note)
    row.createCell(13).setCellValue(this.transferAddress)
}