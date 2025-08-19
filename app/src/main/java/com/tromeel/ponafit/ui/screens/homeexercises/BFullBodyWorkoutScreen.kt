package com.tromeel.ponafit.ui.screens.homeexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
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
fun BFullBodyWorkoutScreen(navController: NavController) {
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

                    Text(
                        text = "Beginner Full Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))


                    Text(
                        text = "Beginner full-body workouts are a great way to build strength, improve fitness, and stay active without needing equipment. These exercises focus on all major muscle groups, helping you improve balance, flexibility, and endurance from the comfort of your home.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // Workout List (8 Workouts)
                    WorkoutCard(
                        title = "Jumping Jacks",
                        description = "A cardio warm-up to increase heart rate.",
                        steps = listOf(
                            "Stand upright with feet together and arms at your sides.",
                            "Jump while spreading your legs shoulder-width apart and raising your arms overhead.",
                            "Quickly return to the starting position.",
                            "Repeat continuously at a steady pace."
                        ),
                        sets = "3 sets",
                        reps = "15–20 reps"
                    )

                    WorkoutCard(
                        title = "Bodyweight Squats",
                        description = "Strengthens legs and glutes.",
                        steps = listOf(
                            "Stand with feet shoulder-width apart.",
                            "Lower your hips down and back as if sitting on a chair.",
                            "Keep your chest upright and knees behind your toes.",
                            "Push through your heels to return to standing."
                        ),
                        sets = "3 sets",
                        reps = "12 reps"
                    )

                    WorkoutCard(
                        title = "Push-Ups",
                        description = "Builds strength in chest, shoulders, and arms.",
                        steps = listOf(
                            "Place hands on the floor shoulder-width apart.",
                            "Keep your body in a straight line from head to heels.",
                            "Lower your chest toward the ground by bending elbows.",
                            "Push back up to starting position."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    WorkoutCard(
                        title = "Plank Hold",
                        description = "Improves core stability and posture.",
                        steps = listOf(
                            "Start in a push-up position but rest on your forearms.",
                            "Keep your body straight from head to heels.",
                            "Engage your core and hold the position.",
                            "Avoid letting hips sag or rise too high."
                        ),
                        sets = "3 sets",
                        reps = "Hold for 20–30 sec"
                    )

                    WorkoutCard(
                        title = "Lunges",
                        description = "Strengthens legs, glutes, and improves balance.",
                        steps = listOf(
                            "Stand tall with feet hip-width apart.",
                            "Step forward with one leg and lower hips until both knees are bent at 90°.",
                            "Push through your front heel to return to standing.",
                            "Alternate legs and repeat."
                        ),
                        sets = "3 sets",
                        reps = "10 reps per leg"
                    )

                    WorkoutCard(
                        title = "Glute Bridges",
                        description = "Strengthens glutes and lower back.",
                        steps = listOf(
                            "Lie on your back with knees bent and feet flat on the floor.",
                            "Keep arms at your sides with palms down.",
                            "Lift your hips until shoulders, hips, and knees form a straight line.",
                            "Squeeze glutes and lower slowly."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    WorkoutCard(
                        title = "Mountain Climbers",
                        description = "Cardio move to strengthen core and legs.",
                        steps = listOf(
                            "Start in a push-up position with hands under shoulders.",
                            "Drive one knee toward your chest.",
                            "Quickly switch legs as if running in place.",
                            "Keep your back straight and core engaged."
                        ),
                        sets = "3 sets",
                        reps = "20–30 seconds"
                    )

                    WorkoutCard(
                        title = "Superman Hold",
                        description = "Strengthens back and core.",
                        steps = listOf(
                            "Lie face down with arms extended in front of you.",
                            "Simultaneously lift arms, chest, and legs off the ground.",
                            "Hold for a moment while squeezing your back muscles.",
                            "Slowly lower to starting position."
                        ),
                        sets = "3 sets",
                        reps = "Hold for 15–20 sec"
                    )
                }
            }
        }
    )
}

// ✅ Workout Card with background image
@Composable
fun WorkoutCard(
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
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp) // keeps cards tall enough for background
        ) {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            // Overlay content
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.LightGray
                )

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
fun BFullBodyWorkoutScreenPreview() {
    BFullBodyWorkoutScreen(rememberNavController())
}
