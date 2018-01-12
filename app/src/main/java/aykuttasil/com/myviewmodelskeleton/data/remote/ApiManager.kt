package aykuttasil.com.myandroidstructure.data.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import aykuttasil.com.myviewmodelskeleton.data.remote.ApiResponse
import aykuttasil.com.myviewmodelskeleton.data.remote.ApiService
import aykuttasil.com.myviewmodelskeleton.data.remote.model.User
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by aykutasil on 8.12.2017.
 */
class ApiManager @Inject constructor(private val apiService: ApiService) : ApiService {

    override fun getRepos(login: String): LiveData<ApiResponse<List<User>>> {
        return MutableLiveData<ApiResponse<List<User>>>()
    }

    override fun getUser(id: String): Single<User> {
        return Single.create({
            it.onSuccess(User("Aykut", "Asil"))
        })
    }
}