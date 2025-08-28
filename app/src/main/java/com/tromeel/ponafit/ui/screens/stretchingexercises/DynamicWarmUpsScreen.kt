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
import com.tromeel.ponafit.navigation.ROUT_STRETCHINGEXERCISES
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicWarmUpsScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dynamic Warm-Ups", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_STRETCHINGEXERCISES) }) {
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

                    Spacer(modifier = Modifier.height(10.dp))

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
                        StretchCard(
                            title = ex["title"]!!,
                            muscles = ex["muscles"]!!,
                            benefits = ex["benefits"]!!,
                            steps = ex["steps"]!!.split("→").map { it.trim() },
                            duration = ex["duration"]!!,
                            safetyTips = ex["safety"]!!,
                            mainCategory = "Stretching Exercises",
                            subCategory = "Dynamic Warm-Ups",
                            onTrack = { name, dur, main, sub -> vm.trackExercise(name, dur, main, sub) },
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
fun StretchCard7(
    title: String,
    muscles: String,
    benefits: String,
    steps: List<String>,
    duration: String,
    safetyTips: String,
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
                Text("Muscles: $muscles", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Benefits: $benefits", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Duration: $duration", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Steps:", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                Spacer(modifier = Modifier.height(4.dp))
                steps.forEach { step ->
                    Text(text = "• ${step.trim()}", fontSize = 14.sp, color = Color.White, modifier = Modifier.padding(bottom = 2.dp))
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (!isDone) {
                            onTrack(title, duration, mainCategory, subCategory)
                            isDone = true
                        } else {
                            onUndo(title)
                            isDone = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = if (isDone) Color.Gray else Grin),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Mark as Done", tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (isDone) "Done" else "Mark as Done", color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun DynamicWarmUpsScreenPreview() {
    DynamicWarmUpsScreen(rememberNavController())
}
