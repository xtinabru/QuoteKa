package com.example.quotekaapplication.ui.composables.BottomAppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home


// list of all the icons

val bottomNavItems = listOf(
    BottomNavItemData("home", Icons.Filled.Home, "Home"),
    BottomNavItemData("favorite", Icons.Filled.Favorite, "Favorite"),
    BottomNavItemData("profile", Icons.Filled.AccountCircle, "Profile")
)