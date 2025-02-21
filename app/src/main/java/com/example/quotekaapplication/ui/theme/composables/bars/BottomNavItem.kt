package com.example.quotekaapplication.ui.theme.composables.bars

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

//This composable displays a navigation button with an icon
// When the button is clicked, it navigates to the screen specified in the [item].
// The navigation only occurs if the current screen is not the same as the target route.


@Composable
fun BottomNavItem(
    navController: NavController,
    item: BottomNavItemData
) {
    val currentRoute = navController.currentDestination?.route  // get the current route

    IconButton(
        onClick = {
            if (currentRoute != item.route) { // check in case not to go the same route
                navController.navigate(item.route)
            }
        }
    ) {
        Icon(imageVector = item.icon, contentDescription = item.contentDescription)
    }
}