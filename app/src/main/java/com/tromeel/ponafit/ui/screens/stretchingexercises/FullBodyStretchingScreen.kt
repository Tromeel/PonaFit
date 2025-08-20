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
fun FullBodyStretchingScreen(navController: NavController) {
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

                    // ✅ 10 Stretching Exercises
                    StretchCard(
                        title = "Standing Full Body Stretch",
                        muscles = "Spine, shoulders, arms, calves",
                        benefits = "Improves posture, relieves stiffness, energizes the body",
                        steps = listOf(
                            "Stand tall with feet shoulder-width apart.",
                            "Inhale and raise both arms overhead.",
                            "Stretch upward as if reaching for the ceiling.",
                            "Hold briefly, then exhale and relax."
                        ),
                        duration = "20–30 seconds, 2–3 times",
                        safetyTips = "Keep core engaged, avoid over-arching the back."
                    )

                    StretchCard(
                        title = "Cat-Cow Stretch",
                        muscles = "Spine, lower back, neck",
                        benefits = "Increases spinal flexibility, relieves back tension",
                        steps = listOf(
                            "Begin on hands and knees in a tabletop position.",
                            "Inhale, arch your back, and lift your head (Cow).",
                            "Exhale, round your spine, and tuck your chin (Cat).",
                            "Flow smoothly between the two positions."
                        ),
                        duration = "8–10 cycles",
                        safetyTips = "Move slowly, avoid jerky motions."
                    )

                    StretchCard(
                        title = "Seated Forward Bend",
                        muscles = "Hamstrings, lower back, calves",
                        benefits = "Improves hamstring flexibility, calms the mind",
                        steps = listOf(
                            "Sit with legs extended straight forward.",
                            "Inhale, lengthen your spine.",
                            "Exhale, hinge forward reaching toward your toes.",
                            "Hold the stretch while breathing deeply."
                        ),
                        duration = "20–40 seconds",
                        safetyTips = "Avoid rounding the back too much; bend from hips."
                    )

                    StretchCard(
                        title = "Chest Opener Stretch",
                        muscles = "Chest, shoulders, arms",
                        benefits = "Relieves tight chest muscles, improves posture",
                        steps = listOf(
                            "Stand tall and clasp your hands behind your back.",
                            "Straighten arms and gently lift upward.",
                            "Open your chest and squeeze shoulder blades together."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Don’t force arms too high; move within comfort."
                    )

                    StretchCard(
                        title = "Downward Dog",
                        muscles = "Hamstrings, calves, shoulders, spine",
                        benefits = "Lengthens spine, improves flexibility in legs and shoulders",
                        steps = listOf(
                            "Start in plank position with hands shoulder-width apart.",
                            "Lift hips upward into an inverted V-shape.",
                            "Press heels gently toward the floor.",
                            "Relax head between arms."
                        ),
                        duration = "20–40 seconds",
                        safetyTips = "Keep knees slightly bent if hamstrings are tight."
                    )

                    StretchCard(
                        title = "Lunge Hip Flexor Stretch",
                        muscles = "Hip flexors, quads, glutes",
                        benefits = "Relieves tight hips, improves lower body mobility",
                        steps = listOf(
                            "Step one foot forward into a lunge position.",
                            "Lower back knee to the ground.",
                            "Push hips forward gently while keeping chest upright."
                        ),
                        duration = "20–30 seconds each side",
                        safetyTips = "Keep front knee aligned above ankle."
                    )

                    StretchCard(
                        title = "Child’s Pose",
                        muscles = "Back, hips, shoulders",
                        benefits = "Relieves stress, lengthens spine, calms the body",
                        steps = listOf(
                            "Kneel on the floor and sit back on your heels.",
                            "Extend arms forward and lower chest to the floor.",
                            "Relax forehead on the mat."
                        ),
                        duration = "30–60 seconds",
                        safetyTips = "Keep knees apart for comfort if needed."
                    )

                    StretchCard(
                        title = "Standing Side Stretch",
                        muscles = "Obliques, shoulders, spine",
                        benefits = "Improves side flexibility and core mobility",
                        steps = listOf(
                            "Stand tall with feet hip-width apart.",
                            "Raise both arms overhead and clasp hands.",
                            "Lean gently to one side while keeping core engaged."
                        ),
                        duration = "15–20 seconds each side",
                        safetyTips = "Avoid twisting; keep shoulders square."
                    )

                    StretchCard(
                        title = "Seated Spinal Twist",
                        muscles = "Spine, obliques, shoulders",
                        benefits = "Improves spinal mobility, relieves back tension",
                        steps = listOf(
                            "Sit on the floor with legs extended.",
                            "Cross right leg over left and place foot flat.",
                            "Place right hand behind and left elbow outside right knee.",
                            "Twist gently, lengthening spine."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Twist only as far as comfortable."
                    )

                    StretchCard(
                        title = "Neck Stretch",
                        muscles = "Neck, upper traps, shoulders",
                        benefits = "Relieves tension from sitting or stress",
                        steps = listOf(
                            "Sit or stand upright with relaxed shoulders.",
                            "Tilt head gently toward one shoulder.",
                            "Hold, then switch sides."
                        ),
                        duration = "15–20 seconds per side",
                        safetyTips = "Avoid pulling on the neck with your hand."
                    )
                }
            }
        }
    )
}

// ✅ Reusable Stretch Card
@Composable
fun StretchCard(
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
fun FullBodyStretchingScreenPreview() {
    FullBodyStretchingScreen(rememberNavController())
}
