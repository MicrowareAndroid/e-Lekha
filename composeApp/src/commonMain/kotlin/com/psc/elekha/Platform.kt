package com.psc.elekha

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform