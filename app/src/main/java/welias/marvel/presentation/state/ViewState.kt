package welias.marvel.presentation.state

sealed class ViewState<out T> {
    object Initial : ViewState<Nothing>()
    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error<T>(val throwable: Throwable) : ViewState<T>()
}
