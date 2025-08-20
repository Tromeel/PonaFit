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
import com.tromeel.ponafit.navigation.ROUT_GFDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GIFullBodyScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_GFDIFFICULTY) },
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
                        text = "Intermediate Full Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Push your strength and endurance further with these intermediate-level gym workouts. Perfect for those who already know the basics and are ready to progress with more challenging equipment-based exercises.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Intermediate Gym Full Body Workouts
                    GymWorkoutCard(
                        title = "Barbell Squat",
                        description = "Builds strength in legs and glutes while engaging core stability.",
                        steps = listOf(
                            "Position the barbell on your upper back (not neck).",
                            "Stand with feet shoulder-width apart.",
                            "Lower hips down and back until thighs are parallel to the floor.",
                            "Push through heels to return to standing."
                        ),
                        sets = "4 sets",
                        reps = "8–10 reps"
                    )

                    GymWorkoutCard(
                        title = "Deadlift",
                        description = "Powerful movement for back, legs, and overall strength.",
                        steps = listOf(
                            "Stand with feet hip-width apart with barbell over mid-foot.",
                            "Bend at hips and knees, grip the bar just outside knees.",
                            "Keep back flat, chest up, and lift bar by extending hips and knees.",
                            "Lower bar back down with control."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    GymWorkoutCard(
                        title = "Incline Dumbbell Press",
                        description = "Targets upper chest and shoulders effectively.",
                        steps = listOf(
                            "Lie on an incline bench holding dumbbells at chest level.",
                            "Press the dumbbells upward until arms are extended.",
                            "Lower slowly to starting position.",
                            "Keep your core tight throughout."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    GymWorkoutCard(
                        title = "Pull-Ups (Assisted if needed)",
                        description = "Excellent bodyweight and back-building exercise.",
                        steps = listOf(
                            "Grip pull-up bar slightly wider than shoulder-width.",
                            "Pull body upward until chin clears the bar.",
                            "Lower slowly under control.",
                            "Use assisted machine if needed."
                        ),
                        sets = "3 sets",
                        reps = "6–8 reps"
                    )

                    GymWorkoutCard(
                        title = "Seated Dumbbell Shoulder Press",
                        description = "Strengthens shoulders with added weight challenge.",
                        steps = listOf(
                            "Sit upright with dumbbells at shoulder height.",
                            "Press overhead until arms are extended.",
                            "Lower back to starting position with control.",
                            "Avoid arching your back."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    GymWorkoutCard(
                        title = "Cable Row",
                        description = "Works back, biceps, and improves posture.",
                        steps = listOf(
                            "Sit at cable machine with feet braced.",
                            "Grip handle and pull towards torso.",
                            "Squeeze shoulder blades together.",
                            "Return to starting position slowly."
                        ),
                        sets = "3 sets",
                        reps = "10 reps"
                    )

                    GymWorkoutCard(
                        title = "Hanging Leg Raise",
                        description = "Advanced core exercise for abdominal strength.",
                        steps = listOf(
                            "Hang from pull-up bar with straight arms.",
                            "Raise legs until parallel to the floor.",
                            "Lower back down slowly.",
                            "Avoid swinging your body."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with dark background
@Composable
fun GymWorkoutCard(
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
                Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = description, fontSize = 14.sp, color = Color.LightGray)
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
fun GIFullBodyScreenPreview() {
    GIFullBodyScreen(rememberNavController())
}
