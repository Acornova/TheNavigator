package com.acornova.thenavigator.navigationcomposables

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.acornova.thenavigator.screens.*
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Images
import compose.icons.fontawesomeicons.solid.Info
import compose.icons.fontawesomeicons.solid.LocationArrow
import compose.icons.fontawesomeicons.solid.Plus
import compose.icons.fontawesomeicons.solid.User

data class Screen(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val screen: @Composable () -> Unit
)

//    List of screens to show in navigation bar

val screens = listOf(
    Screen("Home", "home", FontAwesomeIcons.Solid.Home) { HomeScreen() },
    Screen("Objective", "objective", FontAwesomeIcons.Solid.Info) { ObjectiveScreen() },
    Screen("Members", "members", FontAwesomeIcons.Solid.User) { MembersScreen() },
    Screen("Features", "features", FontAwesomeIcons.Solid.Plus) { FeaturesScreen() },
    Screen("Map", "map", FontAwesomeIcons.Solid.LocationArrow) { MapScreen() },
    Screen("Prospects", "prospects", FontAwesomeIcons.Solid.ArrowRight) { ProspectsScreen() },
    Screen("Gallery", "gallery", FontAwesomeIcons.Solid.Images) { GalleryScreen() }
)