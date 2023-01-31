package welias.marvel.presentation.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import welias.marvel.domain.usecase.GetCharactersUseCase
import welias.marvel.domain.usecase.GetTopCharactersUseCase
import welias.marvel.presentation.mapper.toCharacterUi
import welias.marvel.presentation.model.CharacterUI
import welias.marvel.presentation.state.ViewState

class HomeViewModel(
    private val getTopCharactersUseCase: GetTopCharactersUseCase,
    private val getCharacters: GetCharactersUseCase
) : ViewModel() {

    private val _topCharacters =
        MutableStateFlow<ViewState<List<CharacterUI>>>(ViewState.Initial)
    val topCharacterUI = _topCharacters.asStateFlow()

    fun retry() {
        getTopCharacters()
        getCharacters()
    }

    fun getTopCharacters() {
        viewModelScope.launch {
            getTopCharactersUseCase.execute()
                .onStart { handleLoading() }
                .map { result -> result.map { it.toCharacterUi() } }
                .catch { handleError(it) }
                .collect(::handleTopCharacters)
        }
    }

    fun getCharacters(): Flow<PagingData<CharacterUI>> {
        return flow {
            getCharacters.execute().collect {
                emit(it.map { characters -> characters.toCharacterUi() })
            }
        }.cachedIn(viewModelScope)
    }

    private fun handleTopCharacters(topCharacters: List<CharacterUI>) {
        _topCharacters.value = ViewState.Success(topCharacters)
    }

    private fun handleLoading() {
        _topCharacters.value = ViewState.Loading
    }

    private fun handleError(throwable: Throwable) {
        _topCharacters.value = ViewState.Error(throwable)
    }
}
