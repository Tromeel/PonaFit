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
fun IFullBodyWorkoutScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Intermediate Full Body Workouts", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Intermediate full-body workouts are a great way to build strength, improve fitness, and stay active without needing equipment. These exercises target all major muscle groups for balance, flexibility, and endurance.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Burpees",
                            "sets" to "4 sets",
                            "reps" to "10–12 reps",
                            "description" to "A full-body exercise for strength and cardio.",
                            "steps" to listOf(
                                "Start standing tall with feet shoulder-width apart.",
                                "Drop into a squat, place hands on the floor.",
                                "Kick feet back into a push-up position.",
                                "Do one push-up, then jump back up explosively."
                            )
                        ),
                        mapOf(
                            "title" to "Jump Squats",
                            "sets" to "4 sets",
                            "reps" to "12–15 reps",
                            "description" to "Builds explosive power in legs and glutes.",
                            "steps" to listOf(
                                "Stand with feet shoulder-width apart.",
                                "Perform a squat keeping chest upright.",
                                "Push through your heels and jump explosively.",
                                "Land softly and go right into the next rep."
                            )
                        ),
                        mapOf(
                            "title" to "Decline Push-Ups",
                            "sets" to "4 sets",
                            "reps" to "10–15 reps",
                            "description" to "Targets upper chest and shoulders.",
                            "steps" to listOf(
                                "Place your feet on a raised surface like a chair.",
                                "Hands on the ground, slightly wider than shoulders.",
                                "Lower your chest toward the ground.",
                                "Push back up while keeping body aligned."
                            )
                        ),
                        mapOf(
                            "title" to "Side Plank with Hip Dips",
                            "sets" to "3 sets",
                            "reps" to "12 reps each side",
                            "description" to "Strengthens core, obliques, and stabilizers.",
                            "steps" to listOf(
                                "Lie on your side with elbow under shoulder.",
                                "Lift hips into a straight line position.",
                                "Lower hips slightly toward the ground.",
                                "Raise them back up and repeat."
                            )
                        ),
                        mapOf(
                            "title" to "Bulgarian Split Squats",
                            "sets" to "3 sets",
                            "reps" to "10–12 reps each leg",
                            "description" to "Single-leg exercise for balance and strength.",
                            "steps" to listOf(
                                "Stand a few feet in front of a bench or chair.",
                                "Place one foot on the bench behind you.",
                                "Lower your hips until front thigh is parallel.",
                                "Push through front heel to rise back up."
                            )
                        ),
                        mapOf(
                            "title" to "Pike Push-Ups",
                            "sets" to "3 sets",
                            "reps" to "8–12 reps",
                            "description" to "Focuses on shoulders and upper body strength.",
                            "steps" to listOf(
                                "Start in a downward dog position.",
                                "Hands shoulder-width apart, hips raised high.",
                                "Lower head toward the ground by bending elbows.",
                                "Push back up to the start position."
                            )
                        ),
                        mapOf(
                            "title" to "Bicycle Crunches",
                            "sets" to "3 sets",
                            "reps" to "15–20 reps each side",
                            "description" to "Core workout targeting abs and obliques.",
                            "steps" to listOf(
                                "Lie flat on your back with hands behind your head.",
                                "Lift knees to a tabletop position.",
                                "Bring right elbow toward left knee while extending right leg.",
                                "Switch sides in a pedaling motion."
                            )
                        ),
                        mapOf(
                            "title" to "Plank to Shoulder Tap",
                            "sets" to "3 sets",
                            "reps" to "12–16 reps each side",
                            "description" to "Improves stability and core strength.",
                            "steps" to listOf(
                                "Start in a high plank with hands under shoulders.",
                                "Lift one hand and tap the opposite shoulder.",
                                "Alternate sides while keeping hips steady.",
                                "Engage your core throughout."
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
fun IFullBodyWorkoutScreenPreview() {
    IFullBodyWorkoutScreen(rememberNavController())
}
