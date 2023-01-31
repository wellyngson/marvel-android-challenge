package welias.marvel.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import welias.marvel.core.constants.FIVE
import welias.marvel.core.constants.PAGE_SIZE
import welias.marvel.core.constants.TWENTY
import welias.marvel.core.constants.ZERO
import welias.marvel.data.model.CharacterResponse
import welias.marvel.data.service.AppService

class AppPagingSource(
    private val service: AppService
) : PagingSource<Int, CharacterResponse>() {

    override fun getRefreshKey(
        state: PagingState<Int, CharacterResponse>
    ): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(
                anchorPosition
            )
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, CharacterResponse> {
        return try {
            val page = params.key
            val offset = if (page == null) FIVE else page * PAGE_SIZE
            val response = service.getListCharacters(offset = offset, limit = TWENTY)
            val nextKey =
                if (offset >= response.data.total) null
                else (page ?: ZERO) + 1
            return LoadResult.Page(
                data = response.data.results,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
