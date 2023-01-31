package welias.marvel.data.datasource.remote

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import welias.marvel.data.model.CharacterDataWrapperResponse
import welias.marvel.data.model.CharacterResponse

interface AppRemoteDataSource {
    fun getTopListCharacters(): Flow<CharacterDataWrapperResponse>
    fun getListCharacters(): Flow<PagingData<CharacterResponse>>
}
