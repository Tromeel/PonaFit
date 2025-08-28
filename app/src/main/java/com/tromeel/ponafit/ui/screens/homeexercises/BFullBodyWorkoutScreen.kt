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
fun BFullBodyWorkoutScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Full Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Beginner full-body workouts build strength, balance, and endurance from home. Follow each step carefully.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Jumping Jacks",
                            "sets" to "3 sets",
                            "reps" to "15–20 reps",
                            "description" to "A cardio warm-up to increase heart rate.",
                            "steps" to listOf(
                                "Stand upright with feet together and arms at your sides.",
                                "Jump while spreading your legs shoulder-width apart and raising your arms overhead.",
                                "Quickly return to the starting position.",
                                "Repeat continuously at a steady pace."
                            )
                        ),
                        mapOf(
                            "title" to "Bodyweight Squats",
                            "sets" to "3 sets",
                            "reps" to "12 reps",
                            "description" to "Strengthens legs and glutes.",
                            "steps" to listOf(
                                "Stand with feet shoulder-width apart.",
                                "Lower your hips down and back as if sitting on a chair.",
                                "Keep your chest upright and knees behind your toes.",
                                "Push through your heels to return to standing."
                            )
                        ),
                        mapOf(
                            "title" to "Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Builds strength in chest, shoulders, and arms.",
                            "steps" to listOf(
                                "Place hands on the floor shoulder-width apart.",
                                "Keep your body in a straight line from head to heels.",
                                "Lower your chest toward the ground by bending elbows.",
                                "Push back up to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Plank Hold",
                            "sets" to "3 sets",
                            "reps" to "Hold for 20–30 sec",
                            "description" to "Improves core stability and posture.",
                            "steps" to listOf(
                                "Start in a push-up position but rest on your forearms.",
                                "Keep your body straight from head to heels.",
                                "Engage your core and hold the position.",
                                "Avoid letting hips sag or rise too high."
                            )
                        ),
                        mapOf(
                            "title" to "Glute Bridges",
                            "sets" to "3 sets",
                            "reps" to "12–15 reps",
                            "description" to "Activates and strengthens glutes and lower back.",
                            "steps" to listOf(
                                "Lie flat on your back with knees bent and feet flat on the floor.",
                                "Place your arms at your sides, palms facing down.",
                                "Lift your hips upward until your body forms a straight line from shoulders to knees.",
                                "Squeeze your glutes at the top, then slowly lower down."
                            )
                        ),
                        mapOf(
                            "title" to "Lunges",
                            "sets" to "3 sets",
                            "reps" to "10 reps each leg",
                            "description" to "Strengthens legs, glutes, and improves balance.",
                            "steps" to listOf(
                                "Stand upright with feet together.",
                                "Step forward with one leg and lower your body until both knees are bent at 90 degrees.",
                                "Push through your front heel to return to starting position.",
                                "Alternate legs for each rep."
                            )
                        ),
                        mapOf(
                            "title" to "Superman Hold",
                            "sets" to "3 sets",
                            "reps" to "Hold 20 sec",
                            "description" to "Strengthens lower back and improves posture.",
                            "steps" to listOf(
                                "Lie face down on the floor with arms extended forward.",
                                "Lift your arms, chest, and legs off the ground simultaneously.",
                                "Hold for a few seconds while squeezing your back muscles.",
                                "Slowly return to the starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Mountain Climbers",
                            "sets" to "3 sets",
                            "reps" to "20 reps",
                            "description" to "Boosts cardio and core endurance.",
                            "steps" to listOf(
                                "Start in a push-up position.",
                                "Drive one knee toward your chest while keeping the other leg extended.",
                                "Quickly switch legs in a running motion.",
                                "Continue alternating at a steady pace."
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
                            subCategory = "Beginner Full Body",
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

@Composable
fun WorkoutCardTrackable(
    title: String,
    description: String,
    reps: String,
    sets: String,
    steps: List<String>,
    mainCategory: String,
    subCategory: String,
    onTrack: (String, String, String, String) -> Unit,
    onUndo: (String) -> Unit,
    vm: ExerciseViewModel
) {
    var isDone by remember { mutableStateOf(false) }

    LaunchedEffect(title) {
        vm.isExerciseTracked(title).collect { tracked ->
            isDone = tracked
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
            .heightIn(min = 280.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
                Spacer(modifier = Modifier.height(6.dp))
                Text(description, fontSize = 14.sp, color = Color.LightGray)
                Spacer(modifier = Modifier.height(6.dp))
                Text("Sets: $sets", fontSize = 14.sp, color = Color.White)
                Text("Reps: $reps", fontSize = 14.sp, color = Color.White)

                Spacer(modifier = Modifier.height(10.dp))
                Text("Steps:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                steps.forEach {
                    Text("• ${it.trim()}", fontSize = 13.sp, color = Color.White, modifier = Modifier.padding(top = 2.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (!isDone) {
                            onTrack(title, reps, mainCategory, subCategory)
                            isDone = true
                        } else {
                            onUndo(title)
                            isDone = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isDone) Color.Gray else Grin
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(Icons.Default.Check, contentDescription = "Done", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (isDone) "Done" else "Mark as Done", color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun BFullBodyWorkoutScreenPreview() {
    BFullBodyWorkoutScreen(rememberNavController())
}
