package com.tromeel.ponafit.ui.screens.stretchingexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_STRETCHINGEXERCISES
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun CoolDownScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

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

                    // ✅ 10 Cool Down Exercises
                    StretchCard4(
                        title = "Standing Forward Fold",
                        muscles = "Hamstrings, lower back",
                        benefits = "Relieves tension in the back and legs",
                        steps = listOf(
                            "Stand with feet hip-width apart.",
                            "Bend forward at the hips.",
                            "Let arms hang or hold opposite elbows."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Bend knees slightly if needed."
                    )

                    StretchCard4(
                        title = "Seated Hamstring Stretch",
                        muscles = "Hamstrings, calves",
                        benefits = "Improves flexibility in the back of legs",
                        steps = listOf(
                            "Sit with one leg extended forward.",
                            "Reach toward your toes.",
                            "Keep back straight."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Avoid bouncing."
                    )

                    StretchCard4(
                        title = "Child’s Pose",
                        muscles = "Back, hips, shoulders",
                        benefits = "Promotes relaxation and stretches spine",
                        steps = listOf(
                            "Kneel on the floor.",
                            "Sit back on heels and extend arms forward.",
                            "Relax forehead on mat."
                        ),
                        duration = "30–60 seconds",
                        safetyTips = "Keep breathing deeply."
                    )

                    StretchCard4(
                        title = "Cat-Cow Stretch",
                        muscles = "Spine, back, core",
                        benefits = "Improves spinal flexibility",
                        steps = listOf(
                            "Start on hands and knees.",
                            "Arch back upward (cat).",
                            "Drop belly down and lift chest (cow)."
                        ),
                        duration = "6–8 slow cycles",
                        safetyTips = "Move smoothly with breath."
                    )

                    StretchCard4(
                        title = "Quadriceps Stretch",
                        muscles = "Quads, hip flexors",
                        benefits = "Relieves tightness in front thighs",
                        steps = listOf(
                            "Stand on one leg.",
                            "Pull other foot toward glutes.",
                            "Hold ankle gently."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Hold onto support if needed."
                    )

                    StretchCard4(
                        title = "Shoulder Stretch",
                        muscles = "Shoulders, upper back",
                        benefits = "Releases shoulder tension",
                        steps = listOf(
                            "Bring one arm across chest.",
                            "Hold with opposite hand.",
                            "Keep shoulders relaxed."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Do not force the stretch."
                    )

                    StretchCard4(
                        title = "Triceps Stretch",
                        muscles = "Triceps, shoulders",
                        benefits = "Improves arm flexibility",
                        steps = listOf(
                            "Raise one arm overhead.",
                            "Bend elbow and touch upper back.",
                            "Use other hand to press gently."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep neck neutral."
                    )

                    StretchCard4(
                        title = "Calf Stretch",
                        muscles = "Calves, ankles",
                        benefits = "Relieves tight calves",
                        steps = listOf(
                            "Stand facing a wall.",
                            "Step one leg back.",
                            "Press heel into the ground."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep back leg straight."
                    )

                    StretchCard4(
                        title = "Seated Spinal Twist",
                        muscles = "Spine, obliques",
                        benefits = "Improves spinal mobility",
                        steps = listOf(
                            "Sit with legs extended.",
                            "Cross one leg over the other.",
                            "Twist torso toward bent knee."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep back straight during twist."
                    )

                    StretchCard4(
                        title = "Butterfly Stretch",
                        muscles = "Inner thighs, hips",
                        benefits = "Opens hips and improves flexibility",
                        steps = listOf(
                            "Sit with soles of feet together.",
                            "Hold feet with hands.",
                            "Gently press knees toward floor."
                        ),
                        duration = "30–45 seconds",
                        safetyTips = "Avoid forcing knees down."
                    )
                }
            }
        }
    )
}

// ✅ Reusable Stretch Card
@Composable
fun StretchCard4(
    title: String,
    muscles: String,
    benefits: String,
    steps: List<String>,
    duration: String,
    safetyTips: String
) {
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
                .heightIn(min = 220.dp)
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
                Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Muscles: $muscles", fontSize = 13.sp, color = Color.LightGray)

                Text(text = "Benefits: $benefits", fontSize = 13.sp, color = Color.LightGray)

                Spacer(modifier = Modifier.height(6.dp))
                steps.forEachIndexed { index, step ->
                    Text(
                        text = "${index + 1}. $step",
                        fontSize = 13.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Duration/Reps: $duration", fontSize = 13.sp, color = Color.LightGray)
                Text(text = "Safety Tips: $safetyTips", fontSize = 13.sp, color = Color.LightGray)
            }
        }
    }
}

@Preview
@Composable
fun CoolDownScreenPreview() {
    CoolDownScreen(rememberNavController())
}
