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
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GICoreScreen(navController: NavController) {
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
                        text = "Intermediate Abs & Core Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These intermediate-level workouts build strength and definition in your abs and core using gym equipment. They improve rotational power, stability, and endurance while preparing you for advanced training.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Intermediate Abs & Core Workouts
                    GymBLCard4(
                        title = "Weighted Cable Crunch",
                        description = "Adds resistance to crunches for stronger ab definition.",
                        steps = listOf(
                            "Attach rope handle to high pulley.",
                            "Kneel down facing the machine and grab the rope.",
                            "Crunch forward by contracting your abs.",
                            "Return slowly without pulling with arms."
                        ),
                        sets = "3–4 sets",
                        reps = "12–15 reps"
                    )

                    GymBLCard4(
                        title = "Hanging Leg Raises (Straight Legs)",
                        description = "Targets lower abs with higher difficulty than knee raises.",
                        steps = listOf(
                            "Hang from a pull-up bar with arms extended.",
                            "Keep legs straight and lift them up to hip level or higher.",
                            "Pause briefly at the top, then lower slowly."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard4(
                        title = "Decline Weighted Sit-Ups",
                        description = "Increases resistance for stronger abs and endurance.",
                        steps = listOf(
                            "Lie on a decline bench with feet secured.",
                            "Hold a weight plate or dumbbell at your chest.",
                            "Perform a sit-up while keeping core tight.",
                            "Lower down slowly with control."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    GymBLCard4(
                        title = "Cable Oblique Twists",
                        description = "Strengthens obliques and builds rotational power.",
                        steps = listOf(
                            "Set cable pulley at chest height.",
                            "Stand sideways holding the handle with both hands.",
                            "Rotate torso away from the machine.",
                            "Return slowly and repeat both sides."
                        ),
                        sets = "3 sets",
                        reps = "12 reps per side"
                    )

                    GymBLCard4(
                        title = "Weighted Plank",
                        description = "Increases core stability under load.",
                        steps = listOf(
                            "Get into plank position on forearms.",
                            "Have a partner place a weight plate on your back.",
                            "Hold the position while keeping core tight and hips level."
                        ),
                        sets = "3 sets",
                        reps = "30–45 seconds"
                    )

                    GymBLCard4(
                        title = "Ab Wheel Rollouts",
                        description = "Challenging core exercise for stability and strength.",
                        steps = listOf(
                            "Kneel on the floor holding an ab wheel.",
                            "Roll forward slowly while keeping abs tight.",
                            "Extend as far as possible without arching your back.",
                            "Pull wheel back to reset."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard4(
                        title = "Medicine Ball Slams",
                        description = "Explosive movement that trains abs and power.",
                        steps = listOf(
                            "Hold a medicine ball overhead.",
                            "Slam it forcefully into the ground using core strength.",
                            "Pick it up and repeat quickly."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with Background Image
@Composable
fun GymBLCard4(
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
fun GICoreScreenPreview() {
    GICoreScreen(rememberNavController())
}
