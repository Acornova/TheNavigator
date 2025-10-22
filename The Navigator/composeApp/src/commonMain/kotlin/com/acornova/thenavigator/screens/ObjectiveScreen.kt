package com.acornova.thenavigator.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

@Composable
fun ObjectiveScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.primary)
            .verticalScroll(rememberScrollState())
            .padding(25.dp)
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(
            text = "Objective",
            color = Colors.onPrimaryVariant
        )
        DecorLine()
        Column(
            modifier = Modifier
                .fillMaxWidth(if (getSize() == "Small") 0.9f else 0.8f)
                .clip(RoundedCornerShape(100.dp))
                .background(Colors.background)
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "“If sending messages online is easy, then delivering physical objects should be too. Autonomous cars equally hold the potential to share physical objects as hassle-free as digital data. Hence, we built our project, The Navigator, to demonstrate the capabilities of autonomous delivery, and this app/web showcases the capabilities of autonomous delivery and prospects for implementation in real life, as well as a peek into the project.”",
                color = Colors.onPrimary,
                fontSize = 24.sp,
                style = typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                fontFamily = dmsans
            )
        }
        Spacer(Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            PreviousButton {
                navController.navigate("home")
            }
            Spacer(Modifier.width(10.dp))
            HomeButton()
            Spacer(Modifier.width(10.dp))
            NextButton {
                navController.navigate("members")
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}