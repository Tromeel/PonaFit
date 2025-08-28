package com.tromeel.ponafit.ui.screens.physio

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tromeel.ponafit.R
import com.tromeel.ponafit.navigation.ROUT_ADD_PHYSIO
import com.tromeel.ponafit.navigation.ROUT_PHYSIO_LIST
import com.tromeel.ponafit.viewmodel.PhysioViewModel

// Define your custom color
val Grin = Color(0xFF2E7D32) // Green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPhysioScreen(navController: NavController, viewModel: PhysioViewModel) {
    var name by remember { mutableStateOf("") }
    var fee by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var showMenu by remember { mutableStateOf(false) }

    val context = LocalContext.current

    // Image Picker Launcher
    val imagePicker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            imageUri = it
            Log.d("ImagePicker", "Selected image URI: $it")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Physiotherapist", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Grin),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { showMenu = true }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menu", tint = Color.White)
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Physiotherapists List") },
                            onClick = {
                                navController.navigate(ROUT_PHYSIO_LIST)
                                showMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Add Physiotherapist") },
                            onClick = {
                                navController.navigate(ROUT_ADD_PHYSIO)
                                showMenu = false
                            }
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        content = { paddingValues ->
            // Background image
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Image(
                    painter = painterResource(R.drawable.greenbg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Common colors for all text fields

                    val textFieldColors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Grin,
                        unfocusedBorderColor = Color.Gray,
                        focusedLabelColor = Grin,
                        unfocusedLabelColor = Color.Gray,
                        cursorColor = Grin,
                        focusedLeadingIconColor = Grin,
                        unfocusedLeadingIconColor = Color.Gray,
                        focusedTrailingIconColor = Grin,
                        unfocusedTrailingIconColor = Color.Gray,
                        focusedPlaceholderColor = Grin.copy(alpha = 0.7f),
                        unfocusedPlaceholderColor = Color.Gray
                    )
                    // Physiotherapist Name
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Full Name") },
                        leadingIcon = { Icon(painter = painterResource(R.drawable.name), contentDescription = "name") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = textFieldColors
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Consultation Fee
                    OutlinedTextField(
                        value = fee,
                        onValueChange = { fee = it },
                        label = { Text("Consultation Fee") },
                        leadingIcon = { Icon(painter = painterResource(R.drawable.price), contentDescription = "Fee") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = textFieldColors
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Phone Number
                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone Number") },
                        leadingIcon = { Icon(painter = painterResource(R.drawable.phone), contentDescription = "phone") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = textFieldColors
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Profile Photo Picker
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                            .clickable { imagePicker.launch("image/*") },
                        contentAlignment = Alignment.Center
                    ) {
                        if (imageUri != null) {
                            Image(
                                painter = rememberAsyncImagePainter(model = imageUri),
                                contentDescription = "Selected Profile Image",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(painter = painterResource(R.drawable.image), contentDescription = "Pick Image")
                                Text("Tap to pick profile photo", color = Color.DarkGray)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Add Physiotherapist Button
                    Button(
                        onClick = {
                            val feeValue = fee.toDoubleOrNull()
                            if (feeValue != null) {
                                imageUri?.toString()?.let { viewModel.addPhysio(name, feeValue, phone, it) }
                                navController.popBackStack()
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Grin)
                    ) {
                        Text("Add Physiotherapist", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }
    )
}

// Bottom Navigation Bar Component
@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Grin,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUT_PHYSIO_LIST) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Physiotherapists List", tint = Color.White) },
            label = { Text("Home", color = Color.White) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUT_ADD_PHYSIO) },
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "Add Physiotherapist", tint = Color.White) },
            label = { Text("Add", color = Color.White) }
        )
    }
}
