package welias.marvel.presentation.ui.fragments.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import welias.marvel.R
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.theme.*
import welias.marvel.presentation.ui.components.home.Character
import welias.marvel.presentation.ui.components.home.CircleCharacter

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    topCharactersUI: State<List<CharacterUI>>,
    charactersUi: LazyPagingItems<CharacterUI>,
    openCharacterDetails: (characterUI: CharacterUI) -> Unit = {}
) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (titleTopCharacters, topCharacters, titleMainCharacters, mainCharacters) = createRefs()

        Text(
            text = stringResource(id = R.string.first_characters),
            color = Color.White,
            modifier = Modifier.constrainAs(titleTopCharacters) {
                top.linkTo(parent.top, margin = dp24)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            style = AntonXSize
        )

        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .constrainAs(topCharacters) {
                    top.linkTo(titleTopCharacters.bottom, margin = dp16)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            horizontalArrangement = Arrangement.spacedBy(dp16),
            contentPadding = PaddingValues(vertical = dp16)
        ) {
            items(items = topCharactersUI.value) { characterUI ->
                CircleCharacter(
                    characterUI = characterUI,
                    openCharacterDetails = { openCharacterDetails(characterUI) }
                )
            }
        }

        Text(
            text = stringResource(id = R.string.all_heroes),
            color = Color.White,
            modifier = Modifier.constrainAs(titleMainCharacters) {
                top.linkTo(topCharacters.bottom, margin = dp32)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            style = AntonXSize
        )

        LazyColumn(
            modifier = modifier.constrainAs(mainCharacters) {
                top.linkTo(titleMainCharacters.bottom, margin = dp30)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            verticalArrangement = Arrangement.spacedBy(dp16)
        ) {
            items(items = charactersUi) { characterUI ->
                characterUI?.let {
                    Character(
                        characterUI = it,
                        openCharacterDetails = { openCharacterDetails(it) }
                    )
                }
            }
        }
    }
}
