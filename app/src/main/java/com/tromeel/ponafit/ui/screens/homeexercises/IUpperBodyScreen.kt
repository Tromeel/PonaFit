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
fun IUpperBodyScreen(navController: NavController) {
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
                        text = "Intermediate Upper Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Intermediate upper-body workouts at home challenge your chest, shoulders, arms, and back with greater intensity. These moves build endurance, improve strength, and add muscle definition—all without heavy equipment.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Workout List (8 total)
                    UpperBodyWorkoutCard1(
                        title = "Standard Push-Ups",
                        description = "Builds strength in chest, shoulders, and triceps.",
                        steps = listOf(
                            "Start in a plank position with hands under shoulders.",
                            "Lower your chest toward the floor by bending elbows.",
                            "Push back up to starting position.",
                            "Keep your body straight throughout."
                        ),
                        sets = "4 sets",
                        reps = "10–15 reps"
                    )

                    UpperBodyWorkoutCard1(
                        title = "Incline Push-Ups",
                        description = "Adds variation to target chest and shoulders.",
                        steps = listOf(
                            "Place hands on an elevated surface like a chair or bench.",
                            "Keep body straight in a plank position.",
                            "Lower chest toward the surface, then push back up.",
                            "Engage core to maintain stability."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    UpperBodyWorkoutCard1(
                        title = "Pike Push-Ups",
                        description = "Strengthens shoulders and upper chest.",
                        steps = listOf(
                            "Start in a downward dog position with hips raised.",
                            "Bend elbows to lower head toward the ground.",
                            "Push through shoulders to return to starting position.",
                            "Keep movement controlled."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    UpperBodyWorkoutCard1(
                        title = "Plank Shoulder Taps",
                        description = "Improves shoulder stability and core strength.",
                        steps = listOf(
                            "Hold a plank with hands under shoulders.",
                            "Lift one hand and tap the opposite shoulder.",
                            "Alternate sides while keeping hips stable.",
                            "Avoid twisting your torso."
                        ),
                        sets = "3 sets",
                        reps = "12 taps each side"
                    )

                    UpperBodyWorkoutCard1(
                        title = "Tricep Dips",
                        description = "Tones triceps and shoulders using a chair.",
                        steps = listOf(
                            "Sit on the edge of a chair with hands beside your hips.",
                            "Slide off the chair, supporting yourself with arms.",
                            "Lower body by bending elbows to 90 degrees.",
                            "Push back up to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    UpperBodyWorkoutCard1(
                        title = "Superman Pulls",
                        description = "Strengthens back and shoulders.",
                        steps = listOf(
                            "Lie face down with arms extended forward.",
                            "Lift arms, chest, and legs slightly off the ground.",
                            "Pull elbows toward your ribs, squeezing shoulder blades.",
                            "Extend arms forward again."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    UpperBodyWorkoutCard1(
                        title = "Diamond Push-Ups",
                        description = "Targets triceps and inner chest.",
                        steps = listOf(
                            "Start in push-up position with hands close together under chest.",
                            "Form a diamond shape with thumbs and index fingers.",
                            "Lower chest toward hands, then push back up.",
                            "Keep elbows close to your body."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    UpperBodyWorkoutCard1(
                        title = "Plank to Push-Up",
                        description = "Works chest, shoulders, arms, and core.",
                        steps = listOf(
                            "Start in a forearm plank position.",
                            "Push up onto one hand, then the other into a full plank.",
                            "Lower back down to forearms one arm at a time.",
                            "Alternate leading arms each rep."
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
fun UpperBodyWorkoutCard1 (
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
fun IUpperBodyScreenPreview() {
    IUpperBodyScreen(rememberNavController())
}
