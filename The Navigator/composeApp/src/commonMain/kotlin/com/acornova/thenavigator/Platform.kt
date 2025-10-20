package com.acornova.thenavigator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform