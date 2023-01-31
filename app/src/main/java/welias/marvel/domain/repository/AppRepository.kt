package welias.marvel.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import welias.marvel.domain.model.CharacterDomain

interface AppRepository {
    fun getTopListCharacters(): Flow<List<CharacterDomain>>
    fun getListCharacters(): Flow<PagingData<CharacterDomain>>
}
