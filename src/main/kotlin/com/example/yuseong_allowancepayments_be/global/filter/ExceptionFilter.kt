package com.example.yuseong_allowancepayments_be.global.filter

import com.example.yuseong_allowancepayments_be.global.error.CustomException
import com.example.yuseong_allowancepayments_be.global.error.response.BaseErrorResponse
import com.example.yuseong_allowancepayments_be.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is CustomException -> sendErrorMessage(e, response)
                else -> sendErrorMessage(InternalServerErrorException.EXCEPTION, response)
            }
        }
    }

    private fun sendErrorMessage(exception: CustomException, response: HttpServletResponse) {
        val errorResponse = BaseErrorResponse.of(exception)

        response.characterEncoding = StandardCharsets.UTF_8.toString()
        response.status = errorResponse.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}