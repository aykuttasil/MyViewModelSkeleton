package aykuttasil.com.myviewmodelskeleton.ui.user

import android.arch.lifecycle.AndroidViewModel
import aykuttasil.com.myandroidstructure.data.DataManager
import aykuttasil.com.myviewmodelskeleton.App
import javax.inject.Inject

/**
 * Created by aykutasil on 27.12.2017.
 */
class UserViewModel @Inject constructor(val app: App, private val dataManager: DataManager) : AndroidViewModel(app) {

}