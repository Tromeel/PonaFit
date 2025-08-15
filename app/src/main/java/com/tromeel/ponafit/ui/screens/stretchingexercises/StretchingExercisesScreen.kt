package com.tromeel.ponafit.ui.screens.stretchingexercises

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
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin


@Composable
fun StretchingExercisesScreen(navController: NavController){
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
                            onClick = { }
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
                            text = "Stretching and Mobility",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,

                            )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Enables one to Stretch and Move freely",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 20.dp),
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Stretching and mobility exercises improve flexibility, reduce stiffness, and keep your joints moving smoothly.\n",
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
                        onClick = {},
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
                                    painter = painterResource(R.drawable.fullstretch),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Full-Body Stretching",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Full-body stretching helps improve flexibility, release tension, and keep your entire body feeling loose and balanced.\n",
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
                        onClick = {},
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
                                    painter = painterResource(R.drawable.upperstretch),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Upper-Body Mobility",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Upper-body mobility exercises improve shoulder, arm, and back movement, enhancing flexibility and posture.\n",
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
                        onClick = {},
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
                                    painter = painterResource(R.drawable.lowerstretch),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Lower-Body Mobility",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Lower-body mobility exercises boost hip, knee, and ankle flexibility, improving movement and stability.\n",
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
                        onClick = {},
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
                                    painter = painterResource(R.drawable.warmup),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Dynamic Warm-ups",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Dynamic warm-ups use active movements to increase blood flow, loosen muscles, and prepare your body for exercise.\n",
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
                        onClick = {},
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
                                    painter = painterResource(R.drawable.cooldown),
                                    contentDescription = "shirt1",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                Text(
                                    text = "Cool-Down Stretches",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,

                                    )
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = "Cooldown stretches help relax muscles, improve flexibility, and promote recovery after exercise.\n",
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
fun StretchingExercisesScreenPreview(){
    StretchingExercisesScreen(rememberNavController())
}