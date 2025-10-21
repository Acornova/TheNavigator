package com.acornova.thenavigator

import android.content.res.Configuration
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

actual fun getPlatform(): String = "Android ${Build.VERSION.SDK_INT}"

@Composable
actual fun getSize(): String {
    val configuration = LocalConfiguration.current
    return if (configuration.screenWidthDp > 840 && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        "Large"
    } else {
        "Small"
    }
}

@Composable
actual fun phoneAnroid(): Boolean {
    return true
}