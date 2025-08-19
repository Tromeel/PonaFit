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
import com.tromeel.ponafit.navigation.ROUT_FDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_LDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_UDIFFICULTY
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun BUpperBodyScreen(navController: NavController) {
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
                        text = "Beginner Upper Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Beginner upper-body workouts at home help build strength in your chest, arms, shoulders, and back using just your bodyweight. These simple exercises improve posture, stability, and overall fitness without needing any equipment.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Workout List (7 total)
                    UpperBodyWorkoutCard(
                        title = "Wall Push-Ups",
                        description = "Great for beginners to strengthen chest and arms.",
                        steps = listOf(
                            "Stand facing a wall with arms extended at shoulder height.",
                            "Place palms flat on the wall, slightly wider than shoulders.",
                            "Bend elbows and lean chest toward the wall.",
                            "Push back to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–15 reps"
                    )

                    UpperBodyWorkoutCard(
                        title = "Arm Circles",
                        description = "Improves shoulder mobility and endurance.",
                        steps = listOf(
                            "Stand upright with arms extended to the sides.",
                            "Rotate arms forward in small circles.",
                            "Gradually make circles bigger.",
                            "Repeat in the opposite direction."
                        ),
                        sets = "3 sets",
                        reps = "15–20 sec each"
                    )

                    UpperBodyWorkoutCard(
                        title = "Modified Knee Push-Ups",
                        description = "Strengthens chest, shoulders, and triceps.",
                        steps = listOf(
                            "Start in a push-up position but with knees on the floor.",
                            "Hands should be shoulder-width apart.",
                            "Lower chest toward the ground by bending elbows.",
                            "Push back up to starting position."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    UpperBodyWorkoutCard(
                        title = "Superman Hold",
                        description = "Strengthens back and shoulders.",
                        steps = listOf(
                            "Lie face down on the floor with arms extended forward.",
                            "Lift arms, chest, and legs slightly off the ground.",
                            "Hold for a few seconds while squeezing your back.",
                            "Slowly return to the starting position."
                        ),
                        sets = "3 sets",
                        reps = "Hold for 10–15 sec"
                    )

                    UpperBodyWorkoutCard(
                        title = "Shoulder Shrugs",
                        description = "Helps relax and strengthen shoulder muscles.",
                        steps = listOf(
                            "Stand upright with arms relaxed by your sides.",
                            "Lift your shoulders up toward your ears.",
                            "Hold for 1–2 seconds, then release slowly.",
                            "Repeat steadily without rushing."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    UpperBodyWorkoutCard(
                        title = "Chair Dips",
                        description = "Works on triceps and shoulders using a sturdy chair.",
                        steps = listOf(
                            "Sit on the edge of a chair with hands gripping the sides.",
                            "Walk your feet slightly forward and slide off the seat.",
                            "Lower your body by bending elbows to 90 degrees.",
                            "Push back up to starting position."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    UpperBodyWorkoutCard(
                        title = "Front Arm Raises",
                        description = "Strengthens shoulders and improves control.",
                        steps = listOf(
                            "Stand upright with arms down at your sides.",
                            "Lift both arms forward until shoulder height.",
                            "Pause briefly, then lower arms slowly.",
                            "Keep movements controlled without swinging."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card Composable
@Composable
fun UpperBodyWorkoutCard(
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
fun BUpperBodyScreenPreview() {
    BUpperBodyScreen(rememberNavController())
}
