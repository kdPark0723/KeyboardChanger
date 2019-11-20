package com.kdpark0723.keyboardchanger.response


data class ErrorResponse(override val message: String? = null) : Response(message)