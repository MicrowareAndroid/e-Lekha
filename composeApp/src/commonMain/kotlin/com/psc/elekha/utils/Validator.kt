package com.psc.elekha.utils

object Validator {

    fun checkValidation(email: String, password: String): String? {
        return when {
            email.isBlank() -> "Please enter email id"
            password.isBlank() -> "Please enter password"
            else -> null
        }
    }



}