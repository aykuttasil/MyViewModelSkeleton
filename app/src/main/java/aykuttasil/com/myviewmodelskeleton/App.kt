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
import javax.inject.Inject


/**
 * Created by aykutasil on 7.12.2017.
 */

/*
class App : DaggerApplication() {

    lateinit var appComponent: AppComponent

    companion object {
        fun getInstance(context: Context): App {
            return context.applicationContext as App
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        debug {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
*/

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        fun getInstance(context: Context): App {
            return context.applicationContext as App
        }
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        debug {
            Stetho.initializeWithDefaults(this)
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
