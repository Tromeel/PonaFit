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
fun WristElbowRehabScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    // Updated recovery phases for Wrist & Elbow rehab
    val recoveryPeriods = mapOf(
        "0–2 Weeks" to listOf(
            mapOf("title" to "Wrist Flexion Stretch", "muscles" to "Forearm flexors", "benefits" to "Improves flexibility and reduces stiffness", "duration" to "15 sec hold, 3 sets", "safety" to "Do not overstretch", "steps" to "Extend arm → Palm up → Gently pull fingers back → Hold"),
            mapOf("title" to "Wrist Extension Stretch", "muscles" to "Forearm extensors", "benefits" to "Restores wrist mobility", "duration" to "15 sec hold, 3 sets", "safety" to "Stop if painful", "steps" to "Extend arm → Palm down → Gently pull hand down → Hold"),
            mapOf("title" to "Finger Flexion & Extension", "muscles" to "Hand flexors & extensors", "benefits" to "Prevents stiffness in fingers", "duration" to "10 reps, 2 sets", "safety" to "Move gently", "steps" to "Make a fist → Open fingers wide → Repeat"),
            mapOf("title" to "Elbow Flexion & Extension", "muscles" to "Biceps, triceps", "benefits" to "Maintains elbow mobility", "duration" to "10 reps, 2 sets", "safety" to "Do not force movement", "steps" to "Bend elbow → Straighten arm → Repeat"),
            mapOf("title" to "Forearm Rotations", "muscles" to "Supinators, pronators", "benefits" to "Restores forearm rotation", "duration" to "10 reps each way, 2 sets", "safety" to "Keep elbow at side", "steps" to "Palm up → Rotate palm down → Repeat")
        ),
        "2–4 Weeks" to listOf(
            mapOf("title" to "Wrist Circles", "muscles" to "Forearm", "benefits" to "Improves overall wrist mobility", "duration" to "10 reps each direction", "safety" to "Small controlled circles", "steps" to "Rotate wrist clockwise → Rotate counterclockwise"),
            mapOf("title" to "Grip Strength with Ball", "muscles" to "Hand, forearm", "benefits" to "Improves grip strength", "duration" to "10 squeezes, 2 sets", "safety" to "Do not over-squeeze", "steps" to "Hold soft ball → Squeeze → Release"),
            mapOf("title" to "Pronation/Supination with Support", "muscles" to "Forearm", "benefits" to "Improves rotation control", "duration" to "10 reps, 2 sets", "safety" to "Support elbow on table", "steps" to "Palm up → Rotate to palm down → Repeat"),
            mapOf("title" to "Wrist Flexion with Light Resistance", "muscles" to "Forearm flexors", "benefits" to "Strengthens wrist", "duration" to "10 reps, 2 sets", "safety" to "Use light object", "steps" to "Hold light weight → Flex wrist up → Lower"),
            mapOf("title" to "Wrist Extension with Light Resistance", "muscles" to "Forearm extensors", "benefits" to "Strengthens extensors", "duration" to "10 reps, 2 sets", "safety" to "Control motion", "steps" to "Hold light weight → Extend wrist → Lower")
        ),
        "4–6 Weeks" to listOf(
            mapOf("title" to "Elbow Flexion with Band", "muscles" to "Biceps", "benefits" to "Strengthens elbow flexion", "duration" to "10 reps, 2 sets", "safety" to "Use light band", "steps" to "Hold band → Curl elbow → Return"),
            mapOf("title" to "Triceps Extensions with Band", "muscles" to "Triceps", "benefits" to "Strengthens elbow extensors", "duration" to "10 reps, 2 sets", "safety" to "Keep elbow stable", "steps" to "Hold band overhead → Extend elbow → Return"),
            mapOf("title" to "Radial/Ulnar Deviation", "muscles" to "Forearm stabilizers", "benefits" to "Improves wrist stability", "duration" to "10 reps, 2 sets", "safety" to "Use light resistance", "steps" to "Hold object → Move wrist side to side"),
            mapOf("title" to "Grip with Putty", "muscles" to "Hand, forearm", "benefits" to "Enhances grip strength", "duration" to "10 reps, 2 sets", "safety" to "Do not overexert", "steps" to "Squeeze putty → Release → Repeat"),
            mapOf("title" to "Reverse Wrist Curls", "muscles" to "Forearm extensors", "benefits" to "Balances wrist strength", "duration" to "10 reps, 2 sets", "safety" to "Control motion", "steps" to "Hold light weight → Extend wrist up → Lower")
        ),
        "6–8 Weeks" to listOf(
            mapOf("title" to "Eccentric Wrist Flexion", "muscles" to "Forearm flexors", "benefits" to "Improves tendon strength", "duration" to "8 reps, 2 sets", "safety" to "Slow controlled motion", "steps" to "Lift with both hands → Lower with one"),
            mapOf("title" to "Eccentric Wrist Extension", "muscles" to "Forearm extensors", "benefits" to "Builds tendon endurance", "duration" to "8 reps, 2 sets", "safety" to "Lower slowly", "steps" to "Lift with both hands → Lower with one"),
            mapOf("title" to "Forearm Supination with Weight", "muscles" to "Supinators", "benefits" to "Improves rotation", "duration" to "10 reps, 2 sets", "safety" to "Hold near end of hammer", "steps" to "Rotate palm up → Return"),
            mapOf("title" to "Forearm Pronation with Weight", "muscles" to "Pronators", "benefits" to "Strengthens pronators", "duration" to "10 reps, 2 sets", "safety" to "Controlled motion", "steps" to "Rotate palm down → Return"),
            mapOf("title" to "Grip Endurance Hold", "muscles" to "Forearm, hand", "benefits" to "Improves grip endurance", "duration" to "15 sec hold, 2 sets", "safety" to "Avoid over-gripping", "steps" to "Squeeze ball → Hold → Release")
        ),
        "8+ Weeks" to listOf(
            mapOf("title" to "Push-Ups on Wall", "muscles" to "Wrist, elbow stabilizers", "benefits" to "Builds functional strength", "duration" to "10 reps, 2 sets", "safety" to "Keep wrists neutral", "steps" to "Stand at wall → Push → Return"),
            mapOf("title" to "Wrist Roller Exercise", "muscles" to "Forearm flexors & extensors", "benefits" to "Enhances wrist endurance", "duration" to "2–3 rolls up/down", "safety" to "Use light weight", "steps" to "Roll weight up → Roll down"),
            mapOf("title" to "Reverse Curls", "muscles" to "Forearm extensors", "benefits" to "Balances strength", "duration" to "10 reps, 2 sets", "safety" to "Use light dumbbell", "steps" to "Curl with palms down → Lower"),
            mapOf("title" to "Farmer’s Carry (Light)", "muscles" to "Grip, forearm", "benefits" to "Builds grip strength", "duration" to "20 sec walk, 2 sets", "safety" to "Keep wrists neutral", "steps" to "Hold weights → Walk → Rest"),
            mapOf("title" to "Resistance Band Wrist Twists", "muscles" to "Forearm pronators/supinators", "benefits" to "Functional forearm strength", "duration" to "10 reps each side, 2 sets", "safety" to "Controlled twists", "steps" to "Attach band → Twist wrist → Return")
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Wrist & Elbow Rehab Exercises", color = Grin, fontWeight = FontWeight.Bold) },
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
                    text = "These exercises are designed to restore wrist and elbow function across different recovery phases. Always follow your physiotherapist’s guidance.",
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
                                subCategory = "WristElbowRehab",
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
fun WristElbowRehabScreenPreview() {
    WristElbowRehabScreen(rememberNavController())
}
