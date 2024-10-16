package com.arquitectura.triviapp.Entidades

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arquitectura.triviapp.DAO.HistorialDao

@Database(entities = [Historial::class], version = 1, exportSchema = false)
abstract class HistorialDatabase : RoomDatabase() {

    abstract fun historyDao(): HistorialDao

    companion object {

        @Volatile
        private var INSTANCE: HistorialDatabase? = null

        fun getDatabase(context: Context): HistorialDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HistorialDatabase::class.java,
                    "historial_database"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}