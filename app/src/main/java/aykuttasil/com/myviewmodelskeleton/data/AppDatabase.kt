package aykuttasil.com.myviewmodelskeleton.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import aykuttasil.com.myviewmodelskeleton.data.local.dao.LocationDao
import aykuttasil.com.myviewmodelskeleton.data.local.dao.UserDao
import aykuttasil.com.myviewmodelskeleton.data.local.entity.LocationEntity
import aykuttasil.com.myviewmodelskeleton.data.local.entity.UserEntity
import aykuttasil.com.myviewmodelskeleton.util.converter.RoomTypeConverter

@Database(
        entities = [(UserEntity::class), (LocationEntity::class)],
        version = 3)
@TypeConverters(RoomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getLocationDao(): LocationDao
}