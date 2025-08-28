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
fun BUpperBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Upper Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Beginner upper-body workouts at home help build strength in your chest, arms, shoulders, and back using just your bodyweight.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Wall Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "10–15 reps",
                            "description" to "Great for beginners to strengthen chest and arms.",
                            "steps" to listOf(
                                "Stand facing a wall with arms extended at shoulder height.",
                                "Place palms flat on the wall, slightly wider than shoulders.",
                                "Bend elbows and lean chest toward the wall.",
                                "Push back to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Arm Circles",
                            "sets" to "3 sets",
                            "reps" to "15–20 sec each",
                            "description" to "Improves shoulder mobility and endurance.",
                            "steps" to listOf(
                                "Stand upright with arms extended to the sides.",
                                "Rotate arms forward in small circles.",
                                "Gradually make circles bigger.",
                                "Repeat in the opposite direction."
                            )
                        ),
                        mapOf(
                            "title" to "Modified Knee Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Strengthens chest, shoulders, and triceps.",
                            "steps" to listOf(
                                "Start in a push-up position but with knees on the floor.",
                                "Hands should be shoulder-width apart.",
                                "Lower chest toward the ground by bending elbows.",
                                "Push back up to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Superman Hold",
                            "sets" to "3 sets",
                            "reps" to "Hold for 10–15 sec",
                            "description" to "Strengthens back and shoulders.",
                            "steps" to listOf(
                                "Lie face down on the floor with arms extended forward.",
                                "Lift arms, chest, and legs slightly off the ground.",
                                "Hold for a few seconds while squeezing your back.",
                                "Slowly return to the starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Shoulder Shrugs",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Helps relax and strengthen shoulder muscles.",
                            "steps" to listOf(
                                "Stand upright with arms relaxed by your sides.",
                                "Lift your shoulders up toward your ears.",
                                "Hold for 1–2 seconds, then release slowly.",
                                "Repeat steadily without rushing."
                            )
                        ),
                        mapOf(
                            "title" to "Chair Dips",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Works on triceps and shoulders using a sturdy chair.",
                            "steps" to listOf(
                                "Sit on the edge of a chair with hands gripping the sides.",
                                "Walk your feet slightly forward and slide off the seat.",
                                "Lower your body by bending elbows to 90 degrees.",
                                "Push back up to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Front Arm Raises",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Strengthens shoulders and improves control.",
                            "steps" to listOf(
                                "Stand upright with arms down at your sides.",
                                "Lift both arms forward until shoulder height.",
                                "Pause briefly, then lower arms slowly.",
                                "Keep movements controlled without swinging."
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
                            subCategory = "Beginner Upper Body",
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
fun BUpperBodyScreenPreview() {
    BUpperBodyScreen(rememberNavController())
}
