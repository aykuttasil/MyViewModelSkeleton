package aykuttasil.com.myandroidstructure.data.remote

import aykuttasil.com.myviewmodelskeleton.data.remote.model.User
import aykuttasil.com.myviewmodelskeleton.data.remote.ApiService
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by aykutasil on 8.12.2017.
 */
class ApiManager @Inject constructor(private val apiService: ApiService) : ApiService {

    override fun getUser(id: String): Single<User> {
        return Single.create({
            it.onSuccess(User("Aykut", "Asil"))
        })
    }


}