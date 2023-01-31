package welias.marvel.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import welias.marvel.data.datasource.remote.AppRemoteDataSource
import welias.marvel.domain.mapper.toCharacterDomainItem
import welias.marvel.domain.model.CharacterDomain
import welias.marvel.domain.repository.AppRepository

class AppRepositoryImpl(
    private val remoteDataSource: AppRemoteDataSource,
    private val dispatcher: CoroutineDispatcher
) : AppRepository {
    override fun getTopListCharacters(): Flow<List<CharacterDomain>> {
        return flow {
            remoteDataSource.getTopListCharacters().collect { result ->
                emit(result.data.results.map { it.toCharacterDomainItem() })
            }
        }.flowOn(dispatcher)
    }

    override fun getListCharacters(): Flow<PagingData<CharacterDomain>> {
        return flow {
            remoteDataSource.getListCharacters().collect { result ->
                emit(result.map { it.toCharacterDomainItem() })
            }
        }.flowOn(dispatcher)
    }
}
