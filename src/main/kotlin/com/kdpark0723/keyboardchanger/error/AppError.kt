package com.kdpark0723.keyboardchanger.error

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

open class AppError(
    status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    message: String? = "Internal server error."
) : ResponseStatusException(status, message)