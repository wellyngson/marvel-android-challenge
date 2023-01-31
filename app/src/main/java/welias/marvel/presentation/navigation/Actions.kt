package welias.marvel.presentation.navigation

import androidx.navigation.NavHostController
import welias.marvel.core.constants.ARG_MATCH
import welias.marvel.presentation.model.CharacterUI

class Actions(navHostController: NavHostController) {

    val navigateBack: () -> Unit = {
        navHostController.navigateUp()
    }

    val goToHome: () -> Unit = {
        navHostController.navigate(Route.Home.route) {
            navHostController.popBackStack()
        }
    }

    val openMatchDetail: (CharacterUI) -> Unit = { characterUI ->
        navHostController.currentBackStackEntry?.savedStateHandle?.set(ARG_MATCH, characterUI)
        navHostController.navigate(Route.Detail.route)
    }
}
