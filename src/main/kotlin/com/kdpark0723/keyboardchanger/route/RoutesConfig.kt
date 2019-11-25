package com.kdpark0723.keyboardchanger.route

import keyboardchanger.handel.GetChangedKeyboardStringToJapaneseHandler
import keyboardchanger.handel.GetChangedKeyboardStringToKoreanHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.router

@Configuration
@EnableWebFlux
class RoutesConfig : WebFluxConfigurer {

    private val koreanHandler = GetChangedKeyboardStringToKoreanHandler()
    private val japaneseHandler = GetChangedKeyboardStringToJapaneseHandler()

    @Bean
    fun routes() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/korean/{value}", koreanHandler::handleRequest)
            GET("/japanese/{value}", japaneseHandler::handleRequest)
        }
    }
}
