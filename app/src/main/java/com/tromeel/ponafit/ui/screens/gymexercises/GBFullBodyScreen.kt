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
import com.tromeel.ponafit.navigation.ROUT_GFDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GBFullBodyScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_GFDIFFICULTY) },
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
                        text = "Beginner Full Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Start your fitness journey with these simple yet effective full-body workouts. Designed for beginners at the gym to build strength, improve endurance, and boost confidence.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Beginner Gym Full Body Workouts (7 Exercises)
                    GymBeginnerWorkoutCard(
                        title = "Leg Press",
                        description = "Great for building leg strength without needing balance.",
                        steps = listOf(
                            "Sit on the machine with your back flat.",
                            "Place your feet shoulder-width apart on the platform.",
                            "Push the platform up and release the safety.",
                            "Lower slowly until knees are at 90°, then push back up."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard(
                        title = "Lat Pulldown",
                        description = "Targets your back and arms effectively.",
                        steps = listOf(
                            "Sit at the pulldown machine and grip the bar slightly wider than shoulders.",
                            "Pull the bar down to your chest.",
                            "Control the bar as you return it slowly upward.",
                            "Keep your back straight throughout."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard(
                        title = "Chest Press Machine",
                        description = "Safe way to work your chest and triceps.",
                        steps = listOf(
                            "Sit on the machine with back against the pad.",
                            "Grip the handles at chest level.",
                            "Push the handles forward until arms are extended.",
                            "Return slowly with control."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard(
                        title = "Dumbbell Shoulder Press",
                        description = "Strengthens shoulders and improves posture.",
                        steps = listOf(
                            "Sit on a bench with dumbbells at shoulder height.",
                            "Press the dumbbells upward until arms are straight.",
                            "Lower back down slowly.",
                            "Keep core engaged."
                        ),
                        sets = "3 sets",
                        reps = "8–10 reps"
                    )

                    GymBeginnerWorkoutCard(
                        title = "Seated Row Machine",
                        description = "Strengthens back, biceps, and improves posture.",
                        steps = listOf(
                            "Sit with feet on the footrests and grip the handles.",
                            "Pull the handles towards your torso.",
                            "Squeeze your shoulder blades together.",
                            "Slowly return to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBeginnerWorkoutCard(
                        title = "Leg Curl Machine",
                        description = "Works your hamstrings safely while seated or lying down.",
                        steps = listOf(
                            "Adjust the machine to fit your legs comfortably.",
                            "Place ankles under the padded lever.",
                            "Curl your legs back as far as possible.",
                            "Return slowly to starting position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    // 🔄 Replaced Plank Hold with Cable Woodchopper
                    GymBeginnerWorkoutCard(
                        title = "Cable Woodchopper",
                        description = "Excellent core exercise using the cable machine to build rotational strength.",
                        steps = listOf(
                            "Set the cable handle to shoulder height.",
                            "Stand sideways to the machine with feet shoulder-width apart.",
                            "Grip the handle with both hands and pull it diagonally across your body.",
                            "Slowly return to the starting position with control."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps each side"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card for Gym Workouts
@Composable
fun GymBeginnerWorkoutCard(
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
fun GBFullBodyScreenPreview() {
    GBFullBodyScreen(rememberNavController())
}
