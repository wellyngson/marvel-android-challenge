package welias.marvel.presentation.ui.fragments.home.uistate

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import welias.marvel.R
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.theme.*
import welias.marvel.presentation.ui.components.core.ErrorDialog
import welias.marvel.presentation.ui.components.core.LoadingItem
import welias.marvel.presentation.ui.components.home.Character
import welias.marvel.presentation.ui.components.home.CircleCharacter

@Composable
fun HomeSuccess(
    topCharactersUI: List<CharacterUI>,
    characters: LazyPagingItems<CharacterUI>,
    openCharacterDetails: (characterUI: CharacterUI) -> Unit = {}
) {
    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.first_characters).uppercase(),
            color = Color.White,
            style = AntonXSize,
            modifier = Modifier.padding(top = dp24, bottom = dp16)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dp16),
            contentPadding = PaddingValues(horizontal = dp16)
        ) {
            items(items = topCharactersUI) { characterUI ->
                CircleCharacter(
                    characterUI = characterUI,
                    openCharacterDetails = { openCharacterDetails(characterUI) }
                )
            }
        }

        Text(
            text = stringResource(id = R.string.all_heroes).uppercase(),
            color = Color.White,
            style = AntonXSize,
            modifier = Modifier.padding(top = dp32, bottom = dp30)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(dp16),
            contentPadding = PaddingValues(horizontal = dp16)
        ) {
            items(items = characters) { characterUI ->
                characterUI?.let {
                    Character(
                        characterUI = it,
                        openCharacterDetails = { openCharacterDetails(it) }
                    )
                }
            }

            val state = characters.loadState
            when {
                state.refresh is LoadState.Loading -> {
                    item {
                        LoadingItem()
                    }
                }
                state.append is LoadState.Error -> {
                    item {
                        ErrorDialog(
                            onClick = {
                                characters.refresh()
                            }
                        )
                    }
                }
                else -> Unit
            }
        }

        characters.apply {
            when (loadState.append) {
                is LoadState.Loading -> HomeLoading()
                else -> Unit
            }
        }
    }
}
