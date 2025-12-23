package com.psc.elekha.apicall

import org.jetbrains.compose.resources.StringResource

sealed class APiState {
    object idle : APiState()
    object loading : APiState()
    data class success(val message: String) : APiState()
    data class finish(val message: StringResource,var flag:Int) : APiState()
    data class error(val message: String) : APiState()
}