package com.tromeel.ponafit.ui.screens.rehab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.tromeel.ponafit.navigation.ROUT_REHAB
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoulderRehabScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    val recoveryPeriods = mapOf(
        "0–2 Weeks" to listOf(
            mapOf("title" to "Pendulum Swings", "muscles" to "Shoulder joint, deltoid", "benefits" to "Promotes gentle shoulder mobility", "duration" to "10 reps, 3 sets", "safety" to "Move gently, avoid pain", "steps" to "Lean forward → Let arm hang → Swing gently in circles"),
            mapOf("title" to "Scapular Squeezes", "muscles" to "Upper back, scapula", "benefits" to "Improves shoulder stability", "duration" to "10 reps, 3 sets", "safety" to "Do not shrug shoulders", "steps" to "Squeeze shoulder blades together → Hold 5 sec → Relax"),
            mapOf("title" to "Elbow Flexion/Extension", "muscles" to "Biceps, triceps", "benefits" to "Maintains arm mobility", "duration" to "10 reps, 3 sets", "safety" to "Move slowly", "steps" to "Bend elbow → Straighten → Repeat"),
            mapOf("title" to "Shoulder Circles", "muscles" to "Deltoid, rotator cuff", "benefits" to "Gentle joint mobility", "duration" to "10 reps each way, 3 sets", "safety" to "Move slowly", "steps" to "Lift arm → Circle forward → Reverse"),
            mapOf("title" to "Wand Assistance Flexion", "muscles" to "Deltoid, rotator cuff", "benefits" to "Assisted shoulder flexion", "duration" to "10 reps, 3 sets", "safety" to "Avoid pain", "steps" to "Hold wand → Lift arm with assistance → Lower slowly")
        ),
        "2–4 Weeks" to listOf(
            mapOf("title" to "Wall Slides", "muscles" to "Shoulders, upper back", "benefits" to "Enhances shoulder mobility", "duration" to "10 reps, 2–3 sets", "safety" to "Do not arch back", "steps" to "Stand against wall → Slide arms upward → Lower slowly"),
            mapOf("title" to "External Rotation with Band", "muscles" to "Rotator cuff", "benefits" to "Strengthens external rotators", "duration" to "10 reps, 2–3 sets", "safety" to "Keep elbow close to body", "steps" to "Hold band → Rotate arm outward → Return"),
            mapOf("title" to "Shoulder Flexion", "muscles" to "Deltoid", "benefits" to "Maintains shoulder flexion range", "duration" to "10 reps, 2–3 sets", "safety" to "Avoid pain", "steps" to "Lift arm forward → Hold → Lower slowly"),
            mapOf("title" to "Shoulder Abduction", "muscles" to "Deltoid, rotator cuff", "benefits" to "Strengthens lateral shoulder", "duration" to "10 reps, 2–3 sets", "safety" to "Do not shrug", "steps" to "Lift arm sideways → Hold → Lower slowly"),
            mapOf("title" to "Prone Y’s", "muscles" to "Upper back, shoulders", "benefits" to "Improves scapular control", "duration" to "10 reps, 2–3 sets", "safety" to "Lift gently", "steps" to "Lie face down → Lift arms in Y → Lower")
        ),
        "4–6 Weeks" to listOf(
            mapOf("title" to "TheraBand Rows", "muscles" to "Back, shoulder", "benefits" to "Strengthens upper back and shoulder stabilizers", "duration" to "10 reps, 3 sets", "safety" to "Keep back straight", "steps" to "Pull band toward chest → Squeeze shoulder blades → Release"),
            mapOf("title" to "Shoulder Abduction with Band", "muscles" to "Deltoid, rotator cuff", "benefits" to "Improves lateral shoulder strength", "duration" to "10 reps, 2–3 sets", "safety" to "Avoid shrugging", "steps" to "Lift arm to side → Lower slowly"),
            mapOf("title" to "Prone T’s", "muscles" to "Upper back, shoulders", "benefits" to "Strengthens scapular stabilizers", "duration" to "10 reps, 3 sets", "safety" to "Lift gently", "steps" to "Lie face down → Lift arms to T → Lower"),
            mapOf("title" to "Internal Rotation with Band", "muscles" to "Rotator cuff", "benefits" to "Strengthens internal rotators", "duration" to "10 reps, 2 sets", "safety" to "Elbow at 90°", "steps" to "Pull band inward → Return"),
            mapOf("title" to "Wall Angels", "muscles" to "Upper back, shoulders", "benefits" to "Improves posture and shoulder mobility", "duration" to "10 reps, 2 sets", "safety" to "Keep back flat", "steps" to "Stand → Move arms up/down wall → Return")
        ),
        "6–8 Weeks" to listOf(
            mapOf("title" to "Wall Push-Ups", "muscles" to "Chest, shoulders", "benefits" to "Builds shoulder and chest strength safely", "duration" to "10 reps, 2–3 sets", "safety" to "Do not arch back", "steps" to "Stand facing wall → Push against wall → Return"),
            mapOf("title" to "Standing Row with Band", "muscles" to "Back, shoulders", "benefits" to "Strengthens posterior shoulder muscles", "duration" to "10 reps, 2–3 sets", "safety" to "Keep shoulders down", "steps" to "Pull band toward body → Squeeze shoulder blades → Release"),
            mapOf("title" to "Shoulder Extension with Band", "muscles" to "Posterior deltoid", "benefits" to "Strengthens back of shoulder", "duration" to "10 reps, 2 sets", "safety" to "Move slowly", "steps" to "Pull arm backward → Return slowly"),
            mapOf("title" to "Reverse Fly with Band", "muscles" to "Rear deltoid, back", "benefits" to "Strengthens rear shoulder", "duration" to "10 reps, 2 sets", "safety" to "Keep arms straight", "steps" to "Pull band outward → Return"),
            mapOf("title" to "Overhead Wall Stretch", "muscles" to "Deltoid, upper back", "benefits" to "Improves mobility and posture", "duration" to "Hold 20 sec, 3 sets", "safety" to "Do not overstretch", "steps" to "Place hands on wall → Stretch upward → Hold")
        ),
        "8+ Weeks" to listOf(
            mapOf("title" to "Overhead Press with Light Weights", "muscles" to "Deltoid, rotator cuff", "benefits" to "Builds overall shoulder strength", "duration" to "8–10 reps, 2–3 sets", "safety" to "Use light weights only", "steps" to "Lift weights overhead → Lower slowly"),
            mapOf("title" to "External Rotation at 90° Abduction", "muscles" to "Rotator cuff", "benefits" to "Strengthens shoulder rotators", "duration" to "8–10 reps, 2–3 sets", "safety" to "Avoid shoulder pain", "steps" to "Raise arm to side → Rotate outward → Return"),
            mapOf("title" to "Scaption", "muscles" to "Deltoid, supraspinatus", "benefits" to "Strengthens shoulder in functional plane", "duration" to "8–10 reps, 2 sets", "safety" to "Move slowly", "steps" to "Lift arms 30° forward of side → Lower slowly"),
            mapOf("title" to "Lateral Raises with Light Weights", "muscles" to "Deltoid", "benefits" to "Strengthens side shoulder muscles", "duration" to "10 reps, 2 sets", "safety" to "Use light weights", "steps" to "Lift arms sideways → Lower slowly"),
            mapOf("title" to "Front Raises with Light Weights", "muscles" to "Deltoid, anterior shoulder", "benefits" to "Strengthens front shoulder muscles", "duration" to "10 reps, 2 sets", "safety" to "Use light weights", "steps" to "Lift arms forward → Lower slowly")
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shoulder Rehab Exercises", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_REHAB) }) {
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(R.drawable.greenbg),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "These exercises are designed to strengthen your shoulder and surrounding muscles during different recovery phases. Always follow your physiotherapist's guidance.",
                    fontSize = 18.sp,
                    color = Grin,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                recoveryPeriods.forEach { (period, exercises) ->
                    Text(
                        text = period,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Grin,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(exercises) { ex ->
                            StretchCard(
                                title = ex["title"]!!,
                                muscles = ex["muscles"]!!,
                                benefits = ex["benefits"]!!,
                                steps = ex["steps"]!!.split("→").map { it.trim() },
                                duration = ex["duration"]!!,
                                safetyTips = ex["safety"]!!,
                                mainCategory = "Rehab",
                                subCategory = "ShoulderRehab",
                                onTrack = { name, dur, main, sub -> vm.trackExercise(name, dur, main, sub) },
                                onUndo = { name -> vm.removeExerciseFromHistory(name) },
                                vm = vm,
                                modifier = Modifier.width(250.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun StretchCard1(
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
    vm: ExerciseViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(300.dp)
            .paint(
                painter = painterResource(R.drawable.darkbg),
                contentScale = ContentScale.FillBounds,
                alpha = 0.85f
            ),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
                Text("Muscles: $muscles", fontSize = 14.sp, color = Color.White)
                Text("Benefits: $benefits", fontSize = 14.sp, color = Color.White)
                Text("Duration: $duration", fontSize = 14.sp, color = Color.White)
                Text("Safety: $safetyTips", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Steps:", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color.White)
                steps.forEach { step ->
                    Text("• $step", fontSize = 14.sp, color = Color.White)
                }
            }

            val isTracked by vm.isExerciseTracked(title).collectAsState(initial = false)
            Button(
                onClick = {
                    if (isTracked) onUndo(title) else onTrack(title, duration, mainCategory, subCategory)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = if (isTracked) Color.Gray else Grin)
            ) {
                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Check, contentDescription = "Mark as Done", tint = Color.Black)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = if (isTracked) "Done" else "Mark as Done", color = Color.Black)
                }
            }
        }
    }
}

@Composable
@Preview
fun ShoulderRehabScreenPreview() {
    ShoulderRehabScreen(rememberNavController())
}
