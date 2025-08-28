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
import com.tromeel.ponafit.navigation.ROUT_GLDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GBLowerBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Lower Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "These beginner-friendly lower body workouts use gym machines and weights. They are designed to build strength, stability, and endurance safely for new lifters.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Leg Press (Machine)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Strengthens quads, hamstrings, and glutes with controlled range.",
                            "steps" to listOf(
                                "Sit on the leg press machine with feet shoulder-width on the platform.",
                                "Push the platform upward until legs are extended but not locked.",
                                "Lower slowly until knees are at 90 degrees.",
                                "Press back up with control."
                            )
                        ),
                        mapOf(
                            "title" to "Bodyweight or Assisted Squats",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Great for beginners to learn squat movement safely.",
                            "steps" to listOf(
                                "Stand with feet shoulder-width apart.",
                                "Hold onto a support or use a Smith machine bar for balance.",
                                "Lower hips down as if sitting in a chair.",
                                "Push back up through heels."
                            )
                        ),
                        mapOf(
                            "title" to "Leg Curl (Machine)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Isolates and strengthens hamstrings.",
                            "steps" to listOf(
                                "Sit or lie on the leg curl machine.",
                                "Hook ankles under padded lever.",
                                "Curl legs back as far as possible.",
                                "Slowly return to start position."
                            )
                        ),
                        mapOf(
                            "title" to "Leg Extension (Machine)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Focuses on building quad strength.",
                            "steps" to listOf(
                                "Sit on the leg extension machine with shins under padded bar.",
                                "Extend legs forward until straight.",
                                "Hold for 1–2 seconds at the top.",
                                "Lower slowly back down."
                            )
                        ),
                        mapOf(
                            "title" to "Glute Bridges (Weighted Optional)",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Activates glutes and strengthens hips.",
                            "steps" to listOf(
                                "Lie on your back with knees bent and feet flat.",
                                "Place barbell or weight plate across hips if desired.",
                                "Lift hips upward until body forms a straight line.",
                                "Lower slowly back down."
                            )
                        ),
                        mapOf(
                            "title" to "Standing Calf Raises (Machine)",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Builds calf muscles and ankle strength.",
                            "steps" to listOf(
                                "Stand on calf raise machine with toes on platform.",
                                "Lower heels below platform level.",
                                "Push up onto toes and squeeze calves.",
                                "Slowly return down."
                            )
                        ),
                        mapOf(
                            "title" to "Hip Abduction (Machine)",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Strengthens outer thighs and glutes.",
                            "steps" to listOf(
                                "Sit on the hip abduction machine with legs inside pads.",
                                "Push legs outward slowly.",
                                "Hold for 1–2 seconds.",
                                "Return with control."
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
                            subCategory = "Beginner Lower Body",
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
fun GBLowerBodyScreenPreview() {
    GBLowerBodyScreen(rememberNavController())
}
