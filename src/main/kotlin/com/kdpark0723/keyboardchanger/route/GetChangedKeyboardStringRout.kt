package com.kdpark0723.keyboardchanger.route

import keyboardchanger.handel.GetChangedKeyboardStringFromEnglishHandler
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

val handler = GetChangedKeyboardStringFromEnglishHandler()

val route = router {
    // (1)
    accept(APPLICATION_JSON).nest {
        GET("/english/{value}", handler::handleRequest)
    }
}

