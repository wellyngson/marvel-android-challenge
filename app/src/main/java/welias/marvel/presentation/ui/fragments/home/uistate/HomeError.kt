package welias.marvel.presentation.ui.fragments.home.uistate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import welias.marvel.R
import welias.marvel.presentation.theme.*

@Composable
fun HomeError(retry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(dp48),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.no_connection_error),
            color = Color.White,
            textAlign = TextAlign.Center,
            style = DmSansNormalSizeW400
        )

        Button(
            modifier = Modifier.padding(top = dp16),
            onClick = { retry() },
            colors = ButtonDefaults.buttonColors(backgroundColor = GraySecondary)
        ) {
            Text(
                text = stringResource(id = R.string.try_again).uppercase(),
                color = Color.White,
                style = AntonXSize
            )
        }
    }
}
