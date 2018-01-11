package aykuttasil.com.myviewmodelskeleton.ui.main

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.location.Location
import aykuttasil.com.myandroidstructure.data.DataManager
import aykuttasil.com.myviewmodelskeleton.App
import aykuttasil.com.myviewmodelskeleton.data.local.entity.LocationEntity
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity
import aykuttasil.com.myviewmodelskeleton.util.livedata.LocationLiveData
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by aykutasil on 27.12.2017.
 */
class MainViewModel @Inject constructor(val app: App) : AndroidViewModel(app) {

    @Inject
    lateinit var dataManager: DataManager

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun startSaveLocation(): LiveData<Location> {
        return LocationLiveData(app, dataManager)
    }

    fun getLastLocationFromDb(): LiveData<List<LocationEntity>> {
        return dataManager.getLocations()
    }

    fun getLastLocationFromDbRx(): Flowable<List<LocationEntity>> {
        return dataManager.getLocationsRx()
    }

    fun addSampleUser(user: UserEntity) {
        compositeDisposable.add(dataManager.addUserToLocal(user)?.subscribeOn(Schedulers.io())!!.subscribe())
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}