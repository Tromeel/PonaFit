package com.tromeel.ponafit.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tromeel.ponafit.model.Physio
import com.tromeel.ponafit.model.User


@Database(entities = [Physio::class, User::class], version = 3, exportSchema = false)
abstract class PhysioDatabase : RoomDatabase() {
    abstract fun physioDao(): PhysioDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE:PhysioDatabase? = null

        fun getDatabase(context: Context): PhysioDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhysioDatabase::class.java,
                    "main_database"
                )
                    .fallbackToDestructiveMigration() // 💥 This clears DB on version change
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}