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
import com.tromeel.ponafit.navigation.ROUT_FDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AFullBodyWorkoutScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Full Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_FDIFFICULTY) }) {
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
                        text = "Advanced full-body workouts push your strength, stamina, and control to the next level. Follow each step to maximize results.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Burpees",
                            "sets" to "4 sets",
                            "reps" to "15 reps",
                            "description" to "Explosive full-body exercise that boosts strength and cardio.",
                            "steps" to listOf("Start standing.", "Drop into push-up position.", "Perform push-up, jump up with arms overhead.")
                        ),
                        mapOf(
                            "title" to "Pull-Ups",
                            "sets" to "4 sets",
                            "reps" to "8–12 reps",
                            "description" to "Strengthens back, shoulders, and arms.",
                            "steps" to listOf("Hang from a bar with palms facing forward.", "Pull up until chin clears the bar.", "Lower slowly.")
                        ),
                        mapOf(
                            "title" to "Pistol Squats",
                            "sets" to "3 sets",
                            "reps" to "6–8 each leg",
                            "description" to "Single-leg squat for balance and leg power.",
                            "steps" to listOf("Stand on one leg.", "Extend the other leg forward.", "Lower into squat, then rise back up.")
                        ),
                        mapOf(
                            "title" to "Handstand Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "6–10 reps",
                            "description" to "Builds upper body strength and stability.",
                            "steps" to listOf("Kick up into a handstand against wall.", "Lower head to floor.", "Push back up.")
                        ),
                        mapOf(
                            "title" to "Jump Squats",
                            "sets" to "4 sets",
                            "reps" to "12 reps",
                            "description" to "Explosive power for legs and core.",
                            "steps" to listOf("Perform a regular squat.", "Explosively jump upward.", "Land softly and repeat.")
                        ),
                        mapOf(
                            "title" to "Clapping Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "10 reps",
                            "description" to "Explosive chest and tricep power.",
                            "steps" to listOf("Start in push-up position.", "Push explosively off ground and clap.", "Land back in push-up position.")
                        ),
                        mapOf(
                            "title" to "Dragon Flags",
                            "sets" to "3 sets",
                            "reps" to "6–8 reps",
                            "description" to "Intense core strength exercise.",
                            "steps" to listOf("Lie on bench holding sides.", "Raise body in straight line, only shoulders touching.", "Lower slowly.")
                        ),
                        mapOf(
                            "title" to "One-Arm Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–10 each arm",
                            "description" to "Chest, core, and arm strength challenge.",
                            "steps" to listOf("Spread feet wide.", "Place one hand under chest.", "Lower and push back up.")
                        ),
                        mapOf(
                            "title" to "Jumping Lunges",
                            "sets" to "3 sets",
                            "reps" to "12 each leg",
                            "description" to "Leg power and balance.",
                            "steps" to listOf("Start in lunge.", "Jump explosively and switch legs mid-air.", "Land softly.")
                        ),
                        mapOf(
                            "title" to "Plank to Push-Up",
                            "sets" to "3 sets",
                            "reps" to "15 reps",
                            "description" to "Core and upper body endurance.",
                            "steps" to listOf("Start in plank on forearms.", "Push up into push-up position.", "Return to plank.")
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
                            subCategory = "Advanced Full Body",
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
fun AFullBodyWorkoutScreenPreview() {
    AFullBodyWorkoutScreen(rememberNavController())
}
