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
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_LDIFFICULTY
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun ILowerBodyScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_LDIFFICULTY) },
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
                        text = "Intermediate Lower Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These intermediate lower-body workouts at home build strength, endurance, and stability. Perfect for progressing beyond beginner moves, they challenge your balance, coordination, and muscular control without needing equipment.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Intermediate Workout List
                    LowerBodyWorkoutCard1(
                        title = "Bulgarian Split Squats",
                        description = "Strengthens quads, glutes, and balance.",
                        steps = listOf(
                            "Stand a few feet in front of a chair or step.",
                            "Place one foot back on the chair.",
                            "Lower into a lunge with your front knee at 90°.",
                            "Push back up through the front heel."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps each leg"
                    )

                    LowerBodyWorkoutCard1(
                        title = "Single-Leg Glute Bridges",
                        description = "Targets glutes and hamstrings while improving stability.",
                        steps = listOf(
                            "Lie on your back with one knee bent and the other leg straight.",
                            "Press through the bent leg’s heel to lift hips upward.",
                            "Keep the raised leg extended and core tight.",
                            "Lower slowly and repeat."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps each side"
                    )

                    LowerBodyWorkoutCard1(
                        title = "Reverse Lunges",
                        description = "Improves coordination and strengthens quads and glutes.",
                        steps = listOf(
                            "Stand tall with feet hip-width apart.",
                            "Step one leg back and lower until knees form 90° angles.",
                            "Push through the front heel to return to standing.",
                            "Repeat on the other side."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps each leg"
                    )

                    LowerBodyWorkoutCard1(
                        title = "Jump Squats",
                        description = "Explosive move to build leg power and endurance.",
                        steps = listOf(
                            "Stand with feet shoulder-width apart.",
                            "Lower into a squat position.",
                            "Jump upward explosively, extending arms overhead.",
                            "Land softly and go straight into the next squat."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    LowerBodyWorkoutCard1(
                        title = "Curtsy Lunges",
                        description = "Engages glutes, inner thighs, and improves hip mobility.",
                        steps = listOf(
                            "Stand upright with feet hip-width apart.",
                            "Step one leg diagonally back behind the other.",
                            "Bend knees until front thigh is parallel to the ground.",
                            "Return to starting position and switch legs."
                        ),
                        sets = "3 sets",
                        reps = "10 reps each leg"
                    )

                    LowerBodyWorkoutCard1(
                        title = "Single-Leg Calf Raises",
                        description = "Improves balance and ankle stability.",
                        steps = listOf(
                            "Stand on one foot near a wall for support.",
                            "Rise up onto the ball of your foot.",
                            "Hold for 1–2 seconds, then lower slowly.",
                            "Switch sides after completing reps."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps each side"
                    )

                    LowerBodyWorkoutCard1(
                        title = "Wall Sit with Heel Lifts",
                        description = "Isometric strength and calf activation.",
                        steps = listOf(
                            "Sit against a wall with thighs parallel to the floor.",
                            "Lift both heels off the ground, balancing on toes.",
                            "Hold for 1–2 seconds and lower heels.",
                            "Maintain squat position throughout."
                        ),
                        sets = "3 sets",
                        reps = "10–12 heel lifts per hold"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card Composable
@Composable
fun LowerBodyWorkoutCard1(
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
fun ILowerBodyScreenPreview() {
    ILowerBodyScreen(rememberNavController())
}
