package aykuttasil.com.myandroidstructure.data

import android.arch.lifecycle.LiveData
import android.util.Log
import aykuttasil.com.myandroidstructure.data.remote.ApiManager
import aykuttasil.com.myviewmodelskeleton.data.AppDatabase
import aykuttasil.com.myviewmodelskeleton.data.IDataManager
import aykuttasil.com.myviewmodelskeleton.data.local.entity.LocationEntity
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aykutasil on 8.12.2017.
 */
@Singleton
class DataManager @Inject constructor(private val apiManager: ApiManager, private val appDatabase: AppDatabase) : IDataManager {
    override fun getUsersCount(): Flowable<Int> {
        return appDatabase.getUserDao().getItemsCount()
    }

    override fun addUsers(items: List<UserEntity>) {
        Single.create<Unit>({
            try {
                it.onSuccess(appDatabase.getUserDao().insertItems(items))
            } catch (exp: Exception) {
                exp.printStackTrace()
            }
        }).subscribeOn(Schedulers.io())
                .subscribe()
    }

    override fun addUser(item: UserEntity) {
        Single.create<Long>({
            try {
                it.onSuccess(appDatabase.getUserDao().insertItem(item))
            } catch (exp: Exception) {
                exp.printStackTrace()
            }
        }).subscribeOn(Schedulers.io())
                .subscribe()
    }

    override fun getUsersRx(): Flowable<List<UserEntity>> {
        return appDatabase.getUserDao().getItems()
    }

    override fun getLocationsRx(): Flowable<List<LocationEntity>> {
        return appDatabase.getLocationDao().getItems()
    }

    override fun addLocation(loc: LocationEntity) {
        Single.create<Long>({
            try {
                it.onSuccess(appDatabase.getLocationDao().insertItem(loc))
            } catch (exp: Exception) {
                exp.printStackTrace()
            }
        }).subscribeOn(Schedulers.io())
                .subscribe()
    }

    override fun getLocation(id: Long): LocationEntity {
        return appDatabase.getLocationDao().getItem(id)
    }

    override fun getLocations(): LiveData<List<LocationEntity>> {
        return appDatabase.getLocationDao().getItemsLiveData()
    }

    fun addUserToLocal(user: UserEntity): Single<Long>? {
        return Single.create {
            try {
                val userId = appDatabase.getUserDao().insertItem(user)
                Log.i("aaa", "User Id: " + userId)
                it.onSuccess(userId)
            } catch (e: Exception) {
                it.onError(e)
            }
        }
    }

    fun getUsersToLocal(): Flowable<List<UserEntity>> {
        return appDatabase.getUserDao().getItems()
    }

    fun getUsersToLocalLive(): LiveData<List<UserEntity>> {
        return appDatabase.getUserDao().getItemsLiveData()
    }

}