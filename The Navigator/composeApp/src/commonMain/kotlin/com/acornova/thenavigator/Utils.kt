package com.acornova.thenavigator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.acornova.thenavigator.DataSource.navController
import com.acornova.thenavigator.DataSource.poppins
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Home

// Utilities

@Composable
fun Title(text: String, color: Color) {
    Text(
        text = text,
        color = color,
        fontSize = typography.headlineMedium.fontSize,
        style = typography.headlineMedium,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppins,
        textAlign = TextAlign.Center
    )
}

@Composable
fun DecorLine() {
    Spacer(Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(4.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Colors.onPrimaryContrast)
    )
    Spacer(Modifier.height(30.dp))
}

@Composable
fun NextButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.container,
            contentColor = Colors.onContainer
        ),
        modifier = Modifier
            .width(56.dp)
            .clip(RoundedCornerShape(100.dp))
    ) {
        Spacer(Modifier.height(40.dp))
        Image(
            imageVector = FontAwesomeIcons.Solid.ArrowRight,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            colorFilter = ColorFilter.tint(Colors.onContainer)
        )
    }
}

@Composable
fun PreviousButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.container,
            contentColor = Colors.onContainer
        ),
        modifier = Modifier
            .width(56.dp)
            .clip(RoundedCornerShape(100.dp))
    ) {
        Spacer(Modifier.height(40.dp))
        Image(
            imageVector = FontAwesomeIcons.Solid.ArrowLeft,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            colorFilter = ColorFilter.tint(Colors.onContainer)
        )
    }
}

@Composable
fun HomeButton() {
    Button(
        onClick = {
            navController.navigate("home")
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Colors.container,
            contentColor = Colors.onContainer
        ),
        modifier = Modifier
            .width(56.dp)
            .clip(RoundedCornerShape(100.dp))
    ) {
        Spacer(Modifier.height(40.dp))
        Image(
            imageVector = FontAwesomeIcons.Solid.Home,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            colorFilter = ColorFilter.tint(Colors.onContainer)
        )
    }
}