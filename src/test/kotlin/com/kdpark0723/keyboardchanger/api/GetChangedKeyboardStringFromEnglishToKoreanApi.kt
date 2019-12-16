package com.kdpark0723.keyboardchanger.api

import org.springframework.test.web.reactive.server.WebTestClient

class GetChangedKeyboardStringFromEnglishToKoreanApi(
    client: WebTestClient
) : GetChangedKeyboardStringFromEnglishApi(client, "/korean")