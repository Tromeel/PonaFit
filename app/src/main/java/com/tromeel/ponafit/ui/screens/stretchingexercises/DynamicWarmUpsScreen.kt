package com.tromeel.ponafit.ui.screens.stretchingexercises

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
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
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_STRETCHINGEXERCISES
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@Composable
fun DynamicWarmUpsScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Grin) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black) },
                    label = { Text("Home", color = Color.Black) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.History, contentDescription = "History", tint = Color.Black) },
                    label = { Text("History", color = Color.Black) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_HISTORY)
                    }
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
                    IconButton(
                        onClick = { navController.navigate(ROUT_STRETCHINGEXERCISES) },
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Grin,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 10.dp, top = 10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Dynamic Warm-Ups",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Text(
                        text = "Dynamic warm-ups prepare your muscles, joints, and heart for exercise by improving mobility, circulation, and performance.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Arm Circles",
                            "muscles" to "Shoulders, arms",
                            "benefits" to "Loosens shoulder joints, improves circulation",
                            "duration" to "20–30 seconds each direction",
                            "safety" to "Keep movements controlled",
                            "steps" to "Stand with arms extended sideways → Make small forward circles → Switch to backward circles"
                        ),
                        mapOf(
                            "title" to "High Knees",
                            "muscles" to "Quads, hip flexors, calves, core",
                            "benefits" to "Boosts heart rate, activates lower body",
                            "duration" to "30–45 seconds",
                            "safety" to "Land softly on balls of feet",
                            "steps" to "Jog in place, lifting knees high → Pump arms as you move → Keep core engaged"
                        ),
                        mapOf(
                            "title" to "Leg Swings",
                            "muscles" to "Hip flexors, hamstrings, glutes",
                            "benefits" to "Improves hip mobility and flexibility",
                            "duration" to "10–15 swings per leg",
                            "safety" to "Keep movement smooth and controlled",
                            "steps" to "Hold onto support for balance → Swing one leg forward and backward → Switch legs after reps"
                        ),
                        mapOf(
                            "title" to "Lunges with Twist",
                            "muscles" to "Quads, glutes, core",
                            "benefits" to "Opens hips and engages core",
                            "duration" to "8–10 reps per side",
                            "safety" to "Keep front knee over ankle",
                            "steps" to "Step into a forward lunge → Twist torso toward front leg → Return and switch sides"
                        ),
                        mapOf(
                            "title" to "Butt Kicks",
                            "muscles" to "Hamstrings, calves",
                            "benefits" to "Activates posterior chain, warms up legs",
                            "duration" to "30 seconds",
                            "safety" to "Land softly on balls of feet",
                            "steps" to "Jog in place → Kick heels toward glutes → Maintain upright posture"
                        ),
                        mapOf(
                            "title" to "Side Lunges",
                            "muscles" to "Adductors, quads, glutes",
                            "benefits" to "Improves lateral mobility and flexibility",
                            "duration" to "8–10 reps per side",
                            "safety" to "Keep back straight, avoid twisting knee",
                            "steps" to "Step to side → Bend leading knee → Push hips back → Return"
                        ),
                        mapOf(
                            "title" to "Torso Twists",
                            "muscles" to "Obliques, spine",
                            "benefits" to "Mobilizes spine and core",
                            "duration" to "10–15 twists per side",
                            "safety" to "Keep hips stable",
                            "steps" to "Stand feet shoulder-width → Twist torso left and right → Move smoothly"
                        )
                    )

                    exercises.forEach { ex ->
                        StretchCard4(
                            title = ex["title"]!!,
                            muscles = ex["muscles"]!!,
                            benefits = ex["benefits"]!!,
                            steps = ex["steps"]!!.split("→").map { it.trim() },
                            duration = ex["duration"]!!,
                            safetyTips = ex["safety"]!!,
                            mainCategory = "Stretching Exercises",
                            subCategory = "Dynamic Warm-Ups",
                            onTrack = { name, dur, main, sub ->
                                vm.trackExercise(name, dur, main, sub)
                            },
                            onUndo = { name -> vm.removeExerciseFromHistory(name) }
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun DynamicWarmUpsScreenPreview() {
    DynamicWarmUpsScreen(rememberNavController())
}
