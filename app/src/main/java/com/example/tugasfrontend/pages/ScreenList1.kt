package com.example.tugasfrontend.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasfrontend.R
import com.example.tugasfrontend.Routes
import com.example.tugasfrontend.TopBar

@Composable
fun ScreenList1 (navController: NavController, modifier: Modifier = Modifier) {
    val imageList = listOf(
        R.drawable.carol to "   Carol   ",
        R.drawable.greatest to "The Greatest Showman",
        R.drawable.homealone1 to "Home Alone",
        R.drawable.littlewomen to "Little Women",
        R.drawable.monkeyman to "Monkey Man",
        R.drawable.thebear to "The Bear",
        R.drawable.spirited to "Spirited Away",
        R.drawable.poets to "Dead Poets Society",
        R.drawable.it to "     IT     ",
        R.drawable.queens to "The Queens Gambit"
    )
    Scaffold(
        topBar = {
            TopBar(title = "List1Page") // Assuming TopBar is defined elsewhere in your project
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding),// Applies padding from Scaffold to avoid overlap with TopBar
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // LazyRow positioned at the top, directly under the TopBar
            LazyRow(
                modifier = Modifier
                    .padding(8.dp) // Adds padding around LazyRow
            ) {
                items(10) { index ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        val (image, title) = imageList[index % imageList.size]
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "Row Image $index",
                            modifier = Modifier
                                .size(85.dp, 113.dp) // Set image size to 3x4 cm
                                .padding(end = 8.dp)
                        )
                        Text(
                            text = title, // Display the title of the image
                            fontSize = 16.sp,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(Routes.DetailScreen)
                                }
                                .padding(4.dp)
                        )
                    }
                }
            }

            // LazyColumn aligned to the left
            LazyColumn(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 16.dp
                    ) // Adds padding for spacing from top and left edge
                    .padding(bottom = 10.dp) // Adds extra padding at the bottom to avoid overlapping with the navigation bar
            ) {
                items(10) { index ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(bottom = 10.dp) // 1 cm (approx.) space between items
                        ) {
                            val (image, title) = imageList[index % imageList.size]
                            Image(
                                painter = painterResource(id = image),
                                contentDescription = "Column Image $index",
                                modifier = Modifier
                                    .size(85.dp, 113.dp) // Set image size to 3x4 cm
                                    .padding(end = 8.dp)
                            )
                            Text(
                                text = title, // Display the title of the image
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(Routes.DetailScreen)
                                    }
                                    .padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
