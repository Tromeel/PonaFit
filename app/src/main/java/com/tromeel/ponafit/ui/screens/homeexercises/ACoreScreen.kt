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
import com.tromeel.ponafit.navigation.ROUT_CDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ACoreScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Abs & Core Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Take your core training to the next level with these challenging abs and core exercises. Designed to build strength, endurance, and definition — no gym required.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Hanging Leg Raises (Floor Variation)",
                            "sets" to "4 sets",
                            "reps" to "12–15 reps",
                            "description" to "A tough move for your lower abs and hip flexors.",
                            "steps" to listOf(
                                "Lie flat and hold onto a sturdy object behind your head.",
                                "Lift both legs straight up toward the ceiling.",
                                "Lower them slowly without touching the ground.",
                                "Keep your core braced the entire time."
                            )
                        ),
                        mapOf(
                            "title" to "V-Ups",
                            "sets" to "4 sets",
                            "reps" to "12–15 reps",
                            "description" to "Works upper and lower abs together in one explosive move.",
                            "steps" to listOf(
                                "Lie flat on your back with arms extended overhead.",
                                "Lift both arms and legs at the same time to meet in the middle.",
                                "Form a 'V' shape at the top.",
                                "Lower back down slowly."
                            )
                        ),
                        mapOf(
                            "title" to "Plank to Shoulder Tap",
                            "sets" to "3 sets",
                            "reps" to "30–40 taps",
                            "description" to "Builds stability and anti-rotation core strength.",
                            "steps" to listOf(
                                "Start in a high plank position.",
                                "Tap your right hand to your left shoulder.",
                                "Switch sides while keeping hips as still as possible.",
                                "Maintain tight core engagement."
                            )
                        ),
                        mapOf(
                            "title" to "Dragon Flags (Beginner Variation)",
                            "sets" to "3 sets",
                            "reps" to "6–8 reps",
                            "description" to "A brutal move for core strength popularized by Bruce Lee.",
                            "steps" to listOf(
                                "Lie flat holding a sturdy surface behind your head.",
                                "Lift your entire body off the floor except upper back.",
                                "Lower legs down slowly, resisting gravity.",
                                "Return to the top with control."
                            )
                        ),
                        mapOf(
                            "title" to "Side Plank with Hip Dips",
                            "sets" to "3 sets each side",
                            "reps" to "12–15 dips",
                            "description" to "Targets obliques and deep core stabilizers.",
                            "steps" to listOf(
                                "Get into a side plank on your elbow.",
                                "Lower your hip toward the ground slightly.",
                                "Lift back up to starting position.",
                                "Repeat on both sides."
                            )
                        ),
                        mapOf(
                            "title" to "Toe Touch Crunches",
                            "sets" to "3 sets",
                            "reps" to "15–20 reps",
                            "description" to "Strengthens upper abs and builds endurance.",
                            "steps" to listOf(
                                "Lie on your back with legs raised straight up.",
                                "Reach arms toward your toes while lifting shoulders.",
                                "Squeeze your abs at the top.",
                                "Lower down with control."
                            )
                        ),
                        mapOf(
                            "title" to "Plank Walkouts",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Engages your entire core, shoulders, and arms.",
                            "steps" to listOf(
                                "Start standing tall.",
                                "Bend forward and walk your hands into a plank.",
                                "Hold for a second, then walk hands back in and stand up.",
                                "Repeat smoothly."
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
                            subCategory = "Advanced Abs & Core",
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
fun ACoreScreenPreview() {
    ACoreScreen(rememberNavController())
}
