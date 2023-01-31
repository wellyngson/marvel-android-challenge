package welias.marvel.presentation.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import welias.marvel.R
import welias.marvel.core.constants.FIVE
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.theme.*
import welias.marvel.presentation.ui.components.core.More

@Composable
fun Character(
    modifier: Modifier = Modifier,
    characterUI: CharacterUI,
    openCharacterDetails: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (image, name, description, more) = createRefs()

        Image(
            modifier = Modifier.size(width = dp164, height = dp240).constrainAs(image) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(model = characterUI.uri),
            contentDescription = stringResource(id = R.string.content_description_image_character)
        )

        Text(
            modifier = Modifier.constrainAs(name) {
                top.linkTo(image.top, margin = dp20)
                start.linkTo(image.end, margin = dp16)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            style = AntonXXSize,
            text = characterUI.name,
            color = Color.White
        )

        Text(
            modifier = Modifier.constrainAs(description) {
                top.linkTo(name.bottom, margin = dp8)
                start.linkTo(name.start)
                end.linkTo(name.end)
                width = Dimension.fillToConstraints
            },
            text = characterUI.description,
            color = Color.White,
            style = DmSansNormalSizeW400,
            overflow = TextOverflow.Ellipsis,
            maxLines = FIVE
        )

        More(
            modifier = modifier.constrainAs(more) {
                bottom.linkTo(image.bottom)
                start.linkTo(name.start)
            },
            onClick = { openCharacterDetails() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterPreview() {
    MarvelTheme {
        Character(
            characterUI = CharacterUI(
                id = 0,
                name = "Captain America",
                description = "",
                uri = ""
            )
        )
    }
}
