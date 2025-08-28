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
import com.tromeel.ponafit.navigation.ROUT_GLDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GALowerBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Lower Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_GLDIFFICULTY) }) {
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
                        text = "These advanced-level workouts focus on maximum strength, hypertrophy, and explosive power using free weights and machines. Ideal for experienced lifters aiming to push their limits.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Barbell Back Squat (Heavy)",
                            "sets" to "5 sets",
                            "reps" to "5–6 reps",
                            "description" to "The ultimate strength-building move for quads, glutes, and hamstrings.",
                            "steps" to listOf(
                                "Set barbell on a squat rack at upper back level.",
                                "Brace core and unrack bar with feet shoulder-width apart.",
                                "Descend below parallel, keeping chest up.",
                                "Drive upward explosively through heels."
                            )
                        ),
                        mapOf(
                            "title" to "Deficit Deadlifts",
                            "sets" to "4 sets",
                            "reps" to "4–6 reps",
                            "description" to "Increases pulling strength and range of motion, hitting hamstrings and glutes.",
                            "steps" to listOf(
                                "Stand on a low platform holding a barbell.",
                                "Grip firmly and hinge at hips with straight back.",
                                "Pull bar upward, extending hips and knees together.",
                                "Lower with control to deficit position."
                            )
                        ),
                        mapOf(
                            "title" to "Front Squats",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "Emphasizes quads and core stability while reducing spinal load.",
                            "steps" to listOf(
                                "Rack barbell across front shoulders with elbows high.",
                                "Keep chest upright and core tight.",
                                "Lower hips below parallel in controlled squat.",
                                "Push through mid-foot to stand tall."
                            )
                        ),
                        mapOf(
                            "title" to "Bulgarian Split Squat (Weighted)",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps per leg",
                            "description" to "Intense unilateral leg strength builder for balance and stability.",
                            "steps" to listOf(
                                "Stand in front of bench with one foot elevated behind.",
                                "Hold dumbbells or barbell for resistance.",
                                "Lower into deep lunge with front knee aligned.",
                                "Push upward through front heel."
                            )
                        ),
                        mapOf(
                            "title" to "Barbell Hip Thrusts (Heavy)",
                            "sets" to "4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Advanced glute-building exercise for power and strength.",
                            "steps" to listOf(
                                "Sit with upper back on bench and barbell across hips.",
                                "Brace core and drive hips upward explosively.",
                                "Hold at top with full glute squeeze.",
                                "Lower slowly with control."
                            )
                        ),
                        mapOf(
                            "title" to "Pendulum Squat (Machine)",
                            "sets" to "4 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets quads and glutes with controlled machine resistance.",
                            "steps" to listOf(
                                "Step into pendulum squat machine and set shoulders under pads.",
                                "Descend slowly with controlled knee bend.",
                                "Drive explosively upward through heels.",
                                "Avoid locking out knees fully."
                            )
                        ),
                        mapOf(
                            "title" to "Standing Calf Raises (Heavy Load)",
                            "sets" to "5 sets",
                            "reps" to "12–15 reps",
                            "description" to "Maximizes calf hypertrophy and strength.",
                            "steps" to listOf(
                                "Use standing calf raise machine or hold heavy barbell.",
                                "Rise onto toes, fully extending ankles.",
                                "Pause and squeeze calves hard.",
                                "Lower heels slowly below platform."
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
                            subCategory = "Advanced Lower Body",
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
fun GALowerBodyScreenPreview() {
    GALowerBodyScreen(rememberNavController())
}
