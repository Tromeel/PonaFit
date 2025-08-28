package com.tromeel.ponafit.ui.screens.gymexercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.data.DatabaseProvider
import com.tromeel.ponafit.navigation.ROUT_ACCOUNT
import com.tromeel.ponafit.navigation.ROUT_GCDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GBCoreScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Abs & Core Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_GCDIFFICULTY) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Grin)
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Transparent)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Grin) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black) },
                    label = { Text("Home", color = Color.Black) },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0; navController.navigate(ROUT_HOME) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.History, contentDescription = "History", tint = Color.Black) },
                    label = { Text("History", color = Color.Black) },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1; navController.navigate(ROUT_HISTORY) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Pr", tint = Color.Black) },
                    label = { Text("Actions", color = Color.Black) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_ACCOUNT)}
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
                    Text(
                        text = "These beginner-friendly gym workouts help you strengthen your abs and core using machines and equipment. They build stability, improve posture, and prepare you for harder exercises.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Ab Crunch Machine",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Great for isolating and strengthening the rectus abdominis.",
                            "steps" to listOf(
                                "Adjust the seat and select an appropriate weight.",
                                "Grip the handles and keep your feet flat on the floor.",
                                "Contract your abs to curl your torso forward.",
                                "Return slowly to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Hanging Knee Raises",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Works lower abs and hip flexors effectively.",
                            "steps" to listOf(
                                "Hang from a pull-up bar with arms fully extended.",
                                "Engage your core and lift knees toward your chest.",
                                "Pause briefly at the top, then lower with control."
                            )
                        ),
                        mapOf(
                            "title" to "Cable Woodchoppers",
                            "sets" to "3 sets",
                            "reps" to "12 reps per side",
                            "description" to "Strengthens obliques and improves rotational power.",
                            "steps" to listOf(
                                "Attach a handle to the high pulley on a cable machine.",
                                "Stand sideways with feet shoulder-width apart.",
                                "Pull the handle diagonally across your body.",
                                "Return slowly and repeat on both sides."
                            )
                        ),
                        mapOf(
                            "title" to "Decline Bench Sit-Ups",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Adds resistance for stronger ab development.",
                            "steps" to listOf(
                                "Lie on a decline bench and secure your feet.",
                                "Cross arms over chest or hold a weight plate.",
                                "Sit up by contracting your abs.",
                                "Lower yourself back with control."
                            )
                        ),
                        mapOf(
                            "title" to "Plank (Weighted or Bodyweight)",
                            "sets" to "3 sets",
                            "reps" to "20–40 seconds",
                            "description" to "Builds core endurance and stability.",
                            "steps" to listOf(
                                "Place forearms on the floor and extend legs behind you.",
                                "Keep body straight from head to heels.",
                                "Hold the position without letting hips sag.",
                                "Optional: place a weight plate on your back."
                            )
                        ),
                        mapOf(
                            "title" to "Seated Russian Twists (Medicine Ball)",
                            "sets" to "3 sets",
                            "reps" to "12–15 twists per side",
                            "description" to "Engages obliques and deep core muscles.",
                            "steps" to listOf(
                                "Sit on the floor with knees bent and heels down.",
                                "Hold a medicine ball with both hands.",
                                "Lean back slightly and twist torso side to side.",
                                "Touch the ball to the ground each side."
                            )
                        ),
                        mapOf(
                            "title" to "Stability Ball Rollouts",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets deep core muscles for control and stability.",
                            "steps" to listOf(
                                "Kneel on the floor with forearms on a stability ball.",
                                "Roll the ball forward slowly while keeping abs tight.",
                                "Extend as far as possible without arching lower back.",
                                "Pull ball back toward you to reset."
                            )
                        )
                    )

                    exercises.forEach { ex ->
                        WorkoutCardTrackable(
                            title = ex["title"] as String,
                            description = ex["description"] as String,
                            reps = ex["reps"] as String,
                            sets = ex["sets"] as String,
                            steps = ex["steps"] as List<String>,
                            mainCategory = "Gym Exercises",
                            subCategory = "Beginner Abs & Core",
                            onTrack = { name, reps, main, sub -> vm.trackExercise(name, reps, main, sub) },
                            onUndo = { name -> vm.removeExerciseFromHistory(name) },
                            vm = vm
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun GBCoreScreenPreview() {
    GBCoreScreen(rememberNavController())
}
