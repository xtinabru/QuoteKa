package com.example.quotekaapplication.ui.composables.TopAppBar

// represents an item in the dropdown menu
data class DropdownMenuItemData(
    val label: String,
    val onClick: () -> Unit
)
