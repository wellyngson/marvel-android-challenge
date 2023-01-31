package welias.marvel.domain.usecase

import kotlinx.coroutines.flow.Flow
import welias.marvel.domain.model.CharacterDomain
import welias.marvel.domain.repository.AppRepository

class GetTopCharactersUseCase(private val repository: AppRepository) {
    fun execute(): Flow<List<CharacterDomain>> {
        return repository.getTopListCharacters()
    }
}
