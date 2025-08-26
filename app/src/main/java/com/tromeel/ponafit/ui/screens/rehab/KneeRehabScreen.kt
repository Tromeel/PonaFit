package com.tromeel.ponafit.ui.screens.rehab

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
import com.tromeel.ponafit.ui.screens.stretchingexercises.StretchCard
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KneeRehabScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Knee Rehab Exercises", color = Grin, fontWeight = FontWeight.Bold) },
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
                        text = "These exercises are designed to strengthen your knee and surrounding muscles during different recovery phases. Always follow your physiotherapist's guidance.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    val recoveryPeriods = mapOf(
                        "0–2 Weeks" to listOf(
                            mapOf("title" to "Quadriceps Activation", "muscles" to "Quadriceps", "benefits" to "Maintains quad strength without moving the knee", "duration" to "10 reps, 3 sets", "safety" to "Keep knee straight, do not lift leg", "steps" to "Sit with leg straight → Tighten thigh muscles → Hold 5 sec → Relax"),
                            mapOf("title" to "Knee Glide", "muscles" to "Knee joint, hamstrings", "benefits" to "Promotes knee mobility", "duration" to "10–15 reps, 2–3 sets", "safety" to "Move slowly, avoid pain", "steps" to "Lie on back → Slide heel toward buttocks → Slide back → Repeat"),
                            mapOf("title" to "Ankle Pumps", "muscles" to "Calves, ankle", "benefits" to "Promotes circulation", "duration" to "15 reps, 3 sets", "safety" to "Move gently", "steps" to "Flex and point toes → Repeat slowly"),
                            mapOf("title" to "Hamstring Sets", "muscles" to "Hamstrings", "benefits" to "Maintains hamstring tone", "duration" to "10 reps, 3 sets", "safety" to "Do not strain", "steps" to "Press heel into floor → Hold 5 sec → Relax"),
                            mapOf("title" to "Seated Knee Extensions", "muscles" to "Quadriceps", "benefits" to "Maintains knee range of motion", "duration" to "10 reps, 3 sets", "safety" to "Avoid pain", "steps" to "Sit → Straighten knee → Hold → Relax")
                        ),
                        "2–4 Weeks" to listOf(
                            mapOf("title" to "Straight Leg Strength", "muscles" to "Quadriceps, hip flexors", "benefits" to "Strengthens quad without bending knee", "duration" to "10–12 reps, 3 sets", "safety" to "Avoid arching back", "steps" to "Lie on back → Tighten thigh → Lift straight leg → Hold → Lower slowly"),
                            mapOf("title" to "Heel Raises", "muscles" to "Calves, quads", "benefits" to "Strengthens lower leg and improves balance", "duration" to "10 reps, 3 sets", "safety" to "Hold support if needed", "steps" to "Stand → Raise heels → Lower slowly"),
                            mapOf("title" to "Short Arc Quads", "muscles" to "Quadriceps", "benefits" to "Strengthens quad safely", "duration" to "10 reps, 3 sets", "safety" to "Avoid knee pain", "steps" to "Place towel under knee → Lift lower leg → Hold → Lower"),
                            mapOf("title" to "Hip Abductions", "muscles" to "Glutes, hip", "benefits" to "Improves hip stability", "duration" to "10 reps, 2–3 sets", "safety" to "Do not lean torso", "steps" to "Lie on side → Lift top leg → Lower slowly"),
                            mapOf("title" to "Bridging", "muscles" to "Glutes, hamstrings", "benefits" to "Activates posterior chain", "duration" to "10 reps, 3 sets", "safety" to "Avoid lower back strain", "steps" to "Lie on back → Lift hips → Hold → Lower slowly")
                        ),
                        "4–6 Weeks" to listOf(
                            mapOf("title" to "Partial Squats", "muscles" to "Quads, glutes", "benefits" to "Improves knee stability", "duration" to "10 reps, 2–3 sets", "safety" to "Keep knees behind toes", "steps" to "Stand with support → Slightly bend knees → Hold briefly → Return"),
                            mapOf("title" to "Step-Throughs", "muscles" to "Quads, glutes", "benefits" to "Improves functional movement", "duration" to "10 reps, 2–3 sets", "safety" to "Use support", "steps" to "Step forward → Back → Repeat"),
                            mapOf("title" to "Side-Lying Leg Lifts", "muscles" to "Hip abductors", "benefits" to "Strengthens hip stabilizers", "duration" to "10 reps, 3 sets", "safety" to "Keep torso straight", "steps" to "Lie on side → Lift top leg → Lower slowly"),
                            mapOf("title" to "Terminal Knee Extensions", "muscles" to "Quadriceps", "benefits" to "Improves knee extension", "duration" to "10 reps, 3 sets", "safety" to "Avoid pain", "steps" to "Knee slightly bent → Extend fully → Hold → Relax"),
                            mapOf("title" to "Mini Lunges", "muscles" to "Quads, glutes", "benefits" to "Improves knee control", "duration" to "8–10 reps, 2–3 sets", "safety" to "Do not overbend", "steps" to "Step forward → Slight bend → Return")
                        ),
                        "6–8 Weeks" to listOf(
                            mapOf("title" to "Step-Up Strength", "muscles" to "Quads, glutes, calves", "benefits" to "Builds strength and balance", "duration" to "10 reps each leg, 2–3 sets", "safety" to "Use support if needed", "steps" to "Step onto low platform → Step down slowly → Repeat"),
                            mapOf("title" to "Walking Lunges", "muscles" to "Quads, glutes", "benefits" to "Strengthens legs and improves balance", "duration" to "10 reps each leg, 2 sets", "safety" to "Maintain knee alignment", "steps" to "Step forward → Bend knees → Return → Switch"),
                            mapOf("title" to "Single-Leg Balance", "muscles" to "Quads, glutes", "benefits" to "Improves stability", "duration" to "30 sec each leg, 2 sets", "safety" to "Hold support if needed", "steps" to "Stand on one leg → Maintain balance → Switch"),
                            mapOf("title" to "Calf Raises on Step", "muscles" to "Calves", "benefits" to "Strengthens lower leg", "duration" to "12 reps, 2 sets", "safety" to "Slow controlled motion", "steps" to "Stand on step → Raise heels → Lower"),
                            mapOf("title" to "Glute Bridges with Hold", "muscles" to "Glutes, hamstrings", "benefits" to "Improves posterior strength", "duration" to "10 reps, 3 sets", "safety" to "Avoid overextension", "steps" to "Lift hips → Hold 3 sec → Lower")
                        ),
                        "8+ Weeks" to listOf(
                            mapOf("title" to "Lunge Stability", "muscles" to "Quads, hamstrings, glutes", "benefits" to "Improves strength and flexibility", "duration" to "8–10 reps each leg, 2–3 sets", "safety" to "Keep front knee over ankle", "steps" to "Step forward → Bend knees to 90° → Return → Switch legs"),
                            mapOf("title" to "Bulgarian Split Squats", "muscles" to "Quads, glutes", "benefits" to "Improves leg strength", "duration" to "8 reps each leg, 2–3 sets", "safety" to "Use support if needed", "steps" to "Back foot on bench → Lower front knee → Return"),
                            mapOf("title" to "Single-Leg Deadlift", "muscles" to "Hamstrings, glutes", "benefits" to "Strengthens posterior chain", "duration" to "8–10 reps each leg, 2 sets", "safety" to "Maintain balance", "steps" to "Hinge at hips → Lower → Return"),
                            mapOf("title" to "Side Lunges", "muscles" to "Quads, adductors, glutes", "benefits" to "Improves lateral stability", "duration" to "8–10 reps each leg, 2 sets", "safety" to "Do not twist knee", "steps" to "Step sideways → Bend knee → Return"),
                            mapOf("title" to "Step-Downs", "muscles" to "Quads, glutes", "benefits" to "Improves eccentric control", "duration" to "10 reps each leg, 2 sets", "safety" to "Go slow, controlled", "steps" to "Step off platform → Return → Switch leg")
                        )
                    )

                    recoveryPeriods.forEach { (period, exercises) ->
                        Text(
                            text = period,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Grin,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )

                        exercises.forEach { ex ->
                            StretchCard(
                                title = ex["title"]!!,
                                muscles = ex["muscles"]!!,
                                benefits = ex["benefits"]!!,
                                steps = ex["steps"]!!.split("→").map { it.trim() },
                                duration = ex["duration"]!!,
                                safetyTips = ex["safety"]!!,
                                mainCategory = "Knee Rehab",
                                subCategory = period,
                                onTrack = { name, dur, main, sub -> vm.trackExercise(name, dur, main, sub) },
                                onUndo = { name -> vm.removeExerciseFromHistory(name) },
                                vm = vm
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
fun KneeRehabScreenPreview() {
    KneeRehabScreen(rememberNavController())
}