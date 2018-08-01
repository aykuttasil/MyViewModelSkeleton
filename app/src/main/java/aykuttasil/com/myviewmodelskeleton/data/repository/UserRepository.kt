package aykuttasil.com.myviewmodelskeleton.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import aykuttasil.com.myviewmodelskeleton.data.Resource
import aykuttasil.com.myviewmodelskeleton.data.local.dao.UserDao
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity
import aykuttasil.com.myviewmodelskeleton.data.remote.ApiResponse
import aykuttasil.com.myviewmodelskeleton.data.remote.ApiService
import aykuttasil.com.myviewmodelskeleton.data.remote.NetworkBoundResource
import aykuttasil.com.myviewmodelskeleton.data.remote.model.User
import javax.inject.Inject

/**
 * Created by aykutasil on 3.02.2018.
 */
class UserRepository @Inject constructor(val apiService: ApiService, val userDao: UserDao) {

    fun getUser(username: String): LiveData<Resource<UserEntity>> {
        return object : NetworkBoundResource<UserEntity, User>() {
            override fun saveCallResult(item: User) {
                val userEntity = UserEntity(_UserName = item.name, UserEmail = item.login, _UserJob = "Developer")
                userDao.insertItem(userEntity)
            }

            override fun shouldFetch(data: UserEntity?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<UserEntity> {
                return userDao.getItem(username)
            }

            override fun createCall(): LiveData<ApiResponse<User>> {
                return Transformations.map(apiService.getUser(username)) {
                    val toplam = (1..1000000).sum()
                    println(toplam)
                    it
                }
            }

        }.asLiveData()
    }

}