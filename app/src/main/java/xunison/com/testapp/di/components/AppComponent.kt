package xunison.com.testapp.di.components

import javax.inject.Singleton

import dagger.Component
import xunison.com.testapp.di.module.ApiModule
import xunison.com.testapp.di.module.HttpModule
import xunison.com.testapp.di.module.RepositoriesModule


@Singleton
@Component(modules = [ApiModule::class, RepositoriesModule::class, HttpModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun httpModule(httpModule: HttpModule): Builder
        fun repositoriesModule(repositoriesModule: RepositoriesModule): Builder
        fun build(): AppComponent
    }
}