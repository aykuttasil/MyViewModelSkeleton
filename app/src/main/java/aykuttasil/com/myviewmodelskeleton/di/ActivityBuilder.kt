package aykuttasil.com.myviewmodelskeleton.di

import aykuttasil.com.myviewmodelskeleton.ui.main.MainActivity
import aykuttasil.com.myviewmodelskeleton.ui.main.MainActivityModule
import aykuttasil.com.myviewmodelskeleton.ui.user.UserActivityModule
import aykuttasil.com.myviewmodelskeleton.ui.user.UserActivity
import com.aykuttasil.sweetloc.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by aykutasil on 13.12.2017.
 */
@Module(includes = [FragmentBuilder::class])
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun bindMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(UserActivityModule::class)])
    internal abstract fun bindUserActivity(): UserActivity

}