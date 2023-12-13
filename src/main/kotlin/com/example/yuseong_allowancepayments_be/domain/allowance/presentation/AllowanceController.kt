package com.example.yuseong_allowancepayments_be.domain.allowance.presentation

import com.example.yuseong_allowancepayments_be.domain.allowance.persistence.enums.AllowanceType
import com.example.yuseong_allowancepayments_be.domain.allowance.service.ExportAllowanceInfoService
import com.example.yuseong_allowancepayments_be.domain.allowance.service.SaveAllowanceInfoService
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/allowance")
class AllowanceController(
    private val saveAllowanceInfoService: SaveAllowanceInfoService,
    private val exportAllowanceInfoService: ExportAllowanceInfoService
) {

    @PostMapping
    fun uploadExcelFile(@RequestPart file: MultipartFile, @RequestParam @NotNull type: AllowanceType) {
        saveAllowanceInfoService.execute(file, type)
    }

    @GetMapping("/export")
    fun exportData(
        @RequestParam type: AllowanceType,
        response: HttpServletResponse
    ) {
        val file = exportAllowanceInfoService.execute(type)

        response.contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        response.outputStream.write(file)
    }
}