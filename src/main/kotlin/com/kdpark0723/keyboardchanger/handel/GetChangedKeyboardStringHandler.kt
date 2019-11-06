package com.kdpark0723.keyboardchanger.handel

import com.kdpark0723.keyboardchanger.model.KeyboardString
import com.kdpark0723.keyboardchanger.model.KeyboardType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


abstract class GetChangedKeyboardStringHandler {
    protected var inputType: KeyboardType = KeyboardType.ENGLISH

    fun handleRequest(request: ServerRequest): Mono<ServerResponse> {
        val value = request.pathVariable("value")

        val doChange = request.queryParam("type")
            .map {
                val type = getType(it)

                Mono.fromCallable { change(KeyboardString(value, inputType), type) }
                    .map {
                        if (it.type != type) RuntimeException("Return type is not same.")

                        it
                    }
            }.orElseThrow { RuntimeException("Unsupported type error.") }

        return ServerResponse.ok().contentType(APPLICATION_JSON)
            .body(doChange, KeyboardString::class.java)
    }

    private fun getType(type: String) = when (type) {
        "ko" -> KeyboardType.KOREAN
        "en" -> KeyboardType.ENGLISH
        else -> throw RuntimeException("Unsupported type error.")
    }

    abstract fun change(string: KeyboardString, requireType: KeyboardType): KeyboardString
}