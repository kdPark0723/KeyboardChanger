package com.kdpark0723.keyboardchanger.api

import com.kdpark0723.keyboardchanger.model.KeyboardString
import com.kdpark0723.keyboardchanger.response.ErrorResponse
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

open class GetChangedKeyboardStringFromEnglishApi(
    private val client: WebTestClient,
    private val url: String
) : Api() {

    fun getChangedKeyboardStringSuccess(value: String, type: String = "en"): KeyboardString? {
        val response = getChangedKeyboardString(value, type)

        val responseBodySpec = response
            .expectStatus().isOk
            .expectBody<KeyboardString>()

        return getResponseBody(responseBodySpec)
    }

    fun getChangedKeyboardStringFailBecauseForbidden(value: String, type: String = "en"): ErrorResponse? {
        val response = getChangedKeyboardString(value, type)

        val responseBodySpec = response
            .expectStatus().isForbidden
            .expectBody<ErrorResponse>()

        return getResponseBody(responseBodySpec)
    }

    private fun getChangedKeyboardString(value: String, type: String): WebTestClient.ResponseSpec {
        return client.get()
            .uri("$url/$value?type=$type")
            .exchange()
    }
}