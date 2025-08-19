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
fun BLowerBodyScreen(navController: NavController) {
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
                        text = "Beginner Lower Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These beginner lower-body workouts at home help strengthen your legs, glutes, and hips without equipment. They improve balance, stability, and core strength while building a solid foundation for overall fitness.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Workout List (7 total)
                    LowerBodyWorkoutCard(
                        title = "Squats",
                        description = "Strengthens legs and glutes.",
                        steps = listOf(
                            "Stand with feet shoulder-width apart.",
                            "Bend knees and push hips back like sitting in a chair.",
                            "Keep chest upright and core tight.",
                            "Stand back up to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    LowerBodyWorkoutCard(
                        title = "Glute Bridges",
                        description = "Activates glutes and strengthens core.",
                        steps = listOf(
                            "Lie on your back with knees bent and feet flat.",
                            "Keep arms at your sides for support.",
                            "Lift hips toward the ceiling while squeezing glutes.",
                            "Lower back down slowly."
                        ),
                        sets = "3 sets",
                        reps = "10–15 reps"
                    )

                    LowerBodyWorkoutCard(
                        title = "Step-Ups",
                        description = "Builds leg strength using a sturdy step or chair.",
                        steps = listOf(
                            "Stand facing a sturdy chair or step.",
                            "Place one foot firmly on the step.",
                            "Push through your heel to lift your body up.",
                            "Step back down and repeat with the other leg."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps each leg"
                    )

                    LowerBodyWorkoutCard(
                        title = "Lunges",
                        description = "Improves balance and leg strength.",
                        steps = listOf(
                            "Stand upright with feet together.",
                            "Step forward with one leg and lower until knees form 90°.",
                            "Push through front heel to return to standing.",
                            "Repeat on the other leg."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps each leg"
                    )

                    LowerBodyWorkoutCard(
                        title = "Calf Raises",
                        description = "Strengthens calves and improves ankle stability.",
                        steps = listOf(
                            "Stand with feet hip-width apart.",
                            "Lift heels off the ground onto your toes.",
                            "Hold for 1–2 seconds at the top.",
                            "Lower heels back down slowly."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    LowerBodyWorkoutCard(
                        title = "Side Leg Raises",
                        description = "Strengthens hips and outer thighs.",
                        steps = listOf(
                            "Stand upright, holding onto a wall or chair for balance.",
                            "Lift one leg out to the side, keeping it straight.",
                            "Lower slowly and repeat.",
                            "Switch to the other leg."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps each leg"
                    )

                    LowerBodyWorkoutCard(
                        title = "Wall Sit",
                        description = "Endurance move for quads and glutes.",
                        steps = listOf(
                            "Stand with your back against a wall.",
                            "Slide down until thighs are parallel to the floor.",
                            "Hold position with core tight and back flat.",
                            "Push through heels to stand back up."
                        ),
                        sets = "3 sets",
                        reps = "Hold for 15–20 sec"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card Composable
@Composable
fun LowerBodyWorkoutCard(
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
fun BLowerBodyScreenPreview() {
    BLowerBodyScreen(rememberNavController())
}
