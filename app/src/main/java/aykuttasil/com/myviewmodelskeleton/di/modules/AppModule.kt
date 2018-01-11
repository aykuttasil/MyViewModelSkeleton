package aykuttasil.com.myviewmodelskeleton.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import aykuttasil.com.myviewmodelskeleton.App
import aykuttasil.com.myviewmodelskeleton.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by aykutasil on 8.12.2017.
 */

@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    @Singleton
    @Provides
    @ApplicationContext
    internal fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    internal fun provideApp(application: Application): App {
        return application.applicationContext as App
    }

    @Singleton
    @Provides
    internal fun provideSharedPreference(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application.applicationContext)
    }

    /*
    @Singleton
    @Provides
    internal fun provideApiManager(apiService: ApiService): ApiManager {
        return ApiManager(apiService)
    }

    @Singleton
    @Provides
    internal fun provideDataManager(apiManager: ApiManager, appDatabase: AppDatabase): DataManager {
        return DataManager(apiManager, appDatabase)
    }
    */
}
