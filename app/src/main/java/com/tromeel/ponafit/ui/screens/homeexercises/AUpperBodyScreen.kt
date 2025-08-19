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
import com.tromeel.ponafit.navigation.ROUT_UDIFFICULTY
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun AUpperBodyScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_UDIFFICULTY) },
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
                        text = "Advanced Upper Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Advanced upper-body workouts at home push your strength, stability, and endurance to the next level. These exercises challenge chest, shoulders, arms, and back with explosive and high-resistance movements—perfect for building real power and definition without weights.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Advanced Workout List
                    UpperBodyWorkoutCard2(
                        title = "Archer Push-Ups",
                        description = "A unilateral push-up that builds serious chest and shoulder strength.",
                        steps = listOf(
                            "Start in push-up position with arms wider than shoulder-width.",
                            "Lower your chest toward one arm while keeping the other straight.",
                            "Push back up and shift to the opposite side.",
                            "Keep core tight throughout."
                        ),
                        sets = "4 sets",
                        reps = "8–10 each side"
                    )

                    UpperBodyWorkoutCard2(
                        title = "Handstand Push-Ups (Wall Supported)",
                        description = "Targets shoulders and triceps with high resistance.",
                        steps = listOf(
                            "Kick up into a handstand against a wall.",
                            "Lower your head slowly toward the floor by bending elbows.",
                            "Push back up to full arm extension.",
                            "Maintain tight core for balance."
                        ),
                        sets = "4 sets",
                        reps = "6–8 reps"
                    )

                    UpperBodyWorkoutCard2(
                        title = "Clapping Push-Ups",
                        description = "Explosive power move for chest, shoulders, and triceps.",
                        steps = listOf(
                            "Start in push-up position.",
                            "Lower your chest and push up explosively off the ground.",
                            "Clap hands quickly before landing back in push-up position.",
                            "Absorb landing softly with bent elbows."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    UpperBodyWorkoutCard2(
                        title = "Pseudo Planche Push-Ups",
                        description = "Engages chest, shoulders, and core heavily.",
                        steps = listOf(
                            "Begin in push-up position with hands placed lower near hips.",
                            "Lean forward slightly to shift weight onto shoulders.",
                            "Lower chest toward ground keeping elbows tucked.",
                            "Push back up while maintaining forward lean."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    UpperBodyWorkoutCard2(
                        title = "One-Arm Push-Ups",
                        description = "Advanced unilateral strength builder.",
                        steps = listOf(
                            "Start in push-up position with feet slightly wider.",
                            "Place one arm behind your back.",
                            "Lower chest toward ground with one arm supporting.",
                            "Push back up with controlled movement."
                        ),
                        sets = "3 sets",
                        reps = "5–8 each arm"
                    )

                    UpperBodyWorkoutCard2(
                        title = "Typewriter Push-Ups",
                        description = "Targets chest and shoulders with side-to-side strength.",
                        steps = listOf(
                            "Start in wide push-up position.",
                            "Lower chest to one side, keeping elbows tucked.",
                            "Shift body across to the other side while staying low.",
                            "Push back up to starting position."
                        ),
                        sets = "3 sets",
                        reps = "6–8 each side"
                    )

                    UpperBodyWorkoutCard2(
                        title = "Superman Push-Ups",
                        description = "Explosive movement engaging chest, shoulders, arms, and core.",
                        steps = listOf(
                            "Begin in push-up position.",
                            "Lower chest and push up explosively off the floor.",
                            "Extend arms forward like Superman while in the air.",
                            "Land softly back in push-up position."
                        ),
                        sets = "3 sets",
                        reps = "6–8 reps"
                    )

                    UpperBodyWorkoutCard2(
                        title = "Pike to Handstand Press",
                        description = "Bridges strength between shoulders and core.",
                        steps = listOf(
                            "Start in a pike position with hips raised.",
                            "Push through shoulders, lifting legs slightly off the floor.",
                            "Transition into a supported handstand against the wall.",
                            "Lower back to pike with control."
                        ),
                        sets = "3 sets",
                        reps = "5–6 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card Composable
@Composable
fun UpperBodyWorkoutCard2(
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
fun AUpperBodyScreenPreview() {
    AUpperBodyScreen(rememberNavController())
}
