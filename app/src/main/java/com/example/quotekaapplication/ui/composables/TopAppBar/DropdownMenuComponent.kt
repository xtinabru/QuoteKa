    package com.example.quotekaapplication.ui.composables.TopAppBar

    import androidx.compose.foundation.border
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.DropdownMenu
    import androidx.compose.material3.DropdownMenuItem
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import com.example.quotekaapplication.ui.theme.Purple

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
            onDismissRequest = onDismissRequest,
            modifier = Modifier
                .border(2.dp, Purple, shape = MaterialTheme.shapes.small),

            containerColor = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.small,
        ) {
            menuItems.forEach { (label, onClick) ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    },
                    onClick = onClick,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
                )
            }
        }
    }

