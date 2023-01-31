package welias.marvel.presentation.ui.util

import android.content.Context
import android.widget.Toast
import welias.marvel.R

fun showToast(context: Context) {
    Toast.makeText(context, R.string.no_connection_error, Toast.LENGTH_LONG).show()
}
