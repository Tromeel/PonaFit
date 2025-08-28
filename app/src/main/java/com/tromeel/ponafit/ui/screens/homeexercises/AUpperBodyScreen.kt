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
import com.tromeel.ponafit.navigation.ROUT_UDIFFICULTY
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AUpperBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Advanced Upper Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Advanced upper-body workouts at home push your strength, stability, and endurance to the next level.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Archer Push-Ups",
                            "sets" to "4 sets",
                            "reps" to "8–10 each side",
                            "description" to "A unilateral push-up that builds serious chest and shoulder strength.",
                            "steps" to listOf(
                                "Start in push-up position with arms wider than shoulder-width.",
                                "Lower your chest toward one arm while keeping the other straight.",
                                "Push back up and shift to the opposite side.",
                                "Keep core tight throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Handstand Push-Ups (Wall Supported)",
                            "sets" to "4 sets",
                            "reps" to "6–8 reps",
                            "description" to "Targets shoulders and triceps with high resistance.",
                            "steps" to listOf(
                                "Kick up into a handstand against a wall.",
                                "Lower your head slowly toward the floor by bending elbows.",
                                "Push back up to full arm extension.",
                                "Maintain tight core for balance."
                            )
                        ),
                        mapOf(
                            "title" to "Clapping Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Explosive power move for chest, shoulders, and triceps.",
                            "steps" to listOf(
                                "Start in push-up position.",
                                "Lower your chest and push up explosively off the ground.",
                                "Clap hands quickly before landing back in push-up position.",
                                "Absorb landing softly with bent elbows."
                            )
                        ),
                        mapOf(
                            "title" to "Pseudo Planche Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Engages chest, shoulders, and core heavily.",
                            "steps" to listOf(
                                "Begin in push-up position with hands placed lower near hips.",
                                "Lean forward slightly to shift weight onto shoulders.",
                                "Lower chest toward ground keeping elbows tucked.",
                                "Push back up while maintaining forward lean."
                            )
                        ),
                        mapOf(
                            "title" to "One-Arm Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "5–8 each arm",
                            "description" to "Advanced unilateral strength builder.",
                            "steps" to listOf(
                                "Start in push-up position with feet slightly wider.",
                                "Place one arm behind your back.",
                                "Lower chest toward ground with one arm supporting.",
                                "Push back up with controlled movement."
                            )
                        ),
                        mapOf(
                            "title" to "Typewriter Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "6–8 each side",
                            "description" to "Targets chest and shoulders with side-to-side strength.",
                            "steps" to listOf(
                                "Start in wide push-up position.",
                                "Lower chest to one side, keeping elbows tucked.",
                                "Shift body across to the other side while staying low.",
                                "Push back up to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Superman Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "6–8 reps",
                            "description" to "Explosive movement engaging chest, shoulders, arms, and core.",
                            "steps" to listOf(
                                "Begin in push-up position.",
                                "Lower chest and push up explosively off the floor.",
                                "Extend arms forward like Superman while in the air.",
                                "Land softly back in push-up position."
                            )
                        ),
                        mapOf(
                            "title" to "Pike to Handstand Press",
                            "sets" to "3 sets",
                            "reps" to "5–6 reps",
                            "description" to "Bridges strength between shoulders and core.",
                            "steps" to listOf(
                                "Start in a pike position with hips raised.",
                                "Push through shoulders, lifting legs slightly off the floor.",
                                "Transition into a supported handstand against the wall.",
                                "Lower back to pike with control."
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
                            subCategory = "Advanced Upper Body",
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
fun AUpperBodyScreenPreview() {
    AUpperBodyScreen(rememberNavController())
}
