package aykuttasil.com.myviewmodelskeleton.data.remote.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by aykutasil on 8.12.2017.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class User(val ad: String, val soyad: String) : Parcelable