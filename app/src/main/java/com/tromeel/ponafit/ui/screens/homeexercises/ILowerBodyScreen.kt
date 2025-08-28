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
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_LDIFFICULTY
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ILowerBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Intermediate Lower Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "These intermediate lower-body workouts at home build strength, endurance, and stability. Perfect for progressing beyond beginner moves, they challenge your balance, coordination, and muscular control without needing equipment.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Bulgarian Split Squats",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps each leg",
                            "description" to "Strengthens quads, glutes, and balance.",
                            "steps" to listOf(
                                "Stand a few feet in front of a chair or step.",
                                "Place one foot back on the chair.",
                                "Lower into a lunge with your front knee at 90°.",
                                "Push back up through the front heel."
                            )
                        ),
                        mapOf(
                            "title" to "Single-Leg Glute Bridges",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps each side",
                            "description" to "Targets glutes and hamstrings while improving stability.",
                            "steps" to listOf(
                                "Lie on your back with one knee bent and the other leg straight.",
                                "Press through the bent leg’s heel to lift hips upward.",
                                "Keep the raised leg extended and core tight.",
                                "Lower slowly and repeat."
                            )
                        ),
                        mapOf(
                            "title" to "Reverse Lunges",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps each leg",
                            "description" to "Improves coordination and strengthens quads and glutes.",
                            "steps" to listOf(
                                "Stand tall with feet hip-width apart.",
                                "Step one leg back and lower until knees form 90° angles.",
                                "Push through the front heel to return to standing.",
                                "Repeat on the other side."
                            )
                        ),
                        mapOf(
                            "title" to "Jump Squats",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Explosive move to build leg power and endurance.",
                            "steps" to listOf(
                                "Stand with feet shoulder-width apart.",
                                "Lower into a squat position.",
                                "Jump upward explosively, extending arms overhead.",
                                "Land softly and go straight into the next squat."
                            )
                        ),
                        mapOf(
                            "title" to "Curtsy Lunges",
                            "sets" to "3 sets",
                            "reps" to "10 reps each leg",
                            "description" to "Engages glutes, inner thighs, and improves hip mobility.",
                            "steps" to listOf(
                                "Stand upright with feet hip-width apart.",
                                "Step one leg diagonally back behind the other.",
                                "Bend knees until front thigh is parallel to the ground.",
                                "Return to starting position and switch legs."
                            )
                        ),
                        mapOf(
                            "title" to "Single-Leg Calf Raises",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps each side",
                            "description" to "Improves balance and ankle stability.",
                            "steps" to listOf(
                                "Stand on one foot near a wall for support.",
                                "Rise up onto the ball of your foot.",
                                "Hold for 1–2 seconds, then lower slowly.",
                                "Switch sides after completing reps."
                            )
                        ),
                        mapOf(
                            "title" to "Wall Sit with Heel Lifts",
                            "sets" to "3 sets",
                            "reps" to "10–12 heel lifts per hold",
                            "description" to "Isometric strength and calf activation.",
                            "steps" to listOf(
                                "Sit against a wall with thighs parallel to the floor.",
                                "Lift both heels off the ground, balancing on toes.",
                                "Hold for 1–2 seconds and lower heels.",
                                "Maintain squat position throughout."
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
fun ILowerBodyScreenPreview() {
    ILowerBodyScreen(rememberNavController())
}
