package aykuttasil.com.myviewmodelskeleton.ui.user

import android.content.Context
import aykuttasil.com.myviewmodelskeleton.di.ActivityContext
import aykuttasil.com.myviewmodelskeleton.ui.user.UserActivity
import dagger.Module
import dagger.Provides

/**
 * Created by aykutasil on 13.12.2017.
 */
@Module
class UserActivityModule {

    @ActivityContext
    @Provides
    fun providerContext(context: UserActivity): Context {
        return context
    }
}
