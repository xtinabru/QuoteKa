
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
import com.example.quotekaapplication.ui.screens.AddQuoteScreen
import com.example.quotekaapplication.ui.screens.CategoriesScreen
import com.example.quotekaapplication.ui.screens.FavoriteScreen
import com.example.quotekaapplication.ui.screens.Authentication.Login.LoginScreen
import com.example.quotekaapplication.ui.screens.MainScreen
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
    val isAuthenticated = authViewModel.isAuthenticated.value
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

            if (isAuthenticated) { // show if is logged in
                TopAppBarComponent(title = "Main Screen",
                    navController = navController,
                    authViewModel = authViewModel )
            }
        },
        content = { paddingValues -> // paddings btwn elements

            NavHost(
                navController = navController,
                startDestination = if (isAuthenticated) "home" else "onBoarding",
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(route = "home")  { MainScreen(navController, paddingValues) }
                composable("categories") { CategoriesScreen() }
                composable("add_quote") { AddQuoteScreen() }
                composable(route = "info")  { QuoteInfo(navController, paddingValues) }
                composable("favorite") { FavoriteScreen() }
                composable(route = "settings")  { SettingsScreen(navController, paddingValues) }
                composable("profile") { ProfileScreen() }
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
