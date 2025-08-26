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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
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

@Composable
fun FullBodyStretchingScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Grin) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black) },
                    label = { Text("Home", color = Color.Black) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.History, contentDescription = "History", tint = Color.Black) },
                    label = { Text("History", color = Color.Black) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_HISTORY)
                    }
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
                    IconButton(
                        onClick = { navController.navigate(ROUT_STRETCHINGEXERCISES) },
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Grin,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 10.dp, top = 10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Full Body Stretching",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

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
                        StretchCard4(
                            title = ex["title"]!!,
                            muscles = ex["muscles"]!!,
                            benefits = ex["benefits"]!!,
                            steps = ex["steps"]!!.split("→"),
                            duration = ex["duration"]!!,
                            safetyTips = ex["safety"]!!,
                            mainCategory = "Stretching Exercises",
                            subCategory = "Full Body",
                            onTrack = { name, dur, main, sub ->
                                vm.trackExercise(name, dur, main, sub)
                            },
                            onUndo = { name -> vm.removeExerciseFromHistory(name) }
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun FullBodyStretchingScreenPreview() {
    FullBodyStretchingScreen(rememberNavController())
}
