package com.example.yuseong_allowancepayments_be.domain.allowance.controller

import com.example.yuseong_allowancepayments_be.domain.allowance.domain.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.service.SaveAllowanceInfoService
import org.jetbrains.annotations.NotNull
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@Controller
class AllowanceController(
    private val saveAllowanceInfoService: SaveAllowanceInfoService
) {

    @PostMapping
    fun uploadExcelFile(@RequestPart file: MultipartFile, @RequestParam @NotNull type: AllowanceType) {
        saveAllowanceInfoService.execute(file, type)
    }
}