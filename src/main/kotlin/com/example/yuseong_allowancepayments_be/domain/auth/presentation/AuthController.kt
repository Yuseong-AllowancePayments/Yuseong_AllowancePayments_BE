package com.example.yuseong_allowancepayments_be.domain.auth.presentation

import com.example.yuseong_allowancepayments_be.domain.allowance.dto.AdminLoginRequest
import com.example.yuseong_allowancepayments_be.domain.allowance.dto.LoginRequest
import com.example.yuseong_allowancepayments_be.domain.auth.dto.GetCenterPinCodesResponse
import com.example.yuseong_allowancepayments_be.domain.auth.dto.IssuePinCodeRequest
import com.example.yuseong_allowancepayments_be.domain.auth.dto.TokenResponse
import com.example.yuseong_allowancepayments_be.domain.auth.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val loginService: LoginService,
    private val issuePinCodeService: IssuePinCodeService,
    private val getCenterPinCodesService: GetCenterPinCodesService,
    private val adminLoginService: AdminLoginService,
    private val removePinCodeService: RemovePinCodeService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/token")
    fun login(@RequestBody request: LoginRequest): TokenResponse {
        return loginService.execute(request)
    }

    @PostMapping("/admin/token")
    fun adminLogin(@RequestBody request: AdminLoginRequest): TokenResponse {
        return adminLoginService.execute(request)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pin")
    fun issuePinCode(@RequestBody request: IssuePinCodeRequest) {
        issuePinCodeService.execute(request)
    }

    @GetMapping("/pin")
    fun getCenterPinCodes(): GetCenterPinCodesResponse {
        return getCenterPinCodesService.execute()
    }

    @DeleteMapping("/pin/{code}")
    fun removePinCode(@PathVariable("code") code: String) {
        removePinCodeService.execute(code)
    }
}