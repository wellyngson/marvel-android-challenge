package welias.marvel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import welias.marvel.core.constants.ARG_MATCH
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.ui.fragments.details.DetailsFragment
import welias.marvel.presentation.ui.fragments.home.HomeFragment
import welias.marvel.presentation.ui.fragments.splash.SplashFragment

@Composable
fun NavGraph(navController: NavHostController) {
    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController,
        startDestination = Route.Splash.route
    ) {
        composable(route = Route.Splash.route) {
            SplashFragment(
                goToHome = actions.goToHome
            )
        }
        composable(route = Route.Home.route) {
            HomeFragment(
                openCharactersDetails = actions.openMatchDetail
            )
        }
        composable(route = Route.Detail.route) {
            val characterUI = navController.previousBackStackEntry
                ?.savedStateHandle?.get<CharacterUI>(ARG_MATCH)

            DetailsFragment(
                navigateBack = actions.navigateBack,
                characterUI = characterUI
            )
        }
    }
}
