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
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_STRETCHINGEXERCISES
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpperBodyStretchingScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Upper Body Stretching", color = Grin, fontWeight = FontWeight.Bold) },
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

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These stretches loosen tight shoulders, chest, arms, and back muscles. Great for posture, mobility, and reducing stiffness.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Neck Side Stretch",
                            "muscles" to "Neck, upper traps",
                            "benefits" to "Relieves tension and stiffness in the neck",
                            "steps" to "Sit or stand tall → Tilt head toward one shoulder → Hold gently, then switch sides",
                            "duration" to "15–20 seconds per side",
                            "safety" to "Avoid pulling on the head with too much force"
                        ),
                        mapOf(
                            "title" to "Shoulder Rolls",
                            "muscles" to "Shoulders, traps",
                            "benefits" to "Increases shoulder mobility and relieves tightness",
                            "steps" to "Sit or stand tall → Roll shoulders slowly forward → Repeat backward",
                            "duration" to "8–10 rolls each direction",
                            "safety" to "Keep movements slow and controlled"
                        ),
                        mapOf(
                            "title" to "Triceps Stretch",
                            "muscles" to "Triceps, shoulders",
                            "benefits" to "Loosens tight triceps and improves arm mobility",
                            "steps" to "Raise one arm overhead → Bend elbow → Reach hand down back → Use other hand to press elbow gently",
                            "duration" to "20–30 seconds per arm",
                            "safety" to "Avoid arching lower back"
                        ),
                        mapOf(
                            "title" to "Chest Stretch",
                            "muscles" to "Chest, shoulders",
                            "benefits" to "Opens chest and relieves shoulder tightness",
                            "steps" to "Stand tall → Clasp hands behind back → Lift hands slightly → Hold and breathe",
                            "duration" to "15–20 seconds",
                            "safety" to "Avoid straining shoulders"
                        ),
                        mapOf(
                            "title" to "Upper Back Stretch",
                            "muscles" to "Upper back, shoulders",
                            "benefits" to "Reduces tension in upper back",
                            "steps" to "Interlace fingers → Extend arms forward → Round upper back → Hold",
                            "duration" to "15–20 seconds",
                            "safety" to "Keep shoulders relaxed"
                        ),
                        mapOf(
                            "title" to "Biceps Stretch",
                            "muscles" to "Biceps, shoulders",
                            "benefits" to "Stretches front of arms and shoulders",
                            "steps" to "Extend arms behind you → Clasp hands → Lift slightly → Hold",
                            "duration" to "15–20 seconds",
                            "safety" to "Avoid overextending elbows"
                        ),
                        mapOf(
                            "title" to "Scapular Retraction",
                            "muscles" to "Upper back, shoulders",
                            "benefits" to "Improves posture, strengthens shoulder blades",
                            "steps" to "Sit or stand tall → Squeeze shoulder blades together → Hold → Release",
                            "duration" to "10–15 repetitions",
                            "safety" to "Avoid shrugging shoulders"
                        )
                    )

                    exercises.forEach { ex ->
                        StretchCard(
                            title = ex["title"]!!,
                            muscles = ex["muscles"]!!,
                            benefits = ex["benefits"]!!,
                            steps = ex["steps"]!!.split("→"),
                            duration = ex["duration"]!!,
                            safetyTips = ex["safety"]!!,
                            mainCategory = "Stretching Exercises",
                            subCategory = "Upper Body",
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
fun StretchCard5(
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
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
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
                    Text(
                        text = "• ${step.trim()}",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
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
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isDone) Color.Gray else Grin
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Mark as Done",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (isDone) "Done" else "Mark as Done", color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun UpperBodyStretchingScreenPreview() {
    UpperBodyStretchingScreen(rememberNavController())
}
