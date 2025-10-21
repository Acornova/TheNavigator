package com.acornova.thenavigator.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
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
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import thenavigator.composeapp.generated.resources.Res
import thenavigator.composeapp.generated.resources.abd
import thenavigator.composeapp.generated.resources.musab
import thenavigator.composeapp.generated.resources.myj

@Composable
fun MembersScreen() {
    @Composable
    fun Member(
        name: String,
        role: String,
        image: DrawableResource
    ) {
        Column(
            modifier = Modifier
                .width(375.dp)
                .height(260.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Colors.background)
                .padding(25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = imageResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(25.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = name,
                color = Colors.onPrimary,
                fontSize = 30.sp,
                style = typography.headlineLarge,
                fontWeight = FontWeight.SemiBold,
                fontFamily = dmsans,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = role,
                color = Colors.onPrimaryVariant,
                fontSize = 18.sp,
                style = typography.headlineLarge,
                fontWeight = FontWeight.Medium,
                fontFamily = dmsans,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
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
            text = "The Team",
            color = Colors.onPrimaryVariant
        )
        DecorLine()
        if (getSize() == "Small") {
            Member(
                name = "M. Abdullah Umair",
                role = "Project Developer, Main coder of microchip",
                image = Res.drawable.abd
            )
            Member(
                name = "M. Musab Khan",
                role = "Assisted in Development, Made the physical hardware",
                image = Res.drawable.musab
            )
            Member(
                name = "M. Yousuf Jamil",
                role = "Android App, Desktop App & Website Developer",
                image = Res.drawable.myj
            )
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Member(
                    name = "M. Abdullah Umair",
                    role = "Project Developer, Main coder of microchip",
                    image = Res.drawable.abd
                )
                Spacer(modifier = Modifier.width(10.dp))
                Member(
                    name = "M. Musab Khan",
                    role = "Assisted in Development, Made the physical hardware",
                    image = Res.drawable.musab
                )
                Spacer(modifier = Modifier.width(10.dp))
                Member(
                    name = "M. Yousuf Jamil",
                    role = "Android App, Desktop App & Website Developer",
                    image = Res.drawable.myj
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
                navController.navigate("objective")
            }
            Spacer(Modifier.width(10.dp))
            HomeButton()
            Spacer(Modifier.width(10.dp))
            NextButton {
                navController.navigate("features")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}