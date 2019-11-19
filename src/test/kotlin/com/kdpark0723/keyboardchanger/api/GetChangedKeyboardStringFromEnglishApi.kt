package com.kdpark0723.keyboardchanger.api

import com.kdpark0723.keyboardchanger.model.KeyboardString
import com.kdpark0723.keyboardchanger.response.ErrorResponse
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

class GetChangedKeyboardStringFromEnglishApi(
    private val client: WebTestClient
) : Api() {

    private val url = "/english"

    fun getChangedKeyboardStringSuccess(value: String, type: String = "ko"): KeyboardString {
        val response = getChangedKeyboardString(value, type)

        val responseBodySpec = response
            .expectStatus().isOk
            .expectBody<KeyboardString>()

        return getResponseBody(responseBodySpec)
    }

    fun getChangedKeyboardStringFailBecauseForbidden(value: String, type: String = "ko"): ErrorResponse {
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