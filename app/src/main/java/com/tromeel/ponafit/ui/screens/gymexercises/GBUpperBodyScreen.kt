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
import com.tromeel.ponafit.navigation.ROUT_GUDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GBUpperBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Upper Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "These beginner-friendly upper body workouts use gym equipment to build strength in your chest, back, shoulders, and arms. Perfect for starting your gym journey safely and effectively.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Chest Press Machine",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Works chest, triceps, and shoulders in a controlled motion.",
                            "steps" to listOf(
                                "Sit with back flat against the pad.",
                                "Grip the handles at chest level.",
                                "Push forward until arms are extended.",
                                "Slowly return with control."
                            )
                        ),
                        mapOf(
                            "title" to "Lat Pulldown",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets your lats, upper back, and biceps.",
                            "steps" to listOf(
                                "Sit at the machine and grab the bar wider than shoulders.",
                                "Pull the bar down to chest level.",
                                "Squeeze shoulder blades together.",
                                "Return slowly to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Seated Row Machine",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Strengthens back and arms while improving posture.",
                            "steps" to listOf(
                                "Sit with feet on the rests and grab handles.",
                                "Pull handles towards your torso.",
                                "Keep chest up and squeeze your back.",
                                "Return slowly to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Dumbbell Shoulder Press",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Builds shoulder strength and stability.",
                            "steps" to listOf(
                                "Sit on a bench with dumbbells at shoulder height.",
                                "Press upward until arms are fully extended.",
                                "Lower slowly with control.",
                                "Keep core tight."
                            )
                        ),
                        mapOf(
                            "title" to "Bicep Curl (Dumbbells or Machine)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Isolates and strengthens the biceps.",
                            "steps" to listOf(
                                "Hold dumbbells or use the curl machine.",
                                "Curl weight upward by bending elbows.",
                                "Pause at the top and squeeze.",
                                "Lower slowly back down."
                            )
                        ),
                        mapOf(
                            "title" to "Tricep Pushdown (Cable Machine)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Strengthens triceps for arm definition.",
                            "steps" to listOf(
                                "Grip the rope or bar at the cable machine.",
                                "Keep elbows tucked in at sides.",
                                "Push the handle down until arms are straight.",
                                "Return slowly to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Chest Fly (Machine or Dumbbells)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets the chest while also engaging shoulders for better upper body strength.",
                            "steps" to listOf(
                                "Sit on the chest fly machine or lie on a bench with dumbbells.",
                                "Start with arms open wide at chest level.",
                                "Bring arms together in a hugging motion.",
                                "Slowly return to starting position."
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
                            subCategory = "Beginner Upper Body",
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
fun GBUpperBodyScreenPreview() {
    GBUpperBodyScreen(rememberNavController())
}
