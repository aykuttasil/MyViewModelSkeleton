package aykuttasil.com.myviewmodelskeleton.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BaseObservable
import android.databinding.Bindable
import aykuttasil.com.myviewmodelskeleton.BR

/**
 * Created by aykutasil on 24.12.2017.
 */
@Entity(tableName = "user")
data class UserEntity(
        @PrimaryKey(autoGenerate = true) val UserId: Long? = null,
        var UserName: String,
        val UserAge: Int,
        val UserCity: String,
        val UserEmail: String
) : BaseObservable() {

    var observeUserName: String
        @Bindable
        get() {
            return UserName
        }
        set(value) {
            UserName = value
            notifyPropertyChanged(BR.observeUserName)
        }
}