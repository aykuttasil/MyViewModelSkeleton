package aykuttasil.com.myviewmodelskeleton.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aykutasil on 24.12.2017.
 */
@Entity(tableName = "user")
data class UserEntity(
        @PrimaryKey(autoGenerate = true) val UserId: Long? = null,
        val UserName: String,
        val UserAge: Int,
        val UserCity: String,
        val UserEmail: String
)