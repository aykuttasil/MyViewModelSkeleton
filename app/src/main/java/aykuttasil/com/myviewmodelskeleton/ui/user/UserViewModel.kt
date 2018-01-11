package aykuttasil.com.myviewmodelskeleton.ui.user

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import aykuttasil.com.myandroidstructure.data.DataManager
import aykuttasil.com.myviewmodelskeleton.App
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.toSingle
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by aykutasil on 27.12.2017.
 */
class UserViewModel @Inject constructor(val app: App) : AndroidViewModel(app) {

    var isUserListAdded = MutableLiveData<Boolean>().apply { value = false }

    @Inject
    lateinit var dataManager: DataManager

    fun addRandomUsers(): LiveData<Boolean> {
        dataManager.getUsersCount()
                .filter {
                    Log.i("aaa", "List size:" + it)
                    it == 0
                }
                .toSingle()
                .flatMap { a ->
                    Log.i("aaa", "List size:" + a)
                    Single.just(true)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isUserListAdded.value = true
                }, {
                    it.printStackTrace()
                })

        return isUserListAdded
    }

    override fun onCleared() {
        super.onCleared()
    }
}