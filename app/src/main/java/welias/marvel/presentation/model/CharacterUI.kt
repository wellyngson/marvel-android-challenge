package welias.marvel.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterUI(
    val id: Long,
    val name: String,
    val description: String,
    val uri: String
) : Parcelable
