package com.tromeel.ponafit.ui.screens.stretchingexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_STRETCHINGEXERCISES
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@Composable
fun CoolDownScreen(navController: NavController) {
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
                        text = "Cool Down Stretches",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Text(
                        text = "Cool down exercises help your body relax, reduce stiffness, and promote recovery after a workout. Perform each stretch slowly and with controlled breathing.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // =================== Cool Down Exercises with Instructions ===================
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
                            "duration" to "6–8 slow cycles",
                            "muscles" to "Spine, core",
                            "benefits" to "Increases spinal flexibility, relieves tension in back and neck",
                            "safety" to "Move slowly and avoid jerky motions",
                            "steps" to "Start on hands and knees → Inhale arch back (Cow) → Exhale round spine (Cat) → Repeat slowly"
                        ),
                        mapOf(
                            "title" to "Quadriceps Stretch",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Quadriceps, hip flexors",
                            "benefits" to "Improves leg flexibility, reduces tightness in quads",
                            "safety" to "Keep knees together and avoid arching lower back",
                            "steps" to "Stand tall → Bend one knee, hold ankle → Pull heel toward glutes → Keep knees aligned → Switch sides"
                        ),
                        mapOf(
                            "title" to "Shoulder Stretch",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Deltoids, upper back",
                            "benefits" to "Relieves tension in shoulders, improves upper body mobility",
                            "safety" to "Do not overstretch; keep shoulders down",
                            "steps" to "Bring one arm across chest → Use other arm to pull it closer → Hold → Switch sides"
                        ),
                        mapOf(
                            "title" to "Triceps Stretch",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Triceps, shoulders",
                            "benefits" to "Improves arm flexibility, relieves tension in upper arms",
                            "safety" to "Keep neck relaxed and avoid twisting torso",
                            "steps" to "Raise one arm overhead → Bend elbow and reach hand down back → Use other hand to press elbow → Switch sides"
                        ),
                        mapOf(
                            "title" to "Calf Stretch",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Calves, Achilles tendon",
                            "benefits" to "Relieves calf tightness, improves ankle flexibility",
                            "safety" to "Do not lock back knee; keep heel on floor",
                            "steps" to "Stand facing wall → Step one foot back → Press heel down → Hold stretch → Switch sides"
                        ),
                        mapOf(
                            "title" to "Seated Spinal Twist",
                            "duration" to "20–30 seconds per side",
                            "muscles" to "Spine, obliques",
                            "benefits" to "Improves spinal mobility and digestion, stretches torso",
                            "safety" to "Move gently; avoid forcing twist",
                            "steps" to "Sit tall with legs extended → Cross one leg over other → Place hand behind back → Twist gently → Switch sides"
                        ),
                        mapOf(
                            "title" to "Butterfly Stretch",
                            "duration" to "30–45 seconds",
                            "muscles" to "Inner thighs, hips",
                            "benefits" to "Opens hips, stretches inner thighs, improves posture",
                            "safety" to "Keep spine straight and avoid bouncing knees",
                            "steps" to "Sit with feet together → Pull heels toward pelvis → Hold feet → Gently press knees toward floor"
                        )
                    )

                    exercises.forEach { ex ->
                        StretchCard4(
                            title = ex["title"]!!,
                            muscles = ex["muscles"]!!,
                            benefits = ex["benefits"]!!,
                            steps = ex["steps"]!!.split("→"), // split into list
                            duration = ex["duration"]!!,
                            safetyTips = ex["safety"]!!,
                            onTrack = { name, dur -> vm.trackExercise(name, dur) },
                            onUndo = { name -> vm.removeExerciseFromHistory(name) }
                        )
                    }
                }
            }
        }
    )
}

// =================== StretchCard4 with Instructions, Bigger Size ===================
@Composable
fun StretchCard4(
    title: String,
    muscles: String,
    benefits: String,
    steps: List<String>,
    duration: String,
    safetyTips: String,
    onTrack: (String, String) -> Unit,
    onUndo: (String) -> Unit
) {
    var isDone by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
            .heightIn(min = 280.dp), // increased min height for content
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(18.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(title, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text("Muscles: $muscles", fontSize = 14.sp, color = Color.LightGray)
                Text("Benefits: $benefits", fontSize = 14.sp, color = Color.LightGray)

                Text("Instructions:", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                steps.forEachIndexed { index, step ->
                    Text("${index + 1}. ${step.trim()}", fontSize = 14.sp, color = Color.White)
                }

                Text("Duration/Reps: $duration", fontSize = 14.sp, color = Color.LightGray)
                Text("Safety Tips: $safetyTips", fontSize = 14.sp, color = Color.LightGray)

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            isDone = true
                            onTrack(title, duration)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Grin)
                    ) {
                        if (isDone) {
                            Icon(Icons.Default.Check, contentDescription = "Done", tint = Color.White, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Done", color = Color.White, fontWeight = FontWeight.Bold)
                        } else {
                            Text("Mark as Done", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }

                    if (isDone) {
                        Button(
                            onClick = {
                                isDone = false
                                onUndo(title)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Grin)
                        ) {
                            Text("Undo", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CoolDownScreenPreview() {
    CoolDownScreen(rememberNavController())
}
