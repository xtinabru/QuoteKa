import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quotekaapplication.ui.composables.BottomAppBar.BottomBar
import com.example.quotekaapplication.ui.screens.Authentication.LoginScreen
import com.example.quotekaapplication.ui.screens.FavoritesScreen
import com.example.quotekaapplication.ui.screens.HomeScreen
import com.example.quotekaapplication.ui.screens.OnBoardingScreen.OnBoardingScreen
import com.example.quotekaapplication.ui.screens.ProfileScreen
import com.example.quotekaapplication.ui.screens.QuoteInfo
import com.example.quotekaapplication.ui.screens.RegisterScreen
import com.example.quotekaapplication.ui.screens.SettingsScreen
import com.example.quotekaapplication.ui.viewmodels.AuthViewModel
import com.example.quotekaapplication.ui.viewmodels.OnBoardingViewModel

@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()
    val bottomBarViewModel: BottomBarViewModel = viewModel()

    val currentRoute = bottomBarViewModel.currentRoute ?: "QuoteKa"
    val isAuthenticated = authViewModel.isAuthenticated.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (isAuthenticated) {
                TopAppBarComponent(
                    navController = navController,
                    authViewModel = authViewModel,
                    bottomBarViewModel = bottomBarViewModel,
                    currentRoute = currentRoute
                )
            }
        },
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = if (isAuthenticated) "home" else "onBoarding",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(route = "home")  { HomeScreen( paddingValues) }
                composable(route = "info")  { QuoteInfo(navController, ) }
                composable("favorite") { FavoritesScreen(paddingValues) }
                composable(route = "settings")  { SettingsScreen(navController) }
                composable("profile") { ProfileScreen(navController) }
                composable("onboarding") {
                    val onBoardingViewModel: OnBoardingViewModel = viewModel()
                    OnBoardingScreen(navController, onBoardingViewModel)
                }
                composable("login") { LoginScreen(navController, authViewModel) }
                composable("register") { RegisterScreen(navController, authViewModel) }
            }
        },
        bottomBar = {
            if (isAuthenticated) { BottomBar(navController) }
        }
    )
}
