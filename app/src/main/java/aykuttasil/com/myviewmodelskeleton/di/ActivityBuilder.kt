package aykuttasil.com.myviewmodelskeleton.di

import aykuttasil.com.myviewmodelskeleton.ui.main.MainActivity
import aykuttasil.com.myviewmodelskeleton.ui.main.MainActivityModule
import aykuttasil.com.myviewmodelskeleton.ui.main.UserActivityModule
import aykuttasil.com.myviewmodelskeleton.ui.user.UserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by aykutasil on 13.12.2017.
 */
@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun bindMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(UserActivityModule::class))
    internal abstract fun bindUserActivity(): UserActivity

}