package com.acornova.thenavigator.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acornova.thenavigator.Colors
import com.acornova.thenavigator.DataSource
import com.acornova.thenavigator.DataSource.coroutineScope
import com.acornova.thenavigator.DataSource.navController
import com.acornova.thenavigator.DataSource.dmsans
import com.acornova.thenavigator.Title
import com.acornova.thenavigator.getSize
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Clock
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.imageResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.bg

@Composable
fun HomeScreen() {
    Image(
        bitmap = imageResource(Res.drawable.bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize().blur(10.dp),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "The Navigator",
            color = Colors.onPrimaryVariant,
            fontSize = if (getSize() == "Small") typography.displaySmall.fontSize else 100.sp,
            style = typography.displayLarge,
            fontWeight = FontWeight.SemiBold,
            fontFamily = dmsans,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "The next stage of technological revolution of depot management hassle-free.",
            color = Colors.onPrimary,
            fontSize = typography.headlineSmall.fontSize,
            style = typography.headlineSmall,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            fontFamily = dmsans
        )
        Spacer(Modifier.height(20.dp))
        Row {
            Button(
                onClick = {
                    DataSource.autoBreak = false
                    coroutineScope.launch {
                        DataSource.AutoRun()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Colors.primary,
                    contentColor = Colors.onPrimary
                ),
                modifier = Modifier
                    .width(100.dp)
                    .clip(RoundedCornerShape(100.dp))
            ) {
                Spacer(Modifier.height(40.dp))
                Image(
                    imageVector = FontAwesomeIcons.Solid.Clock,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Colors.onPrimary)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    navController.navigate("objective")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Colors.primary,
                    contentColor = Colors.onPrimary
                ),
                modifier = Modifier
                    .width(250.dp)
                    .clip(RoundedCornerShape(100.dp))
            ) {
                Spacer(Modifier.height(40.dp))
                Text(
                    text = "Get Started",
                    color = Colors.onPrimary,
                    fontSize = typography.headlineSmall.fontSize,
                    style = typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = dmsans
                )
                Spacer(Modifier.width(10.dp))
                Image(
                    imageVector = FontAwesomeIcons.Solid.ArrowRight,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Colors.onPrimary)
                )
            }
        }
    }
}