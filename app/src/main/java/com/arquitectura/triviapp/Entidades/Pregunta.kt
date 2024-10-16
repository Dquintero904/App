package com.arquitectura.triviapp.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tabla_preguntas")
data class Pregunta(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val pregunta: String,
    val op1: String,
    val op2: String,
    val op3: String,
    val op4: String,
    val respuesta: String,
    val categoria: String
)



