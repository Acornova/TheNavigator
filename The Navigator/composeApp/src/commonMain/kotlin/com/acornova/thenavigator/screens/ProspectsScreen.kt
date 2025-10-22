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
fun ProspectsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.primary)
            .padding(top = 150.dp)
            .padding(25.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(
            text = "Prospects",
            color = Colors.onPrimaryVariant
        )
        DecorLine()

        @Composable
        fun Prospect(
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
                        style = typography.headlineMedium,
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
                        style = typography.headlineMedium,
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
                Prospect(
                    number = "1",
                    description = "Build a functional prototype to validate core capabilities (autonomous navigation, load handling, safety interlocks) and define KPIs (uptime, throughput, error rate)."
                )
                Prospect(
                    number = "2",
                    description = "Plan and execute large-scale pilots across multiple sites and conditions: create test matrices (temperature, layout, loads), run stress and failover scenarios, and validate integrations with existing WMS and IT systems."
                )
                Prospect(
                    number = "3",
                    description = "Use AI-driven algorithms to handle unpredictable situations: collect diverse operation data, train in simulation/digital-twin environments, use ensembles with uncertainty estimates, and implement human-in-the-loop escalation and safe fallbacks."
                )
                Prospect(
                    number = "4",
                    description = "Integrate end-to-end with operations: fleet/charging infrastructure, network capacity, inventory/WMS sync, security and access control, and operator UIs for monitoring and overrides."
                )
                Prospect(
                    number = "5",
                    description = "Scale in phases: increase unit count and route complexity gradually, deploy centralized monitoring/telemetry, set up maintenance and spare-parts logistics, and train on-site technicians and operators."
                )
                Prospect(
                    number = "6",
                    description = "Achieve full production readiness: obtain regulatory/safety certifications, set up support & SLA processes, implement continuous improvement (A/B tests, model retraining, incident postmortems) and prepare commercial rollout plans."
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
                    Prospect(
                        number = "1",
                        description = "Build a functional prototype to validate core capabilities (autonomous navigation, load handling, safety interlocks) and define KPIs (uptime, throughput, error rate)."
                    )
                    Prospect(
                        number = "2",
                        description = "Plan and execute large-scale pilots across multiple sites and conditions: create test matrices (temperature, layout, loads), run stress and failover scenarios, and validate integrations with existing WMS and IT systems."
                    )
                    Prospect(
                        number = "3",
                        description = "Use AI-driven algorithms to handle unpredictable situations: collect diverse operation data, train in simulation/digital-twin environments, use ensembles with uncertainty estimates, and implement human-in-the-loop escalation and safe fallbacks."
                    )
                    Prospect(
                        number = "4",
                        description = "Integrate end-to-end with operations: fleet/charging infrastructure, network capacity, inventory/WMS sync, security and access control, and operator UIs for monitoring and overrides."
                    )
                    Prospect(
                        number = "5",
                        description = "Scale in phases: increase unit count and route complexity gradually, deploy centralized monitoring/telemetry, set up maintenance and spare-parts logistics, and train on-site technicians and operators."
                    )
                    Prospect(
                        number = "6",
                        description = "Achieve full production readiness: obtain regulatory/safety certifications, set up support & SLA processes, implement continuous improvement (A/B tests, model retraining, incident postmortems) and prepare commercial rollout plans."
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
                navController.navigate("map")
            }
            Spacer(Modifier.width(10.dp))
            HomeButton()
            Spacer(Modifier.width(10.dp))
            NextButton {
                navController.navigate("gallery")
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}