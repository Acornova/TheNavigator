package com.acornova.thenavigator.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acornova.thenavigator.Colors
import com.acornova.thenavigator.DataSource
import com.acornova.thenavigator.DataSource.navController
import com.acornova.thenavigator.DataSource.dmsans
import com.acornova.thenavigator.DecorLine
import com.acornova.thenavigator.HomeButton
import com.acornova.thenavigator.NextButton
import com.acornova.thenavigator.PreviousButton
import com.acornova.thenavigator.Title
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.bg
import thenavigator.composeapp.generated.resources.map

@Composable
fun MapScreen() {
    @Composable
    fun ShowImage(
        image: DrawableResource
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(25.dp))
                .background(Colors.background)
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Click to view the map",
                color = Colors.onPrimaryVariant,
                modifier = Modifier.padding(25.dp).clickable {
                    DataSource.setImage(Res.drawable.map)
                    DataSource.setReturnRoute("map")
                    navController.navigate("imageViewer")
                },
                fontFamily = dmsans,
                fontSize = 30.sp
            )
            Spacer(Modifier.height(10.dp))
            Image(
                bitmap = imageResource(image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(25.dp))
                    .clickable {
                        DataSource.setImage(Res.drawable.map)
                        DataSource.setReturnRoute("map")
                        navController.navigate("imageViewer")
                    },
                contentScale = ContentScale.Crop,

                )
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
            text = "The Map",
            color = Colors.onPrimaryVariant
        )
        DecorLine()
        ShowImage(
            image = Res.drawable.map
        )
        Spacer(Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            PreviousButton {
                navController.navigate("features")
            }
            Spacer(Modifier.width(10.dp))
            HomeButton()
            Spacer(Modifier.width(10.dp))
            NextButton {
                navController.navigate("prospects")
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}