package com.kdpark0723.keyboardchanger.integrate

import com.kdpark0723.keyboardchanger.api.GetChangedKeyboardStringFromEnglishToJapaneseApi
import com.kdpark0723.keyboardchanger.route.RoutesConfig
import com.kdpark0723.keyboardchanger.unit.ServerTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


class GetChangedKeyboardStringFromEnglishToJapaneseTest(
    @Autowired config: RoutesConfig
) : ServerTest(config) {

    private val api = GetChangedKeyboardStringFromEnglishToJapaneseApi(client)

    @Test
    fun getChangedKeyboardStringFromEnglishTestSuccess() {
        api.getChangedKeyboardStringSuccess("xptmxm")
    }

    @Test
    fun getChangedKeyboardStringFromEnglishTestFailBecauseTypeIsInvalid() {
        api.getChangedKeyboardStringFailBecauseForbidden("xptmxm", "invalid")
    }

}