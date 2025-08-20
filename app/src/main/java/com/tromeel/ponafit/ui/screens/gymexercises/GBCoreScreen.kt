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
import com.tromeel.ponafit.navigation.ROUT_GCDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_GLDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GBCoreScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_GCDIFFICULTY) },
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
                        text = "Beginner Abs & Core Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These beginner-friendly gym workouts help you strengthen your abs and core using machines and equipment. They build stability, improve posture, and prepare you for harder exercises.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Beginner Abs & Core Workouts
                    GymBLCard3(
                        title = "Ab Crunch Machine",
                        description = "Great for isolating and strengthening the rectus abdominis.",
                        steps = listOf(
                            "Adjust the seat and select an appropriate weight.",
                            "Grip the handles and keep your feet flat on the floor.",
                            "Contract your abs to curl your torso forward.",
                            "Return slowly to starting position."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    GymBLCard3(
                        title = "Hanging Knee Raises",
                        description = "Works lower abs and hip flexors effectively.",
                        steps = listOf(
                            "Hang from a pull-up bar with arms fully extended.",
                            "Engage your core and lift knees toward your chest.",
                            "Pause briefly at the top, then lower with control."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard3(
                        title = "Cable Woodchoppers",
                        description = "Strengthens obliques and improves rotational power.",
                        steps = listOf(
                            "Attach a handle to the high pulley on a cable machine.",
                            "Stand sideways with feet shoulder-width apart.",
                            "Pull the handle diagonally across your body.",
                            "Return slowly and repeat on both sides."
                        ),
                        sets = "3 sets",
                        reps = "12 reps per side"
                    )

                    GymBLCard3(
                        title = "Decline Bench Sit-Ups",
                        description = "Adds resistance for stronger ab development.",
                        steps = listOf(
                            "Lie on a decline bench and secure your feet.",
                            "Cross arms over chest or hold a weight plate.",
                            "Sit up by contracting your abs.",
                            "Lower yourself back with control."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard3(
                        title = "Plank (Weighted or Bodyweight)",
                        description = "Builds core endurance and stability.",
                        steps = listOf(
                            "Place forearms on the floor and extend legs behind you.",
                            "Keep body straight from head to heels.",
                            "Hold the position without letting hips sag.",
                            "Optional: place a weight plate on your back."
                        ),
                        sets = "3 sets",
                        reps = "20–40 seconds"
                    )

                    GymBLCard3(
                        title = "Seated Russian Twists (Medicine Ball)",
                        description = "Engages obliques and deep core muscles.",
                        steps = listOf(
                            "Sit on the floor with knees bent and heels down.",
                            "Hold a medicine ball with both hands.",
                            "Lean back slightly and twist torso side to side.",
                            "Touch the ball to the ground each side."
                        ),
                        sets = "3 sets",
                        reps = "12–15 twists per side"
                    )

                    GymBLCard3(
                        title = "Stability Ball Rollouts",
                        description = "Targets deep core muscles for control and stability.",
                        steps = listOf(
                            "Kneel on the floor with forearms on a stability ball.",
                            "Roll the ball forward slowly while keeping abs tight.",
                            "Extend as far as possible without arching lower back.",
                            "Pull ball back toward you to reset."
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
fun GymBLCard3(
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
fun GBCoreScreenPreview() {
    GBCoreScreen(rememberNavController())
}
