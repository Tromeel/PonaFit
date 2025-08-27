package com.tromeel.ponafit.ui.screens.physio

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tromeel.ponafit.R
import com.tromeel.ponafit.model.Physio
import com.tromeel.ponafit.navigation.ROUT_ADD_PHYSIO
import com.tromeel.ponafit.navigation.ROUT_EDIT_PHYSIO
import com.tromeel.ponafit.navigation.ROUT_PHYSIO_LIST
import com.tromeel.ponafit.navigation.editPhysioRoute
import com.tromeel.ponafit.viewmodel.PhysioViewModel
import java.io.IOException
import java.io.OutputStream

// Replace this with your app’s color


@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhysioListScreen(navController: NavController, viewModel: PhysioViewModel) {
    val physioList by viewModel.allPhysio.observeAsState(emptyList())

    var showMenu by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredPhysios = physioList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.greenbg),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        title = { Text("Physiotherapists", fontSize = 20.sp, color = Color.White) },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Grin),
                        actions = {
                            IconButton(onClick = { showMenu = true }) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }
                            DropdownMenu(
                                expanded = showMenu,
                                onDismissRequest = { showMenu = false }
                            ) {
                                DropdownMenuItem(
                                    text = { Text("Physiotherapist List") },
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

                    //Search Bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        placeholder = { Text("Search physiotherapists...") },
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.Gray
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Gray,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.DarkGray
                        )
                    )
                }
            },
            bottomBar = { BottomNavigationBar1(navController) },
            containerColor = Color.Transparent // Transparent to see background
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                LazyColumn {
                    items(filteredPhysios.size) { index ->
                        PhysioItem(navController, filteredPhysios[index], viewModel)
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun PhysioItem(navController: NavController, physio: Physio, viewModel: PhysioViewModel) {
    val painter: Painter = rememberAsyncImagePainter(
        model = physio.imagePath?.let { Uri.parse(it) } ?: Uri.EMPTY
    )
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                if (physio.id != 0) {
                    navController.navigate(ROUT_EDIT_PHYSIO)
                }
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // Profile Image - Fit inside without cropping
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painter,
                    contentDescription = "Physiotherapist Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Fit // ✅ Show whole image in the space
                )

                // Gradient overlay only at bottom
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f))
                            )
                        )
                )
            }

            // Info Section
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = physio.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Fee: Ksh${physio.price}",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "Phone: ${physio.phone}",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }

            // Buttons Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = {
                        val smsIntent = Intent(Intent.ACTION_SENDTO)
                        smsIntent.data = "smsto:${physio.phone}".toUri()
                        smsIntent.putExtra("sms_body", "Hello Physiotherapist, I’d like to inquire...")
                        context.startActivity(smsIntent)
                    },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Message"
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(text = "Message")
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    IconButton(onClick = { navController.navigate(editPhysioRoute(physio.id)) }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.Black)
                    }

                    IconButton(onClick = { viewModel.deletePhysio(physio) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Black)
                    }

                    IconButton(onClick = { generatePhysioPDF(context, physio) }) {
                        Icon(
                            painter = painterResource(R.drawable.download),
                            contentDescription = "Download",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
fun generatePhysioPDF(context: Context, physio: Physio) {
    val pdfDocument = PdfDocument()
    val pageInfo = PdfDocument.PageInfo.Builder(300, 500, 1).create()
    val page = pdfDocument.startPage(pageInfo)
    val canvas = page.canvas
    val paint = android.graphics.Paint()

    val bitmap: Bitmap? = try {
        physio.imagePath?.let {
            val uri = Uri.parse(it)
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    bitmap?.let {
        val scaledBitmap = Bitmap.createScaledBitmap(it, 250, 150, false)
        canvas.drawBitmap(scaledBitmap, 25f, 20f, paint)
    }

    paint.textSize = 16f
    paint.isFakeBoldText = true
    canvas.drawText("Physiotherapist Details", 60f, 200f, paint)

    paint.textSize = 12f
    paint.isFakeBoldText = false
    canvas.drawText("Name: ${physio.name}", 50f, 230f, paint)
    canvas.drawText("Fee: Ksh${physio.price}", 50f, 250f, paint)
    canvas.drawText("Phone: ${physio.phone}", 50f, 270f, paint)

    pdfDocument.finishPage(page)

    val fileName = "${physio.name}_Details.pdf"
    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
        put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
        put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
    }

    val contentResolver = context.contentResolver
    val uri = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)

    if (uri != null) {
        try {
            val outputStream: OutputStream? = contentResolver.openOutputStream(uri)
            if (outputStream != null) {
                pdfDocument.writeTo(outputStream)
                Toast.makeText(context, "PDF saved to Downloads!", Toast.LENGTH_LONG).show()
            }
            outputStream?.close()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to save PDF!", Toast.LENGTH_LONG).show()
        }
    } else {
        Toast.makeText(context, "Failed to create file!", Toast.LENGTH_LONG).show()
    }

    pdfDocument.close()
}

@Composable
fun BottomNavigationBar1(navController: NavController) {
    NavigationBar(
        containerColor = Grin,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUT_PHYSIO_LIST) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Physiotherapist List", tint = Color.White) },
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
