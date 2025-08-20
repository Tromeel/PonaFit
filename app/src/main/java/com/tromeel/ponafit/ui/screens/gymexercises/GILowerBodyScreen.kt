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
import com.tromeel.ponafit.navigation.ROUT_GLDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GILowerBodyScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_GLDIFFICULTY) },
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
                        text = "Intermediate Lower Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These intermediate-level workouts target strength, power, and muscle growth using gym machines and free weights. They are ideal for those who already have a foundation and want to progress further.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Intermediate Lower Body Workouts
                    GymBLCard1(
                        title = "Barbell Back Squats",
                        description = "Builds strength in quads, glutes, and hamstrings.",
                        steps = listOf(
                            "Set a barbell on a squat rack at shoulder height.",
                            "Position the bar across your upper back and grip it firmly.",
                            "Step back, feet shoulder-width apart, and lower hips below parallel.",
                            "Push through heels to return to standing."
                        ),
                        sets = "4 sets",
                        reps = "8–10 reps"
                    )

                    GymBLCard1(
                        title = "Romanian Deadlifts (Barbell/Dumbbells)",
                        description = "Targets hamstrings and glutes with a hip hinge movement.",
                        steps = listOf(
                            "Hold barbell or dumbbells in front of thighs.",
                            "Keep back straight and hinge at hips.",
                            "Lower weights until hamstrings stretch.",
                            "Drive hips forward to stand tall."
                        ),
                        sets = "4 sets",
                        reps = "8–10 reps"
                    )

                    GymBLCard1(
                        title = "Walking Lunges (Dumbbells)",
                        description = "Improves balance, stability, and unilateral strength.",
                        steps = listOf(
                            "Hold dumbbells at your sides.",
                            "Step forward with one leg into a lunge position.",
                            "Push through front heel and step forward with the other leg.",
                            "Repeat alternating steps."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps per leg"
                    )

                    GymBLCard1(
                        title = "Bulgarian Split Squats (Dumbbells)",
                        description = "Intensely works quads and glutes.",
                        steps = listOf(
                            "Stand in front of a bench with one foot resting on it behind you.",
                            "Hold dumbbells at your sides.",
                            "Lower into a lunge, keeping front knee over ankle.",
                            "Push through front heel to rise."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps per leg"
                    )

                    GymBLCard1(
                        title = "Leg Press (Machine)",
                        description = "Develops overall lower body strength.",
                        steps = listOf(
                            "Sit on the leg press machine and place feet shoulder-width on platform.",
                            "Push platform upward until legs are extended but not locked.",
                            "Lower slowly until knees reach 90 degrees.",
                            "Press back up with control."
                        ),
                        sets = "4 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard1(
                        title = "Hip Thrusts (Barbell)",
                        description = "Maximizes glute strength and power.",
                        steps = listOf(
                            "Sit on the floor with your back against a bench.",
                            "Place a barbell across hips (use padding for comfort).",
                            "Drive hips upward until body is straight.",
                            "Lower with control and repeat."
                        ),
                        sets = "4 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard1(
                        title = "Standing Calf Raises (Weighted)",
                        description = "Builds calf strength and definition.",
                        steps = listOf(
                            "Hold dumbbells or use calf raise machine.",
                            "Stand with toes on platform, heels hanging off.",
                            "Push up onto toes and squeeze calves.",
                            "Lower slowly below platform level."
                        ),
                        sets = "4 sets",
                        reps = "12–15 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with Background Image
@Composable
fun GymBLCard1(
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
fun GILowerBodyScreenPreview() {
    GILowerBodyScreen(rememberNavController())
}
