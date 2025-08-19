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
import com.tromeel.ponafit.navigation.ROUT_LDIFFICULTY
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun BCoreScreen(navController: NavController) {
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
                        text = "Beginner Abs & Core Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Strengthen your abs and core with these beginner-friendly exercises you can easily do at home. They help improve stability, posture, and overall fitness without requiring equipment.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ 7 Beginner Abs & Core Workout List
                    AbsCoreWorkoutCard(
                        title = "Crunches",
                        description = "A simple move to engage and strengthen your upper abs.",
                        steps = listOf(
                            "Lie on your back with knees bent and feet flat.",
                            "Place hands behind your head lightly.",
                            "Lift your shoulders off the floor while exhaling.",
                            "Lower slowly and repeat."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    AbsCoreWorkoutCard(
                        title = "Leg Raises",
                        description = "Targets the lower abs for stability and strength.",
                        steps = listOf(
                            "Lie flat on your back with legs extended.",
                            "Place hands under your hips for support.",
                            "Lift legs toward the ceiling while keeping them straight.",
                            "Lower slowly without touching the floor."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    AbsCoreWorkoutCard(
                        title = "Plank",
                        description = "A static hold that builds core stability.",
                        steps = listOf(
                            "Start face down on the floor.",
                            "Lift onto elbows and toes, keeping your body straight.",
                            "Engage your core and hold the position.",
                            "Avoid arching your back."
                        ),
                        sets = "3 sets",
                        reps = "20–30 seconds hold"
                    )

                    AbsCoreWorkoutCard(
                        title = "Bicycle Crunches",
                        description = "Works both the abs and obliques for a complete core burn.",
                        steps = listOf(
                            "Lie on your back with knees lifted.",
                            "Bring opposite elbow to opposite knee while extending the other leg.",
                            "Switch sides in a pedaling motion.",
                            "Keep core engaged throughout."
                        ),
                        sets = "3 sets",
                        reps = "12–16 reps each side"
                    )

                    AbsCoreWorkoutCard(
                        title = "Seated Knee Tucks",
                        description = "Great for lower abs and balance.",
                        steps = listOf(
                            "Sit on the edge of a chair or floor.",
                            "Lean back slightly and lift your feet off the ground.",
                            "Bring knees toward chest and extend legs back out.",
                            "Repeat smoothly."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    AbsCoreWorkoutCard(
                        title = "Mountain Climbers",
                        description = "A cardio move that strengthens your core and burns calories.",
                        steps = listOf(
                            "Start in a plank position.",
                            "Drive one knee toward your chest quickly.",
                            "Switch legs in a running motion.",
                            "Keep hips low and core tight."
                        ),
                        sets = "3 sets",
                        reps = "20–30 seconds"
                    )

                    AbsCoreWorkoutCard(
                        title = "Russian Twists",
                        description = "Targets your obliques and helps build rotational core strength.",
                        steps = listOf(
                            "Sit on the floor with knees bent.",
                            "Lean back slightly and lift your feet off the ground.",
                            "Hold hands together and twist your torso to one side.",
                            "Switch sides while keeping your core engaged."
                        ),
                        sets = "3 sets",
                        reps = "12–16 twists each side"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card for Abs & Core
@Composable
fun AbsCoreWorkoutCard(
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
fun BCoreScreenPreview() {
    BCoreScreen(rememberNavController())
}
