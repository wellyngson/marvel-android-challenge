package welias.marvel.presentation.navigation

import welias.marvel.core.constants.DETAIL_SCREEN
import welias.marvel.core.constants.HOME_SCREEN
import welias.marvel.core.constants.SPLASH_SCREEN

sealed class Route(val route: String) {
    object Splash : Route(SPLASH_SCREEN)
    object Home : Route(HOME_SCREEN)
    object Detail : Route(DETAIL_SCREEN)
}
