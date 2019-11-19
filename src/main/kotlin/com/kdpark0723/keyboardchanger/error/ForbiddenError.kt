package com.kdpark0723.keyboardchanger.error

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

open class ForbiddenError(
    status: HttpStatus = HttpStatus.FORBIDDEN,
    message: String? = "forbidden."
) : ResponseStatusException(status, message)