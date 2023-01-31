package welias.marvel.presentation.ui.fragments.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.delay
import welias.marvel.R
import welias.marvel.core.constants.ANIMATION_DURATION
import welias.marvel.core.constants.SPLASH_LOGO_DURATION
import welias.marvel.presentation.theme.af0
import welias.marvel.presentation.theme.af03
import welias.marvel.presentation.theme.af2

@Composable
fun SplashFragment(
    modifier: Modifier = Modifier,
    goToHome: () -> Unit = {}
) {
    val scale = remember {
        Animatable(af0)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = af03,
            animationSpec = tween(
                durationMillis = SPLASH_LOGO_DURATION,
                easing = {
                    OvershootInterpolator(af2).getInterpolation(it)
                }
            )
        )
        delay(ANIMATION_DURATION)
        goToHome()
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_splash),
            contentDescription = stringResource(R.string.content_description_image_logo),
            modifier = modifier.scale(scale.value).fillMaxSize()
        )
    }
}
