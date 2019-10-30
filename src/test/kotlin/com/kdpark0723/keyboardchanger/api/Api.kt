package com.kdpark0723.keyboardchanger.api

import org.springframework.test.web.reactive.server.KotlinBodySpec

open class Api {

    protected fun <T> getResponseBody(responseBodySpec: KotlinBodySpec<T>): T {
        return responseBodySpec
            .returnResult()
            .responseBody!!
    }
}