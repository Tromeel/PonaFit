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
fun BCoreScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Abs & Core Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Strengthen your abs and core with these beginner-friendly exercises. Improve stability, posture, and endurance — no equipment needed.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Crunches",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "A simple move to engage and strengthen your upper abs.",
                            "steps" to listOf(
                                "Lie on your back with knees bent and feet flat.",
                                "Place hands behind your head lightly.",
                                "Lift your shoulders off the floor while exhaling.",
                                "Lower slowly and repeat."
                            )
                        ),
                        mapOf(
                            "title" to "Leg Raises",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets the lower abs for stability and strength.",
                            "steps" to listOf(
                                "Lie flat on your back with legs extended.",
                                "Place hands under your hips for support.",
                                "Lift legs toward the ceiling while keeping them straight.",
                                "Lower slowly without touching the floor."
                            )
                        ),
                        mapOf(
                            "title" to "Plank",
                            "sets" to "3 sets",
                            "reps" to "20–30 seconds hold",
                            "description" to "A static hold that builds core stability.",
                            "steps" to listOf(
                                "Start face down on the floor.",
                                "Lift onto elbows and toes, keeping your body straight.",
                                "Engage your core and hold the position.",
                                "Avoid arching your back."
                            )
                        ),
                        mapOf(
                            "title" to "Bicycle Crunches",
                            "sets" to "3 sets",
                            "reps" to "12–16 reps each side",
                            "description" to "Works both the abs and obliques.",
                            "steps" to listOf(
                                "Lie on your back with knees lifted.",
                                "Bring opposite elbow to opposite knee while extending the other leg.",
                                "Switch sides in a pedaling motion.",
                                "Keep core engaged throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Seated Knee Tucks",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Great for lower abs and balance.",
                            "steps" to listOf(
                                "Sit on the edge of a chair or floor.",
                                "Lean back slightly and lift your feet off the ground.",
                                "Bring knees toward chest and extend legs back out.",
                                "Repeat smoothly."
                            )
                        ),
                        mapOf(
                            "title" to "Mountain Climbers",
                            "sets" to "3 sets",
                            "reps" to "20–30 seconds",
                            "description" to "A cardio move that strengthens your core and burns calories.",
                            "steps" to listOf(
                                "Start in a plank position.",
                                "Drive one knee toward your chest quickly.",
                                "Switch legs in a running motion.",
                                "Keep hips low and core tight."
                            )
                        ),
                        mapOf(
                            "title" to "Russian Twists",
                            "sets" to "3 sets",
                            "reps" to "12–16 twists each side",
                            "description" to "Targets your obliques and builds rotational core strength.",
                            "steps" to listOf(
                                "Sit on the floor with knees bent.",
                                "Lean back slightly and lift your feet off the ground.",
                                "Hold hands together and twist your torso to one side.",
                                "Switch sides while keeping your core engaged."
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
                            subCategory = "Beginner Abs & Core",
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
fun BCoreScreenPreview() {
    BCoreScreen(rememberNavController())
}
