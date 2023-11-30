package com.example.yuseong_allowancepayments_be.domain.allowance.presentation

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.dto.LoginRequest
import com.example.yuseong_allowancepayments_be.domain.allowance.service.SaveAllowanceInfoService
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController("/allowance")
class AllowanceController(
    private val saveAllowanceInfoService: SaveAllowanceInfoService
) {

    @PostMapping
    fun uploadExcelFile(@RequestPart file: MultipartFile, @RequestParam @NotNull type: AllowanceType) {
        saveAllowanceInfoService.execute(file, type)
    }
}