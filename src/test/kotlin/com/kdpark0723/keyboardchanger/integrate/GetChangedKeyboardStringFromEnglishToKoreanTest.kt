package com.kdpark0723.keyboardchanger.integrate

import com.kdpark0723.keyboardchanger.api.GetChangedKeyboardStringFromEnglishToKoreanApi
import com.kdpark0723.keyboardchanger.route.RoutesConfig
import com.kdpark0723.keyboardchanger.unit.ServerTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


class GetChangedKeyboardStringFromEnglishToKoreanTest(
    @Autowired config: RoutesConfig
) : ServerTest(config) {

    private val api = GetChangedKeyboardStringFromEnglishToKoreanApi(client)

    @Test
    fun getChangedKeyboardStringFromEnglishTestSuccess() {
        api.getChangedKeyboardStringSuccess("xptmxm")
    }

    @Test
    fun getChangedKeyboardStringFromEnglishTestFailBecauseTypeIsInvalid() {
        api.getChangedKeyboardStringFailBecauseForbidden("xptmxm", "invalid")
    }

}