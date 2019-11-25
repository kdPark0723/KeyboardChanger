package com.kdpark0723.keyboardchanger.unit

import com.kdpark0723.keyboardchanger.route.RoutesConfig
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class ServerTest(config: RoutesConfig) {
    protected val client = WebTestClient
        .bindToRouterFunction(config.routes())
        .build()
}