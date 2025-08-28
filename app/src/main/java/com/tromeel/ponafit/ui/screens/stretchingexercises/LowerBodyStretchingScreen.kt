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
fun LowerBodyStretchingScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lower Body Stretching", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "Lower body stretches improve flexibility, mobility, and recovery for your hips, hamstrings, calves, and quads.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Hamstring Stretch",
                            "muscles" to "Hamstrings, calves",
                            "benefits" to "Increases hamstring flexibility, relieves tightness",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Avoid rounding your back; hinge at hips",
                            "steps" to "Sit on the floor with legs extended → Reach forward toward toes → Hold position and breathe"
                        ),
                        mapOf(
                            "title" to "Quad Stretch",
                            "muscles" to "Quadriceps",
                            "benefits" to "Loosens front thighs, improves mobility",
                            "duration" to "20–30 seconds per leg",
                            "safety" to "Hold onto wall for balance; keep knees close",
                            "steps" to "Stand tall → Grab ankle and pull heel toward glutes → Keep knees aligned"
                        ),
                        mapOf(
                            "title" to "Calf Stretch",
                            "muscles" to "Calves (gastrocnemius, soleus)",
                            "benefits" to "Relieves calf tightness, improves ankle flexibility",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Keep back heel flat on the ground",
                            "steps" to "Stand facing wall → Step one foot back → Press heel down and lean forward"
                        ),
                        mapOf(
                            "title" to "Glute Stretch",
                            "muscles" to "Glutes, hips",
                            "benefits" to "Relieves tight hips and glutes",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Avoid twisting the spine excessively",
                            "steps" to "Lie on back → Cross ankle over opposite knee → Pull thigh toward chest"
                        ),
                        mapOf(
                            "title" to "Hip Flexor Stretch",
                            "muscles" to "Hip flexors, quads",
                            "benefits" to "Improves hip mobility, relieves anterior tightness",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Keep pelvis neutral; avoid arching lower back",
                            "steps" to "Lunge forward → Lower back knee → Push hips forward gently"
                        ),
                        mapOf(
                            "title" to "Inner Thigh Stretch",
                            "muscles" to "Adductors",
                            "benefits" to "Increases inner thigh flexibility",
                            "duration" to "20–30 seconds",
                            "safety" to "Do not bounce; stretch gently",
                            "steps" to "Sit with soles of feet together → Gently press knees toward floor → Hold"
                        ),
                        mapOf(
                            "title" to "IT Band Stretch",
                            "muscles" to "Outer thigh, IT band",
                            "benefits" to "Reduces lateral thigh tightness",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Keep hips square; do not twist excessively",
                            "steps" to "Cross one leg over the other → Lean toward opposite side → Hold gently"
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
                            subCategory = "Lower Body",
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
fun StretchCard4(
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

@Composable
@Preview
fun LowerBodyStretchingScreenPreview() {
    LowerBodyStretchingScreen(rememberNavController())
}
