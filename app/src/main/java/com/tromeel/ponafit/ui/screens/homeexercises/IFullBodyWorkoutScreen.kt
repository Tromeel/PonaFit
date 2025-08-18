package com.tromeel.ponafit.ui.screens.homeexercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_DIFFICULTY1
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun IFullBodyWorkoutScreen(navController: NavController) {
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
                        onClick = { navController.navigate(ROUT_DIFFICULTY1) },
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

                    // Title
                    Text(
                        text = "Intermediate Full Body Workouts",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))


                    Text(
                        text = "Intermediate full-body workouts are a great way to build strength, improve fitness, and stay active without needing equipment. These exercises focus on all major muscle groups, helping you improve balance, flexibility, and endurance from the comfort of your home.",
                        fontSize = 20.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // Workout List
                    IntermediateWorkoutCard(
                        title = "Burpees",
                        description = "A full-body exercise for strength and cardio.",
                        steps = listOf(
                            "Start standing tall with feet shoulder-width apart.",
                            "Drop into a squat, place hands on the floor.",
                            "Kick feet back into a push-up position.",
                            "Do one push-up, then jump back up explosively."
                        ),
                        sets = "4 sets",
                        reps = "10–12 reps"
                    )

                    IntermediateWorkoutCard(
                        title = "Jump Squats",
                        description = "Builds explosive power in legs and glutes.",
                        steps = listOf(
                            "Stand with feet shoulder-width apart.",
                            "Perform a squat keeping chest upright.",
                            "Push through your heels and jump explosively.",
                            "Land softly and go right into the next rep."
                        ),
                        sets = "4 sets",
                        reps = "12–15 reps"
                    )

                    IntermediateWorkoutCard(
                        title = "Decline Push-Ups",
                        description = "Targets upper chest and shoulders.",
                        steps = listOf(
                            "Place your feet on a raised surface like a chair.",
                            "Hands on the ground, slightly wider than shoulders.",
                            "Lower your chest toward the ground.",
                            "Push back up while keeping body aligned."
                        ),
                        sets = "4 sets",
                        reps = "10–15 reps"
                    )

                    IntermediateWorkoutCard(
                        title = "Side Plank with Hip Dips",
                        description = "Strengthens core, obliques, and stabilizers.",
                        steps = listOf(
                            "Lie on your side with elbow under shoulder.",
                            "Lift hips into a straight line position.",
                            "Lower hips slightly toward the ground.",
                            "Raise them back up and repeat."
                        ),
                        sets = "3 sets",
                        reps = "12 reps each side"
                    )

                    IntermediateWorkoutCard(
                        title = "Bulgarian Split Squats",
                        description = "Single-leg exercise for balance and strength.",
                        steps = listOf(
                            "Stand a few feet in front of a bench or chair.",
                            "Place one foot on the bench behind you.",
                            "Lower your hips until front thigh is parallel.",
                            "Push through front heel to rise back up."
                        ),
                        sets = "3 sets",
                        reps = "10–12 reps each leg"
                    )

                    IntermediateWorkoutCard(
                        title = "Pike Push-Ups",
                        description = "Focuses on shoulders and upper body strength.",
                        steps = listOf(
                            "Start in a downward dog position.",
                            "Hands shoulder-width apart, hips raised high.",
                            "Lower head toward the ground by bending elbows.",
                            "Push back up to the start position."
                        ),
                        sets = "3 sets",
                        reps = "8–12 reps"
                    )

                    IntermediateWorkoutCard(
                        title = "Bicycle Crunches",
                        description = "Core workout targeting abs and obliques.",
                        steps = listOf(
                            "Lie flat on your back with hands behind your head.",
                            "Lift knees to a tabletop position.",
                            "Bring right elbow toward left knee while extending right leg.",
                            "Switch sides in a pedaling motion."
                        ),
                        sets = "3 sets",
                        reps = "15–20 reps each side"
                    )

                    IntermediateWorkoutCard(
                        title = "Plank to Shoulder Tap",
                        description = "Improves stability and core strength.",
                        steps = listOf(
                            "Start in a high plank with hands under shoulders.",
                            "Lift one hand and tap the opposite shoulder.",
                            "Alternate sides while keeping hips steady.",
                            "Engage your core throughout."
                        ),
                        sets = "3 sets",
                        reps = "12–16 reps each side"
                    )
                }
            }
        }
    )
}

// ✅ Reusable Workout Card Design (with darkbg background)
@Composable
fun IntermediateWorkoutCard(
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
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(R.drawable.darkbg), // background image
                    contentScale = ContentScale.Crop
                )
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
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

                // Steps list
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
                    Text(
                        text = "Sets: $sets",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Reps: $reps",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun IntermediateScreenPreview() {
    IFullBodyWorkoutScreen(rememberNavController())
}
