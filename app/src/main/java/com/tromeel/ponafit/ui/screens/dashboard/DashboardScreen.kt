package com.tromeel.ponafit.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_HOMEEXERCISES
import com.tromeel.ponafit.ui.theme.Grin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Grin) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black) },
                    label = { Text("Home", color = Color.Black) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black) },
                    label = { Text("Profile", color = Color.Black) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 }
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(R.drawable.greenbg),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = paddingValues.calculateBottomPadding()
                    )
            ) {
                Row(
                    modifier = Modifier.height(150.dp)
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(50.dp))
                        Text(
                            text = "Hello Athletes",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Here is our Exercise Library ",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.pona),
                        contentDescription = "swaggy",
                        modifier = Modifier.size(200.dp),
                        alignment = Alignment.TopEnd
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    ExerciseCard(
                        imageRes = R.drawable.home,
                        title = "Home Exercises",
                        description = "No gym? No problem. Simple yet effective workouts you can do anywhere using minimal or no equipment. Perfect for staying active in your living room.",
                        taskCount = "4 tasks",
                        backgroundRes = R.drawable.darkbg,
                        onClick = { navController.navigate(ROUT_HOMEEXERCISES) }
                    )
                    ExerciseCard(
                        imageRes = R.drawable.gym,
                        title = "Gym Exercises",
                        description = "Make the most of gym machines and weights with guided workouts that target strength, endurance, and overall fitness.",
                        taskCount = "15 tasks",
                        backgroundRes = R.drawable.darkbg,
                        onClick = { navController.navigate("gym_exercises") }
                    )
                    ExerciseCard(
                        imageRes = R.drawable.stretch,
                        title = "Stretching and Mobility",
                        description = "Improve flexibility, posture, and joint health with gentle stretches and mobility drills designed for all fitness levels.",
                        taskCount = "10 tasks",
                        backgroundRes = R.drawable.darkbg,
                        onClick = { navController.navigate("stretching_mobility") }
                    )
                    ExerciseCard(
                        imageRes = R.drawable.rehab,
                        title = "Injury-Specific Rehab",
                        description = "Targeted physiotherapy routines to aid recovery from common injuries like knee, back, and shoulder issues—always guided step-by-step for safety.",
                        taskCount = "8 tasks",
                        backgroundRes = R.drawable.darkbg,
                        onClick = { navController.navigate("injury_rehab") }
                    )
                }
            }
        }
    )
}

@Composable
fun ExerciseCard(
    imageRes: Int,
    title: String,
    description: String,
    taskCount: String,
    backgroundRes: Int,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .height(500.dp)
            .width(250.dp)
            .padding(start = 20.dp, bottom = 10.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            // Background image
            Image(
                painter = painterResource(backgroundRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Semi-transparent overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            // Foreground content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = taskCount,
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(navController = rememberNavController())
}
