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
import com.tromeel.ponafit.navigation.ROUT_GLDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GALowerBodyScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_GLDIFFICULTY) },
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
                        text = "Advanced Lower Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These advanced-level workouts focus on maximum strength, hypertrophy, and explosive power using free weights and machines. Ideal for experienced lifters aiming to push their limits.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Advanced Lower Body Workouts
                    GymBLCard2(
                        title = "Barbell Back Squat (Heavy)",
                        description = "The ultimate strength-building move for quads, glutes, and hamstrings.",
                        steps = listOf(
                            "Set barbell on a squat rack at upper back level.",
                            "Brace core and unrack bar with feet shoulder-width apart.",
                            "Descend below parallel, keeping chest up.",
                            "Drive upward explosively through heels."
                        ),
                        sets = "5 sets",
                        reps = "5–6 reps"
                    )

                    GymBLCard2(
                        title = "Deficit Deadlifts",
                        description = "Increases pulling strength and range of motion, hitting hamstrings and glutes.",
                        steps = listOf(
                            "Stand on a low platform holding a barbell.",
                            "Grip firmly and hinge at hips with straight back.",
                            "Pull bar upward, extending hips and knees together.",
                            "Lower with control to deficit position."
                        ),
                        sets = "4 sets",
                        reps = "4–6 reps"
                    )

                    GymBLCard2(
                        title = "Front Squats",
                        description = "Emphasizes quads and core stability while reducing spinal load.",
                        steps = listOf(
                            "Rack barbell across front shoulders with elbows high.",
                            "Keep chest upright and core tight.",
                            "Lower hips below parallel in controlled squat.",
                            "Push through mid-foot to stand tall."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    GymBLCard2(
                        title = "Bulgarian Split Squat (Weighted)",
                        description = "Intense unilateral leg strength builder for balance and stability.",
                        steps = listOf(
                            "Stand in front of bench with one foot elevated behind.",
                            "Hold dumbbells or barbell for resistance.",
                            "Lower into deep lunge with front knee aligned.",
                            "Push upward through front heel."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps per leg"
                    )

                    GymBLCard2(
                        title = "Barbell Hip Thrusts (Heavy)",
                        description = "Advanced glute-building exercise for power and strength.",
                        steps = listOf(
                            "Sit with upper back on bench and barbell across hips.",
                            "Brace core and drive hips upward explosively.",
                            "Hold at top with full glute squeeze.",
                            "Lower slowly with control."
                        ),
                        sets = "4 sets",
                        reps = "8–10 reps"
                    )

                    GymBLCard2(
                        title = "Pendulum Squat (Machine)",
                        description = "Targets quads and glutes with controlled machine resistance.",
                        steps = listOf(
                            "Step into pendulum squat machine and set shoulders under pads.",
                            "Descend slowly with controlled knee bend.",
                            "Drive explosively upward through heels.",
                            "Avoid locking out knees fully."
                        ),
                        sets = "4 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard2(
                        title = "Standing Calf Raises (Heavy Load)",
                        description = "Maximizes calf hypertrophy and strength.",
                        steps = listOf(
                            "Use standing calf raise machine or hold heavy barbell.",
                            "Rise onto toes, fully extending ankles.",
                            "Pause and squeeze calves hard.",
                            "Lower heels slowly below platform."
                        ),
                        sets = "5 sets",
                        reps = "12–15 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with Background Image
@Composable
fun GymBLCard2(
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
fun GALowerBodyScreenPreview() {
    GALowerBodyScreen(rememberNavController())
}
