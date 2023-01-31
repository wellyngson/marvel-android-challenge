package welias.marvel.presentation.ui.components.core

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import welias.marvel.presentation.theme.GraySecondary

@Composable
fun LoadingShimmerEffect(): Brush {
    val gradient = listOf(
        GraySecondary.copy(alpha = 0.9f), // darker grey (90% opacity)
        GraySecondary.copy(alpha = 0.3f), // lighter grey (30% opacity)
        GraySecondary.copy(alpha = 0.9f)
    )

    val transition = rememberInfiniteTransition() // animate infinite times

    val translateAnimation = transition.animateFloat( // animate the transition
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // duration for the animation
                easing = FastOutLinearInEasing
            )
        )
    )
    return linearGradient(
        colors = gradient,
        start = Offset(200f, 200f),
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        )
    )
}
