package com.example.quotekaapplication.ui.theme.composables.bars

import androidx.compose.ui.graphics.vector.ImageVector

//  Data class that represents a bottom navigation item.
//  This contains the necessary information for each navigation item:
//  route, icon, and content description for accessibility.

data class BottomNavItemData(
    val route: String,
    val icon: ImageVector,
    val contentDescription: String,

)
