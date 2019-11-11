package com.kdpark0723.keyboardchanger.unit

import com.kdpark0723.keyboardchanger.api.GetChangedKeyboardStringFromEnglishApi
import com.kdpark0723.keyboardchanger.route.RoutesConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.reactive.server.WebTestClient


class GetChangedKeyboardStringFromEnglishTest(
    @Autowired config: RoutesConfig
) : ServerTest() {
    private val client = WebTestClient
        .bindToRouterFunction(config.routes())
        .build()

    private val api = GetChangedKeyboardStringFromEnglishApi(client)

    @Test
    fun getChangedKeyboardStringFromEnglishTestSuccess() {
        api.getChangedKeyboardStringSuccess("xptmxm")
    }

}