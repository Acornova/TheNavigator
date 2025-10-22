package com.acornova.thenavigator

import androidx.compose.runtime.Composable
import java.awt.Window

actual fun getPlatform(): String = "Java ${System.getProperty("java.version")}"

@Composable
actual fun getSize(): String {
//    return if (Window.getWindows()[0].width < 680) "Small" else "Large"
    return "Large"
}

@Composable
actual fun phoneAnroid(): Boolean {
    return false
}