package aykuttasil.com.myviewmodelskeleton.data.remote.model

/**
 * Created by aykutasil on 30.01.2018.
 */
data class NetworkResponse<T>(var data: T, var code: Int, var msg: String, var extra: String)