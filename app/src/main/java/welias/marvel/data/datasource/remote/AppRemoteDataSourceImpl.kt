package welias.marvel.data.datasource.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import welias.marvel.core.constants.PAGE_SIZE
import welias.marvel.data.model.CharacterDataWrapperResponse
import welias.marvel.data.model.CharacterResponse
import welias.marvel.data.paging.AppPagingSource
import welias.marvel.data.service.AppService

class AppRemoteDataSourceImpl(private val service: AppService) : AppRemoteDataSource {
    override fun getTopListCharacters(): Flow<CharacterDataWrapperResponse> {
        return flow {
            emit(service.getListCharacters())
        }
    }

    override fun getListCharacters(): Flow<PagingData<CharacterResponse>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                AppPagingSource(this.service)
            }
        ).flow
    }
}
