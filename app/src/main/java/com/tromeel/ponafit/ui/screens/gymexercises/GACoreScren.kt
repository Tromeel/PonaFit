package com.tromeel.ponafit.ui.screens.gymexercises

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
import com.tromeel.ponafit.navigation.ROUT_GCDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GACoreScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_GCDIFFICULTY) },
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
                        text = "Advanced Abs & Core Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These advanced gym workouts are designed to build maximum strength, stability, and definition in your abs and core. They use resistance, explosive power, and balance challenges for elite-level conditioning.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Advanced Abs & Core Workouts
                    GymBLCard5(
                        title = "Weighted Decline Sit-Ups",
                        description = "High-resistance sit-ups for explosive core strength.",
                        steps = listOf(
                            "Lie on a decline bench with feet secured.",
                            "Hold a heavy plate or dumbbell behind your head.",
                            "Perform sit-ups with slow controlled motion."
                        ),
                        sets = "4 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard5(
                        title = "Hanging Toes-to-Bar",
                        description = "An advanced core move targeting lower abs and hip flexors.",
                        steps = listOf(
                            "Hang from a pull-up bar with a strong grip.",
                            "Raise legs fully until toes touch the bar.",
                            "Lower slowly under control."
                        ),
                        sets = "4 sets",
                        reps = "8–12 reps"
                    )

                    GymBLCard5(
                        title = "Weighted Ab Wheel Rollouts",
                        description = "Advanced rollout with added resistance for deep core engagement.",
                        steps = listOf(
                            "Hold an ab wheel and kneel on the floor.",
                            "Have a partner place a weight plate on your back.",
                            "Roll forward fully without arching your spine.",
                            "Return under control."
                        ),
                        sets = "3–4 sets",
                        reps = "8–10 reps"
                    )

                    GymBLCard5(
                        title = "Cable Woodchoppers (Heavy)",
                        description = "Explosive rotational strength for obliques and core stability.",
                        steps = listOf(
                            "Set cable to high pulley position.",
                            "Pull across your body diagonally with power.",
                            "Control the return slowly."
                        ),
                        sets = "3 sets",
                        reps = "12 reps per side"
                    )

                    GymBLCard5(
                        title = "Dragon Flags",
                        description = "Elite core strength move popularized by Bruce Lee.",
                        steps = listOf(
                            "Lie on a bench and hold behind your head for support.",
                            "Lift your whole body straight upward.",
                            "Lower slowly, keeping core braced."
                        ),
                        sets = "3 sets",
                        reps = "6–8 reps"
                    )

                    GymBLCard5(
                        title = "Landmine Oblique Twists",
                        description = "Heavy rotational power move using a landmine barbell setup.",
                        steps = listOf(
                            "Stand with feet shoulder-width apart holding the landmine bar.",
                            "Rotate torso explosively side to side.",
                            "Engage obliques and keep arms extended."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps per side"
                    )

                    GymBLCard5(
                        title = "Weighted Stability Ball Pike",
                        description = "Combines balance and strength for advanced core control.",
                        steps = listOf(
                            "Start in plank with feet on a stability ball.",
                            "Place a weight vest or plate on your back for added resistance.",
                            "Pull hips upward into a pike position.",
                            "Lower slowly back to plank."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with Background Image
@Composable
fun GymBLCard5(
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
fun GACoreScreenPreview() {
    GACoreScreen(rememberNavController())
}
