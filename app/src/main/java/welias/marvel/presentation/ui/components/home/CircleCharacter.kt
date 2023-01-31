package welias.marvel.presentation.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import welias.marvel.R
import welias.marvel.core.constants.TWO
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.theme.DmSansNormalSizeW700
import welias.marvel.presentation.theme.MarvelTheme
import welias.marvel.presentation.theme.dp100
import welias.marvel.presentation.theme.dp12

@Composable
fun CircleCharacter(
    modifier: Modifier = Modifier,
    characterUI: CharacterUI,
    openCharacterDetails: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier.clickable {
            openCharacterDetails()
        }
    ) {
        val (image, name) = createRefs()

        Image(
            modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.size(dp100).clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(model = characterUI.uri),
            contentDescription = stringResource(id = R.string.content_description_image_character)
        )

        Text(
            text = characterUI.name,
            color = Color.White,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(image.bottom, margin = dp12)
                start.linkTo(image.start)
                end.linkTo(image.end)
                width = Dimension.fillToConstraints
            },
            style = DmSansNormalSizeW700,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = TWO
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircleCharacterPreview() {
    MarvelTheme {
        CircleCharacter(
            characterUI = CharacterUI(
                id = 0,
                name = "Captain America",
                description = "",
                uri = ""
            )
        )
    }
}
