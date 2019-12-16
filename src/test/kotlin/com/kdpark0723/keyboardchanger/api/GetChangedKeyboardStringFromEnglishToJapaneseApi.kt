package com.kdpark0723.keyboardchanger.api

import org.springframework.test.web.reactive.server.WebTestClient

class GetChangedKeyboardStringFromEnglishToJapaneseApi(
    client: WebTestClient
) : GetChangedKeyboardStringFromEnglishApi(client, "/japanese")