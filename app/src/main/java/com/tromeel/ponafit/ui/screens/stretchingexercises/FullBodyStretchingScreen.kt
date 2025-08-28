package com.tromeel.ponafit.ui.screens.stretchingexercises

import androidx.compose.foundation.BorderStroke
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
fun FullBodyStretchingScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Full Body Stretching", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "These stretches help improve flexibility, relieve tension, and enhance mobility across your whole body. Perform them gently and consistently for best results.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val exercises = listOf(
                        mapOf(
                            "title" to "Standing Full Body Stretch",
                            "duration" to "20–30 seconds, 2–3 times",
                            "muscles" to "Spine, shoulders, arms, calves",
                            "benefits" to "Improves posture, relieves stiffness, energizes the body",
                            "safety" to "Keep core engaged, avoid over-arching the back",
                            "steps" to "Stand tall with feet shoulder-width apart → Inhale and raise both arms overhead → Stretch upward as if reaching for the ceiling → Hold briefly, then exhale and relax"
                        ),
                        mapOf(
                            "title" to "Cat-Cow Stretch",
                            "duration" to "8–10 cycles",
                            "muscles" to "Spine, lower back, neck",
                            "benefits" to "Increases spinal flexibility, relieves back tension",
                            "safety" to "Move slowly, avoid jerky motions",
                            "steps" to "Begin on hands and knees in tabletop → Inhale, arch back & lift head (Cow) → Exhale, round spine & tuck chin (Cat) → Flow smoothly between positions"
                        ),
                        mapOf(
                            "title" to "Seated Forward Fold",
                            "duration" to "20–30 seconds",
                            "muscles" to "Hamstrings, spine",
                            "benefits" to "Stretches hamstrings and back, relaxes mind",
                            "safety" to "Keep spine long, avoid bouncing",
                            "steps" to "Sit with legs extended → Inhale, lengthen spine → Exhale, hinge forward from hips and reach toward toes → Hold and breathe"
                        ),
                        mapOf(
                            "title" to "Chest Opener Stretch",
                            "duration" to "15–20 seconds per side",
                            "muscles" to "Chest, shoulders",
                            "benefits" to "Opens chest, improves posture",
                            "safety" to "Avoid shoulder strain",
                            "steps" to "Stand tall → Clasp hands behind back → Lift hands slightly while opening chest → Hold and breathe"
                        ),
                        mapOf(
                            "title" to "Side Stretch",
                            "duration" to "15–20 seconds per side",
                            "muscles" to "Obliques, shoulders",
                            "benefits" to "Relieves side body tension",
                            "safety" to "Keep hips squared",
                            "steps" to "Stand tall → Reach right arm overhead → Lean to the left side → Hold, then switch sides"
                        ),
                        mapOf(
                            "title" to "Hip Flexor Stretch",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Hip flexors, quads",
                            "benefits" to "Reduces hip tightness",
                            "safety" to "Avoid arching lower back",
                            "steps" to "Lunge forward with right leg → Keep back leg straight → Push hips forward gently → Hold, then switch sides"
                        ),
                        mapOf(
                            "title" to "Child's Pose",
                            "duration" to "30–40 seconds",
                            "muscles" to "Spine, back, shoulders",
                            "benefits" to "Relaxes spine and shoulders, calms mind",
                            "safety" to "Avoid forcing knees together",
                            "steps" to "Kneel on floor → Sit back on heels → Stretch arms forward → Rest forehead on mat and breathe"
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
                            subCategory = "Full Body",
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
fun StretchCard(
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
        // Removed border as requested
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
fun FullBodyStretchingScreenPreview() {
    FullBodyStretchingScreen(rememberNavController())
}
