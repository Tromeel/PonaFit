package com.tromeel.ponafit.ui.screens.homeexercises

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
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_UDIFFICULTY
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IUpperBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Intermediate Upper Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_UDIFFICULTY) }) {
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
                        text = "Challenge your chest, shoulders, arms, and back with greater intensity. These moves build endurance, improve strength, and add definition—all without heavy equipment.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Standard Push-Ups",
                            "sets" to "4 sets",
                            "reps" to "10–15 reps",
                            "description" to "Builds strength in chest, shoulders, and triceps.",
                            "steps" to listOf(
                                "Start in a plank position with hands under shoulders.",
                                "Lower your chest toward the floor by bending elbows.",
                                "Push back up to starting position.",
                                "Keep your body straight throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Incline Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Adds variation to target chest and shoulders.",
                            "steps" to listOf(
                                "Place hands on an elevated surface like a chair or bench.",
                                "Keep body straight in a plank position.",
                                "Lower chest toward the surface, then push back up.",
                                "Engage core to maintain stability."
                            )
                        ),
                        mapOf(
                            "title" to "Pike Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Strengthens shoulders and upper chest.",
                            "steps" to listOf(
                                "Start in a downward dog position with hips raised.",
                                "Bend elbows to lower head toward the ground.",
                                "Push through shoulders to return to starting position.",
                                "Keep movement controlled."
                            )
                        ),
                        mapOf(
                            "title" to "Plank Shoulder Taps",
                            "sets" to "3 sets",
                            "reps" to "12 taps each side",
                            "description" to "Improves shoulder stability and core strength.",
                            "steps" to listOf(
                                "Hold a plank with hands under shoulders.",
                                "Lift one hand and tap the opposite shoulder.",
                                "Alternate sides while keeping hips stable.",
                                "Avoid twisting your torso."
                            )
                        ),
                        mapOf(
                            "title" to "Tricep Dips",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets triceps and improves arm strength.",
                            "steps" to listOf(
                                "Sit on the edge of a sturdy chair or bench.",
                                "Place hands beside hips, fingers forward.",
                                "Slide forward and bend elbows to lower hips.",
                                "Push back up to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Superman Pulls",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Strengthens back and shoulders.",
                            "steps" to listOf(
                                "Lie face down with arms extended forward.",
                                "Lift chest, arms, and legs off the ground.",
                                "Pull elbows back as if rowing, squeezing shoulder blades.",
                                "Return arms forward and repeat."
                            )
                        ),
                        mapOf(
                            "title" to "Diamond Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Focuses on triceps and inner chest.",
                            "steps" to listOf(
                                "Start in a plank position with hands close together under chest.",
                                "Form a diamond shape with thumbs and index fingers.",
                                "Lower chest toward hands by bending elbows.",
                                "Push back up to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Plank to Push-Up",
                            "sets" to "3 sets",
                            "reps" to "10 reps",
                            "description" to "Builds core stability and upper body strength.",
                            "steps" to listOf(
                                "Begin in a forearm plank position.",
                                "Place one hand on the floor, then the other, to push up into plank.",
                                "Lower back to forearm plank one arm at a time.",
                                "Alternate leading arms each rep."
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
fun IUpperBodyScreenPreview() {
    IUpperBodyScreen(rememberNavController())
}
