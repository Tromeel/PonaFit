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

                    // =================== Cool Down Exercises ===================
                    val exercises = listOf(
                        Triple("Standing Forward Fold", "20–30 seconds", listOf(
                            "Stand with feet hip-width apart.",
                            "Bend forward at the hips.",
                            "Let arms hang or hold opposite elbows."
                        )),
                        Triple("Seated Hamstring Stretch", "20–30 seconds per side", listOf(
                            "Sit with one leg extended forward.",
                            "Reach toward your toes.",
                            "Keep back straight."
                        )),
                        Triple("Child’s Pose", "30–60 seconds", listOf(
                            "Kneel on the floor.",
                            "Sit back on heels and extend arms forward.",
                            "Relax forehead on mat."
                        )),
                        Triple("Cat-Cow Stretch", "6–8 slow cycles", listOf(
                            "Start on hands and knees.",
                            "Arch back upward (cat).",
                            "Drop belly down and lift chest (cow)."
                        )),
                        Triple("Quadriceps Stretch", "20–30 seconds per side", listOf(
                            "Stand on one leg.",
                            "Pull other foot toward glutes.",
                            "Hold ankle gently."
                        )),
                        Triple("Shoulder Stretch", "20–30 seconds per side", listOf(
                            "Bring one arm across chest.",
                            "Hold with opposite hand.",
                            "Keep shoulders relaxed."
                        )),
                        Triple("Triceps Stretch", "20–30 seconds per side", listOf(
                            "Raise one arm overhead.",
                            "Bend elbow and touch upper back.",
                            "Use other hand to press gently."
                        )),
                        Triple("Calf Stretch", "20–30 seconds per side", listOf(
                            "Stand facing a wall.",
                            "Step one leg back.",
                            "Press heel into the ground."
                        )),
                        Triple("Seated Spinal Twist", "20–30 seconds per side", listOf(
                            "Sit with legs extended.",
                            "Cross one leg over the other.",
                            "Twist torso toward bent knee."
                        )),
                        Triple("Butterfly Stretch", "30–45 seconds", listOf(
                            "Sit with soles of feet together.",
                            "Hold feet with hands.",
                            "Gently press knees toward floor."
                        ))
                    )

                    exercises.forEach { (title, duration, steps) ->
                        StretchCard4(
                            title = title,
                            muscles = "",
                            benefits = "",
                            steps = steps,
                            duration = duration,
                            safetyTips = "",
                            onTrack = { name, dur -> vm.trackExercise(name, dur) }
                        )
                    }
                }
            }
        }
    )
}

// =================== StretchCard4 with Done Toggle ===================
@Composable
fun StretchCard4(
    title: String,
    muscles: String,
    benefits: String,
    steps: List<String>,
    duration: String,
    safetyTips: String,
    onTrack: (String, String) -> Unit
) {
    var isDone by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 240.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

                Spacer(modifier = Modifier.height(4.dp))
                Text("Muscles: $muscles", fontSize = 13.sp, color = Color.LightGray)
                Text("Benefits: $benefits", fontSize = 13.sp, color = Color.LightGray)

                Spacer(modifier = Modifier.height(6.dp))
                steps.forEachIndexed { index, step ->
                    Text("${index + 1}. $step", fontSize = 13.sp, color = Color.White, modifier = Modifier.padding(bottom = 2.dp))
                }

                Spacer(modifier = Modifier.height(6.dp))
                Text("Duration/Reps: $duration", fontSize = 13.sp, color = Color.LightGray)
                Text("Safety Tips: $safetyTips", fontSize = 13.sp, color = Color.LightGray)

                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        isDone = true
                        onTrack(title, duration)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Grin)
                ) {
                    if (isDone) {
                        Icon(Icons.Default.Check, contentDescription = "Done", tint = Color.Black, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Done", color = Color.Black, fontWeight = FontWeight.Bold)
                    } else {
                        Text("Mark as Done", color = Color.Black, fontWeight = FontWeight.Bold)
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
