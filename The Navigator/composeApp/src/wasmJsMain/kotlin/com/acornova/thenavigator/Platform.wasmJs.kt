package com.acornova.thenavigator

import androidx.compose.runtime.Composable
import kotlinx.browser.window

actual fun getPlatform(): String = "Web with Kotlin/Wasm"

@Composable
actual fun getSize(): String {
    val userAgent = window.navigator.userAgent
    return  if (userAgent.contains("Mobile") || userAgent.contains("Android") || userAgent.contains("iPhone")) {
        "Small"
    } else {
        "Large"
    }
}

@Composable
actual fun phoneAnroid(): Boolean {
    val userAgent = window.navigator.userAgent
    return userAgent.contains("Android")
}