package com.kdpark0723.keyboardchanger.route

import keyboardchanger.handel.GetChangedKeyboardStringFromEnglishHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.router

@Configuration
@EnableWebFlux
class RoutesConfig : WebFluxConfigurer {

    private val handler = GetChangedKeyboardStringFromEnglishHandler()

    @Bean
    fun routes() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/english/{value}", handler::handleRequest)
        }
    }
}
