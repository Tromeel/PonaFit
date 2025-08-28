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
import com.tromeel.ponafit.navigation.ROUT_GFDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.screens.homeexercises.WorkoutCardTrackable
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GBFullBodyScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beginner Full Body Workouts (Gym)", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Start your fitness journey with these simple yet effective full-body workouts. Designed for beginners at the gym to build strength, improve endurance, and boost confidence.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Leg Press",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Great for building leg strength without needing balance.",
                            "steps" to listOf(
                                "Sit on the machine with your back flat.",
                                "Place your feet shoulder-width apart on the platform.",
                                "Push the platform up and release the safety.",
                                "Lower slowly until knees are at 90°, then push back up."
                            )
                        ),
                        mapOf(
                            "title" to "Lat Pulldown",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Targets your back and arms effectively.",
                            "steps" to listOf(
                                "Sit at the pulldown machine and grip the bar slightly wider than shoulders.",
                                "Pull the bar down to your chest.",
                                "Control the bar as you return it slowly upward.",
                                "Keep your back straight throughout."
                            )
                        ),
                        mapOf(
                            "title" to "Chest Press Machine",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Safe way to work your chest and triceps.",
                            "steps" to listOf(
                                "Sit on the machine with back against the pad.",
                                "Grip the handles at chest level.",
                                "Push the handles forward until arms are extended.",
                                "Return slowly with control."
                            )
                        ),
                        mapOf(
                            "title" to "Dumbbell Shoulder Press",
                            "sets" to "3 sets",
                            "reps" to "8–10 reps",
                            "description" to "Strengthens shoulders and improves posture.",
                            "steps" to listOf(
                                "Sit on a bench with dumbbells at shoulder height.",
                                "Press the dumbbells upward until arms are straight.",
                                "Lower back down slowly.",
                                "Keep core engaged."
                            )
                        ),
                        mapOf(
                            "title" to "Seated Row Machine",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Strengthens back, biceps, and improves posture.",
                            "steps" to listOf(
                                "Sit with feet on the footrests and grip the handles.",
                                "Pull the handles towards your torso.",
                                "Squeeze your shoulder blades together.",
                                "Slowly return to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Leg Curl Machine",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps",
                            "description" to "Works your hamstrings safely while seated or lying down.",
                            "steps" to listOf(
                                "Adjust the machine to fit your legs comfortably.",
                                "Place ankles under the padded lever.",
                                "Curl your legs back as far as possible.",
                                "Return slowly to starting position."
                            )
                        ),
                        mapOf(
                            "title" to "Cable Woodchopper",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps each side",
                            "description" to "Excellent core exercise using the cable machine to build rotational strength.",
                            "steps" to listOf(
                                "Set the cable handle to shoulder height.",
                                "Stand sideways to the machine with feet shoulder-width apart.",
                                "Grip the handle with both hands and pull it diagonally across your body.",
                                "Slowly return to the starting position with control."
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

@Preview
@Composable
fun GBFullBodyScreenPreview() {
    GBFullBodyScreen(rememberNavController())
}
