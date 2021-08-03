package xunison.com.testapp

import android.app.Application
import androidx.annotation.Keep
import xunison.com.testapp.di.components.AppComponent
import xunison.com.testapp.di.components.DaggerAppComponent
import xunison.com.testapp.di.module.RepositoriesModule

@Keep
open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .repositoriesModule(RepositoriesModule(this))
            .build()
        application = this
    }

    protected fun setComponent(appComponent: AppComponent)
    {
        component = appComponent
    }


    companion object {
        lateinit var component: AppComponent
            private set

        lateinit var application: Application
            private set
    }
}