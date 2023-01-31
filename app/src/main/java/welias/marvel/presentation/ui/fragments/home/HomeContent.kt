package welias.marvel.presentation.ui.fragments.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.state.ViewState
import welias.marvel.presentation.ui.fragments.home.uistate.HomeError
import welias.marvel.presentation.ui.fragments.home.uistate.HomeLoading
import welias.marvel.presentation.ui.fragments.home.uistate.HomeSuccess

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    openCharacterDetails: (characterUI: CharacterUI) -> Unit = {}
) {
    val characters = viewModel.getCharacters().collectAsLazyPagingItems()

    Column(modifier = modifier.fillMaxSize()) {
        when (val state = viewModel.topCharacterUI.collectAsState().value) {
            is ViewState.Loading -> {
                HomeLoading()
            }
            is ViewState.Success -> {
                HomeSuccess(
                    topCharactersUI = state.data,
                    characters = characters,
                    openCharacterDetails = { openCharacterDetails(it) }
                )
            }
            is ViewState.Error -> {
                HomeError {
                    viewModel.retry()
                }
            }
            else -> Unit
        }
    }
}
