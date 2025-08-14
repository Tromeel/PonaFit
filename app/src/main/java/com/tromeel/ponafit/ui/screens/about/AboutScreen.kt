package com.tromeel.ponafit.ui.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.tromeel.ponafit.navigation.ROUT_HOME
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.ui.theme.Parple


@Composable
fun AboutScreen(navController: NavController){


    Column (
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = painterResource(R.drawable.darkbg), contentScale = ContentScale.FillBounds)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,



        ){


        Image(
            painter = painterResource(R.drawable.ponaw),
            contentDescription = "logo",
            modifier = Modifier
                .size(250.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop


        )
        Spacer(modifier = Modifier.height(10.dp) )

        Text(
            text = "About Us",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "PonaFit is your personal guide to staying active, recovering strong, and moving better—whether you’re at home, in the gym, or on the go. We combine expert-designed physiotherapy routines, functional workouts, and guided rehab plans to help you build strength, improve mobility, and prevent injury. Our mission is simple: to make fitness and recovery accessible, safe, and enjoyable for everyone. With PonaFit, every step you take is a step toward a healthier, stronger you.",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            color = Color.White




            )
        Spacer(modifier = Modifier.height(10.dp))

      IconButton(onClick = {
          navController.navigate(ROUT_HOME)

      }
      ) {
          Icon(Icons.Default.ArrowBack, contentDescription = "Back",Modifier.size(70.dp), tint = Color.White)
      }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Move well. Live well",
            fontSize = 20.sp,
            color = Color.White,


        )










    }



}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(navController= rememberNavController())
}