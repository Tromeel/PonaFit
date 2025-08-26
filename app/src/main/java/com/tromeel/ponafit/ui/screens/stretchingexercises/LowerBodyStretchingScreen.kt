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
fun LowerBodyStretchingScreen(navController: NavController) {
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
                        text = "Lower Body Stretching",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Text(
                        text = "These stretches target hips, hamstrings, quads, glutes, calves, and ankles—helping with flexibility, mobility, and recovery.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // =================== Lower Body Exercises ===================
                    val exercises = listOf(
                        mapOf(
                            "title" to "Standing Quad Stretch",
                            "muscles" to "Quadriceps",
                            "benefits" to "Relieves tight thighs, improves flexibility",
                            "steps" to "Stand on one leg → Pull the other foot toward your glutes → Hold for balance and switch sides",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Keep knees close together"
                        ),
                        mapOf(
                            "title" to "Seated Hamstring Stretch",
                            "muscles" to "Hamstrings",
                            "benefits" to "Lengthens hamstrings, reduces stiffness",
                            "steps" to "Sit with one leg extended forward → Reach toward your toes → Hold gently and switch legs",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Avoid rounding lower back too much"
                        ),
                        mapOf(
                            "title" to "Hip Flexor Stretch",
                            "muscles" to "Hip flexors, quads",
                            "benefits" to "Opens hips and reduces tightness from sitting",
                            "steps" to "Kneel on one knee → Shift hips forward gently → Hold and switch legs",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Keep torso upright"
                        ),
                        mapOf(
                            "title" to "Glute Stretch (Figure 4)",
                            "muscles" to "Glutes, hips",
                            "benefits" to "Relieves hip and glute tension",
                            "steps" to "Lie on your back → Cross one ankle over opposite knee → Pull legs gently toward chest",
                            "duration" to "20–30 seconds per side",
                            "safety" to "Avoid straining neck or back"
                        )
                        // Add remaining exercises similarly...
                    )

                    exercises.forEach { ex ->
                        StretchCardTracked(
                            title = ex["title"]!!,
                            muscles = ex["muscles"]!!,
                            benefits = ex["benefits"]!!,
                            steps = ex["steps"]!!.split("→").map { it.trim() },
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

@Composable
fun StretchCardTracked1(
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
            .heightIn(min = 280.dp),
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
fun LowerBodyStretchingScreenPreview() {
    LowerBodyStretchingScreen(rememberNavController())
}
