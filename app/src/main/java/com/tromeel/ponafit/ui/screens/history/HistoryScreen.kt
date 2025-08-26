package com.tromeel.ponafit.ui.screens.history

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.model.ExerciseTrackingEntity
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navController: NavController,
    vm: ExerciseViewModel
) {
    var selectedIndex by remember { mutableStateOf(1) } // bottom bar
    val history = vm.allTracking.collectAsState()

    // Grouped by categories → subcategories
    val groupedHistory = remember(history.value) {
        groupExercises(history.value)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercise History", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Grin,
                    titleContentColor = Color.Black
                )
            )
        },
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
                if (history.value.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No exercises completed yet.", color = Color.White)
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(8.dp)
                    ) {
                        groupedHistory.forEach { (category, subcategories) ->
                            item {
                                ExpandableCategory(
                                    title = category,
                                    subcategories = subcategories
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ExpandableCategory(
    title: String,
    subcategories: Map<String, List<ExerciseTrackingEntity>>
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(title, style = MaterialTheme.typography.titleLarge)
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = null
                    )
                }
            }

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column {
                    subcategories.forEach { (sub, exercises) ->
                        ExpandableSubCategory(sub, exercises)
                    }
                }
            }
        }
    }
}

@Composable
fun ExpandableSubCategory(
    title: String,
    exercises: List<ExerciseTrackingEntity>
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = null
                )
            }
        }

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column {
                exercises.forEach { item ->
                    ExerciseHistoryItem(item)
                }
            }
        }
    }
}

@Composable
fun ExerciseHistoryItem(item: ExerciseTrackingEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, bottom = 6.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(item.exerciseName, style = MaterialTheme.typography.bodyLarge)
            Text("Duration: ${item.duration}", style = MaterialTheme.typography.bodySmall)
            Text(
                "Completed at: ${
                    SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
                        .format(Date(item.completedAt))
                }",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

/**
 * Groups exercises into main categories and subcategories
 */
fun groupExercises(history: List<ExerciseTrackingEntity>): Map<String, Map<String, List<ExerciseTrackingEntity>>> {
    val categories = mapOf(
        "Home Exercises" to listOf("Full Body Workouts", "Upper Body Workouts", "Lower Body Workouts", "Abs Workouts"),
        "Gym Exercises" to listOf("Full Body Workouts", "Upper Body Workouts", "Lower Body Workouts", "Abs Workouts"),
        "Stretching Exercises" to listOf("Full Body Stretching", "Upper Body Stretching", "Lower Body Stretching", "Dynamic Warmups", "Cooldown"),
        "Rehab" to listOf("Knee Rehab", "Shoulder Rehab", "Lower Back Rehab", "Ankle Rehab", "Hip Rehab", "Wrist Rehab", "Neck Rehab")
    )

    return categories.mapValues { (cat, subs) ->
        subs.associateWith { sub ->
            history.filter { it.exerciseName.contains(sub, ignoreCase = true) }
        }
    }
}
