package com.tromeel.ponafit.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
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
import com.tromeel.ponafit.navigation.*
import com.tromeel.ponafit.ui.theme.Grin

data class ExerciseCategory(
    val imageRes: Int,
    val title: String,
    val description: String,
    val taskCount: String,
    val backgroundRes: Int,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }

    // ✅ List of exercise categories
    val categories = listOf(
        ExerciseCategory(
            imageRes = R.drawable.home,
            title = "Home Exercises",
            description = "No gym? No problem. Simple yet effective workouts you can do anywhere using minimal or no equipment.",
            taskCount = "4 tasks",
            backgroundRes = R.drawable.darkbg,
            route = ROUT_HOMEEXERCISES
        ),
        ExerciseCategory(
            imageRes = R.drawable.gym,
            title = "Gym Exercises",
            description = "Make the most of gym machines and weights with guided workouts that target strength, endurance, and overall fitness.",
            taskCount = "4 tasks",
            backgroundRes = R.drawable.darkbg,
            route = ROUT_GYMEXERCISES
        ),
        ExerciseCategory(
            imageRes = R.drawable.stretch,
            title = "Stretching and Mobility",
            description = "Improve flexibility, posture, and joint health with gentle stretches and mobility drills.",
            taskCount = "5 tasks",
            backgroundRes = R.drawable.darkbg,
            route = ROUT_STRETCHINGEXERCISES
        ),
        ExerciseCategory(
            imageRes = R.drawable.rehab,
            title = "Injury-Specific Rehab",
            description = "Targeted physiotherapy routines to aid recovery from common injuries like knee, back, and shoulder issues.",
            taskCount = "7 tasks",
            backgroundRes = R.drawable.darkbg,
            route = ROUT_REHAB
        )
    )

    // ✅ Filter categories based on search query
    val filteredCategories = categories.filter {
        it.title.contains(searchQuery, ignoreCase = true)
    }

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
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Profile", tint = Color.Black) },
                    label = { Text("Actions", color = Color.Black) },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        navController.navigate(ROUT_ACCOUNT)
                    }
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

                // ✅ Custom Grin Search bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
                    },
                    placeholder = {
                        Text("Search categories...", color = Color.Black)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(50.dp), // pill-shaped
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,  // Border color when focused
                        unfocusedBorderColor = Grin, // Border color when not focused
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Grin,
                        focusedTrailingIconColor = Color.White,
                        unfocusedTrailingIconColor = Grin
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // ✅ Scrollable row of filtered cards
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    if (filteredCategories.isEmpty()) {
                        Text(
                            "No categories found",
                            color = Grin,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(20.dp)
                        )
                    } else {
                        filteredCategories.forEach { category ->
                            ExerciseCard(
                                imageRes = category.imageRes,
                                title = category.title,
                                description = category.description,
                                taskCount = category.taskCount,
                                backgroundRes = category.backgroundRes,
                                onClick = { navController.navigate(category.route) }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(20.dp))
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
            Image(
                painter = painterResource(backgroundRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )
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
