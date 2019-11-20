package com.kdpark0723.keyboardchanger.filter

import org.springframework.http.codec.HttpMessageWriter
import org.springframework.web.reactive.function.server.HandlerStrategies
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.result.view.ViewResolver

class HandlerStrategiesResponseContext(private val strategies: HandlerStrategies) : ServerResponse.Context {

    override fun messageWriters(): List<HttpMessageWriter<*>> = this.strategies.messageWriters()

    override fun viewResolvers(): List<ViewResolver> = this.strategies.viewResolvers()
}