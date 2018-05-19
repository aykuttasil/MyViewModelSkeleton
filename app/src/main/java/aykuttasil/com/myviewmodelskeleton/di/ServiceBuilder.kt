package aykuttasil.com.myviewmodelskeleton.di

import aykuttasil.com.myviewmodelskeleton.di.scopes.PerService
import aykuttasil.com.myviewmodelskeleton.service.AppService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilder {

    @PerService
    @ContributesAndroidInjector
    internal abstract fun bindAppService(): AppService

}