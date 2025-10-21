package com.acornova.thenavigator.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.acornova.thenavigator.Colors
import com.acornova.thenavigator.DataSource
import com.acornova.thenavigator.DataSource.navController
import com.acornova.thenavigator.DataSource.dmsans
import com.acornova.thenavigator.DecorLine
import com.acornova.thenavigator.HomeButton
import com.acornova.thenavigator.NextButton
import com.acornova.thenavigator.PreviousButton
import com.acornova.thenavigator.Title
import com.acornova.thenavigator.getSize
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Microscope
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.bg

@Composable
fun GalleryScreen() {
    @Composable
    fun ShowImage(
        image: DrawableResource
    ) {
        Column(
            modifier = Modifier
                .width(375.dp)
                .height(325.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Colors.background)
                .clickable {
                    DataSource.setImage(image = image)
                    DataSource.setReturnRoute("gallery")
                    navController.navigate("imageViewer")
                }
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                bitmap = imageResource(image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .clip(RoundedCornerShape(25.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {
                    DataSource.setImage(image = image)
                    DataSource.setReturnRoute("gallery")
                    navController.navigate("imageViewer")
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
                Image(
                    imageVector = FontAwesomeIcons.Solid.Microscope,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp),
                    colorFilter = ColorFilter.tint(Colors.onPrimary)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    text = "View Image",
                    color = Colors.onPrimary,
                    fontSize = typography.headlineSmall.fontSize,
                    style = typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = dmsans
                )
            }
        }
        Spacer(Modifier.height(10.dp))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.primary)
            .padding(25.dp)
            .padding(top = 150.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(
            text = "Gallery",
            color = Colors.onPrimaryVariant
        )
        DecorLine()
        if (getSize() == "Small") {
            ShowImage(
                image = Res.drawable.bg
            )
            ShowImage(
                image = Res.drawable.bg
            )
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ShowImage(
                    image = Res.drawable.bg
                )
                Spacer(Modifier.width(10.dp))
                ShowImage(
                    image = Res.drawable.bg
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            PreviousButton {
                navController.navigate("prospects")
            }
            Spacer(Modifier.width(10.dp))
            HomeButton()
            Spacer(Modifier.width(10.dp))
            NextButton {
                navController.navigate("home")
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}