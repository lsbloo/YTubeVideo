package com.htk.ytubevideo.authentication.factory

class CredentialsAuthenticationErrorFactory {

    companion object {
        fun getExceptionWithType(type: CredentialsAuthenticationErrorEnum) : OnCredentialsAuthenticationError {
            return when(type) {
                CredentialsAuthenticationErrorEnum.NETWORK_EXCEPTION -> {
                    NetworkException()
                }

                CredentialsAuthenticationErrorEnum.INVALID_EMAIL_OR_PASSWORD -> {
                    InvalidEmailOrPasswordException()
                }

                else -> {
                    NetworkException()
                }
            }
        }
    }
}