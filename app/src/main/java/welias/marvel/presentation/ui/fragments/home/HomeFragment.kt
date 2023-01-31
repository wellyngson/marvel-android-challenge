package welias.marvel.presentation.ui.fragments.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.getViewModel
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.theme.BlackPrimary
import welias.marvel.presentation.ui.components.core.AppTopBar

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    openCharactersDetails: (characterUI: CharacterUI) -> Unit = {}
) {
    val viewModel = getViewModel<HomeViewModel>()
    val topCharacters = viewModel.topCharacterUI.collectAsState()
    val characters = viewModel.getCharacters().collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = BlackPrimary,
        topBar = { AppTopBar() },
        content = {
            HomeContent(
                modifier = modifier,
                topCharactersUI = topCharacters,
                charactersUi = characters,
                openCharacterDetails = { openCharactersDetails(it) }
            )
        }
    )
}
