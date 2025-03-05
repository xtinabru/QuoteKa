import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.quotekaapplication.ui.composables.TopAppBar.DropdownMenuComponent
import com.example.quotekaapplication.ui.composables.TopAppBar.LogoutConfirmationDialog
import com.example.quotekaapplication.ui.viewmodels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    title: String,
    navController: NavController,
    authViewModel: AuthViewModel,
    currentRoute: String
) {
    var expanded by remember { mutableStateOf(false) }
    var showLogoutConfirmation by remember { mutableStateOf(false) }

    val title = when (currentRoute) {
        "home" -> "Home"
        "categories" -> "Categories"
        "add_quote" -> "Add Quote"
        "favorite" -> "Favorites"
        "settings" -> "Settings"
        "profile" -> "Profile"
        else -> "QuoteKa" // default
    }


    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.tertiary,
        ),
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = title,
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Open submenu"
                )
            }
            DropdownMenuComponent(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                onInfoClick = {
                    expanded = false
                    navController.navigate("info")
                },
                onSettingsClick = {
                    expanded = false
                    navController.navigate("settings")
                },
                onLogoutClick = {
                    expanded = false
                    showLogoutConfirmation = true
                }
            )
        }
    )

    if (showLogoutConfirmation) {
        LogoutConfirmationDialog(
            onDismissRequest = { showLogoutConfirmation = false },
            onConfirmLogout = {
                authViewModel.logout()
                navController.navigate("onboarding")
            },
            onCancelLogout = { showLogoutConfirmation = false }
        )
    }
}
