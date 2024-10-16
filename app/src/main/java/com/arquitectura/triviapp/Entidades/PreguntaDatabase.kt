package com.arquitectura.triviapp.Entidades

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arquitectura.triviapp.DAO.PreguntaDao


@Database(entities = [Pregunta::class], version = 1, exportSchema = false)
abstract class PreguntaDatabase : RoomDatabase() {

    abstract fun preguntaDao(): PreguntaDao

    companion object {
        @Volatile
        private var INSTANCE: PreguntaDatabase? = null

        fun getDatabase(context: Context): PreguntaDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PreguntaDatabase::class.java,
                    "pregunta_database"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}