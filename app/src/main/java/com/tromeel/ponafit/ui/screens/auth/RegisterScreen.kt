package com.tromeel.ponafit.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextFieldDefaults.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.tromeel.ponafit.R
import com.tromeel.ponafit.model.User
import com.tromeel.ponafit.navigation.ROUT_LOGIN
import com.tromeel.ponafit.ui.theme.Grin
import com.tromeel.ponafit.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onRegisterSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val dropdownMenuPurpleColor = Color(0xFF6200EA)
    val contentColor = Color.White

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Full screen background image
        Image(
            painter = painterResource(R.drawable.darkbg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Scrollable form content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.pona),
                contentDescription = "PonaFit Logo",
                modifier = Modifier
                    .padding(16.dp)
                    .size(width = 150.dp, height = 75.dp)
            )
            //lotiie

            val composition by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(R.raw.register)
            )
            val progress by animateLottieCompositionAsState(composition)

            LottieAnimation(
                composition, progress,
                modifier = Modifier.size(width = 200.dp, height = 100.dp)
            )

            AnimatedVisibility(
                visible = true,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    "Sign Up",
                    fontSize = 32.sp,
                    fontFamily = FontFamily.Cursive,
                    color = contentColor
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Username
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username", color = contentColor.copy(alpha = 0.7f)) },
                leadingIcon = {
                    Icon(Icons.Filled.Person, contentDescription = null, tint = contentColor)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = contentColor.copy(alpha = 0.5f),
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = contentColor.copy(alpha = 0.7f),
                    cursorColor = contentColor,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = contentColor.copy(alpha = 0.7f),
                    focusedTextColor = contentColor,
                    unfocusedTextColor = contentColor
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = contentColor.copy(alpha = 0.7f)) },
                leadingIcon = {
                    Icon(Icons.Filled.Email, contentDescription = null, tint = contentColor)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = contentColor.copy(alpha = 0.5f),
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = contentColor.copy(alpha = 0.7f),
                    cursorColor = contentColor,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = contentColor.copy(alpha = 0.7f),
                    focusedTextColor = contentColor,
                    unfocusedTextColor = contentColor
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Role dropdown
            var role by remember { mutableStateOf("User") }
            val roleOptions = listOf("User", "Admin")
            var expanded by remember { mutableStateOf(false) }

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = role,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Select Role", color = contentColor.copy(alpha = 0.7f)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = contentColor.copy(alpha = 0.5f),
                        focusedTextColor = contentColor,
                        unfocusedTextColor = contentColor,
                        focusedTrailingIconColor = Color.White,
                        unfocusedTrailingIconColor = contentColor.copy(alpha = 0.7f),
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = contentColor.copy(alpha = 0.7f),
                        cursorColor = contentColor
                    )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.background(Grin)
                ) {
                    roleOptions.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(selectionOption, color = Color.White) },
                            onClick = {
                                role = selectionOption
                                expanded = false
                            },
                            colors = MenuDefaults.itemColors(textColor = Color.White)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = contentColor.copy(alpha = 0.7f)) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null, tint = contentColor) },
                trailingIcon = {
                    val image = if (passwordVisible) painterResource(R.drawable.passwordshow) else painterResource(R.drawable.passwordhide)
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(image, contentDescription = null, tint = contentColor)
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = contentColor.copy(alpha = 0.5f),
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = contentColor.copy(alpha = 0.7f),
                    cursorColor = contentColor,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = contentColor.copy(alpha = 0.7f),
                    focusedTrailingIconColor = Color.White,
                    unfocusedTrailingIconColor = contentColor.copy(alpha = 0.7f),
                    focusedTextColor = contentColor,
                    unfocusedTextColor = contentColor
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Confirm Password
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password", color = contentColor.copy(alpha = 0.7f)) },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null, tint = contentColor) },
                trailingIcon = {
                    val image = if (confirmPasswordVisible) painterResource(R.drawable.passwordshow) else painterResource(R.drawable.passwordhide)
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Icon(image, contentDescription = null, tint = contentColor)
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = contentColor.copy(alpha = 0.5f),
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = contentColor.copy(alpha = 0.7f),
                    cursorColor = contentColor,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = contentColor.copy(alpha = 0.7f),
                    focusedTrailingIconColor = Color.White,
                    unfocusedTrailingIconColor = contentColor.copy(alpha = 0.7f),
                    focusedTextColor = contentColor,
                    unfocusedTextColor = contentColor
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Register Button
            Button(
                onClick = {
                    if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                        Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                    } else if (password != confirmPassword) {
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    } else {
                        authViewModel.registerUser(
                            User(username = username, email = email, role = role, password = password)
                        )
                        onRegisterSuccess()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = buttonColors(
                    containerColor = Grin,
                    contentColor = Color.White
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Register")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Login Redirect
            TextButton(
                onClick = { navController.navigate(ROUT_LOGIN) }
            ) {
                Text("Already have an account? Login", color = Color.White)
            }
        }
    }
}
