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
fun ICoreScreen(navController: NavController) {
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
                        text = "Intermediate Abs & Core Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Take your core training to the next level with these intermediate exercises. Designed to challenge your strength and endurance, these moves build stability, burn calories, and sculpt your abs at home—no equipment needed.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Intermediate Abs & Core Workouts
                    AbsCoreWorkoutCard1(
                        title = "V-Ups",
                        description = "Engages both upper and lower abs simultaneously.",
                        steps = listOf(
                            "Lie flat with arms extended overhead and legs straight.",
                            "Lift arms and legs together to form a V shape.",
                            "Reach hands toward feet.",
                            "Lower slowly and repeat."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    AbsCoreWorkoutCard1(
                        title = "Side Plank with Hip Dips",
                        description = "Strengthens obliques and improves balance.",
                        steps = listOf(
                            "Start in a side plank position on your elbow.",
                            "Lower hips toward the ground without touching.",
                            "Lift hips back up to starting position.",
                            "Repeat before switching sides."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps each side"
                    )

                    AbsCoreWorkoutCard1(
                        title = "Flutter Kicks",
                        description = "Targets lower abs with controlled leg movement.",
                        steps = listOf(
                            "Lie flat with hands under your hips.",
                            "Lift legs slightly off the floor.",
                            "Kick legs up and down in a fluttering motion.",
                            "Keep core engaged throughout."
                        ),
                        sets = "3 sets",
                        reps = "20–30 seconds"
                    )

                    AbsCoreWorkoutCard1(
                        title = "Plank to Shoulder Tap",
                        description = "Builds stability and core control.",
                        steps = listOf(
                            "Start in a high plank position.",
                            "Lift one hand and tap opposite shoulder.",
                            "Alternate hands while keeping hips stable.",
                            "Avoid rotating your torso."
                        ),
                        sets = "3 sets",
                        reps = "12–16 reps each side"
                    )

                    AbsCoreWorkoutCard1(
                        title = "Reverse Crunch",
                        description = "Excellent for targeting the lower abs.",
                        steps = listOf(
                            "Lie on your back with knees bent at 90°.",
                            "Lift hips off the floor while pulling knees toward chest.",
                            "Lower slowly without touching the floor.",
                            "Repeat with control."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    AbsCoreWorkoutCard1(
                        title = "Plank Jacks",
                        description = "Dynamic plank variation to build endurance.",
                        steps = listOf(
                            "Start in plank position.",
                            "Jump feet apart and back together, like a jumping jack.",
                            "Keep core tight and back straight.",
                            "Maintain steady breathing."
                        ),
                        sets = "3 sets",
                        reps = "20–30 seconds"
                    )

                    AbsCoreWorkoutCard1(
                        title = "Toe Touches",
                        description = "Strengthens upper abs and improves flexibility.",
                        steps = listOf(
                            "Lie flat with legs raised straight up.",
                            "Reach hands toward toes, lifting shoulders off the floor.",
                            "Lower slowly while keeping legs raised.",
                            "Repeat with control."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card for Abs & Core
@Composable
fun AbsCoreWorkoutCard1(
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
fun ICoreScreenPreview() {
    ICoreScreen(rememberNavController())
}
