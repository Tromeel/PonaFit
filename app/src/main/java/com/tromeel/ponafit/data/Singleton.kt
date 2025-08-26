package com.tromeel.ponafit.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    @Volatile
    private var db: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return db ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "ponafit_db"
            )
                .fallbackToDestructiveMigration() // ✅ ensures schema updates don't crash
                .build()
            db = instance
            instance
        }
    }
}
