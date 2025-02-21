    package com.example.quotekaapplication.ui.theme.composables.TopAppBar

    import androidx.compose.material3.DropdownMenu
    import androidx.compose.material3.DropdownMenuItem
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable

    // This displays a dropdown menu with three items: "Info", "Settings", and "Logout".
    // The menu opens or closes based on the value of the 'expanded' parameter.
// Clicking to any menu item triggers the corresponding function (onInfoClick, onSettingsClick, onLogoutClick),
// which performs the desired action (navigating to anther screen or log out).
    @Composable
    fun DropdownMenuComponent(
        expanded: Boolean,
        onDismissRequest: () -> Unit,
        onInfoClick: () -> Unit,
        onSettingsClick: () -> Unit,
        onLogoutClick: () -> Unit
    ) {
        val menuItems = listOf(
            "Info" to onInfoClick,
            "Settings" to onSettingsClick,
            "Logout" to onLogoutClick
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest
        ) {
            menuItems.forEach { (label, onClick) ->
                DropdownMenuItem(
                    text = { Text(label) },
                    onClick = onClick
                )
            }
        }
    }