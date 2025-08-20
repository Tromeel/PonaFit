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
fun GIUpperBodyScreen(navController: NavController) {
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
                        text = "Intermediate Upper Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These intermediate-level workouts use gym equipment to challenge your chest, back, shoulders, and arms. Perfect for building more strength and definition once you’ve mastered the basics.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Intermediate Gym Upper Body Workouts
                    GymBeginnerWorkoutCard2(
                        title = "Incline Bench Press (Barbell or Dumbbells)",
                        description = "Targets upper chest and shoulders.",
                        steps = listOf(
                            "Lie on an incline bench at 30–45 degrees.",
                            "Hold barbell or dumbbells above chest.",
                            "Lower slowly to chest level.",
                            "Push back up with control."
                        ),
                        sets = "4 sets",
                        reps = "8–10 reps"
                    )

                    GymBeginnerWorkoutCard2(
                        title = "Pull-Ups or Assisted Pull-Ups",
                        description = "Strengthens lats, biceps, and upper back.",
                        steps = listOf(
                            "Grip bar slightly wider than shoulders.",
                            "Pull body up until chin is above bar.",
                            "Lower slowly under control.",
                            "Use assist machine if needed."
                        ),
                        sets = "4 sets",
                        reps = "6–10 reps"
                    )

                    GymBeginnerWorkoutCard2(
                        title = "Seated Dumbbell Shoulder Press",
                        description = "Builds strong shoulders and stability.",
                        steps = listOf(
                            "Sit upright with dumbbells at shoulder height.",
                            "Press upward until arms are extended.",
                            "Lower dumbbells slowly.",
                            "Keep core tight throughout."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    GymBeginnerWorkoutCard2(
                        title = "Cable Rows",
                        description = "Develops mid-back, biceps, and forearms.",
                        steps = listOf(
                            "Sit at the cable row station with feet on rests.",
                            "Pull handle to torso while keeping chest up.",
                            "Squeeze shoulder blades together.",
                            "Return with control."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard2(
                        title = "Arnold Press (Dumbbells)",
                        description = "Works shoulders through a greater range of motion.",
                        steps = listOf(
                            "Start with dumbbells in front of chest, palms facing you.",
                            "Rotate wrists outward as you press up.",
                            "Fully extend arms overhead.",
                            "Lower and rotate back to start."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    GymBeginnerWorkoutCard2(
                        title = "Barbell Bicep Curls",
                        description = "Builds arm size and strength.",
                        steps = listOf(
                            "Stand holding barbell with palms up.",
                            "Curl barbell upward using biceps.",
                            "Squeeze at top, then lower slowly.",
                            "Keep elbows tucked in."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    GymBeginnerWorkoutCard2(
                        title = "Overhead Tricep Extension (Cable or Dumbbell)",
                        description = "Isolates and strengthens the triceps.",
                        steps = listOf(
                            "Hold dumbbell overhead or use cable rope attachment.",
                            "Lower behind head by bending elbows.",
                            "Extend arms back up overhead.",
                            "Avoid flaring elbows."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with Background Image
@Composable
fun GymBeginnerWorkoutCard2(
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
fun GIUpperBodyScreenPreview() {
    GIUpperBodyScreen(rememberNavController())
}
