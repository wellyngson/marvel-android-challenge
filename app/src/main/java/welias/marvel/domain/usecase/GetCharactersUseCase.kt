package welias.marvel.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import welias.marvel.domain.model.CharacterDomain
import welias.marvel.domain.repository.AppRepository

class GetCharactersUseCase(private val repository: AppRepository) {
    fun execute(): Flow<PagingData<CharacterDomain>> {
        return repository.getListCharacters()
    }
}
