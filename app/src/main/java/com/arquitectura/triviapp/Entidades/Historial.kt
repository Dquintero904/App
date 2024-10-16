package com.arquitectura.triviapp.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_historial")
data class Historial(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    var username: String,
    var categoria: String,
    var puntaje: Int,
    var fecha: String,
    var tiempo: String
)
