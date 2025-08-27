package com.tromeel.ponafit.ui.screens.rehab



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.data.DatabaseProvider
import com.tromeel.ponafit.navigation.ROUT_HISTORY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_REHAB
import com.tromeel.ponafit.repository.ExerciseRepository
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnkleFootRehabScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val dao = remember { DatabaseProvider.getDatabase(context).exerciseTrackingDao() }
    val repo = remember { ExerciseRepository(dao) }
    val vm = remember { ExerciseViewModel(repo) }

    val recoveryPeriods = mapOf(
        "0–2 Weeks" to listOf(
            mapOf("title" to "Ankle Pumps", "muscles" to "Calves, ankle", "benefits" to "Promotes circulation", "duration" to "15 reps, 3 sets", "safety" to "Move gently", "steps" to "Flex and point toes → Repeat slowly"),
            mapOf("title" to "Towel Scrunches", "muscles" to "Foot intrinsic muscles", "benefits" to "Strengthens toes and arch", "duration" to "10 reps, 3 sets", "safety" to "Do not strain toes", "steps" to "Place towel → Scrunch toes → Relax"),
            mapOf("title" to "Seated Heel Raises", "muscles" to "Calves", "benefits" to "Activates calf muscles safely", "duration" to "10 reps, 3 sets", "safety" to "Move slowly", "steps" to "Sit → Raise heels → Lower → Repeat"),
            mapOf("title" to "Alphabet Exercise", "muscles" to "Ankle muscles", "benefits" to "Improves ankle mobility", "duration" to "1 set", "safety" to "Avoid pain", "steps" to "Draw letters with toes → Repeat"),
            mapOf("title" to "Ankle Circles", "muscles" to "Ankle joint", "benefits" to "Increases mobility", "duration" to "10 reps each direction", "safety" to "Move gently", "steps" to "Rotate ankle clockwise → Counterclockwise → Repeat")
        ),
        "2–4 Weeks" to listOf(
            mapOf("title" to "Standing Heel Raises", "muscles" to "Calves, foot", "benefits" to "Strengthens calf and ankle", "duration" to "12 reps, 3 sets", "safety" to "Hold support if needed", "steps" to "Stand → Raise heels → Lower slowly"),
            mapOf("title" to "Toe Spreads", "muscles" to "Foot intrinsic muscles", "benefits" to "Improves balance and strength", "duration" to "10 reps, 3 sets", "safety" to "Do not overextend toes", "steps" to "Spread toes apart → Relax → Repeat"),
            mapOf("title" to "Ankle Inversion/Eversion", "muscles" to "Ankle muscles", "benefits" to "Strengthens lateral stabilizers", "duration" to "10 reps each direction, 2 sets", "safety" to "Move slowly", "steps" to "Rotate ankle inward → Outward → Repeat"),
            mapOf("title" to "Resisted Dorsiflexion", "muscles" to "Front shin, ankle", "benefits" to "Improves ankle control", "duration" to "10 reps, 2–3 sets", "safety" to "Use light resistance band", "steps" to "Pull toes toward you against band → Release → Repeat"),
            mapOf("title" to "Seated Toe Taps", "muscles" to "Foot, ankle", "benefits" to "Enhances coordination", "duration" to "15 reps, 2 sets", "safety" to "Move gently", "steps" to "Tap toes on floor → Repeat")
        ),
        "4–6 Weeks" to listOf(
            mapOf("title" to "Single-Leg Balance", "muscles" to "Ankle stabilizers", "benefits" to "Improves proprioception", "duration" to "30 sec each leg, 2 sets", "safety" to "Hold support if needed", "steps" to "Stand on one leg → Maintain balance → Switch"),
            mapOf("title" to "Calf Raises on Step", "muscles" to "Calves, Achilles tendon", "benefits" to "Strengthens lower leg", "duration" to "12 reps, 2–3 sets", "safety" to "Controlled motion", "steps" to "Step onto edge → Raise heels → Lower slowly"),
            mapOf("title" to "Theraband Inversion/Eversion", "muscles" to "Ankle stabilizers", "benefits" to "Adds resistance for strength", "duration" to "10 reps each, 2 sets", "safety" to "Use light band", "steps" to "Pull band inward/outward → Repeat"),
            mapOf("title" to "Toe Walking", "muscles" to "Calves, foot muscles", "benefits" to "Strengthens forefoot and balance", "duration" to "1 min, 2 sets", "safety" to "Do not rush", "steps" to "Walk on toes → Return → Repeat"),
            mapOf("title" to "Heel Walking", "muscles" to "Shins, ankle", "benefits" to "Strengthens anterior tibialis", "duration" to "1 min, 2 sets", "safety" to "Move slowly", "steps" to "Walk on heels → Return → Repeat")
        ),
        "6–8 Weeks" to listOf(
            mapOf("title" to "Single-Leg Calf Raise", "muscles" to "Calves, ankle", "benefits" to "Improves strength and balance", "duration" to "10 reps each leg, 2 sets", "safety" to "Hold support if needed", "steps" to "Stand on one leg → Raise heel → Lower → Repeat"),
            mapOf("title" to "Lateral Hops", "muscles" to "Foot, ankle, calves", "benefits" to "Dynamic stability", "duration" to "10 hops each side, 2 sets", "safety" to "Soft landing", "steps" to "Hop side to side → Repeat"),
            mapOf("title" to "Theraband Plantar Flexion", "muscles" to "Calf, ankle", "benefits" to "Strengthens Achilles tendon", "duration" to "10 reps, 2 sets", "safety" to "Controlled motion", "steps" to "Push foot down against band → Release → Repeat"),
            mapOf("title" to "Toe Curls with Towel", "muscles" to "Foot arch muscles", "benefits" to "Improves intrinsic foot strength", "duration" to "10 reps, 2 sets", "safety" to "Do not strain", "steps" to "Scrunch towel with toes → Release → Repeat"),
            mapOf("title" to "Balance Board Rocking", "muscles" to "Ankle stabilizers", "benefits" to "Enhances proprioception", "duration" to "1 min, 2 sets", "safety" to "Hold support", "steps" to "Rock board side to side → Forward/back → Repeat")
        ),
        "8+ Weeks" to listOf(
            mapOf("title" to "Single-Leg Hops", "muscles" to "Ankle, calves", "benefits" to "Advanced ankle stability", "duration" to "10 reps each leg, 2 sets", "safety" to "Soft landing, controlled", "steps" to "Hop on one leg → Land softly → Repeat"),
            mapOf("title" to "Resisted Ankle Circles", "muscles" to "Ankle", "benefits" to "Strengthens all directions", "duration" to "10 reps each way, 2 sets", "safety" to "Light resistance band", "steps" to "Rotate ankle against band → Repeat"),
            mapOf("title" to "Forward/Backward Hops", "muscles" to "Ankle, calves", "benefits" to "Improves dynamic control", "duration" to "10 reps, 2 sets", "safety" to "Soft landing", "steps" to "Hop forward/back → Repeat"),
            mapOf("title" to "Toe and Heel Raises Combo", "muscles" to "Calves, shins", "benefits" to "Strengthens entire lower leg", "duration" to "10 reps, 2 sets", "safety" to "Move slowly", "steps" to "Raise toes → Raise heels → Repeat"),
            mapOf("title" to "Bosu Ball Balance", "muscles" to "Ankle stabilizers", "benefits" to "Advanced proprioception", "duration" to "1 min, 2 sets", "safety" to "Hold support if needed", "steps" to "Stand on Bosu → Maintain balance → Repeat")
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ankle & Foot Rehab Exercises", color = Grin, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_REHAB) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Grin)
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Transparent)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Grin) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black) },
                    label = { Text("Home", color = Color.Black) },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0; navController.navigate(ROUT_HOME) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.History, contentDescription = "History", tint = Color.Black) },
                    label = { Text("History", color = Color.Black) },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1; navController.navigate(ROUT_HISTORY) }
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(R.drawable.greenbg),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "These exercises are designed to strengthen your ankle and foot during different recovery phases. Always follow your physiotherapist's guidance.",
                    fontSize = 18.sp,
                    color = Grin,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                recoveryPeriods.forEach { (period, exercises) ->
                    Text(
                        text = period,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Grin,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(exercises) { ex ->
                            StretchCard(
                                title = ex["title"]!!,
                                muscles = ex["muscles"]!!,
                                benefits = ex["benefits"]!!,
                                steps = ex["steps"]!!.split("→").map { it.trim() },
                                duration = ex["duration"]!!,
                                safetyTips = ex["safety"]!!,
                                mainCategory = "Rehab",
                                subCategory = "AnkleFootRehab",
                                onTrack = { name, dur, main, sub -> vm.trackExercise(name, dur, main, sub) },
                                onUndo = { name -> vm.removeExerciseFromHistory(name) },
                                vm = vm,
                                modifier = Modifier.width(250.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun StretchCard2(
    title: String,
    muscles: String,
    benefits: String,
    steps: List<String>,
    duration: String,
    safetyTips: String,
    mainCategory: String,
    subCategory: String,
    onTrack: (String, String, String, String) -> Unit,
    onUndo: (String) -> Unit,
    vm: ExerciseViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(300.dp)
            .paint(
                painter = painterResource(R.drawable.darkbg),
                contentScale = ContentScale.FillBounds,
                alpha = 0.85f
            ),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
                Text("Muscles: $muscles", fontSize = 14.sp, color = Color.White)
                Text("Benefits: $benefits", fontSize = 14.sp, color = Color.White)
                Text("Duration: $duration", fontSize = 14.sp, color = Color.White)
                Text("Safety: $safetyTips", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Steps:", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color.White)
                steps.forEach { step ->
                    Text("• $step", fontSize = 14.sp, color = Color.White)
                }
            }

            val isTracked by vm.isExerciseTracked(title).collectAsState(initial = false)
            Button(
                onClick = {
                    if (isTracked) onUndo(title) else onTrack(title, duration, mainCategory, subCategory)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = if (isTracked) Color.Gray else Grin)
            ) {
                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Check, contentDescription = "Mark as Done", tint = Color.Black)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = if (isTracked) "Done" else "Mark as Done", color = Color.Black)
                }
            }
        }
    }
}

@Composable
@Preview
fun AnkleFootRehabScreenPreview() {
    AnkleFootRehabScreen(rememberNavController())
}
