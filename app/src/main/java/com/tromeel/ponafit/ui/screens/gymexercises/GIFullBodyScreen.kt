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
fun GIFullBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Intermediate Full Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Push your strength and endurance further with these intermediate-level gym workouts. Perfect for those who already know the basics and are ready to progress with more challenging equipment-based exercises.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Barbell Squat",
                            "sets" to "4 sets",
                            "reps" to "8–10 reps",
                            "description" to "Builds strength in legs and glutes while engaging core stability.",
                            "steps" to listOf(
                                "Position the barbell on your upper back (not neck).",
                                "Stand with feet shoulder-width apart.",
                                "Lower hips down and back until thighs are parallel to the floor.",
                                "Push through heels to return to standing."
                            )
                        ),
                        mapOf(
                            "title" to "Deadlift",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "Powerful movement for back, legs, and overall strength.",
                            "steps" to listOf(
                                "Stand with feet hip-width apart with barbell over mid-foot.",
                                "Bend at hips and knees, grip the bar just outside knees.",
                                "Keep back flat, chest up, and lift bar by extending hips and knees.",
                                "Lower bar back down with control."
                            )
                        ),
                        mapOf(
                            "title" to "Incline Dumbbell Press",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Targets upper chest and shoulders effectively.",
                            "steps" to listOf(
                                "Lie on an incline bench holding dumbbells at chest level.",
                                "Press the dumbbells upward until arms are extended.",
                                "Lower slowly to starting position.",
                                "Keep your core tight throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Pull-Ups (Assisted if needed)",
                            "sets" to "3 sets",
                            "reps" to "6–8 reps",
                            "description" to "Excellent bodyweight and back-building exercise.",
                            "steps" to listOf(
                                "Grip pull-up bar slightly wider than shoulder-width.",
                                "Pull body upward until chin clears the bar.",
                                "Lower slowly under control.",
                                "Use assisted machine if needed."
                            )
                        ),
                        mapOf(
                            "title" to "Seated Dumbbell Shoulder Press",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Strengthens shoulders with added weight challenge.",
                            "steps" to listOf(
                                "Sit upright with dumbbells at shoulder height.",
                                "Press overhead until arms are extended.",
                                "Lower back to starting position with control.",
                                "Avoid arching your back."
                            )
                        ),
                        mapOf(
                            "title" to "Cable Row",
                            "sets" to "3 sets",
                            "reps" to "10 reps",
                            "description" to "Works back, biceps, and improves posture.",
                            "steps" to listOf(
                                "Sit at cable machine with feet braced.",
                                "Grip handle and pull towards torso.",
                                "Squeeze shoulder blades together.",
                                "Return to starting position slowly."
                            )
                        ),
                        mapOf(
                            "title" to "Hanging Leg Raise",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Advanced core exercise for abdominal strength.",
                            "steps" to listOf(
                                "Hang from pull-up bar with straight arms.",
                                "Raise legs until parallel to the floor.",
                                "Lower back down slowly.",
                                "Avoid swinging your body."
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
                            subCategory = "Intermediate Full Body",
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
fun GIFullBodyScreenPreview() {
    GIFullBodyScreen(rememberNavController())
}
