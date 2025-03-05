import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quotekaapplication.R
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

    val logoImagePainter = painterResource(id = R.drawable.logo)
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
        navigationIcon = {
            // LOGO
            Image(
                painter = logoImagePainter,
                contentDescription = "Logo",
                modifier = Modifier
                    .size(120.dp)
                    .padding(end = 20.dp)
            )
        },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
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
