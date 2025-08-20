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
fun GAUpperBodyScreen(navController: NavController) {
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
                        text = "Advanced Upper Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These advanced gym workouts focus on maximizing muscle growth, strength, and endurance for your chest, back, shoulders, and arms. They involve heavy weights, advanced techniques, and compound lifts.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Advanced Upper Body Workouts (Gym)
                    GymBeginnerWorkoutCard3(
                        title = "Weighted Pull-Ups",
                        description = "Adds resistance to build serious back and bicep strength.",
                        steps = listOf(
                            "Attach weight belt with plate or hold dumbbell between feet.",
                            "Grip bar slightly wider than shoulders.",
                            "Pull up until chin is over bar.",
                            "Lower slowly under control."
                        ),
                        sets = "4–5 sets",
                        reps = "6–8 reps"
                    )

                    GymBeginnerWorkoutCard3(
                        title = "Incline Barbell Bench Press (Heavy)",
                        description = "Targets upper chest with progressive overload.",
                        steps = listOf(
                            "Set bench at 30–45° incline.",
                            "Grip bar slightly wider than shoulders.",
                            "Lower bar to upper chest.",
                            "Push upward explosively."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    GymBeginnerWorkoutCard3(
                        title = "T-Bar Rows",
                        description = "Builds mid-back thickness and pulling power.",
                        steps = listOf(
                            "Stand over T-bar row station with chest up.",
                            "Grip handles and lift bar from the ground.",
                            "Row bar toward torso, squeezing shoulder blades.",
                            "Lower with control."
                        ),
                        sets = "4 sets",
                        reps = "8–10 reps"
                    )

                    GymBeginnerWorkoutCard3(
                        title = "Overhead Barbell Press",
                        description = "Develops shoulder power and stability.",
                        steps = listOf(
                            "Stand with barbell at chest height.",
                            "Press overhead until arms are fully extended.",
                            "Lower bar slowly to chest.",
                            "Keep core tight and avoid leaning back."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    GymBeginnerWorkoutCard3(
                        title = "Dumbbell Chest Fly (Heavy)",
                        description = "Stretches and builds chest muscle fibers.",
                        steps = listOf(
                            "Lie flat on bench holding dumbbells above chest.",
                            "Lower arms outward in an arc with slight elbow bend.",
                            "Stretch chest fully at bottom.",
                            "Bring dumbbells back together overhead."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard3(
                        title = "Close-Grip Bench Press",
                        description = "Builds triceps while engaging chest and shoulders.",
                        steps = listOf(
                            "Grip barbell shoulder-width apart.",
                            "Lower bar to mid-chest with elbows tucked.",
                            "Press upward with triceps focus.",
                            "Keep wrists straight."
                        ),
                        sets = "4 sets",
                        reps = "6–10 reps"
                    )

                    GymBeginnerWorkoutCard3(
                        title = "Barbell Bicep Curl (Heavy)",
                        description = "Maximizes bicep size and strength.",
                        steps = listOf(
                            "Hold barbell with underhand grip.",
                            "Curl bar upward using only biceps.",
                            "Squeeze at top for 1 sec.",
                            "Lower under control without swinging."
                        ),
                        sets = "3–4 sets",
                        reps = "6–10 reps"
                    )

                    GymBeginnerWorkoutCard3(
                        title = "Skull Crushers (EZ Bar)",
                        description = "Targets long head of triceps for mass.",
                        steps = listOf(
                            "Lie on flat bench holding EZ bar above chest.",
                            "Bend elbows to lower bar toward forehead.",
                            "Extend arms back to start.",
                            "Avoid flaring elbows outward."
                        ),
                        sets = "3–4 sets",
                        reps = "8–10 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with Background Image
@Composable
fun GymBeginnerWorkoutCard3(
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
                .heightIn(min = 220.dp)
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
fun GAUpperBodyScreenPreview() {
    GAUpperBodyScreen(rememberNavController())
}
