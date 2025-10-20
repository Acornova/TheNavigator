package com.acornova.thenavigator

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.compose.resources.painterResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.icon

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "The Navigator",
        icon = painterResource(Res.drawable.icon),
    ) {
        App()
    }
}
