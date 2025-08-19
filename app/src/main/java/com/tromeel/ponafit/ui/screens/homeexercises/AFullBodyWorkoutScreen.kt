package com.tromeel.ponafit.ui.screens.homeexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_FDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun AFullBodyWorkoutScreen(navController: NavController) {
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(R.drawable.greenbg),
                        contentScale = ContentScale.FillBounds
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = { navController.navigate(ROUT_FDIFFICULTY) },
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Grin,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 10.dp, top = 10.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    // Title
                    Text(
                        text = "Advanced Full Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    Text(
                        text = "Advanced full-body workouts push your strength, stamina, and control to the next level. These routines combine challenging movements and higher intensity to maximize results—all from home.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )


                    // Workout List (10 exercises)
                    AdvancedWorkoutCard(
                        title = "Burpees",
                        description = "Explosive full-body exercise that boosts strength and cardio.",
                        steps = listOf("Start standing.", "Drop into push-up position.", "Perform push-up, jump up with arms overhead."),
                        sets = "4 sets", reps = "15 reps"
                    )

                    AdvancedWorkoutCard(
                        title = "Pull-Ups",
                        description = "Strengthens back, shoulders, and arms.",
                        steps = listOf("Hang from a bar with palms facing forward.", "Pull up until chin clears the bar.", "Lower slowly."),
                        sets = "4 sets", reps = "8–12 reps"
                    )

                    AdvancedWorkoutCard(
                        title = "Pistol Squats",
                        description = "Single-leg squat for balance and leg power.",
                        steps = listOf("Stand on one leg.", "Extend the other leg forward.", "Lower into squat, then rise back up."),
                        sets = "3 sets", reps = "6–8 each leg"
                    )

                    AdvancedWorkoutCard(
                        title = "Handstand Push-Ups",
                        description = "Builds upper body strength and stability.",
                        steps = listOf("Kick up into a handstand against wall.", "Lower head to floor.", "Push back up."),
                        sets = "3 sets", reps = "6–10 reps"
                    )

                    AdvancedWorkoutCard(
                        title = "Jump Squats",
                        description = "Explosive power for legs and core.",
                        steps = listOf("Perform a regular squat.", "Explosively jump upward.", "Land softly and repeat."),
                        sets = "4 sets", reps = "12 reps"
                    )

                    AdvancedWorkoutCard(
                        title = "Clapping Push-Ups",
                        description = "Explosive chest and tricep power.",
                        steps = listOf("Start in push-up position.", "Push explosively off ground and clap.", "Land back in push-up position."),
                        sets = "3 sets", reps = "10 reps"
                    )

                    AdvancedWorkoutCard(
                        title = "Dragon Flags",
                        description = "Intense core strength exercise.",
                        steps = listOf("Lie on bench holding sides.", "Raise body in straight line, only shoulders touching.", "Lower slowly."),
                        sets = "3 sets", reps = "6–8 reps"
                    )

                    AdvancedWorkoutCard(
                        title = "One-Arm Push-Ups",
                        description = "Chest, core, and arm strength challenge.",
                        steps = listOf("Spread feet wide.", "Place one hand under chest.", "Lower and push back up."),
                        sets = "3 sets", reps = "8–10 reps each arm"
                    )

                    AdvancedWorkoutCard(
                        title = "Jumping Lunges",
                        description = "Leg power and balance.",
                        steps = listOf("Start in lunge.", "Jump explosively and switch legs mid-air.", "Land softly."),
                        sets = "3 sets", reps = "12 reps each leg"
                    )

                    AdvancedWorkoutCard(
                        title = "Plank to Push-Up",
                        description = "Core and upper body endurance.",
                        steps = listOf("Start in plank on forearms.", "Push up into push-up position.", "Return to plank."),
                        sets = "3 sets", reps = "15 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Advanced Workout Card with same dark background
@Composable
fun AdvancedWorkoutCard(
    title: String,
    description: String,
    steps: List<String>,
    sets: String,
    reps: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box {
            // Background Image (darkbg for all cards)
            Image(
                painter = painterResource(id = R.drawable.darkbg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Dark overlay for readability
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )

            // Workout Text
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = description, fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(10.dp))

                steps.forEachIndexed { index, step ->
                    Text(
                        text = "${index + 1}. $step",
                        fontSize = 13.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Sets: $sets", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.White)
                    Text(text = "Reps: $reps", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun AFullBodyWorkoutScreenPreview() {
    AFullBodyWorkoutScreen(rememberNavController())
}
