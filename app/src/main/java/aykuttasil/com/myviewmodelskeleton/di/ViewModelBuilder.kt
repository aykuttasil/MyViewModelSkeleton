package aykuttasil.com.myviewmodelskeleton.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import aykuttasil.com.myviewmodelskeleton.di.ViewModelFactory
import aykuttasil.com.myviewmodelskeleton.di.key.ViewModelKey
import aykuttasil.com.myviewmodelskeleton.ui.main.MainViewModel
import aykuttasil.com.myviewmodelskeleton.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelBuilder {

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun provideDetailVieWModel(viewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(UserViewModel::class)
    abstract fun provideUserVieWModel(viewModel: UserViewModel): ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

