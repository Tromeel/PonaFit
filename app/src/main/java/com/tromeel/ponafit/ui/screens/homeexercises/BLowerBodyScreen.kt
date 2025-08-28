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
fun BLowerBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Lower Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "These beginner lower-body workouts help strengthen your legs, glutes, and hips without equipment.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Squats",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Strengthens legs and glutes.",
                            "steps" to listOf(
                                "Stand with feet shoulder-width apart.",
                                "Bend knees and push hips back like sitting in a chair.",
                                "Keep chest upright and core tight.",
                                "Stand back up to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Glute Bridges",
                            "sets" to "3 sets",
                            "reps" to "10–15 reps",
                            "description" to "Activates glutes and strengthens core.",
                            "steps" to listOf(
                                "Lie on your back with knees bent and feet flat.",
                                "Keep arms at your sides for support.",
                                "Lift hips toward the ceiling while squeezing glutes.",
                                "Lower back down slowly."
                            )
                        ),
                        mapOf(
                            "title" to "Step-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps each leg",
                            "description" to "Builds leg strength using a sturdy step or chair.",
                            "steps" to listOf(
                                "Stand facing a sturdy chair or step.",
                                "Place one foot firmly on the step.",
                                "Push through your heel to lift your body up.",
                                "Step back down and repeat with the other leg."
                            )
                        ),
                        mapOf(
                            "title" to "Lunges",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps each leg",
                            "description" to "Improves balance and leg strength.",
                            "steps" to listOf(
                                "Stand upright with feet together.",
                                "Step forward with one leg and lower until knees form 90°.",
                                "Push through front heel to return to standing.",
                                "Repeat on the other leg."
                            )
                        ),
                        mapOf(
                            "title" to "Calf Raises",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Strengthens calves and improves ankle stability.",
                            "steps" to listOf(
                                "Stand with feet hip-width apart.",
                                "Lift heels off the ground onto your toes.",
                                "Hold for 1–2 seconds at the top.",
                                "Lower heels back down slowly."
                            )
                        ),
                        mapOf(
                            "title" to "Side Leg Raises",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps each leg",
                            "description" to "Strengthens hips and outer thighs.",
                            "steps" to listOf(
                                "Stand upright, holding onto a wall or chair for balance.",
                                "Lift one leg out to the side, keeping it straight.",
                                "Lower slowly and repeat.",
                                "Switch to the other leg."
                            )
                        ),
                        mapOf(
                            "title" to "Wall Sit",
                            "sets" to "3 sets",
                            "reps" to "Hold for 15–20 sec",
                            "description" to "Endurance move for quads and glutes.",
                            "steps" to listOf(
                                "Stand with your back against a wall.",
                                "Slide down until thighs are parallel to the floor.",
                                "Hold position with core tight and back flat.",
                                "Push through heels to stand back up."
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
fun BLowerBodyScreenPreview() {
    BLowerBodyScreen(rememberNavController())
}
