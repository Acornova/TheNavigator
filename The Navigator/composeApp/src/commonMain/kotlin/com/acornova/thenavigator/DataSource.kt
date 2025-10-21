package com.acornova.thenavigator

import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavHostController
import org.jetbrains.compose.resources.DrawableResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.myj

object DataSource {
    lateinit var poppins : FontFamily
    lateinit var dmSans : FontFamily

    lateinit var navController : NavHostController

    private var imageToShow = Res.drawable.myj
    private var returnRoute = "home"

    fun setImage(image: DrawableResource) {
        imageToShow = image
    }

    fun getImage(): DrawableResource {
        return imageToShow
    }

    fun setReturnRoute(route: String) {
        returnRoute = route
    }

    fun getReturnRoute(): String {
        return returnRoute
    }
}