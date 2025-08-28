package com.tromeel.ponafit.ui.screens.rehab



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun NeckRehabScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    // ✅ Updated recovery phases for Neck rehab
    val recoveryPeriods = mapOf(
        "0–2 Weeks" to listOf(
            mapOf("title" to "Neck Rotation (Gentle)", "muscles" to "Cervical rotators", "benefits" to "Restores mobility", "duration" to "5 reps each side", "safety" to "Move slowly, stop if pain", "steps" to "Look right → Center → Look left → Center"),
            mapOf("title" to "Neck Side Bends", "muscles" to "Lateral neck muscles", "benefits" to "Improves side flexibility", "duration" to "5 reps each side", "safety" to "Do not overstretch", "steps" to "Tilt ear to shoulder → Hold → Switch"),
            mapOf("title" to "Neck Flexion", "muscles" to "Deep neck flexors", "benefits" to "Prevents stiffness", "duration" to "5 reps", "safety" to "Avoid chin-to-chest force", "steps" to "Lower chin gently → Return"),
            mapOf("title" to "Neck Extension (Gentle)", "muscles" to "Cervical extensors", "benefits" to "Restores extension mobility", "duration" to "5 reps", "safety" to "Move slightly, not far back", "steps" to "Look up slightly → Return"),
            mapOf("title" to "Shoulder Rolls", "muscles" to "Trapezius, scapular stabilizers", "benefits" to "Relieves neck tension", "duration" to "10 reps forward/back", "safety" to "Gentle movement", "steps" to "Roll shoulders forward → Roll back")
        ),
        "2–4 Weeks" to listOf(
            mapOf("title" to "Chin Tucks", "muscles" to "Deep neck flexors", "benefits" to "Improves posture", "duration" to "10 reps", "safety" to "Small movement", "steps" to "Pull chin straight back → Hold → Release"),
            mapOf("title" to "Neck Isometrics (Flexion)", "muscles" to "Neck flexors", "benefits" to "Builds gentle strength", "duration" to "5 sec hold × 5", "safety" to "Apply gentle pressure", "steps" to "Hand on forehead → Push head into hand"),
            mapOf("title" to "Neck Isometrics (Extension)", "muscles" to "Neck extensors", "benefits" to "Strengthens extensors", "duration" to "5 sec hold × 5", "safety" to "Gentle pressure", "steps" to "Hand behind head → Push back"),
            mapOf("title" to "Neck Isometrics (Side)", "muscles" to "Lateral flexors", "benefits" to "Improves stability", "duration" to "5 sec hold each side", "safety" to "Do not strain", "steps" to "Hand at side of head → Push into hand"),
            mapOf("title" to "Scapular Squeezes", "muscles" to "Rhomboids, mid-traps", "benefits" to "Improves posture", "duration" to "10 reps", "safety" to "Gentle squeeze", "steps" to "Squeeze shoulder blades → Release")
        ),
        "4–6 Weeks" to listOf(
            mapOf("title" to "Resisted Chin Tucks (Band)", "muscles" to "Deep neck flexors", "benefits" to "Strengthens posture control", "duration" to "10 reps", "safety" to "Use light resistance", "steps" to "Band at back of head → Pull chin in"),
            mapOf("title" to "Resisted Neck Extension (Band)", "muscles" to "Cervical extensors", "benefits" to "Builds neck strength", "duration" to "10 reps", "safety" to "Gentle pull", "steps" to "Band in front → Look up slowly"),
            mapOf("title" to "Resisted Side Bending", "muscles" to "Lateral neck muscles", "benefits" to "Improves side strength", "duration" to "10 reps each side", "safety" to "Use light band", "steps" to "Band at side of head → Tilt head"),
            mapOf("title" to "Shoulder Shrugs with Weights", "muscles" to "Upper traps", "benefits" to "Strengthens support muscles", "duration" to "10 reps", "safety" to "Light weights only", "steps" to "Lift shoulders → Lower"),
            mapOf("title" to "Prone Neck Extension", "muscles" to "Neck extensors", "benefits" to "Improves endurance", "duration" to "8 reps", "safety" to "Keep controlled", "steps" to "Lie face down → Lift head → Lower slowly")
        ),
        "6–8 Weeks" to listOf(
            mapOf("title" to "Dynamic Chin Tucks", "muscles" to "Deep neck flexors", "benefits" to "Improves dynamic control", "duration" to "10 reps", "safety" to "Avoid quick jerks", "steps" to "Tuck chin → Rotate head → Return"),
            mapOf("title" to "Neck Flexion with Band", "muscles" to "Neck flexors", "benefits" to "Strengthens flexors", "duration" to "10 reps", "safety" to "Use light band", "steps" to "Band on forehead → Flex neck"),
            mapOf("title" to "Neck Extension with Band", "muscles" to "Neck extensors", "benefits" to "Strengthens extensors", "duration" to "10 reps", "safety" to "Controlled motion", "steps" to "Band behind head → Extend back"),
            mapOf("title" to "Neck Side Flexion with Band", "muscles" to "Lateral neck", "benefits" to "Improves lateral stability", "duration" to "10 reps", "safety" to "Gentle resistance", "steps" to "Band at side → Tilt ear to shoulder"),
            mapOf("title" to "Wall Angels", "muscles" to "Postural stabilizers", "benefits" to "Improves posture", "duration" to "10 reps", "safety" to "Keep spine neutral", "steps" to "Stand at wall → Raise arms → Lower")
        ),
        "8+ Weeks" to listOf(
            mapOf("title" to "Weighted Shoulder Shrugs", "muscles" to "Trapezius", "benefits" to "Builds neck support", "duration" to "10 reps", "safety" to "Avoid heavy weights", "steps" to "Hold dumbbells → Shrug shoulders"),
            mapOf("title" to "Neck Rotation with Band", "muscles" to "Cervical rotators", "benefits" to "Enhances rotation strength", "duration" to "10 reps each side", "safety" to "Controlled movement", "steps" to "Band to side → Rotate head"),
            mapOf("title" to "Neck Extension with Weight", "muscles" to "Cervical extensors", "benefits" to "Strengthens extensors", "duration" to "8 reps", "safety" to "Use light plate", "steps" to "Plate on back of head → Extend neck"),
            mapOf("title" to "Plank with Chin Tuck", "muscles" to "Core, neck stabilizers", "benefits" to "Functional stability", "duration" to "15–20 sec hold", "safety" to "Keep neutral spine", "steps" to "Plank → Chin tuck → Hold"),
            mapOf("title" to "Resisted Diagonal Movements", "muscles" to "Neck & scapular stabilizers", "benefits" to "Functional movement control", "duration" to "10 reps each diagonal", "safety" to "Use light resistance", "steps" to "Band at angle → Move head diagonally")
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Neck Rehab Exercises", color = Grin, fontWeight = FontWeight.Bold) },
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
                    text = "These exercises are designed to restore neck strength, flexibility, and posture across recovery phases. Always follow your physiotherapist’s guidance.",
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
                                subCategory = "NeckRehab",
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
fun NeckRehabScreenPreview() {
    NeckRehabScreen(rememberNavController())
}
