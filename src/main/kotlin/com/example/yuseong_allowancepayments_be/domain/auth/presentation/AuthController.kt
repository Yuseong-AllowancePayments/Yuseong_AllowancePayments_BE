package com.example.yuseong_allowancepayments_be.domain.auth.presentation

import com.example.yuseong_allowancepayments_be.domain.allowance.dto.LoginRequest
import com.example.yuseong_allowancepayments_be.domain.auth.dto.GetCenterPinCodesResponse
import com.example.yuseong_allowancepayments_be.domain.auth.dto.IssuePinCodeRequest
import com.example.yuseong_allowancepayments_be.domain.auth.dto.TokenResponse
import com.example.yuseong_allowancepayments_be.domain.auth.service.GetCenterPinCodesService
import com.example.yuseong_allowancepayments_be.domain.auth.service.IssuePinCodeService
import com.example.yuseong_allowancepayments_be.domain.auth.service.LoginService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("/auth")
class AuthController(
    private val loginService: LoginService,
    private val issuePinCodeService: IssuePinCodeService,
    private val getCenterPinCodesService: GetCenterPinCodesService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/token")
    fun login(@RequestBody request: LoginRequest): TokenResponse {
        return loginService.execute(request)
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
}