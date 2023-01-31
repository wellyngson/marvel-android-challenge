package welias.marvel.presentation.ui.components.core

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import welias.marvel.presentation.theme.*

@Composable
fun LoadingItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .size(dp42)
                .padding(dp8),
            color = Red,
            strokeWidth = dp4
        )
    }
}
