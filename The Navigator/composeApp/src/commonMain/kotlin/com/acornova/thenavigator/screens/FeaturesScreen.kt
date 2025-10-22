package com.acornova.thenavigator.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acornova.thenavigator.Colors
import com.acornova.thenavigator.DataSource.navController
import com.acornova.thenavigator.DataSource.dmsans
import com.acornova.thenavigator.DecorLine
import com.acornova.thenavigator.HomeButton
import com.acornova.thenavigator.NextButton
import com.acornova.thenavigator.PreviousButton
import com.acornova.thenavigator.Title
import com.acornova.thenavigator.getSize
import org.jetbrains.compose.resources.imageResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.bg

@Composable
fun FeaturesScreen() {
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
            text = "Features",
            color = Colors.onPrimaryVariant
        )
        DecorLine()

        @Composable
        fun Feature(
            number: String,
            description: String
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Colors.background),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number,
                        color = Colors.onPrimaryVariant,
                        fontSize = 30.sp,
                        style = typography.headlineLarge,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = dmsans
                    )
                }
                Spacer(Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(25.dp))
                        .background(Colors.primaryVariant)
                        .padding(15.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = description,
                        color = Colors.onPrimary,
                        fontSize = 18.sp,
                        style = typography.headlineLarge,
                        fontWeight = FontWeight.Normal,
                        fontFamily = dmsans
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
        }

        if (getSize() == "Small") {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Feature(
                    number = "1",
                    description = "Realistic Design"
                )
                Feature(
                    number = "2",
                    description = "Suitable for large scale usage"
                )
                Feature(
                    number = "3",
                    description = "Autonomous depot management eliminate labor costs associated with drivers and workers to move items and allows working for 24/7."
                )
                Feature(
                    number = "4",
                    description = "Using electric or hybrid depot management vehicles reduces greenhouse gas emissions."
                )
                Feature(
                    number = "5",
                    description = "By replacing multiple manual vehicles with automation, chances of error are extremely minimalized."
                )
                Feature(
                    number = "6",
                    description = "The autonomous depot management system can be scaled to serve diverse industries."
                )
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    bitmap = imageResource(Res.drawable.bg),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 375.dp, height = 275.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(40.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Feature(
                        number = "1",
                        description = "Realistic Design"
                    )
                    Feature(
                        number = "2",
                        description = "Suitable for large scale usage"
                    )
                    Feature(
                        number = "3",
                        description = "Autonomous depot management eliminates labor costs associated with drivers and workers to move items and allows working for 24/7."
                    )
                    Feature(
                        number = "4",
                        description = "Using electric or hybrid depot management vehicles reduces greenhouse gas emissions."
                    )
                    Feature(
                        number = "5",
                        description = "By replacing multiple manual vehicles with automation, chances of error are extremely minimalized."
                    )
                    Feature(
                        number = "6",
                        description = "The autonomous depot management system can be scaled to serve diverse industries."
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            PreviousButton {
                navController.navigate("members")
            }
            Spacer(Modifier.width(10.dp))
            HomeButton()
            Spacer(Modifier.width(10.dp))
            NextButton {
                navController.navigate("map")
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}