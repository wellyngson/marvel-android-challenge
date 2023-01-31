package welias.marvel.domain.di

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import welias.marvel.domain.usecase.GetCharactersUseCase
import welias.marvel.domain.usecase.GetTopCharactersUseCase

private val useCaseModule = module {
    factory { GetTopCharactersUseCase(repository = get()) }
    factory { GetCharactersUseCase(repository = get()) }
}

object DomainModule {
    fun load() = loadKoinModules(useCaseModule)
}
