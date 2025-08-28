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
fun GIUpperBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Intermediate Upper Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "These intermediate-level workouts use gym equipment to challenge your chest, back, shoulders, and arms. Perfect for building more strength and definition once you’ve mastered the basics.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Incline Bench Press (Barbell or Dumbbells)",
                            "sets" to "4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Targets upper chest and shoulders.",
                            "steps" to listOf(
                                "Lie on an incline bench at 30–45 degrees.",
                                "Hold barbell or dumbbells above chest.",
                                "Lower slowly to chest level.",
                                "Push back up with control."
                            )
                        ),
                        mapOf(
                            "title" to "Pull-Ups or Assisted Pull-Ups",
                            "sets" to "4 sets",
                            "reps" to "6–10 reps",
                            "description" to "Strengthens lats, biceps, and upper back.",
                            "steps" to listOf(
                                "Grip bar slightly wider than shoulders.",
                                "Pull body up until chin is above bar.",
                                "Lower slowly under control.",
                                "Use assist machine if needed."
                            )
                        ),
                        mapOf(
                            "title" to "Seated Dumbbell Shoulder Press",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Builds strong shoulders and stability.",
                            "steps" to listOf(
                                "Sit upright with dumbbells at shoulder height.",
                                "Press upward until arms are extended.",
                                "Lower dumbbells slowly.",
                                "Keep core tight throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Cable Rows",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Develops mid-back, biceps, and forearms.",
                            "steps" to listOf(
                                "Sit at the cable row station with feet on rests.",
                                "Pull handle to torso while keeping chest up.",
                                "Squeeze shoulder blades together.",
                                "Return with control."
                            )
                        ),
                        mapOf(
                            "title" to "Arnold Press (Dumbbells)",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Works shoulders through a greater range of motion.",
                            "steps" to listOf(
                                "Start with dumbbells in front of chest, palms facing you.",
                                "Rotate wrists outward as you press up.",
                                "Fully extend arms overhead.",
                                "Lower and rotate back to start."
                            )
                        ),
                        mapOf(
                            "title" to "Barbell Bicep Curls",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Builds arm size and strength.",
                            "steps" to listOf(
                                "Stand holding barbell with palms up.",
                                "Curl barbell upward using biceps.",
                                "Squeeze at top, then lower slowly.",
                                "Keep elbows tucked in."
                            )
                        ),
                        mapOf(
                            "title" to "Overhead Tricep Extension (Cable or Dumbbell)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Isolates and strengthens the triceps.",
                            "steps" to listOf(
                                "Hold dumbbell overhead or use cable rope attachment.",
                                "Lower behind head by bending elbows.",
                                "Extend arms back up overhead.",
                                "Avoid flaring elbows."
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
                            subCategory = "Intermediate Upper Body",
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
fun GIUpperBodyScreenPreview() {
    GIUpperBodyScreen(rememberNavController())
}
