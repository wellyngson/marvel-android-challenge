package welias.marvel.presentation.ui.fragments.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.theme.BlackPrimary
import welias.marvel.presentation.ui.components.core.AppTopBar

@Composable
fun DetailsFragment(
    modifier: Modifier = Modifier,
    characterUI: CharacterUI?,
    navigateBack: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = BlackPrimary,
        topBar = {
            AppTopBar(
                navigateBack = {
                    navigateBack()
                },
                showBackButton = true
            )
        },
        content = {
            characterUI?.let { character ->
                DetailsContent(
                    modifier = modifier,
                    characterUI = character
                )
            }
        }
    )
}
