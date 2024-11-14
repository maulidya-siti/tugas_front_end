package com.example.tugasfrontend.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasfrontend.R
import com.example.tugasfrontend.Routes
import com.example.tugasfrontend.TopBar

@Composable
fun ScreenList2 (navController: NavController, modifier: Modifier = Modifier) {
    // List of drawable image resource IDs with corresponding titles
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
        /*topBar = {
            TopBar(title = "List2Page") // Assuming TopBar is defined elsewhere in your project
        }*/
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding), // Applies padding from Scaffold to avoid overlap with TopBar
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // LazyVerticalGrid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // Sets the number of columns in the grid
                modifier = Modifier
                    .padding(8.dp) // Adds padding around the grid
                    .padding(bottom = 10.dp) // Adds padding at the bottom for navigation bar space
            ) {
                items(imageList.size) { index ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp) // Adds padding between items
                    ) {
                        val (image, title) = imageList[index]
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "Image $index",
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(Routes.DetailScreen)
                                }
                                .size(151.dp, 189.dp) // Set image size to 4x5 cm (151 x 189 dp)
                        )
                        Text(
                            text = title, // Display the title of the image
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 4.dp) // Adds spacing above the text
                        )
                    }
                }
            }
        }
    }
}