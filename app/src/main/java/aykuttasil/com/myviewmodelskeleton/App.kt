package aykuttasil.com.myviewmodelskeleton

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import aykuttasil.com.myviewmodelskeleton.di.AppInjector
import aykuttasil.com.myviewmodelskeleton.util.extension.debug
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    
    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        debug {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
