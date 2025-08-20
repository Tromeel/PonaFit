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
fun UpperBodyStretchingScreen(navController: NavController) {
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
                        text = "Upper Body Stretching",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Text(
                        text = "These stretches loosen tight shoulders, chest, arms, and back muscles. Great for posture, mobility, and reducing stiffness.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ 10 Upper Body Stretching Exercises
                    StretchCard1(
                        title = "Neck Side Stretch",
                        muscles = "Neck, upper traps",
                        benefits = "Relieves tension and stiffness in the neck",
                        steps = listOf(
                            "Sit or stand tall.",
                            "Tilt head toward one shoulder.",
                            "Hold gently, then switch sides."
                        ),
                        duration = "15–20 seconds per side",
                        safetyTips = "Avoid pulling on the head with too much force."
                    )

                    StretchCard1(
                        title = "Shoulder Rolls",
                        muscles = "Shoulders, traps",
                        benefits = "Increases shoulder mobility and relieves tightness",
                        steps = listOf(
                            "Sit or stand tall.",
                            "Roll shoulders slowly forward in a circular motion.",
                            "Repeat backward."
                        ),
                        duration = "8–10 rolls in each direction",
                        safetyTips = "Keep movements slow and controlled."
                    )

                    StretchCard1(
                        title = "Triceps Stretch",
                        muscles = "Triceps, shoulders",
                        benefits = "Loosens tight triceps and improves arm mobility",
                        steps = listOf(
                            "Raise one arm overhead.",
                            "Bend elbow and reach hand down your back.",
                            "Use other hand to press elbow gently."
                        ),
                        duration = "20–30 seconds per arm",
                        safetyTips = "Avoid arching lower back."
                    )

                    StretchCard1(
                        title = "Cross-Body Shoulder Stretch",
                        muscles = "Shoulders, upper back",
                        benefits = "Relieves shoulder stiffness, improves flexibility",
                        steps = listOf(
                            "Bring one arm across your chest.",
                            "Use the other arm to hold it closer.",
                            "Hold, then switch sides."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Keep shoulders relaxed and down."
                    )

                    StretchCard1(
                        title = "Chest Opener",
                        muscles = "Chest, shoulders",
                        benefits = "Improves posture and relieves chest tightness",
                        steps = listOf(
                            "Clasp hands behind your back.",
                            "Straighten arms and lift slightly.",
                            "Open chest and squeeze shoulder blades."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Don’t overstretch arms behind."
                    )

                    StretchCard1(
                        title = "Seated Spinal Twist",
                        muscles = "Spine, obliques, shoulders",
                        benefits = "Increases spinal mobility, reduces back tension",
                        steps = listOf(
                            "Sit tall with legs extended.",
                            "Cross one leg over the other.",
                            "Place opposite elbow on knee and twist gently."
                        ),
                        duration = "20–30 seconds each side",
                        safetyTips = "Twist only to comfort level."
                    )

                    StretchCard1(
                        title = "Overhead Side Stretch",
                        muscles = "Lats, obliques, shoulders",
                        benefits = "Lengthens side body and improves flexibility",
                        steps = listOf(
                            "Raise both arms overhead.",
                            "Clasp hands together.",
                            "Lean gently to one side, then switch."
                        ),
                        duration = "15–20 seconds per side",
                        safetyTips = "Keep core engaged to avoid collapsing."
                    )

                    StretchCard1(
                        title = "Eagle Arms Stretch",
                        muscles = "Upper back, shoulders",
                        benefits = "Releases tension between shoulder blades",
                        steps = listOf(
                            "Extend arms forward and cross them at elbows.",
                            "Wrap forearms and press palms together.",
                            "Lift elbows slightly while keeping shoulders down."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Stop if you feel sharp shoulder pain."
                    )

                    StretchCard1(
                        title = "Wall Chest Stretch",
                        muscles = "Chest, shoulders, biceps",
                        benefits = "Relieves tight chest and improves posture",
                        steps = listOf(
                            "Stand near a wall.",
                            "Place palm on wall and extend arm behind you.",
                            "Turn body gently away from arm."
                        ),
                        duration = "20–30 seconds per side",
                        safetyTips = "Avoid forcing arm too far back."
                    )

                    StretchCard1(
                        title = "Upper Back Stretch",
                        muscles = "Upper back, shoulders",
                        benefits = "Releases tension in upper back and spine",
                        steps = listOf(
                            "Clasp hands in front of you.",
                            "Push arms forward while rounding upper back.",
                            "Tuck chin slightly."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Focus on stretching back, not arms."
                    )
                }
            }
        }
    )
}

// ✅ Reusable Stretch Card
@Composable
fun StretchCard1(
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
fun UpperBodyStretchingScreenPreview() {
    UpperBodyStretchingScreen(rememberNavController())
}
