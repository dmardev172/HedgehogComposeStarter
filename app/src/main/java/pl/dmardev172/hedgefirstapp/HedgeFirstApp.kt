package pl.dmardev172.hedgefirstapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.dmardev172.hedgefirstapp.di.appModule

class HedgeFirstApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HedgeFirstApp)
            modules(appModule)
        }
    }
}