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

class HomeViewModel(
    private val getTopCharactersUseCase: GetTopCharactersUseCase,
    private val getCharacters: GetCharactersUseCase
) : ViewModel() {

    private val _topCharacters = MutableStateFlow(emptyList<CharacterUI>())
    val topCharacterUI: StateFlow<List<CharacterUI>> get() = _topCharacters

    init {
        getTopCharacters()
    }

    private fun getTopCharacters() {
        viewModelScope.launch {
            getTopCharactersUseCase.execute()
                .onStart { }
                .onCompletion { }
                .map { result -> result.map { it.toCharacterUi() } }
                .catch { }
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
        _topCharacters.value = topCharacters
    }
}
