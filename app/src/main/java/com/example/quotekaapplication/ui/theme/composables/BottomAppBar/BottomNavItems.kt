package com.example.quotekaapplication.ui.theme.composables.BottomAppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home


// list of all the icons

val bottomNavItems = listOf(
    BottomNavItemData("home", Icons.Filled.Home, "Home"),
    BottomNavItemData("categories", Icons.Filled.FavoriteBorder, "Categories"),
    BottomNavItemData("add_quote", Icons.Filled.AddCircle, "Add Quote"),
    BottomNavItemData("favorite", Icons.Filled.Favorite, "Favorite"),
    BottomNavItemData("profile", Icons.Filled.AccountCircle, "Profile")
)