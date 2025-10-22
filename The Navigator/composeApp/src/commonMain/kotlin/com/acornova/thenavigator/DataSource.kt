package com.acornova.thenavigator

import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavHostController
import com.acornova.thenavigator.navigationcomposables.screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.myj

object DataSource {
    lateinit var dmsans : FontFamily

    lateinit var navController : NavHostController

    lateinit var coroutineScope: CoroutineScope

    var autoBreak = false

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

    suspend fun AutoRun(){
        try {
            loop@ while (true) {
                print("Started next iteration. Autobreak is: $autoBreak")
                if (autoBreak) break
                print("Not broken as autobreak is: $autoBreak")
                for (screen in screens) {
                    if (autoBreak) break@loop
                    navController.navigate(screen.route)
                    print("REACHED ${screen.title}")
                    delay(5000)
                    print("Going to next screen. Autobreak is: $autoBreak")
                }
            }
        } catch (e: Exception) {
            print(e.message)
        }
    }
}