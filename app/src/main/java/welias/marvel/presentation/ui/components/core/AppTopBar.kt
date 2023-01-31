package welias.marvel.presentation.ui.components.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import welias.marvel.R
import welias.marvel.core.constants.APP_TOP_BAR_COMPONENT
import welias.marvel.core.extensions.toAlphaVisibility
import welias.marvel.presentation.theme.*

@Preview(showBackground = true)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    showBackButton: Boolean = false,
    showSearchButton: Boolean = false,
    navigateBack: () -> Unit = {},
    search: () -> Unit = {}
) {
    Column {
        TopAppBar(
            modifier = modifier.padding(vertical = dp20).testTag(APP_TOP_BAR_COMPONENT),
            backgroundColor = BlackPrimary,
            elevation = dp0
        ) {
            ConstraintLayout(modifier = modifier.fillMaxWidth()) {
                val (back, logo, search) = createRefs()

                IconButtonTopBar(
                    onClick = { navigateBack.invoke() },
                    icon = Icons.Filled.ArrowBack,
                    modifier = Modifier.constrainAs(back) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }.alpha(showBackButton.toAlphaVisibility()),
                    contentDescription = stringResource(R.string.content_description_back_button)
                )

                Image(
                    painter = painterResource(id = R.drawable.marvel_logo),
                    contentDescription = stringResource(id = R.string.content_description_image_logo),
                    modifier = Modifier.fillMaxSize().constrainAs(logo) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )

                IconButtonTopBar(
                    onClick = { search() },
                    icon = Icons.Filled.Search,
                    modifier = Modifier.constrainAs(search) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }.alpha(showSearchButton.toAlphaVisibility())
                )
            }
        }

        Spacer(
            modifier = modifier.background(GrayPrimary).fillMaxWidth().height(dp1)
        )
    }
}

@Composable
fun IconButtonTopBar(
    onClick: () -> Unit,
    icon: ImageVector,
    modifier: Modifier,
    contentDescription: String? = null
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Icon(
            tint = Color.White,
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}
