package com.example.yuseong_allowancepayments_be

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class YuseongAllowancePaymentsBeApplication

fun main(args: Array<String>) {
    runApplication<YuseongAllowancePaymentsBeApplication>(*args)
}
