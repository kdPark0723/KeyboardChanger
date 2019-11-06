package com.kdpark0723.keyboardchanger.unit

import com.kdpark0723.keyboardchanger.api.GetChangedKeyboardStringFromEnglishApi
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@WebFluxTest
class GetChangedKeyboardStringFromEnglishTest {

    @Autowired
    private lateinit var client: WebTestClient

    private val api = GetChangedKeyboardStringFromEnglishApi(client)

    @Test
    fun getChangedKeyboardStringFromEnglishTestSuccess() {
        api.getChangedKeyboardStringSuccess("xptmxm")
    }
}