package com.tromeel.ponafit.ui.screens.homeexercises

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
import com.tromeel.ponafit.navigation.ROUT_CDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun ACoreScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_CDIFFICULTY) },
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
                        text = "Advanced Abs & Core Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Take your core training to the next level with these challenging abs and core exercises. Designed to build strength, endurance, and definition — no gym required.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Advanced Abs & Core Workouts
                    AbsCoreWorkoutCard2(
                        title = "Hanging Leg Raises (Floor Variation)",
                        description = "A tough move for your lower abs and hip flexors.",
                        steps = listOf(
                            "Lie flat and hold onto a sturdy object behind your head.",
                            "Lift both legs straight up toward the ceiling.",
                            "Lower them slowly without touching the ground.",
                            "Keep your core braced the entire time."
                        ),
                        sets = "4 sets",
                        reps = "12–15 reps"
                    )

                    AbsCoreWorkoutCard2(
                        title = "V-Ups",
                        description = "Works upper and lower abs together in one explosive move.",
                        steps = listOf(
                            "Lie flat on your back with arms extended overhead.",
                            "Lift both arms and legs at the same time to meet in the middle.",
                            "Form a 'V' shape at the top.",
                            "Lower back down slowly."
                        ),
                        sets = "4 sets",
                        reps = "12–15 reps"
                    )

                    AbsCoreWorkoutCard2(
                        title = "Plank to Shoulder Tap",
                        description = "Builds stability and anti-rotation core strength.",
                        steps = listOf(
                            "Start in a high plank position.",
                            "Tap your right hand to your left shoulder.",
                            "Switch sides while keeping hips as still as possible.",
                            "Maintain tight core engagement."
                        ),
                        sets = "3 sets",
                        reps = "30–40 taps"
                    )

                    AbsCoreWorkoutCard2(
                        title = "Dragon Flags (Beginner Variation)",
                        description = "A brutal move for core strength popularized by Bruce Lee.",
                        steps = listOf(
                            "Lie flat holding a sturdy surface behind your head.",
                            "Lift your entire body off the floor except upper back.",
                            "Lower legs down slowly, resisting gravity.",
                            "Return to the top with control."
                        ),
                        sets = "3 sets",
                        reps = "6–8 reps"
                    )

                    AbsCoreWorkoutCard2(
                        title = "Side Plank with Hip Dips",
                        description = "Targets obliques and deep core stabilizers.",
                        steps = listOf(
                            "Get into a side plank on your elbow.",
                            "Lower your hip toward the ground slightly.",
                            "Lift back up to starting position.",
                            "Repeat on both sides."
                        ),
                        sets = "3 sets each side",
                        reps = "12–15 dips"
                    )

                    AbsCoreWorkoutCard2(
                        title = "Toe Touch Crunches",
                        description = "Strengthens upper abs and builds endurance.",
                        steps = listOf(
                            "Lie on your back with legs raised straight up.",
                            "Reach arms toward your toes while lifting shoulders.",
                            "Squeeze your abs at the top.",
                            "Lower down with control."
                        ),
                        sets = "3 sets",
                        reps = "15–20 reps"
                    )

                    AbsCoreWorkoutCard2(
                        title = "Plank Walkouts",
                        description = "Engages your entire core, shoulders, and arms.",
                        steps = listOf(
                            "Start standing tall.",
                            "Bend forward and walk your hands into a plank.",
                            "Hold for a second, then walk hands back in and stand up.",
                            "Repeat smoothly."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card
@Composable
fun AbsCoreWorkoutCard2(
    title: String,
    description: String,
    steps: List<String>,
    sets: String,
    reps: String
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
                .heightIn(min = 200.dp)
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
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(10.dp))

                steps.forEachIndexed { index, step ->
                    Text(
                        text = "${index + 1}. $step",
                        fontSize = 13.sp,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Sets: $sets", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.White)
                    Text(text = "Reps: $reps", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun ACoreScreenPreview() {
    ACoreScreen(rememberNavController())
}
