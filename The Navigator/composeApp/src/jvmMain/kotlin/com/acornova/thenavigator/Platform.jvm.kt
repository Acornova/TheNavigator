package com.acornova.thenavigator

import androidx.compose.runtime.Composable

actual fun getPlatform(): String = "Java ${System.getProperty("java.version")}"

@Composable
actual fun getSize(): String {
    return "Large"
}

@Composable
actual fun phoneAnroid(): Boolean {
    return false
}