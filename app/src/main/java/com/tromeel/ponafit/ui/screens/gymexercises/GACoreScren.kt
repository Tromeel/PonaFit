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
fun GACoreScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Abs & Core Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
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
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Profile", tint = Color.Black) },
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
                        text = "These advanced gym workouts are designed to build maximum strength, stability, and definition in your abs and core. They use resistance, explosive power, and balance challenges for elite-level conditioning.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Weighted Decline Sit-Ups",
                            "sets" to "4 sets",
                            "reps" to "10–12 reps",
                            "description" to "High-resistance sit-ups for explosive core strength.",
                            "steps" to listOf(
                                "Lie on a decline bench with feet secured.",
                                "Hold a heavy plate or dumbbell behind your head.",
                                "Perform sit-ups with slow controlled motion."
                            )
                        ),
                        mapOf(
                            "title" to "Hanging Toes-to-Bar",
                            "sets" to "4 sets",
                            "reps" to "8–12 reps",
                            "description" to "An advanced core move targeting lower abs and hip flexors.",
                            "steps" to listOf(
                                "Hang from a pull-up bar with a strong grip.",
                                "Raise legs fully until toes touch the bar.",
                                "Lower slowly under control."
                            )
                        ),
                        mapOf(
                            "title" to "Weighted Ab Wheel Rollouts",
                            "sets" to "3–4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Advanced rollout with added resistance for deep core engagement.",
                            "steps" to listOf(
                                "Hold an ab wheel and kneel on the floor.",
                                "Have a partner place a weight plate on your back.",
                                "Roll forward fully without arching your spine.",
                                "Return under control."
                            )
                        ),
                        mapOf(
                            "title" to "Cable Woodchoppers (Heavy)",
                            "sets" to "3 sets",
                            "reps" to "12 reps per side",
                            "description" to "Explosive rotational strength for obliques and core stability.",
                            "steps" to listOf(
                                "Set cable to high pulley position.",
                                "Pull across your body diagonally with power.",
                                "Control the return slowly."
                            )
                        ),
                        mapOf(
                            "title" to "Dragon Flags",
                            "sets" to "3 sets",
                            "reps" to "6–8 reps",
                            "description" to "Elite core strength move popularized by Bruce Lee.",
                            "steps" to listOf(
                                "Lie on a bench and hold behind your head for support.",
                                "Lift your whole body straight upward.",
                                "Lower slowly, keeping core braced."
                            )
                        ),
                        mapOf(
                            "title" to "Landmine Oblique Twists",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps per side",
                            "description" to "Heavy rotational power move using a landmine barbell setup.",
                            "steps" to listOf(
                                "Stand with feet shoulder-width apart holding the landmine bar.",
                                "Rotate torso explosively side to side.",
                                "Engage obliques and keep arms extended."
                            )
                        ),
                        mapOf(
                            "title" to "Weighted Stability Ball Pike",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Combines balance and strength for advanced core control.",
                            "steps" to listOf(
                                "Start in plank with feet on a stability ball.",
                                "Place a weight vest or plate on your back for added resistance.",
                                "Pull hips upward into a pike position.",
                                "Lower slowly back to plank."
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
                            subCategory = "Advanced Core",
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
fun GACoreScreenPreview() {
    GACoreScreen(rememberNavController())
}
