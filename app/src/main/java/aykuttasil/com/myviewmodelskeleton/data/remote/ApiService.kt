package aykuttasil.com.myviewmodelskeleton.data.remote

import aykuttasil.com.myviewmodelskeleton.data.remote.model.User
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by aykutasil on 20.12.2017.
 */
interface ApiService {

    @GET("user")
    fun getUser(id: String): Single<User>
}