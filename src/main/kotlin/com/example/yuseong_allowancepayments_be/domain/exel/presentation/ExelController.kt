package com.example.yuseong_allowancepayments_be.domain.exel.presentation

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.HONORABLE_ALLOWANCE
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.WAR_VETERAN
import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType.WAR_VETERAN_SPOUSE
import com.example.yuseong_allowancepayments_be.thirdparty.excel.AllowanceExcelUtil
import com.example.yuseong_allowancepayments_be.thirdparty.excel.dto.ParseAllowanceInfo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/excel")
class ExelController(
    private val allowanceExcelUtil: AllowanceExcelUtil
) {
    @PostMapping("/veteran")
    fun parseVeteran(@RequestPart file: MultipartFile): ParseAllowanceInfo =
        allowanceExcelUtil.parseAllowanceExcel(file, WAR_VETERAN)

    @PostMapping("/spouce")
    fun parseSpouce(@RequestPart file: MultipartFile): ParseAllowanceInfo =
        allowanceExcelUtil.parseAllowanceExcel(file, WAR_VETERAN_SPOUSE)

    @PostMapping("/courtesy")
    fun parseCourtesy(@RequestPart file: MultipartFile): ParseAllowanceInfo =
        allowanceExcelUtil.parseAllowanceExcel(file, HONORABLE_ALLOWANCE)
}