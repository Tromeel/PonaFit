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
fun ALowerBodyScreen(navController: NavController) {
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
                        text = "Advanced Lower Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Take your leg training to the next level with these advanced lower-body workouts at home. These exercises improve explosive power, single-leg strength, balance, and muscular endurance—perfect for athletes and fitness enthusiasts.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Advanced Lower Body Workout List
                    LowerBodyWorkoutCard2(
                        title = "Pistol Squats",
                        description = "A challenging single-leg squat that builds extreme strength and balance.",
                        steps = listOf(
                            "Stand on one leg with the other extended forward.",
                            "Lower into a squat while keeping the extended leg off the floor.",
                            "Go as low as possible without losing balance.",
                            "Push back up through the heel."
                        ),
                        sets = "3 sets",
                        reps = "6–8 reps each leg"
                    )

                    LowerBodyWorkoutCard2(
                        title = "Jumping Lunges",
                        description = "An explosive plyometric move to build power and endurance.",
                        steps = listOf(
                            "Start in a lunge position.",
                            "Explosively jump upward, switching legs mid-air.",
                            "Land softly in a lunge on the opposite leg.",
                            "Repeat immediately."
                        ),
                        sets = "3 sets",
                        reps = "12–16 alternating reps"
                    )

                    LowerBodyWorkoutCard2(
                        title = "Single-Leg Romanian Deadlifts",
                        description = "Builds hamstring and glute strength while challenging balance.",
                        steps = listOf(
                            "Stand on one leg with the other extended behind you.",
                            "Hinge forward at the hips, keeping your back straight.",
                            "Lower until your torso is parallel to the ground.",
                            "Return to standing by squeezing your glutes."
                        ),
                        sets = "3 sets",
                        reps = "10 reps each leg"
                    )

                    LowerBodyWorkoutCard2(
                        title = "Skater Jumps",
                        description = "Lateral plyometric exercise for glutes and stability.",
                        steps = listOf(
                            "Start standing on one leg.",
                            "Jump sideways to land on the opposite leg.",
                            "Swing arms for momentum.",
                            "Land softly and repeat side-to-side."
                        ),
                        sets = "3 sets",
                        reps = "12–14 reps each side"
                    )

                    LowerBodyWorkoutCard2(
                        title = "Wall Sit with Single-Leg Extension",
                        description = "Isometric strength hold with added difficulty.",
                        steps = listOf(
                            "Sit against a wall with thighs parallel to the ground.",
                            "Lift one leg straight out while holding the position.",
                            "Hold for 10–15 seconds before switching legs."
                        ),
                        sets = "3 sets",
                        reps = "2–3 holds per leg"
                    )

                    LowerBodyWorkoutCard2(
                        title = "Broad Jumps",
                        description = "Improves leg power and explosiveness.",
                        steps = listOf(
                            "Stand with feet shoulder-width apart.",
                            "Swing arms back and jump forward as far as possible.",
                            "Land softly with bent knees.",
                            "Reset and repeat."
                        ),
                        sets = "3 sets",
                        reps = "8–10 jumps"
                    )

                    LowerBodyWorkoutCard2(
                        title = "Shrimp Squats",
                        description = "A demanding bodyweight squat variation for balance and quad strength.",
                        steps = listOf(
                            "Stand on one leg and hold the ankle of the opposite leg behind you.",
                            "Lower into a squat while keeping your back straight.",
                            "Touch the rear knee lightly to the ground.",
                            "Push back up through the standing leg."
                        ),
                        sets = "3 sets",
                        reps = "5–8 reps each leg"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card Composable (same as before)
@Composable
fun LowerBodyWorkoutCard2(
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
fun ALowerBodyScreenPreview() {
    ALowerBodyScreen(rememberNavController())
}
