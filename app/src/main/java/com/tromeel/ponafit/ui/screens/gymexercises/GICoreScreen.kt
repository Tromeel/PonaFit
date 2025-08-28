package com.tromeel.ponafit.ui.screens.gymexercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
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
import com.tromeel.ponafit.navigation.ROUT_GCDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GICoreScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Intermediate Abs & Core Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
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
                    Text(
                        text = "These intermediate-level workouts build strength and definition in your abs and core using gym equipment. They improve rotational power, stability, and endurance while preparing you for advanced training.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Weighted Cable Crunch",
                            "sets" to "3–4 sets",
                            "reps" to "12–15 reps",
                            "description" to "Adds resistance to crunches for stronger ab definition.",
                            "steps" to listOf(
                                "Attach rope handle to high pulley.",
                                "Kneel down facing the machine and grab the rope.",
                                "Crunch forward by contracting your abs.",
                                "Return slowly without pulling with arms."
                            )
                        ),
                        mapOf(
                            "title" to "Hanging Leg Raises (Straight Legs)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets lower abs with higher difficulty than knee raises.",
                            "steps" to listOf(
                                "Hang from a pull-up bar with arms extended.",
                                "Keep legs straight and lift them up to hip level or higher.",
                                "Pause briefly at the top, then lower slowly."
                            )
                        ),
                        mapOf(
                            "title" to "Decline Weighted Sit-Ups",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Increases resistance for stronger abs and endurance.",
                            "steps" to listOf(
                                "Lie on a decline bench with feet secured.",
                                "Hold a weight plate or dumbbell at your chest.",
                                "Perform a sit-up while keeping core tight.",
                                "Lower down slowly with control."
                            )
                        ),
                        mapOf(
                            "title" to "Cable Oblique Twists",
                            "sets" to "3 sets",
                            "reps" to "12 reps per side",
                            "description" to "Strengthens obliques and builds rotational power.",
                            "steps" to listOf(
                                "Set cable pulley at chest height.",
                                "Stand sideways holding the handle with both hands.",
                                "Rotate torso away from the machine.",
                                "Return slowly and repeat both sides."
                            )
                        ),
                        mapOf(
                            "title" to "Weighted Plank",
                            "sets" to "3 sets",
                            "reps" to "30–45 seconds",
                            "description" to "Increases core stability under load.",
                            "steps" to listOf(
                                "Get into plank position on forearms.",
                                "Have a partner place a weight plate on your back.",
                                "Hold the position while keeping core tight and hips level."
                            )
                        ),
                        mapOf(
                            "title" to "Ab Wheel Rollouts",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Challenging core exercise for stability and strength.",
                            "steps" to listOf(
                                "Kneel on the floor holding an ab wheel.",
                                "Roll forward slowly while keeping abs tight.",
                                "Extend as far as possible without arching your back.",
                                "Pull wheel back to reset."
                            )
                        ),
                        mapOf(
                            "title" to "Medicine Ball Slams",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Explosive movement that trains abs and power.",
                            "steps" to listOf(
                                "Hold a medicine ball overhead.",
                                "Slam it forcefully into the ground using core strength.",
                                "Pick it up and repeat quickly."
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
                            subCategory = "Intermediate Core",
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
fun GICoreScreenPreview() {
    GICoreScreen(rememberNavController())
}
