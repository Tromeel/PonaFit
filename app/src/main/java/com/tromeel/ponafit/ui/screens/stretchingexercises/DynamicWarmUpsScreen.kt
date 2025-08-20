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
fun DynamicWarmUpsScreen(navController: NavController) {
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
                        text = "Dynamic Warm-Ups",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Text(
                        text = "Dynamic warm-ups prepare your muscles, joints, and heart for exercise by improving mobility, circulation, and performance.",
                        fontSize = 18.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ 10 Dynamic Warm-Up Exercises
                    StretchCard3(
                        title = "Arm Circles",
                        muscles = "Shoulders, arms",
                        benefits = "Loosens shoulder joints, improves circulation",
                        steps = listOf(
                            "Stand with arms extended sideways.",
                            "Make small forward circles.",
                            "Switch to backward circles."
                        ),
                        duration = "20–30 seconds each direction",
                        safetyTips = "Keep movements controlled."
                    )

                    StretchCard3(
                        title = "High Knees",
                        muscles = "Quads, hip flexors, calves, core",
                        benefits = "Boosts heart rate, activates lower body",
                        steps = listOf(
                            "Jog in place, lifting knees high.",
                            "Pump arms as you move.",
                            "Keep core engaged."
                        ),
                        duration = "30–45 seconds",
                        safetyTips = "Land softly on balls of feet."
                    )

                    StretchCard3(
                        title = "Leg Swings",
                        muscles = "Hip flexors, hamstrings, glutes",
                        benefits = "Improves hip mobility and flexibility",
                        steps = listOf(
                            "Hold onto support for balance.",
                            "Swing one leg forward and backward.",
                            "Switch legs after reps."
                        ),
                        duration = "10–15 swings per leg",
                        safetyTips = "Keep movement smooth and controlled."
                    )

                    StretchCard3(
                        title = "Lunges with Twist",
                        muscles = "Quads, glutes, core",
                        benefits = "Opens hips and engages core",
                        steps = listOf(
                            "Step into a forward lunge.",
                            "Twist torso toward front leg.",
                            "Return and switch sides."
                        ),
                        duration = "8–10 reps per side",
                        safetyTips = "Keep front knee over ankle."
                    )

                    StretchCard3(
                        title = "Torso Twists",
                        muscles = "Obliques, core, spine",
                        benefits = "Increases spinal mobility",
                        steps = listOf(
                            "Stand with feet shoulder-width apart.",
                            "Twist torso side to side.",
                            "Swing arms naturally."
                        ),
                        duration = "20–30 seconds",
                        safetyTips = "Rotate gently without jerking."
                    )

                    StretchCard3(
                        title = "Butt Kicks",
                        muscles = "Hamstrings, calves",
                        benefits = "Activates hamstrings, raises heart rate",
                        steps = listOf(
                            "Jog in place.",
                            "Kick heels up toward glutes.",
                            "Pump arms rhythmically."
                        ),
                        duration = "30–45 seconds",
                        safetyTips = "Maintain steady pace."
                    )

                    StretchCard3(
                        title = "Inchworms",
                        muscles = "Hamstrings, shoulders, core",
                        benefits = "Stretches hamstrings and warms up shoulders",
                        steps = listOf(
                            "Stand tall, bend forward to touch floor.",
                            "Walk hands forward to plank.",
                            "Walk feet up toward hands and stand."
                        ),
                        duration = "6–8 reps",
                        safetyTips = "Engage core during plank."
                    )

                    StretchCard3(
                        title = "Jumping Jacks",
                        muscles = "Full body",
                        benefits = "Raises heart rate, improves circulation",
                        steps = listOf(
                            "Jump feet apart while raising arms overhead.",
                            "Jump back to starting position.",
                            "Repeat rhythmically."
                        ),
                        duration = "30–45 seconds",
                        safetyTips = "Land softly to protect joints."
                    )

                    StretchCard3(
                        title = "Hip Circles",
                        muscles = "Hips, lower back",
                        benefits = "Improves hip joint mobility",
                        steps = listOf(
                            "Place hands on hips.",
                            "Rotate hips clockwise.",
                            "Switch to counterclockwise."
                        ),
                        duration = "20 seconds each direction",
                        safetyTips = "Move smoothly without forcing."
                    )

                    StretchCard3(
                        title = "Walking Lunges",
                        muscles = "Quads, hamstrings, glutes",
                        benefits = "Strengthens legs, boosts mobility",
                        steps = listOf(
                            "Step forward into a lunge.",
                            "Push off back leg to move forward.",
                            "Repeat alternating legs."
                        ),
                        duration = "10–12 steps per leg",
                        safetyTips = "Keep torso upright and core engaged."
                    )
                }
            }
        }
    )
}

// ✅ Reusable Stretch Card
@Composable
fun StretchCard3(
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
fun DynamicWarmUpsScreenPreview() {
    DynamicWarmUpsScreen(rememberNavController())
}
