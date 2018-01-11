package aykuttasil.com.myviewmodelskeleton.data

import android.arch.lifecycle.LiveData
import aykuttasil.com.myviewmodelskeleton.data.local.entity.LocationEntity
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity
import io.reactivex.Flowable

/**
 * Created by aykutasil on 27.12.2017.
 */
interface IDataManager {

    fun addLocation(loc: LocationEntity)

    fun getLocation(id: Long): LocationEntity

    fun getLocations(): LiveData<List<LocationEntity>>

    fun getLocationsRx(): Flowable<List<LocationEntity>>

    fun addUser(item: UserEntity)

    fun addUsers(items: List<UserEntity>)

    fun getUser(userId: Long): Flowable<UserEntity>

    fun getUsersRx(): Flowable<List<UserEntity>>

    fun getUsersCount(): Flowable<Int>

}