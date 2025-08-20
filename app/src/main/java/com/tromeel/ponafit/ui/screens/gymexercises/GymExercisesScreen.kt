package com.tromeel.ponafit.ui.screens.gymexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_DASHBOARD
import com.tromeel.ponafit.navigation.ROUT_GCDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_GFDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_GLDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_GUDIFFICULTY
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin


@Composable
fun GymExercisesScreen(navController: NavController){
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Grin
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home",tint = Color.Black) },
                    label = { Text("Home",color = Color.Black) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile",tint = Color.Black) },
                    label = { Text("Profile",color = Color.Black) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 }
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    // Remove top padding so card touches top
                    .padding(
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(R.drawable.greenbg),
                        contentScale = ContentScale.FillBounds
                    )
            ) {
                //Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                    shape = RoundedCornerShape(bottomStart = 60.dp),
                    colors = CardDefaults.cardColors(Grin)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        IconButton(
                            onClick = {navController.navigate(ROUT_HOME) }
                        ) {

                            IconButton(onClick = { navController.navigate(ROUT_DASHBOARD) }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )


                            }

                        }

                        Spacer(modifier = Modifier.height(20.dp)) // ✅ Space between arrow and title

                        Text(
                            text = "Gym Exercises",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,

                            )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Requires Gym Equipment",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 20.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Maximize your strength and endurance with guided gym exercises using machines, free weights, and professional equipment.",
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp),
                            color = Color.White
                        )
                    }
                }
                //End of Card

                Spacer(modifier = Modifier.height(15.dp))


                Text(
                    text = "Exercise Categories",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 20.dp),
                    fontWeight = FontWeight.Bold,
                    color = Grin
                )

                Spacer(modifier = Modifier.height(15.dp))


                Row (
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .horizontalScroll(rememberScrollState())  //SCROLL

                ){
                    //Start of card
                    Card(
                        onClick = {navController.navigate(ROUT_GFDIFFICULTY)},
                        modifier = Modifier
                            .width(200.dp)
                            .height(300.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp)
                        //colors = CardDefaults.
                    ) {
                        Box{
                            Image(
                                painter = painterResource(R.drawable.darkbg),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,

                                ) {
                                Image(
                                    painter = painterResource(R.drawable.fullbody),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Full-Body Workouts",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Boost strength, improve balance, and burn calories with workouts that target all major muscle groups in one session.",
                                    fontSize = 15.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(start = 10.dp, end = 10.dp),


                                    )

                            }

                        }
                    }
                    //End of card
                    Spacer(modifier = Modifier.width(10.dp))

                    //Start of card
                    Card(
                        onClick = {navController.navigate(ROUT_GUDIFFICULTY)},
                        modifier = Modifier
                            .width(200.dp)
                            .height(300.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp)
                        //colors = CardDefaults.
                    ) {
                        Box{
                            Image(
                                painter = painterResource(R.drawable.darkbg),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,

                                ) {
                                Image(
                                    painter = painterResource(R.drawable.upperbody),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Upper-Body Strength",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Build strength and definition in your arms, shoulders, chest, and back with focused upper body training.",
                                    fontSize = 15.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(start = 10.dp, end = 10.dp),


                                    )

                            }

                        }
                    }
                    //End of card
                    Spacer(modifier = Modifier.width(10.dp))

                    //Start of card
                    Card(
                        onClick = {navController.navigate(ROUT_GLDIFFICULTY)},
                        modifier = Modifier
                            .width(200.dp)
                            .height(300.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp)
                        //colors = CardDefaults.
                    ) {
                        Box{
                            Image(
                                painter = painterResource(R.drawable.darkbg),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,

                                ) {
                                Image(
                                    painter = painterResource(R.drawable.lowerbody),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Lower Body Power",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Strengthen and tone your legs, glutes, and hips with powerful lower body exercises for balance and stability.",
                                    fontSize = 15.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(start = 10.dp, end = 10.dp),


                                    )

                            }

                        }
                    }
                    //End of card
                    Spacer(modifier = Modifier.width(10.dp))

                    //Start of card
                    Card(
                        onClick = {navController.navigate(ROUT_GCDIFFICULTY)},
                        modifier = Modifier
                            .width(200.dp)
                            .height(300.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp)
                        //colors = CardDefaults.
                    ) {
                        Box{
                            Image(
                                painter = painterResource(R.drawable.darkbg),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )


                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,

                                ) {
                                Image(
                                    painter = painterResource(R.drawable.core),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Core and Abs",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Build a strong, stable core and sculpt your abs with targeted workouts for strength and definition.",
                                    fontSize = 15.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(start = 10.dp, end = 10.dp),


                                    )

                            }

                        }
                    }
                    //End of card
                    Spacer(modifier = Modifier.width(10.dp))





                }

            }
        }
    )
    //End of Scaffold


}

@Preview
@Composable
fun GymExercisesScreenPreview(){
    GymExercisesScreen(rememberNavController())
}