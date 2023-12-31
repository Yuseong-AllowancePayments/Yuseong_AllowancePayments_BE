package com.example.yuseong_allowancepayments_be.domain.allowance.presentation

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.QueryAllowanceInfoResponse
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdateCashPaymentStatusRequest
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdateNewcomerRequest
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdatePaymentStoppedRequest
import com.example.yuseong_allowancepayments_be.domain.allowance.presentation.dto.UpdatePaymentTargetRequest
import com.example.yuseong_allowancepayments_be.domain.allowance.service.ExportAllowanceInfoService
import com.example.yuseong_allowancepayments_be.domain.allowance.service.GetAllowanceService
import com.example.yuseong_allowancepayments_be.domain.allowance.service.SaveAllowanceInfoService
import com.example.yuseong_allowancepayments_be.domain.allowance.service.UpdateCashPaymentStatusService
import com.example.yuseong_allowancepayments_be.domain.allowance.service.UpdateNewcomerService
import com.example.yuseong_allowancepayments_be.domain.allowance.service.UpdatePaymentStoppedService
import com.example.yuseong_allowancepayments_be.domain.allowance.service.UpdatePaymentTargetService
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.net.URLEncoder
import java.time.LocalDate
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/allowance")
class AllowanceController(
    private val saveAllowanceInfoService: SaveAllowanceInfoService,
    private val exportAllowanceInfoService: ExportAllowanceInfoService,
    private val getAllowanceService: GetAllowanceService,
    private val updateNewcomerService: UpdateNewcomerService,
    private val updateCashPaymentStatusService: UpdateCashPaymentStatusService,
    private val updatePaymentStoppedService: UpdatePaymentStoppedService,
    private val updatePaymentTargetService: UpdatePaymentTargetService,
) {

    @PostMapping
    fun uploadExcelFile(@RequestPart file: MultipartFile, @RequestParam @NotNull type: AllowanceType) {
        saveAllowanceInfoService.execute(file, type)
    }

    @GetMapping("/export")
    fun exportData(
        @RequestParam type: AllowanceType,
        response: HttpServletResponse
    ): ByteArray {
        val file = exportAllowanceInfoService.execute(type)

        response.setHeader(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=${URLEncoder.encode("${LocalDate.now().year}.${LocalDate.now().month.value}월 ${type.fileName}", "UTF-8")}.xlsx"
        )

        return file
    }

    @GetMapping
    fun getAllowanceList(
        @RequestParam type: AllowanceType,
    ): QueryAllowanceInfoResponse {
        return getAllowanceService.execute(type)
    }

    @PatchMapping("/newcomer/{id}")
    fun updateNewcomer(@PathVariable("id") id: Long, @RequestBody request: UpdateNewcomerRequest) {
        updateNewcomerService.execute(id, request)
    }

    @PatchMapping("/cash/{id}")
    fun updateNewcomer(@PathVariable("id") id: Long, @RequestBody request: UpdateCashPaymentStatusRequest) {
        updateCashPaymentStatusService.execute(id, request)
    }

    @PatchMapping("/target/{id}")
    fun updateTarget(@PathVariable("id") id: Long, @RequestBody request: UpdatePaymentTargetRequest) {
        updatePaymentTargetService.execute(id, request)
    }

    @PatchMapping("/stopped/{id}")
    fun updateNewcomer(@PathVariable("id") id: Long, @RequestBody request: UpdatePaymentStoppedRequest) {
        updatePaymentStoppedService.execute(id, request)
    }
}