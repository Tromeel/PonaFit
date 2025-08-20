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
fun LowerBodyStretchingScreen(navController: NavController) {
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

                    // ✅ 10 Lower Body Stretching Exercises
                    StretchCard2(
                        title = "Standing Quad Stretch",
                        muscles = "Quadriceps",
                        benefits = "Relieves tight thighs, improves flexibility",
                        steps = listOf(
                            "Stand on one leg.",
                            "Pull the other foot toward your glutes.",
                            "Hold for balance and switch sides."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep knees close together."
                    )

                    StretchCard2(
                        title = "Seated Hamstring Stretch",
                        muscles = "Hamstrings",
                        benefits = "Lengthens hamstrings, reduces stiffness",
                        steps = listOf(
                            "Sit with one leg extended forward.",
                            "Reach toward your toes.",
                            "Hold gently and switch legs."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Avoid rounding lower back too much."
                    )

                    StretchCard2(
                        title = "Hip Flexor Stretch",
                        muscles = "Hip flexors, quads",
                        benefits = "Opens hips and reduces tightness from sitting",
                        steps = listOf(
                            "Kneel on one knee.",
                            "Shift hips forward gently.",
                            "Hold and switch legs."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep torso upright."
                    )

                    StretchCard2(
                        title = "Glute Stretch (Figure 4)",
                        muscles = "Glutes, hips",
                        benefits = "Relieves hip and glute tension",
                        steps = listOf(
                            "Lie on your back.",
                            "Cross one ankle over opposite knee.",
                            "Pull legs gently toward chest."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Avoid straining neck or back."
                    )

                    StretchCard2(
                        title = "Butterfly Stretch",
                        muscles = "Inner thighs, hips",
                        benefits = "Opens hips, improves inner thigh flexibility",
                        steps = listOf(
                            "Sit with feet together, knees bent outward.",
                            "Hold feet with hands.",
                            "Press knees gently toward the floor."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Keep back straight."
                    )

                    StretchCard2(
                        title = "Calf Stretch",
                        muscles = "Calves",
                        benefits = "Relieves calf tightness, improves ankle mobility",
                        steps = listOf(
                            "Stand facing a wall.",
                            "Step one foot back and press heel down.",
                            "Hold, then switch sides."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep back leg straight."
                    )

                    StretchCard2(
                        title = "Seated Forward Fold",
                        muscles = "Hamstrings, spine",
                        benefits = "Stretches hamstrings and relaxes spine",
                        steps = listOf(
                            "Sit with both legs extended forward.",
                            "Reach toward your toes.",
                            "Hold position gently."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Avoid bouncing into the stretch."
                    )

                    StretchCard2(
                        title = "Lying Spinal Twist",
                        muscles = "Glutes, lower back, obliques",
                        benefits = "Releases tension in lower back and hips",
                        steps = listOf(
                            "Lie on your back.",
                            "Bend one knee and cross it over the body.",
                            "Extend opposite arm to the side."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep shoulders flat on the floor."
                    )

                    StretchCard2(
                        title = "Standing Calf Raise Stretch",
                        muscles = "Calves, ankles",
                        benefits = "Improves ankle mobility and stretches calves",
                        steps = listOf(
                            "Stand with balls of feet on an elevated surface.",
                            "Let heels drop down slowly.",
                            "Hold stretch."
                        ),
                        duration = "15–20 seconds",
                        safetyTips = "Hold onto support if needed."
                    )

                    StretchCard2(
                        title = "Pigeon Pose",
                        muscles = "Glutes, hips",
                        benefits = "Deep hip opener, relieves tight glutes",
                        steps = listOf(
                            "Start in plank position.",
                            "Bring one knee forward and place shin across body.",
                            "Extend other leg back and lean forward."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Avoid forcing knee into position."
                    )
                }
            }
        }
    )
}

// ✅ Reusable Stretch Card
@Composable
fun StretchCard2(
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
fun LowerBodyStretchingScreenPreview() {
    LowerBodyStretchingScreen(rememberNavController())
}
