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
import com.tromeel.ponafit.navigation.ROUT_GUDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GBLowerBodyScreen(navController: NavController) {
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
                        text = "Beginner Lower Body Workouts (Gym)",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "These beginner-friendly lower body workouts use basic gym machines and weights. They are designed to build strength, improve stability, and increase endurance safely for new lifters.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // ✅ Beginner Lower Body Workouts
                    GymBLCard(
                        title = "Leg Press (Machine)",
                        description = "Strengthens quads, hamstrings, and glutes with controlled range.",
                        steps = listOf(
                            "Sit on the leg press machine with feet shoulder-width on the platform.",
                            "Push the platform upward until legs are extended but not locked.",
                            "Lower slowly until knees are at 90 degrees.",
                            "Press back up with control."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard(
                        title = "Bodyweight or Assisted Squats",
                        description = "Great for beginners to learn squat movement safely.",
                        steps = listOf(
                            "Stand with feet shoulder-width apart.",
                            "Hold onto a support or use a Smith machine bar for balance.",
                            "Lower hips down as if sitting in a chair.",
                            "Push back up through heels."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard(
                        title = "Leg Curl (Machine)",
                        description = "Isolates and strengthens hamstrings.",
                        steps = listOf(
                            "Sit or lie on the leg curl machine.",
                            "Hook ankles under padded lever.",
                            "Curl legs back as far as possible.",
                            "Slowly return to start position."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard(
                        title = "Leg Extension (Machine)",
                        description = "Focuses on building quad strength.",
                        steps = listOf(
                            "Sit on the leg extension machine with shins under padded bar.",
                            "Extend legs forward until straight.",
                            "Hold for 1–2 seconds at the top.",
                            "Lower slowly back down."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps"
                    )

                    GymBLCard(
                        title = "Glute Bridges (Weighted Optional)",
                        description = "Activates glutes and strengthens hips.",
                        steps = listOf(
                            "Lie on your back with knees bent and feet flat.",
                            "Place barbell or weight plate across hips if desired.",
                            "Lift hips upward until body forms a straight line.",
                            "Lower slowly back down."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    GymBLCard(
                        title = "Standing Calf Raises (Machine)",
                        description = "Builds calf muscles and ankle strength.",
                        steps = listOf(
                            "Stand on calf raise machine with toes on platform.",
                            "Lower heels below platform level.",
                            "Push up onto toes and squeeze calves.",
                            "Slowly return down."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )

                    GymBLCard(
                        title = "Hip Abduction (Machine)",
                        description = "Strengthens outer thighs and glutes.",
                        steps = listOf(
                            "Sit on the hip abduction machine with legs inside pads.",
                            "Push legs outward slowly.",
                            "Hold for 1–2 seconds.",
                            "Return with control."
                        ),
                        sets = "3 sets",
                        reps = "12–15 reps"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Card with Background Image
@Composable
fun GymBLCard(
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
fun GBLowerBodyScreenPreview() {
    GBLowerBodyScreen(rememberNavController())
}
