package welias.marvel.presentation.ui.fragments.home.uistate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import welias.marvel.core.constants.FIVE
import welias.marvel.core.constants.TWO
import welias.marvel.presentation.theme.*
import welias.marvel.presentation.ui.components.core.LoadingShimmerEffect

@Composable
fun HomeLoading() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(dp16).fillMaxSize()) {
        TopCharactersLoading()
        CharactersLoading()
    }
}

@Composable
fun TopCharactersLoading() {
    val brush = LoadingShimmerEffect()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(
            modifier = Modifier
                .padding(top = dp24, bottom = dp16)
                .size(height = dp36, width = dp240)
                .clip(RoundedCornerShape(dp8))
                .background(brush)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dp16)
        ) {
            items(FIVE) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(
                        modifier = Modifier
                            .size(dp100)
                            .clip(CircleShape)
                            .background(brush)
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(top = dp12)
                            .size(height = dp36, width = dp56)
                            .clip(RoundedCornerShape(dp8))
                            .background(brush)
                    )
                }
            }
        }
    }
}

@Composable
fun CharactersLoading() {
    val brush = LoadingShimmerEffect()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(
            modifier = Modifier
                .padding(top = dp32, bottom = dp30)
                .size(height = dp36, width = dp152)
                .clip(RoundedCornerShape(dp8))
                .background(brush)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dp16)
        ) {
            items(TWO) {
                Row {
                    Spacer(
                        modifier = Modifier
                            .size(width = dp164, height = dp240)
                            .clip(RoundedCornerShape(dp8))
                            .background(brush)
                    )

                    Column {
                        repeat(TWO) {
                            Spacer(
                                modifier = Modifier
                                    .padding(start = dp16, top = dp12)
                                    .size(height = dp36, width = dp152)
                                    .clip(RoundedCornerShape(dp8))
                                    .background(brush)
                            )
                        }
                    }
                }
            }
        }
    }
}
