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
fun HipRehabScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    val recoveryPeriods = mapOf(
        "0–2 Weeks" to listOf(
            mapOf("title" to "Pelvic Tilts", "muscles" to "Hip flexors, lower back", "benefits" to "Activates hip stabilizers gently", "duration" to "10 reps, 3 sets", "safety" to "Move slowly, avoid pain", "steps" to "Lie on back → Flatten lower back → Relax → Repeat"),
            mapOf("title" to "Glute Sets", "muscles" to "Glutes", "benefits" to "Maintains glute strength", "duration" to "10 reps, 3 sets", "safety" to "Do not overcontract", "steps" to "Squeeze glutes → Hold 5 sec → Relax"),
            mapOf("title" to "Hip Abductions Lying", "muscles" to "Glute medius", "benefits" to "Improves hip stability", "duration" to "10 reps each leg, 3 sets", "safety" to "Keep torso stable", "steps" to "Lie on side → Lift top leg → Lower slowly"),
            mapOf("title" to "Knee Squeezes", "muscles" to "Hip adductors", "benefits" to "Strengthens inner thighs gently", "duration" to "10 reps, 3 sets", "safety" to "Do not strain", "steps" to "Place pillow between knees → Squeeze → Relax"),
            mapOf("title" to "Heel Slides", "muscles" to "Hip flexors", "benefits" to "Maintains hip range of motion", "duration" to "10 reps, 3 sets", "safety" to "Move slowly", "steps" to "Lie on back → Slide heel toward buttocks → Return")
        ),
        "2–4 Weeks" to listOf(
            mapOf("title" to "Bridging", "muscles" to "Glutes, hamstrings", "benefits" to "Activates posterior chain", "duration" to "10 reps, 3 sets", "safety" to "Avoid lower back strain", "steps" to "Lie on back → Lift hips → Hold → Lower slowly"),
            mapOf("title" to "Clamshells", "muscles" to "Glute medius", "benefits" to "Improves hip lateral stability", "duration" to "10 reps each side, 2–3 sets", "safety" to "Keep feet together", "steps" to "Lie on side → Open knees → Lower → Repeat"),
            mapOf("title" to "Standing Hip Flexion", "muscles" to "Hip flexors", "benefits" to "Strengthens hip flexors", "duration" to "10 reps each leg, 2 sets", "safety" to "Hold support if needed", "steps" to "Stand → Lift knee forward → Lower slowly"),
            mapOf("title" to "Seated Marching", "muscles" to "Hip flexors", "benefits" to "Promotes hip activation", "duration" to "10 reps each leg, 2–3 sets", "safety" to "Move gently", "steps" to "Sit → Lift one knee → Lower → Alternate"),
            mapOf("title" to "Side-Lying Leg Circles", "muscles" to "Glutes, hip", "benefits" to "Improves hip mobility", "duration" to "10 reps each direction", "safety" to "Controlled motion", "steps" to "Lie on side → Lift leg → Circle → Repeat")
        ),
        "4–6 Weeks" to listOf(
            mapOf("title" to "Mini Squats", "muscles" to "Quads, glutes", "benefits" to "Strengthens hip and thigh", "duration" to "10 reps, 2–3 sets", "safety" to "Keep knees behind toes", "steps" to "Stand → Slight bend knees → Return"),
            mapOf("title" to "Side Step-Ups", "muscles" to "Glutes, hip abductors", "benefits" to "Improves lateral hip strength", "duration" to "10 reps each side, 2 sets", "safety" to "Use low step", "steps" to "Step sideways onto platform → Step down → Repeat"),
            mapOf("title" to "Hip Extension Standing", "muscles" to "Glutes", "benefits" to "Strengthens posterior chain", "duration" to "10 reps each leg, 2–3 sets", "safety" to "Hold support", "steps" to "Stand → Lift leg backward → Lower slowly"),
            mapOf("title" to "Bridges with March", "muscles" to "Glutes, core", "benefits" to "Dynamic hip activation", "duration" to "10 reps, 2 sets", "safety" to "Avoid arching back", "steps" to "Bridge → Lift one knee → Lower → Alternate"),
            mapOf("title" to "Standing Hip Abduction", "muscles" to "Glute medius", "benefits" to "Strengthens lateral hip", "duration" to "10 reps each leg, 2 sets", "safety" to "Use support", "steps" to "Lift leg sideways → Lower slowly")
        ),
        "6–8 Weeks" to listOf(
            mapOf("title" to "Lunges", "muscles" to "Glutes, quads", "benefits" to "Builds hip and leg strength", "duration" to "10 reps each leg, 2–3 sets", "safety" to "Do not overbend front knee", "steps" to "Step forward → Bend knees → Return"),
            mapOf("title" to "Single-Leg Deadlift", "muscles" to "Glutes, hamstrings", "benefits" to "Improves posterior chain and balance", "duration" to "8–10 reps each leg, 2 sets", "safety" to "Keep back straight", "steps" to "Hinge forward → Return"),
            mapOf("title" to "Step-Throughs", "muscles" to "Glutes, quads", "benefits" to "Enhances functional movement", "duration" to "10 reps, 2 sets", "safety" to "Use support", "steps" to "Step forward → Back → Repeat"),
            mapOf("title" to "Clamshell with Band", "muscles" to "Glute medius", "benefits" to "Strengthens hip stabilizers", "duration" to "10 reps each side, 2–3 sets", "safety" to "Avoid twisting torso", "steps" to "Lie on side → Open knees against band → Lower"),
            mapOf("title" to "Side Lunges", "muscles" to "Quads, glutes", "benefits" to "Improves lateral stability", "duration" to "10 reps each leg, 2 sets", "safety" to "Keep knee over ankle", "steps" to "Step sideways → Bend → Return")
        ),
        "8+ Weeks" to listOf(
            mapOf("title" to "Bulgarian Split Squats", "muscles" to "Quads, glutes", "benefits" to "Advanced hip and leg strength", "duration" to "8–10 reps each leg, 2–3 sets", "safety" to "Use support if needed", "steps" to "Back foot on bench → Lower front knee → Return"),
            mapOf("title" to "Single-Leg Squats", "muscles" to "Glutes, quads", "benefits" to "Improves balance and hip strength", "duration" to "8 reps each leg, 2 sets", "safety" to "Hold support if needed", "steps" to "Squat on one leg → Return → Repeat"),
            mapOf("title" to "Hip Bridges with Band", "muscles" to "Glutes, hamstrings", "benefits" to "Enhances hip strength", "duration" to "10 reps, 3 sets", "safety" to "Avoid overextension", "steps" to "Lift hips → Hold → Lower"),
            mapOf("title" to "Curtsy Lunges", "muscles" to "Glutes, quads", "benefits" to "Targets glute medius and quads", "duration" to "8–10 reps each leg, 2 sets", "safety" to "Step diagonally behind", "steps" to "Step behind into lunge → Return → Alternate"),
            mapOf("title" to "Lateral Band Walks", "muscles" to "Glute medius", "benefits" to "Strengthens hip stabilizers", "duration" to "10 steps each way, 2 sets", "safety" to "Keep knees slightly bent", "steps" to "Step sideways against band → Alternate")
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hip Rehab Exercises", color = Grin, fontWeight = FontWeight.Bold) },
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
                    text = "These exercises are designed to strengthen your hip and surrounding muscles during different recovery phases. Always follow your physiotherapist's guidance.",
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
                                subCategory = "HipRehab",
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
@Preview
fun HipRehabScreenPreview() {
    HipRehabScreen(rememberNavController())
}
