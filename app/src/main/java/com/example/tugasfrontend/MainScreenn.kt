package com.example.tugasfrontend

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontend.pages.AboutScreen
import com.example.tugasfrontend.pages.ScreenList1
import com.example.tugasfrontend.pages.ScreenList2

@Composable
fun MainScreenn (navController: NavController = rememberNavController(), modifier: Modifier = Modifier) {

    val navItemList = listOf(
        NavItem("List1", Icons.Default.List),
        NavItem("List2", Icons.Default.List),
        NavItem("About", Icons.Default.Person )
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = when (selectedIndex) {
                    0 -> "Screen 1"
                    1 -> "Screen 2"
                    else -> "About"
                }
            )
        },
        bottomBar = {
            NavigationBar (
                containerColor = Color(0xFF87CEEB),
            ) {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
        ) { innerPadding ->
            ContentScreen(navController = navController, modifier = Modifier.padding(innerPadding).padding(top = 8.dp, bottom = 8.dp), selectedIndex = selectedIndex)
    }
}

@Composable
fun ContentScreen (navController: NavController, modifier: Modifier = Modifier, selectedIndex : Int) {
    when(selectedIndex){
        0-> ScreenList1(navController, modifier)
        1-> ScreenList2(navController, modifier)
        2-> AboutScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF87CEEB), // Light sky blue color
            titleContentColor = Color.Black // Black text for better contrast
        ),
        title = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        /*navigationIcon = {
            IconButton(onClick = { /* Add navigation action if needed */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },*/
        scrollBehavior = scrollBehavior,
    )
}