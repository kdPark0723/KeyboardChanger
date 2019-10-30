package com.kdpark0723.keyboardchanger.api

import com.kdpark0723.keyboardchanger.model.KeyboardString
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

class GetChangedKeyboardStringFromEnglishApi(
    private val client: WebTestClient
) : Api() {

    private val url = "english"

    fun getChangedKeyboardStringSuccess(value: String): KeyboardString {
        val response = getChangedKeyboardString(value)

        val responseBodySpec = response
            .expectStatus().isOk
            .expectBody<KeyboardString>()

        return getResponseBody(responseBodySpec)
    }

    private fun getChangedKeyboardString(value: String): WebTestClient.ResponseSpec {
        return client.get()
            .uri("$url/$value")
            .exchange()
    }
}