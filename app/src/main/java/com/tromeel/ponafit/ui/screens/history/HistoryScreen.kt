package com.tromeel.ponafit.ui.screens.history

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    var selectedIndex by remember { mutableStateOf(1) }
    val history = vm.allTracking.collectAsState()

    val groupedHistory = remember(history.value) { groupExercises(history.value) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exercise History", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Grin,
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Grin) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
                    label = { Text("Home", color = Color.White) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White) },
                    label = { Text("Profile", color = Color.White) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 }
                )
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.greenbg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

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
            .padding(vertical = 4.dp)
            .border(2.dp, Color.White, RoundedCornerShape(8.dp)), // White border
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Grin)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(title, style = MaterialTheme.typography.titleLarge, color = Color.White)
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = null,
                        tint = Color.White
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .border(1.5.dp, Color.White, RoundedCornerShape(6.dp)), // White border
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(containerColor = Grin)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(title, style = MaterialTheme.typography.titleMedium, color = Color.White)
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
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
            .padding(start = 32.dp, bottom = 6.dp)
            .border(1.dp, Color.White, RoundedCornerShape(6.dp)), // White border
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Grin)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(item.exerciseName, style = MaterialTheme.typography.bodyLarge, color = Color.White)
            Text("Duration: ${item.duration}", style = MaterialTheme.typography.bodySmall, color = Color.White)
            Text(
                "Completed at: ${
                    SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
                        .format(Date(item.completedAt))
                }",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
    }
}

fun groupExercises(history: List<ExerciseTrackingEntity>): Map<String, Map<String, List<ExerciseTrackingEntity>>> {
    return history
        .groupBy { it.mainCategory }
        .mapValues { (_, items) ->
            items.groupBy { it.subCategory }
        }
}
