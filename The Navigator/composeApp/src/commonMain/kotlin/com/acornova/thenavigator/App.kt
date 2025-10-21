package com.acornova.thenavigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.acornova.thenavigator.DataSource.dmSans
import com.acornova.thenavigator.DataSource.navController
import com.acornova.thenavigator.DataSource.poppins
import com.acornova.thenavigator.navigationcomposables.BottomBar
import com.acornova.thenavigator.navigationcomposables.NavigationBar
import com.acornova.thenavigator.navigationcomposables.NavigationDrawer
import com.acornova.thenavigator.navigationcomposables.screens
import com.acornova.thenavigator.screens.*
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.ui.tooling.preview.Preview
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.dmsans
import thenavigator.composeapp.generated.resources.poppins

@Composable
@Preview
fun App() {
    poppins = FontFamily(
        listOf(
            Font(Res.font.poppins)
        )
    )

    dmSans = FontFamily(
        listOf(
            Font(Res.font.dmsans)
        )
    )

    navController = rememberNavController()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    MaterialTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                NavigationDrawer(
                    closeDrawer = {
                        coroutineScope.launch { drawerState.close() }
                    }
                )
            },
            gesturesEnabled = getSize() == "Small"
        ) {
            Scaffold(
                topBar = {
                    NavigationBar(
                        onMobileNavClick = {
                            coroutineScope.launch { drawerState.open() }
                        }
                    )
                },
                bottomBar = { BottomBar() }
            ) { padding ->
                Navigation(navController)
            }
        }

        // Auto-close drawer on larger screens
        if (getSize() != "Small" && drawerState.isOpen) {
            LaunchedEffect(Unit) {
                drawerState.close()
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(top = 70.dp).fillMaxSize()) {
        screens.forEach { screen ->
            composable(screen.route) {
                screen.screen()
            }
        }
        composable("imageViewer") {
            ImageViewerScreen()
        }
    }
}