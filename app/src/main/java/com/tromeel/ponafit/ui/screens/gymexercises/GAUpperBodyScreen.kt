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
import com.tromeel.ponafit.navigation.ROUT_GUDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GAUpperBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Upper Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_GUDIFFICULTY) }) {
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
                        text = "These advanced gym workouts maximize muscle growth, strength, and endurance for your chest, back, shoulders, and arms. They involve heavy weights, advanced techniques, and compound lifts.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Weighted Pull-Ups",
                            "sets" to "4–5 sets",
                            "reps" to "6–8 reps",
                            "description" to "Adds resistance to build serious back and bicep strength.",
                            "steps" to listOf(
                                "Attach weight belt with plate or hold dumbbell between feet.",
                                "Grip bar slightly wider than shoulders.",
                                "Pull up until chin is over bar.",
                                "Lower slowly under control."
                            )
                        ),
                        mapOf(
                            "title" to "Incline Barbell Bench Press (Heavy)",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "Targets upper chest with progressive overload.",
                            "steps" to listOf(
                                "Set bench at 30–45° incline.",
                                "Grip bar slightly wider than shoulders.",
                                "Lower bar to upper chest.",
                                "Push upward explosively."
                            )
                        ),
                        mapOf(
                            "title" to "T-Bar Rows",
                            "sets" to "4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Builds mid-back thickness and pulling power.",
                            "steps" to listOf(
                                "Stand over T-bar row station with chest up.",
                                "Grip handles and lift bar from the ground.",
                                "Row bar toward torso, squeezing shoulder blades.",
                                "Lower with control."
                            )
                        ),
                        mapOf(
                            "title" to "Overhead Barbell Press",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "Develops shoulder power and stability.",
                            "steps" to listOf(
                                "Stand with barbell at chest height.",
                                "Press overhead until arms are fully extended.",
                                "Lower bar slowly to chest.",
                                "Keep core tight and avoid leaning back."
                            )
                        ),
                        mapOf(
                            "title" to "Dumbbell Chest Fly (Heavy)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Stretches and builds chest muscle fibers.",
                            "steps" to listOf(
                                "Lie flat on bench holding dumbbells above chest.",
                                "Lower arms outward in an arc with slight elbow bend.",
                                "Stretch chest fully at bottom.",
                                "Bring dumbbells back together overhead."
                            )
                        ),
                        mapOf(
                            "title" to "Close-Grip Bench Press",
                            "sets" to "4 sets",
                            "reps" to "6–10 reps",
                            "description" to "Builds triceps while engaging chest and shoulders.",
                            "steps" to listOf(
                                "Grip barbell shoulder-width apart.",
                                "Lower bar to mid-chest with elbows tucked.",
                                "Press upward with triceps focus.",
                                "Keep wrists straight."
                            )
                        ),
                        mapOf(
                            "title" to "Barbell Bicep Curl (Heavy)",
                            "sets" to "3–4 sets",
                            "reps" to "6–10 reps",
                            "description" to "Maximizes bicep size and strength.",
                            "steps" to listOf(
                                "Hold barbell with underhand grip.",
                                "Curl bar upward using only biceps.",
                                "Squeeze at top for 1 sec.",
                                "Lower under control without swinging."
                            )
                        ),
                        mapOf(
                            "title" to "Skull Crushers (EZ Bar)",
                            "sets" to "3–4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Targets long head of triceps for mass.",
                            "steps" to listOf(
                                "Lie on flat bench holding EZ bar above chest.",
                                "Bend elbows to lower bar toward forehead.",
                                "Extend arms back to start.",
                                "Avoid flaring elbows outward."
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
                            subCategory = "Advanced Upper Body",
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
fun GAUpperBodyScreenPreview() {
    GAUpperBodyScreen(rememberNavController())
}
