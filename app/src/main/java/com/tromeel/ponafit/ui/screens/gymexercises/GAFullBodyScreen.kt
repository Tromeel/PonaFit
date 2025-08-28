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
import com.tromeel.ponafit.navigation.ROUT_GFDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GAFullBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Full Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_GFDIFFICULTY) }) {
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
                        text = "Push your limits with these advanced full-body workouts designed for experienced lifters. Heavy compound lifts and progressive overload maximize strength, size, and power.",
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
                            "description" to "A power-building lower body exercise that challenges legs, glutes, and core under heavy load.",
                            "steps" to listOf(
                                "Unrack barbell on upper traps, feet shoulder-width apart.",
                                "Brace core and descend slowly until thighs break parallel.",
                                "Drive explosively through heels to stand back up.",
                                "Maintain upright torso and control the bar throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Deadlift (Conventional or Sumo)",
                            "sets" to "4–5 sets",
                            "reps" to "4–6 reps",
                            "description" to "Builds raw strength in the posterior chain, targeting hamstrings, glutes, and back.",
                            "steps" to listOf(
                                "Set barbell over mid-foot, grip just outside knees.",
                                "Engage lats, brace core, and pull bar explosively.",
                                "Lock out at the top with straight hips and knees.",
                                "Lower bar with control, maintaining a neutral spine."
                            )
                        ),
                        mapOf(
                            "title" to "Bench Press (Barbell)",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "Classic heavy pressing movement for chest, shoulders, and triceps.",
                            "steps" to listOf(
                                "Lie flat on bench, grip bar slightly wider than shoulders.",
                                "Lower bar to mid-chest under control.",
                                "Press explosively upward until arms are locked out.",
                                "Keep feet flat and back tight on the bench."
                            )
                        ),
                        mapOf(
                            "title" to "Weighted Pull-Ups",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "An advanced pulling movement for lats and arms with added resistance.",
                            "steps" to listOf(
                                "Attach weight belt or hold dumbbell between legs.",
                                "Grip bar shoulder-width and pull chin above bar.",
                                "Lower slowly under full control.",
                                "Avoid kipping or swinging."
                            )
                        ),
                        mapOf(
                            "title" to "Overhead Press (Barbell)",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "A demanding lift for shoulders, triceps, and core stability.",
                            "steps" to listOf(
                                "Stand tall with barbell at shoulder height.",
                                "Press overhead until arms are locked out.",
                                "Lower bar back to chest with control.",
                                "Keep core braced and avoid leaning back."
                            )
                        ),
                        mapOf(
                            "title" to "Barbell Row (Pendlay Row)",
                            "sets" to "4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Strengthens upper back, lats, and posterior chain.",
                            "steps" to listOf(
                                "Hinge forward with barbell on floor.",
                                "Grip slightly wider than shoulder-width.",
                                "Pull bar explosively to lower chest.",
                                "Lower bar back to floor each rep."
                            )
                        ),
                        mapOf(
                            "title" to "Barbell Hip Thrust",
                            "sets" to "4 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets glutes with heavy loading for strength and power.",
                            "steps" to listOf(
                                "Sit on floor with bench behind you.",
                                "Place barbell across hips and lean upper back on bench.",
                                "Drive hips upward until thighs and torso form a line.",
                                "Lower back down with control."
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
                            subCategory = "Advanced Full Body",
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
fun GAFullBodyScreenPreview() {
    GAFullBodyScreen(rememberNavController())
}
