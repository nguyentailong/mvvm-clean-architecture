package com.example.tainguyen.mvvm.data.network.error

class ApiErrorException(var statusCode: Int, message: String) : RuntimeException(message) {
    companion object {
        val BAD_REQUEST = 400
        val UNAUTHORIZED = 401
        val UNPROCESSABLE_ENTITY = 422
        val UPGRADE_REQUIRED = 426
        val INTERNAL_SERVER_ERROR = 500


        val NOT_FOUND = 404
        val CONFLIC = 409
    }

    fun isUnAuthorized401(throwable: Throwable): Boolean {
        return throwable is ApiErrorException && throwable.statusCode == UNAUTHORIZED
    }
}
