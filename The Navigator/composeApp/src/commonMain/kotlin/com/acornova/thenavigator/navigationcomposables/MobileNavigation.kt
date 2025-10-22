package com.acornova.thenavigator.navigationcomposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.acornova.thenavigator.Colors
import com.acornova.thenavigator.DataSource
import com.acornova.thenavigator.DataSource.navController
import com.acornova.thenavigator.DataSource.dmsans
import org.jetbrains.compose.resources.imageResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.icon

// Main top navigation drawer for mobile

@Composable
fun NavigationDrawer(
    closeDrawer: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.primary)
            .padding(vertical = 35.dp, horizontal = 15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                bitmap = imageResource(Res.drawable.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(15.dp))
            Text(
                text = "The Navigator",
                color = Colors.onPrimary,
                fontSize = typography.headlineMedium.fontSize,
                style = typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                fontFamily = dmsans
            )
        }
        Spacer(Modifier.height(60.dp))
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            screens.forEach { screen ->
                NavigationDrawerItem(
                    label = screen.title,
                    icon = screen.icon,
                    onClick = {
                        DataSource.autoBreak = true
                        print("Autoloop broken")
                        navController.navigate(screen.route)
                        closeDrawer()
                    }
                )
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}

// Item to show in navigation drawer

@Composable
fun NavigationDrawerItem(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(100.dp))
            .background(Colors.primaryVariant)
            .clickable {
                onClick()
            }
            .padding(vertical = 15.dp, horizontal = 25.dp)
    ) {
        Image(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            colorFilter = ColorFilter.tint(Colors.onPrimaryVariant)
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = label,
            color = Colors.onPrimaryVariant,
            fontSize = typography.headlineSmall.fontSize,
            style = typography.headlineSmall,
            fontWeight = FontWeight.Normal,
            fontFamily = dmsans
        )
    }
}