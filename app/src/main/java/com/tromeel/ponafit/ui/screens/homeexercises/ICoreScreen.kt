package com.tromeel.ponafit.ui.screens.homeexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import com.tromeel.ponafit.navigation.ROUT_CDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ICoreScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Intermediate Abs & Core Workouts", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_CDIFFICULTY) }) {
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
                        text = "Take your core training to the next level with these intermediate exercises. These moves challenge your strength, stability, and endurance at home—no equipment needed.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "V-Ups",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Engages both upper and lower abs simultaneously.",
                            "steps" to listOf(
                                "Lie flat with arms extended overhead and legs straight.",
                                "Lift arms and legs together to form a V shape.",
                                "Reach hands toward feet.",
                                "Lower slowly and repeat."
                            )
                        ),
                        mapOf(
                            "title" to "Side Plank with Hip Dips",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps each side",
                            "description" to "Strengthens obliques and improves balance.",
                            "steps" to listOf(
                                "Start in a side plank position on your elbow.",
                                "Lower hips toward the ground without touching.",
                                "Lift hips back up to starting position.",
                                "Repeat before switching sides."
                            )
                        ),
                        mapOf(
                            "title" to "Flutter Kicks",
                            "sets" to "3 sets",
                            "reps" to "20–30 sec",
                            "description" to "Targets lower abs with controlled leg movement.",
                            "steps" to listOf(
                                "Lie flat with hands under your hips.",
                                "Lift legs slightly off the floor.",
                                "Kick legs up and down in a fluttering motion.",
                                "Keep core engaged throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Plank to Shoulder Tap",
                            "sets" to "3 sets",
                            "reps" to "12–16 reps each side",
                            "description" to "Builds stability and core control.",
                            "steps" to listOf(
                                "Start in a high plank position.",
                                "Lift one hand and tap opposite shoulder.",
                                "Alternate hands while keeping hips stable.",
                                "Avoid rotating your torso."
                            )
                        ),
                        mapOf(
                            "title" to "Reverse Crunch",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Excellent for targeting the lower abs.",
                            "steps" to listOf(
                                "Lie on your back with knees bent at 90°.",
                                "Lift hips off the floor while pulling knees toward chest.",
                                "Lower slowly without touching the floor.",
                                "Repeat with control."
                            )
                        ),
                        mapOf(
                            "title" to "Plank Jacks",
                            "sets" to "3 sets",
                            "reps" to "20–30 sec",
                            "description" to "Dynamic plank variation to build endurance.",
                            "steps" to listOf(
                                "Start in plank position.",
                                "Jump feet apart and back together, like a jumping jack.",
                                "Keep core tight and back straight.",
                                "Maintain steady breathing."
                            )
                        ),
                        mapOf(
                            "title" to "Toe Touches",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Strengthens upper abs and improves flexibility.",
                            "steps" to listOf(
                                "Lie flat with legs raised straight up.",
                                "Reach hands toward toes, lifting shoulders off the floor.",
                                "Lower slowly while keeping legs raised.",
                                "Repeat with control."
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
                            mainCategory = "Home Exercises",
                            subCategory = "Intermediate Abs & Core",
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
fun ICoreScreenPreview() {
    ICoreScreen(rememberNavController())
}
