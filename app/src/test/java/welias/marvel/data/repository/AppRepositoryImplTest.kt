package welias.marvel.data.repository

import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import welias.marvel.data.datasource.remote.AppRemoteDataSource

@ExperimentalCoroutinesApi
class AppRepositoryImplTest {

    private val remoteDataSource: AppRemoteDataSource = mockk(relaxed = true)

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    private fun setupRepository(
        spyOnIt: Boolean = false
    ) = AppRepositoryImpl(
        remoteDataSource = remoteDataSource,
        dispatcher = testDispatcher
    ).let {
        if (spyOnIt) {
            spyk(it)
        } else {
            it
        }
    }

//    @Test
//    fun `getListCharacters Should return a flow list characters domain When remote data source return flow list characters response`() =
//        runTest {
//            // Given
//            val remoteDataSourceImpl = setupRepository()
//            val offset = Utils.offset
//            val list = Utils.getCharacterDataWrapperResponse().data.results
//            val resultDataSource = flowOf(list)
//            val expected = flowOf(list.map { it.toCharacterDomainItem() })
//
//            // When
//            coEvery { remoteDataSource.getListCharacters(offset = offset) } returns resultDataSource
//            val response = remoteDataSourceImpl.getListCharacters(offset = offset)
//
//            // Then
//            assertEquals(expected.first(), response.first())
//        }
}
