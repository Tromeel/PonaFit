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
fun GILowerBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Intermediate Lower Body Workouts (Gym)",
                        color = Grin,
                        fontWeight = FontWeight.Bold
                    )
                },
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
                        text = "These intermediate-level workouts target strength, power, and muscle growth using gym machines and free weights. They are ideal for those who already have a foundation and want to progress further.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Barbell Back Squats",
                            "sets" to "4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Builds strength in quads, glutes, and hamstrings.",
                            "steps" to listOf(
                                "Set a barbell on a squat rack at shoulder height.",
                                "Position the bar across your upper back and grip it firmly.",
                                "Step back, feet shoulder-width apart, and lower hips below parallel.",
                                "Push through heels to return to standing."
                            )
                        ),
                        mapOf(
                            "title" to "Romanian Deadlifts (Barbell/Dumbbells)",
                            "sets" to "4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Targets hamstrings and glutes with a hip hinge movement.",
                            "steps" to listOf(
                                "Hold barbell or dumbbells in front of thighs.",
                                "Keep back straight and hinge at hips.",
                                "Lower weights until hamstrings stretch.",
                                "Drive hips forward to stand tall."
                            )
                        ),
                        mapOf(
                            "title" to "Walking Lunges (Dumbbells)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps per leg",
                            "description" to "Improves balance, stability, and unilateral strength.",
                            "steps" to listOf(
                                "Hold dumbbells at your sides.",
                                "Step forward with one leg into a lunge position.",
                                "Push through front heel and step forward with the other leg.",
                                "Repeat alternating steps."
                            )
                        ),
                        mapOf(
                            "title" to "Bulgarian Split Squats (Dumbbells)",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps per leg",
                            "description" to "Intensely works quads and glutes.",
                            "steps" to listOf(
                                "Stand in front of a bench with one foot resting on it behind you.",
                                "Hold dumbbells at your sides.",
                                "Lower into a lunge, keeping front knee over ankle.",
                                "Push through front heel to rise."
                            )
                        ),
                        mapOf(
                            "title" to "Leg Press (Machine)",
                            "sets" to "4 sets",
                            "reps" to "10–12 reps",
                            "description" to "Develops overall lower body strength.",
                            "steps" to listOf(
                                "Sit on the leg press machine and place feet shoulder-width on platform.",
                                "Push platform upward until legs are extended but not locked.",
                                "Lower slowly until knees reach 90 degrees.",
                                "Press back up with control."
                            )
                        ),
                        mapOf(
                            "title" to "Hip Thrusts (Barbell)",
                            "sets" to "4 sets",
                            "reps" to "10–12 reps",
                            "description" to "Maximizes glute strength and power.",
                            "steps" to listOf(
                                "Sit on the floor with your back against a bench.",
                                "Place a barbell across hips (use padding for comfort).",
                                "Drive hips upward until body is straight.",
                                "Lower with control and repeat."
                            )
                        ),
                        mapOf(
                            "title" to "Standing Calf Raises (Weighted)",
                            "sets" to "4 sets",
                            "reps" to "12–15 reps",
                            "description" to "Builds calf strength and definition.",
                            "steps" to listOf(
                                "Hold dumbbells or use calf raise machine.",
                                "Stand with toes on platform, heels hanging off.",
                                "Push up onto toes and squeeze calves.",
                                "Lower slowly below platform level."
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
                            subCategory = "Intermediate Lower Body",
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
fun GILowerBodyScreenPreview() {
    GILowerBodyScreen(rememberNavController())
}
