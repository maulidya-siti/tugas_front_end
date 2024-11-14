package com.example.tugasfrontend.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontend.R

@Composable
fun AboutScreen (modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image (Profile Picture)
        Image(
            painter = painterResource(id = R.drawable.siti), // Replace with your image resource
            contentDescription = "Profile Picture",
            modifier = Modifier
                .padding(bottom = 16.dp)// Adds space below the image
                .size(220.dp, 200.dp)
                .clip(RoundedCornerShape(30.dp)) // Add rounded corners
        )

        // Name
        Text(
            text = "Siti Maulidya", // Replace with your name
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp) // Adds space below the name
        )

        // Email
        Text(
            text = "maulidyasiti2@email.com", // Replace with your email
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp) // Adds space below the email
        )

        // University Name
        Text(
            text = "Institut Teknologi Batam", // Replace with your university name
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp) // Adds space below the university
        )

        // Major
        Text(
            text = "Information Systems", // Replace with your major
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }
}