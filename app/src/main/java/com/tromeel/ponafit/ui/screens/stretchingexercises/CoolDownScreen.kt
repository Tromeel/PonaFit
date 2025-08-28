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
fun CoolDownScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cool Down Stretches", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Cool down exercises help your body relax, reduce stiffness, and promote recovery after a workout. Perform each stretch slowly and with controlled breathing.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Standing Forward Fold",
                            "duration" to "20–30 seconds",
                            "muscles" to "Hamstrings, calves, lower back",
                            "benefits" to "Stretches the back and legs, improves flexibility, relieves tension",
                            "safety" to "Keep knees slightly bent if tight hamstrings",
                            "steps" to "Stand tall → Exhale and hinge forward from hips → Let arms hang → Hold position breathing deeply"
                        ),
                        mapOf(
                            "title" to "Seated Hamstring Stretch",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Hamstrings, calves",
                            "benefits" to "Improves flexibility and range of motion in the legs",
                            "safety" to "Do not force reach; keep back straight",
                            "steps" to "Sit on floor → Extend one leg, bend other foot to inner thigh → Reach toward extended foot → Switch sides"
                        ),
                        mapOf(
                            "title" to "Child’s Pose",
                            "duration" to "30–60 seconds",
                            "muscles" to "Spine, shoulders, hips",
                            "benefits" to "Relaxes the back, stretches hips and shoulders, calms the mind",
                            "safety" to "Avoid if you have knee injuries",
                            "steps" to "Kneel on mat → Sit back on heels → Extend arms forward → Rest forehead on floor"
                        ),
                        mapOf(
                            "title" to "Cat-Cow Stretch",
                            "duration" to "8–10 cycles",
                            "muscles" to "Spine, lower back, neck",
                            "benefits" to "Improves spinal flexibility, relieves tension",
                            "safety" to "Move slowly and avoid jerky motions",
                            "steps" to "Start on hands and knees → Inhale arching back (Cow) → Exhale rounding spine (Cat) → Repeat"
                        ),
                        mapOf(
                            "title" to "Figure Four Stretch",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Glutes, hips",
                            "benefits" to "Releases hip tension and stretches glutes",
                            "safety" to "Avoid twisting lower back",
                            "steps" to "Lie on back → Cross ankle over opposite knee → Pull leg toward chest → Switch sides"
                        ),
                        mapOf(
                            "title" to "Shoulder Stretch",
                            "duration" to "20 seconds per side",
                            "muscles" to "Shoulders, upper back",
                            "benefits" to "Relieves shoulder tension",
                            "safety" to "Do not overstretch",
                            "steps" to "Bring one arm across chest → Use opposite arm to press gently → Switch sides"
                        ),
                        mapOf(
                            "title" to "Neck Stretch",
                            "duration" to "15–20 seconds per side",
                            "muscles" to "Neck, upper traps",
                            "benefits" to "Reduces neck stiffness and tension",
                            "safety" to "Avoid pulling on the neck forcefully",
                            "steps" to "Sit or stand tall → Tilt head to one side → Hold gently → Switch sides"
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
                            subCategory = "Cool Down",
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
fun StretchCard6(
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
                modifier = Modifier.fillMaxSize(),
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

@Composable
@Preview
fun CoolDownScreenPreview() {
    CoolDownScreen(rememberNavController())
}
