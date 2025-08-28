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
import com.tromeel.ponafit.navigation.ROUT_REHAB
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LowerBackRehabScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    val recoveryPeriods = mapOf(
        "0–2 Weeks" to listOf(
            mapOf("title" to "Pelvic Tilts", "muscles" to "Lower back, core", "benefits" to "Reduces stiffness and strengthens core", "duration" to "10 reps, 3 sets", "safety" to "Move gently, avoid pain", "steps" to "Lie on back → Flatten lower back → Hold → Relax"),
            mapOf("title" to "Knee-to-Chest Stretch", "muscles" to "Lower back, glutes", "benefits" to "Relieves tension", "duration" to "10 reps each leg, 2 sets", "safety" to "Do not pull too hard", "steps" to "Lie on back → Pull knee to chest → Hold → Switch"),
            mapOf("title" to "Cat-Cow Stretch", "muscles" to "Spine, core", "benefits" to "Improves spinal mobility", "duration" to "10 reps, 2 sets", "safety" to "Move slowly", "steps" to "On hands/knees → Arch back → Round back → Repeat"),
            mapOf("title" to "Bridging", "muscles" to "Glutes, lower back", "benefits" to "Strengthens posterior chain", "duration" to "10 reps, 3 sets", "safety" to "Do not overextend", "steps" to "Lie on back → Lift hips → Hold → Lower"),
            mapOf("title" to "Abdominal Draw-In", "muscles" to "Transverse abdominis", "benefits" to "Engages deep core muscles", "duration" to "10 reps, 3 sets", "safety" to "Breathe normally", "steps" to "Lie on back → Pull belly button in → Hold → Relax")
        ),
        "2–4 Weeks" to listOf(
            mapOf("title" to "Partial Crunches", "muscles" to "Abdominals", "benefits" to "Strengthens core safely", "duration" to "10 reps, 2–3 sets", "safety" to "Avoid neck strain", "steps" to "Lie on back → Lift shoulders slightly → Lower"),
            mapOf("title" to "Hip Flexor Stretch", "muscles" to "Hip flexors, lower back", "benefits" to "Reduces tightness", "duration" to "20 sec hold, 2 sets each side", "safety" to "Do not arch back", "steps" to "Lunge position → Tilt pelvis forward → Hold → Switch"),
            mapOf("title" to "Seated Lower Back Stretch", "muscles" to "Lower back", "benefits" to "Increases mobility", "duration" to "20 sec hold, 2 sets", "safety" to "Move gently", "steps" to "Sit → Bend forward → Reach toes → Hold"),
            mapOf("title" to "Bird-Dog", "muscles" to "Core, lower back", "benefits" to "Improves stability and posture", "duration" to "10 reps each side, 2 sets", "safety" to "Keep back neutral", "steps" to "On hands/knees → Extend opposite arm/leg → Hold → Switch"),
            mapOf("title" to "Pelvic Bridge March", "muscles" to "Glutes, lower back", "benefits" to "Adds dynamic stability", "duration" to "10 reps each leg, 2 sets", "safety" to "Avoid arching", "steps" to "Lift hips → Alternate legs → Lower")
        ),
        "4–6 Weeks" to listOf(
            mapOf("title" to "Lumbar Extension", "muscles" to "Lower back", "benefits" to "Strengthens back extensors", "duration" to "10 reps, 2–3 sets", "safety" to "Move slowly", "steps" to "Lie on stomach → Lift chest slightly → Lower"),
            mapOf("title" to "Side-Lying Leg Lifts", "muscles" to "Obliques, glutes", "benefits" to "Strengthens lateral stabilizers", "duration" to "10 reps each side, 2 sets", "safety" to "Keep torso stable", "steps" to "Lie on side → Lift top leg → Lower"),
            mapOf("title" to "Modified Plank", "muscles" to "Core, lower back", "benefits" to "Improves core stability", "duration" to "20–30 sec, 2 sets", "safety" to "Avoid sagging", "steps" to "On elbows/knees → Hold neutral spine"),
            mapOf("title" to "Cat-Cow Flow", "muscles" to "Spine, core", "benefits" to "Maintains spinal mobility", "duration" to "10 reps, 2 sets", "safety" to "Move smoothly", "steps" to "Arch back → Round back → Repeat"),
            mapOf("title" to "Hip Bridge with March", "muscles" to "Glutes, lower back", "benefits" to "Dynamic posterior chain strengthening", "duration" to "10 reps each leg, 2 sets", "safety" to "Keep hips stable", "steps" to "Lift hips → Alternate legs → Lower")
        ),
        "6–8 Weeks" to listOf(
            mapOf("title" to "Full Plank", "muscles" to "Core, lower back", "benefits" to "Builds core endurance", "duration" to "30–45 sec, 2 sets", "safety" to "Maintain neutral spine", "steps" to "On elbows/toes → Hold → Breathe"),
            mapOf("title" to "Bird-Dog with Hold", "muscles" to "Core, lower back", "benefits" to "Enhances stability and coordination", "duration" to "10 reps each side, 2 sets", "safety" to "Keep back flat", "steps" to "Extend opposite arm/leg → Hold → Switch"),
            mapOf("title" to "Side Plank", "muscles" to "Obliques, core", "benefits" to "Strengthens lateral core", "duration" to "20–30 sec each side, 2 sets", "safety" to "Avoid sagging", "steps" to "Lie on side → Lift hips → Hold → Switch"),
            mapOf("title" to "Superman", "muscles" to "Lower back, glutes", "benefits" to "Strengthens posterior chain", "duration" to "10 reps, 2 sets", "safety" to "Lift smoothly", "steps" to "Lie on stomach → Lift arms/legs → Hold → Lower"),
            mapOf("title" to "Hip Hinge with Band", "muscles" to "Glutes, hamstrings, lower back", "benefits" to "Improves functional strength", "duration" to "10 reps, 2 sets", "safety" to "Keep back straight", "steps" to "Stand → Hinge at hips → Return")
        ),
        "8+ Weeks" to listOf(
            mapOf("title" to "Deadlift with Light Weights", "muscles" to "Lower back, glutes, hamstrings", "benefits" to "Builds posterior chain strength", "duration" to "8–10 reps, 2–3 sets", "safety" to "Use light weights only", "steps" to "Hinge at hips → Lift weights → Lower slowly"),
            mapOf("title" to "Bird-Dog with Resistance Band", "muscles" to "Core, lower back", "benefits" to "Adds resistance for core strength", "duration" to "10 reps each side, 2 sets", "safety" to "Maintain neutral spine", "steps" to "Attach band → Extend opposite arm/leg → Return"),
            mapOf("title" to "Side Plank with Hip Drop", "muscles" to "Obliques, core", "benefits" to "Dynamic lateral core strength", "duration" to "10 reps each side, 2 sets", "safety" to "Move slowly", "steps" to "Lift hips → Lower slightly → Repeat"),
            mapOf("title" to "Bridge March with Band", "muscles" to "Glutes, hamstrings, lower back", "benefits" to "Dynamic posterior chain strengthening", "duration" to "10 reps each leg, 2 sets", "safety" to "Maintain stable hips", "steps" to "Lift hips → Alternate legs → Lower"),
            mapOf("title" to "Good Mornings with Band", "muscles" to "Lower back, hamstrings", "benefits" to "Strengthens posterior chain", "duration" to "10 reps, 2–3 sets", "safety" to "Keep back straight", "steps" to "Stand → Hinge at hips → Return")
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lower Back Rehab Exercises", color = Grin, fontWeight = FontWeight.Bold) },
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
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Profile", tint = Color.Black) },
                    label = { Text("Actions", color = Color.Black) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_ACCOUNT)}
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
                    text = "These exercises are designed to strengthen your lower back and surrounding muscles during different recovery phases. Always follow your physiotherapist's guidance.",
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
                                subCategory = "LowerBackRehab",
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
fun LowerBackRehabScreenPreview() {
    LowerBackRehabScreen(rememberNavController())
}
