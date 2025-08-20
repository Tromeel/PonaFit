package com.tromeel.ponafit.ui.screens.gymexercises

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
import com.tromeel.ponafit.navigation.ROUT_GUDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GBUpperBodyScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_GUDIFFICULTY) },
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
                        text = "Beginner Upper Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These beginner-friendly upper body workouts use gym equipment to help build strength in your chest, back, shoulders, and arms. Perfect for starting your gym journey safely and effectively.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Beginner Gym Upper Body Workouts
                    GymBeginnerWorkoutCard1(
                        title = "Chest Press Machine",
                        description = "Works chest, triceps, and shoulders in a controlled motion.",
                        steps = listOf(
                            "Sit with back flat against the pad.",
                            "Grip the handles at chest level.",
                            "Push forward until arms are extended.",
                            "Slowly return with control."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard1(
                        title = "Lat Pulldown",
                        description = "Targets your lats, upper back, and biceps.",
                        steps = listOf(
                            "Sit at the machine and grab the bar wider than shoulders.",
                            "Pull the bar down to chest level.",
                            "Squeeze shoulder blades together.",
                            "Return slowly to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard1(
                        title = "Seated Row Machine",
                        description = "Strengthens back and arms while improving posture.",
                        steps = listOf(
                            "Sit with feet on the rests and grab handles.",
                            "Pull handles towards your torso.",
                            "Keep chest up and squeeze your back.",
                            "Return slowly to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard1(
                        title = "Dumbbell Shoulder Press",
                        description = "Builds shoulder strength and stability.",
                        steps = listOf(
                            "Sit on a bench with dumbbells at shoulder height.",
                            "Press upward until arms are fully extended.",
                            "Lower slowly with control.",
                            "Keep core tight."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    GymBeginnerWorkoutCard1(
                        title = "Bicep Curl (Dumbbells or Machine)",
                        description = "Isolates and strengthens the biceps.",
                        steps = listOf(
                            "Hold dumbbells or use the curl machine.",
                            "Curl weight upward by bending elbows.",
                            "Pause at the top and squeeze.",
                            "Lower slowly back down."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard1(
                        title = "Tricep Pushdown (Cable Machine)",
                        description = "Strengthens triceps for arm definition.",
                        steps = listOf(
                            "Grip the rope or bar at the cable machine.",
                            "Keep elbows tucked in at sides.",
                            "Push the handle down until arms are straight.",
                            "Return slowly to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    // ✅ Added New Exercise
                    GymBeginnerWorkoutCard1(
                        title = "Chest Fly (Machine or Dumbbells)",
                        description = "Targets the chest while also engaging shoulders for better upper body strength.",
                        steps = listOf(
                            "Sit on the chest fly machine or lie on a bench with dumbbells.",
                            "Start with arms open wide at chest level.",
                            "Bring arms together in a hugging motion.",
                            "Slowly return to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card for Gym Workouts
@Composable
fun GymBeginnerWorkoutCard1(
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
                .heightIn(min = 200.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

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
fun GBUpperBodyScreenPreview() {
    GBUpperBodyScreen(rememberNavController())
}
