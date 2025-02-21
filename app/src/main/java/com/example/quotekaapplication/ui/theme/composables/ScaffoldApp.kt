
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quotekaapplication.ui.theme.screens.AddQuoteScreen
import com.example.quotekaapplication.ui.theme.screens.CategoriesScreen
import com.example.quotekaapplication.ui.theme.screens.FavoriteScreen
import com.example.quotekaapplication.ui.theme.screens.LoginScreen
import com.example.quotekaapplication.ui.theme.screens.MainScreen
import com.example.quotekaapplication.ui.theme.screens.OnBoardingScreen
import com.example.quotekaapplication.ui.theme.screens.ProfileScreen
import com.example.quotekaapplication.ui.theme.screens.QuoteInfo
import com.example.quotekaapplication.ui.theme.screens.RegisterScreen
import com.example.quotekaapplication.ui.theme.screens.SettingsScreen

@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()

    val authViewModel: AuthViewModel = viewModel()
    val isAuthenticated = authViewModel.isAuthenticated.value
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

            if (isAuthenticated) { // show if is logged in
                TopAppBar(title = "Main Screen",
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
                composable("onboarding") { OnBoardingScreen(navController) }
                composable("login") { LoginScreen(navController, authViewModel) }
                composable("register") { RegisterScreen(navController, authViewModel) }
            }
        },
        bottomBar = {
            if (isAuthenticated) { BottomBar(navController) }
        }
    )
}
