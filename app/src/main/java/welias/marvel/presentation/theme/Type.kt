package welias.marvel.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import welias.marvel.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = sp16
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

// Fonts
val Anton = FontFamily(Font(R.font.anton))
val DmSans = FontFamily(
    Font(R.font.dm_sans_regular),
    Font(R.font.dm_sans_italic),
    Font(R.font.dm_sans_medium),
    Font(R.font.dm_sans_medium_italic),
    Font(R.font.dm_sans_bold_italic),
    Font(R.font.dm_sans_bold)
)

// Anton TextStyle
val AntonXXXSize = TextStyle(
    color = Color.White,
    fontFamily = Anton,
    fontSize = sp32,
    fontWeight = FontWeight.W400
)

val AntonXXSize = TextStyle(
    color = Color.White,
    fontFamily = Anton,
    fontSize = sp28,
    fontWeight = FontWeight.W400
)

val AntonXSize = TextStyle(
    color = Color.White,
    fontFamily = Anton,
    fontSize = sp24,
    fontWeight = FontWeight.W400
)

val AntonBigNormalSize = TextStyle(
    color = Color.White,
    fontFamily = Anton,
    fontSize = sp16,
    fontWeight = FontWeight.W400
)

// DmSans TextStyle
val DmSansNormalSizeW700 = TextStyle(
    color = Color.White,
    fontFamily = DmSans,
    fontSize = sp14,
    fontWeight = FontWeight.W700
)

val DmSansNormalSizeW400 = TextStyle(
    color = Color.White,
    fontFamily = DmSans,
    fontSize = sp14,
    fontWeight = FontWeight.W400
)
