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
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_LDIFFICULTY
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ALowerBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Lower Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_LDIFFICULTY) }) {
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
                        text = "Take your leg training to the next level with these advanced lower-body workouts at home. These exercises improve explosive power, single-leg strength, balance, and muscular endurance—perfect for athletes and fitness enthusiasts.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Pistol Squats",
                            "sets" to "3 sets",
                            "reps" to "6–8 reps each leg",
                            "description" to "A challenging single-leg squat that builds extreme strength and balance.",
                            "steps" to listOf(
                                "Stand on one leg with the other extended forward.",
                                "Lower into a squat while keeping the extended leg off the floor.",
                                "Go as low as possible without losing balance.",
                                "Push back up through the heel."
                            )
                        ),
                        mapOf(
                            "title" to "Jumping Lunges",
                            "sets" to "3 sets",
                            "reps" to "12–16 alternating reps",
                            "description" to "An explosive plyometric move to build power and endurance.",
                            "steps" to listOf(
                                "Start in a lunge position.",
                                "Explosively jump upward, switching legs mid-air.",
                                "Land softly in a lunge on the opposite leg.",
                                "Repeat immediately."
                            )
                        ),
                        mapOf(
                            "title" to "Single-Leg Romanian Deadlifts",
                            "sets" to "3 sets",
                            "reps" to "10 reps each leg",
                            "description" to "Builds hamstring and glute strength while challenging balance.",
                            "steps" to listOf(
                                "Stand on one leg with the other extended behind you.",
                                "Hinge forward at the hips, keeping your back straight.",
                                "Lower until your torso is parallel to the ground.",
                                "Return to standing by squeezing your glutes."
                            )
                        ),
                        mapOf(
                            "title" to "Skater Jumps",
                            "sets" to "3 sets",
                            "reps" to "12–14 reps each side",
                            "description" to "Lateral plyometric exercise for glutes and stability.",
                            "steps" to listOf(
                                "Start standing on one leg.",
                                "Jump sideways to land on the opposite leg.",
                                "Swing arms for momentum.",
                                "Land softly and repeat side-to-side."
                            )
                        ),
                        mapOf(
                            "title" to "Wall Sit with Single-Leg Extension",
                            "sets" to "3 sets",
                            "reps" to "2–3 holds per leg",
                            "description" to "Isometric strength hold with added difficulty.",
                            "steps" to listOf(
                                "Sit against a wall with thighs parallel to the ground.",
                                "Lift one leg straight out while holding the position.",
                                "Hold for 10–15 seconds before switching legs."
                            )
                        ),
                        mapOf(
                            "title" to "Broad Jumps",
                            "sets" to "3 sets",
                            "reps" to "8–10 jumps",
                            "description" to "Improves leg power and explosiveness.",
                            "steps" to listOf(
                                "Stand with feet shoulder-width apart.",
                                "Swing arms back and jump forward as far as possible.",
                                "Land softly with bent knees.",
                                "Reset and repeat."
                            )
                        ),
                        mapOf(
                            "title" to "Shrimp Squats",
                            "sets" to "3 sets",
                            "reps" to "5–8 reps each leg",
                            "description" to "A demanding bodyweight squat variation for balance and quad strength.",
                            "steps" to listOf(
                                "Stand on one leg and hold the ankle of the opposite leg behind you.",
                                "Lower into a squat while keeping your back straight.",
                                "Touch the rear knee lightly to the ground.",
                                "Push back up through the standing leg."
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
fun ALowerBodyScreenPreview() {
    ALowerBodyScreen(rememberNavController())
}
