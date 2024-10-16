package com.arquitectura.triviapp.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arquitectura.triviapp.Entidades.Pregunta

@Dao
interface PreguntaDao {


    @Insert
    fun insert(pregunta: Pregunta)


    @Query("select * from tabla_preguntas where categoria = :categoria")
    fun getTodasLasPreguntas(categoria: String): List<Pregunta>

    @Query("delete from tabla_preguntas")
    fun delete()

}