package welias.marvel.presentation.ui.fragments.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import welias.marvel.R
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.theme.*

@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    characterUI: CharacterUI
) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize().padding(dp16)
    ) {
        val (image, name, description) = createRefs()

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(model = characterUI.uri),
            contentDescription = stringResource(id = R.string.content_description_image_character)
        )

        Text(
            modifier = Modifier.constrainAs(name) {
                top.linkTo(image.bottom, margin = dp24)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            text = characterUI.name,
            color = Color.White,
            style = AntonXXXSize
        )

        Text(
            modifier = Modifier.constrainAs(description) {
                top.linkTo(name.bottom, margin = dp12)
                start.linkTo(name.start)
                end.linkTo(name.end)
                width = Dimension.fillToConstraints
            },
            text = characterUI.description,
            color = Color.White,
            style = DmSansNormalSizeW400
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsContentPreview() {
    MarvelTheme {
        DetailsContent(
            characterUI = CharacterUI(
                id = 0,
                name = "Captain America",
                description = "",
                uri = ""
            )
        )
    }
}
