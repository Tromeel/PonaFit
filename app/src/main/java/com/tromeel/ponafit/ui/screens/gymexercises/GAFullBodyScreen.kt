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
fun GAFullBodyScreen(navController: NavController) {
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
                        text = "Advanced Full Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Take your training to the next level with these advanced gym workouts. Designed for experienced lifters, these exercises use heavy compound lifts and advanced equipment to maximize strength, power, and muscle growth.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Advanced Gym Full Body Workouts
                    GymWorkoutCard1(
                        title = "Barbell Back Squat (Heavy)",
                        description = "A power-building lower body exercise that challenges legs, glutes, and core under heavy load.",
                        steps = listOf(
                            "Unrack barbell on upper traps, feet shoulder-width apart.",
                            "Brace core and descend slowly until thighs break parallel.",
                            "Drive explosively through heels to stand back up.",
                            "Maintain upright torso and control the bar throughout."
                        ),
                        sets = "5 sets",
                        reps = "5–6 reps"
                    )

                    GymWorkoutCard1(
                        title = "Deadlift (Conventional or Sumo)",
                        description = "Builds raw strength in the posterior chain, targeting hamstrings, glutes, and back.",
                        steps = listOf(
                            "Set barbell over mid-foot, grip just outside knees.",
                            "Engage lats, brace core, and pull bar explosively.",
                            "Lock out at the top with straight hips and knees.",
                            "Lower bar with control, maintaining a neutral spine."
                        ),
                        sets = "4–5 sets",
                        reps = "4–6 reps"
                    )

                    GymWorkoutCard1(
                        title = "Bench Press (Barbell)",
                        description = "Classic heavy pressing movement for chest, shoulders, and triceps.",
                        steps = listOf(
                            "Lie flat on bench, grip bar slightly wider than shoulders.",
                            "Lower bar to mid-chest under control.",
                            "Press explosively upward until arms are locked out.",
                            "Keep feet flat and back tight on the bench."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    GymWorkoutCard1(
                        title = "Weighted Pull-Ups",
                        description = "An advanced pulling movement for lats and arms with added resistance.",
                        steps = listOf(
                            "Attach weight belt or hold dumbbell between legs.",
                            "Grip bar shoulder-width and pull chin above bar.",
                            "Lower slowly under full control.",
                            "Avoid kipping or swinging."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    GymWorkoutCard1(
                        title = "Overhead Press (Barbell)",
                        description = "A demanding lift for shoulders, triceps, and core stability.",
                        steps = listOf(
                            "Stand tall with barbell at shoulder height.",
                            "Press overhead until arms are locked out.",
                            "Lower bar back to chest with control.",
                            "Keep core braced and avoid leaning back."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    GymWorkoutCard1(
                        title = "Barbell Row (Pendlay Row)",
                        description = "Strengthens upper back, lats, and posterior chain.",
                        steps = listOf(
                            "Hinge forward with barbell on floor.",
                            "Grip slightly wider than shoulder-width.",
                            "Pull bar explosively to lower chest.",
                            "Lower bar back to floor each rep."
                        ),
                        sets = "4 sets",
                        reps = "8–10 reps"
                    )

                    GymWorkoutCard1(
                        title = "Barbell Hip Thrust",
                        description = "Targets glutes with heavy loading for strength and power.",
                        steps = listOf(
                            "Sit on floor with bench behind you.",
                            "Place barbell across hips and lean upper back on bench.",
                            "Drive hips upward until thighs and torso form a line.",
                            "Lower back down with control."
                        ),
                        sets = "4 sets",
                        reps = "10–12 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with dark background
@Composable
fun GymWorkoutCard1(
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
fun GAFullBodyScreenPreview() {
    GAFullBodyScreen(rememberNavController())
}
