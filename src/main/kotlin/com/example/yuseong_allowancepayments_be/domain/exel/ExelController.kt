package com.example.yuseong_allowancepayments_be.domain.exel

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.exel.dto.ParseExelResponse
import com.example.yuseong_allowancepayments_be.thirdparty.excel.ExcelUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/excel")
class ExelController(
    private val excelUtil: ExcelUtil
) {

    @GetMapping("/parse")
    fun parseFile(@RequestPart file: MultipartFile): ParseExelResponse {
        val parsed = excelUtil.getAllowanceInfo(file, AllowanceType.WAR_VETERAN)

        return ParseExelResponse(
            paymentTargetTab = parsed.paymentTargets.map { it.toResponse() },
            cashPaymentTab = parsed.cashPayments.map { it.toResponse() },
            newComerTab = parsed.newcomers.map { it.toResponse() },
            paymentStoppedTab = parsed.paymentStopped.map { it.toResponse() }
        )
    }
}