package com.tromeel.ponafit.ui.screens.gymexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.tromeel.ponafit.navigation.ROUT_ACCOUNT
import com.tromeel.ponafit.navigation.ROUT_GAFULLBODY
import com.tromeel.ponafit.navigation.ROUT_GALOWERBODY
import com.tromeel.ponafit.navigation.ROUT_GAUPPERBODY
import com.tromeel.ponafit.navigation.ROUT_GBFULLBODY
import com.tromeel.ponafit.navigation.ROUT_GBLOWERBODY
import com.tromeel.ponafit.navigation.ROUT_GBUPPERBODY
import com.tromeel.ponafit.navigation.ROUT_GIFULLBODY
import com.tromeel.ponafit.navigation.ROUT_GILOWERBODY
import com.tromeel.ponafit.navigation.ROUT_GIUPPERBODY
import com.tromeel.ponafit.navigation.ROUT_GYMEXERCISES
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.navigation.ROUT_HOMEEXERCISES
import com.tromeel.ponafit.ui.theme.Grin

@Composable
fun GLDifficultyScreen(navController: NavController) {
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
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Profile", tint = Color.Black) },
                    label = { Text("Actions", color = Color.Black) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_ACCOUNT)}
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
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
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    IconButton(
                        onClick = { navController.navigate(ROUT_GYMEXERCISES) },
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

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text = "Choose Your Difficulty",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Grin,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Select a difficulty level that matches your fitness and progress at your own pace—start easy, challenge yourself, and move up when ready.",
                        fontSize = 15.sp,
                        color = Grin,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        BCard2(navController)
                        ICard2(navController)
                        ACard2(navController)
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Move well. Live Well",
                        fontSize = 20.sp,
                        color = Grin,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 20.dp)
                    )
                }
            }
        }
    )
}

// ✅ Beginner Card
@Composable
fun BCard2(navController: NavController) {
    Card(
        onClick = { navController.navigate(ROUT_GBLOWERBODY) },
        modifier = Modifier
            .width(250.dp)
            .height(400.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.beginner),
                    contentDescription = "Beginner Workouts",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Beginner Workouts",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Simple full-body movements to build strength, flexibility, and confidence at home.",
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// ✅ Intermediate Card
@Composable
fun ICard2(navController: NavController) {
    Card(
        onClick = { navController.navigate(ROUT_GILOWERBODY) },
        modifier = Modifier
            .width(250.dp)
            .height(400.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.medium),
                    contentDescription = "Intermediate Workouts",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Intermediate Workouts",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Take it up a notch with more challenging routines to build endurance and power.",
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// ✅ Advanced Card
@Composable
fun ACard2(navController: NavController) {
    Card(
        onClick = { navController.navigate(ROUT_GALOWERBODY) },
        modifier = Modifier
            .width(250.dp)
            .height(400.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.darkbg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.advanced),
                    contentDescription = "Advanced Workouts",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Advanced Workouts",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Push your limits with high-intensity exercises designed for strength and endurance.",
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GLDifficultyScreenPreview() {
    GLDifficultyScreen(rememberNavController())
}
