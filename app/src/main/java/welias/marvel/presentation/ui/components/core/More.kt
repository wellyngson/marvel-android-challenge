package welias.marvel.presentation.ui.components.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import welias.marvel.R
import welias.marvel.presentation.theme.*

@Composable
fun More(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        shape = Shapes.large,
        colors = ButtonDefaults.buttonColors(backgroundColor = GraySecondary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dp4)
        ) {
            Text(text = stringResource(id = R.string.more).uppercase(), style = AntonBigNormalSize)
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_up_right),
                tint = Color.White,
                contentDescription = stringResource(id = R.string.more)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MorePreview() {
    MarvelTheme {
        More()
    }
}
