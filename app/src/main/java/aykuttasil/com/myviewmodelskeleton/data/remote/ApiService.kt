package aykuttasil.com.myviewmodelskeleton.data.remote

import android.arch.lifecycle.LiveData
import aykuttasil.com.myviewmodelskeleton.data.remote.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by aykutasil on 20.12.2017.
 */
interface ApiService {

    @GET("user")
    fun getUser(id: String): Single<User>

    @GET("users/{login}/repos")
    fun getRepos(@Path("login") login: String): LiveData<ApiResponse<List<User>>>
}