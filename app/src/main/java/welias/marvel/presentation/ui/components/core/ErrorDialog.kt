package welias.marvel.presentation.ui.components.core

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import welias.marvel.R
import welias.marvel.presentation.theme.*

@Composable
fun ErrorDialog(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = stringResource(R.string.error_dialog_title), style = AntonXSize)
            },
            text = {
                Text(
                    text = stringResource(R.string.error_dialog_default_description),
                    style = DmSansNormalSizeW400
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    onClick()
                    openDialog.value = false
                }) {
                    Text(
                        text = stringResource(id = R.string.try_again).uppercase(),
                        color = Red,
                        style = DmSansNormalSizeW700
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorDialogPreview() {
    MarvelTheme {
        ErrorDialog()
    }
}
