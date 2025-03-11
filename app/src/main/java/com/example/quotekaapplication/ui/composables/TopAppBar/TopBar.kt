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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quotekaapplication.R
import com.example.quotekaapplication.ui.composables.TopAppBar.DropdownMenuComponent
import com.example.quotekaapplication.ui.composables.TopAppBar.LogoutConfirmationDialog
import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import com.example.quotekaapplication.ui.viewmodels.TopAppBarViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    navController: NavController,
    authViewModel: AuthViewModel,
    currentRoute: String,
    bottomBarViewModel: BottomBarViewModel,
    topAppBarViewModel: TopAppBarViewModel = viewModel()
) {

    val logoImagePainter = painterResource(id = R.drawable.logo)

    topAppBarViewModel.updateTitle(currentRoute)

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
                    .size(60.dp)
                    .padding(start = 10.dp),

            )
        },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 80.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = topAppBarViewModel.title.value,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        },
        actions = {
            IconButton(onClick = { topAppBarViewModel.expanded.value = !topAppBarViewModel.expanded.value }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Open submenu"
                )
            }
            DropdownMenuComponent(
                expanded = topAppBarViewModel.expanded.value,
                onDismissRequest = { topAppBarViewModel.expanded.value = false },
                onInfoClick = {
                    topAppBarViewModel.expanded.value = false
                    bottomBarViewModel.currentRoute = "info"
                    navController.navigate("info")
                },
                onSettingsClick = {
                    topAppBarViewModel.expanded.value = false
                    bottomBarViewModel.currentRoute = "settings"
                    navController.navigate("settings")
                },
                onLogoutClick = {
                    topAppBarViewModel.expanded.value = false
                    topAppBarViewModel.showLogoutConfirmation.value = true
                }
            )
        }
    )

    if (topAppBarViewModel.showLogoutConfirmation.value) {
        LogoutConfirmationDialog(
            onDismissRequest = { topAppBarViewModel.showLogoutConfirmation.value = false },
            onConfirmLogout = {
                authViewModel.logout()
                navController.navigate("onboarding")
            },
            onCancelLogout = { topAppBarViewModel.showLogoutConfirmation.value = false }
        )
    }
}
