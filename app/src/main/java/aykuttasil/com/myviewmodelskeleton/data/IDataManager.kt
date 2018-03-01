package aykuttasil.com.myviewmodelskeleton.data

import android.arch.lifecycle.LiveData
import aykuttasil.com.myviewmodelskeleton.data.local.entity.LocationEntity
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity

/**
 * Created by aykutasil on 27.12.2017.
 */
interface IDataManager {

    fun addLocation(loc: LocationEntity)

    fun getUser(username: String): LiveData<Resource<UserEntity>>

}