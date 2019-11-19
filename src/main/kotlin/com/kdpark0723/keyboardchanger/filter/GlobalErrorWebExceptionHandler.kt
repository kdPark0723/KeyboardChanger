package com.kdpark0723.keyboardchanger.filter

import com.kdpark0723.keyboardchanger.response.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.HandlerStrategies
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebExceptionHandler
import reactor.core.publisher.Mono


@Component
@Order(-2)
class GlobalErrorWebExceptionHandler : WebExceptionHandler {

    override fun handle(exchange: ServerWebExchange, ex: Throwable): Mono<Void> {
        return createResponse(ex)
            .flatMap {
                logger.error(ex.message)

                it.writeTo(exchange, HandlerStrategiesResponseContext(HandlerStrategies.withDefaults()))
            }.flatMap { Mono.empty<Void>() }
    }

    fun createResponse(throwable: Throwable) = when (throwable) {
        is ResponseStatusException ->
            createResponse(throwable.status, throwable.message)
        else ->
            createResponse(HttpStatus.INTERNAL_SERVER_ERROR, throwable.message)
    }

    fun createResponse(httpStatus: HttpStatus, message: String?): Mono<ServerResponse> =
        ServerResponse.status(httpStatus).syncBody(ErrorResponse(message))
}

private val logger = LoggerFactory.getLogger(GlobalErrorWebExceptionHandler::class.java)